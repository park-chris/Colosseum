package com.neppplus.colosseum_20211024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.neppplus.colosseum_20211024.databinding.ActivityMainBinding
import com.neppplus.colosseum_20211024.utils.ServerUtil
import org.json.JSONObject
import kotlin.math.log

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

        binding.loginBtn.setOnClickListener {

//            입력한 이메일/비번을 데이터바인딩으로 가져오기.
            val inputEmail = binding.emailEdt.text.toString()
            val inputPw = binding.passwordEdt.text.toString()


//            가져온 이메일/비번을 로그로 출력.
            Log.d("입력이메일", inputEmail)
            Log.d("입력비밀번호", inputPw)


//            서버의 로그인 기능에 전달.
            ServerUtil.postRequestLogin(
                inputEmail,
                inputPw,
                object : ServerUtil.JsonResponseHandler {
                    override fun onResponse(jsonObj: JSONObject) {

//                        화면단에서 jsonObj 분석 -> 상황에 맞는 UI 처리.
                        val code = jsonObj.getInt("code")

//                        로그인 성공 시 -> 성공 토스트
//                        실패시 -> 왜 실패했는지 서버가 알려주는대로 토스트

                        if (code == 200) {

//                            백그라운드단에서 화면단을 건들면 앱이 터져서 runOnUiThread 사용
                            runOnUiThread {
                                Toast.makeText(mContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                            }


                        }
                        else {

//                            서버가 알려주는 로그인 실패 사유 파싱 -> 토스트
                            val message = jsonObj.getString("message")

                            runOnUiThread {
                                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()

                            }

                        }

                    }
                })

        }

        binding.signUpBtn.setOnClickListener {

            val myIntent = Intent(mContext, SignUpActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {
    }



}