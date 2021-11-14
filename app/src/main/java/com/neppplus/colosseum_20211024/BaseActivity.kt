package com.neppplus.colosseum_20211024

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


// kotlin은 class를 만들면 final class로 만들어지기 때문에 상속해줄수없음
abstract class BaseActivity : AppCompatActivity() {

    val mContext = this

//    onCreate의 내용을 수정해서 (재정의해서) 사용 -> override


    abstract fun setupEvents()
    abstract fun setValues()

    fun setCustomActionBar() {

//        일반 함수를 물려준다. -> 그 실행 내용까지 같이 내려줌.
//        자식 (다른 화면) 에서는 -> 이 함수를 실행만 하면 바로 사용 가능.

        val defActionBar = supportActionBar!!
        defActionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM

        defActionBar.setCustomView(R.layout.my_custom_action_bar)

        val toolbar = defActionBar.customView.parent as Toolbar
        toolbar.setContentInsetsAbsolute(0,0)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        여기에 적는 코드? -> 자식 (다른 화면)들의 super.oncreate => 실행되는 내용

//        모든 화면이 만들어질때 -> 액션바가 있다면 -> 액션바 커스터마이징 기능 실행

//        ActionBar가 있을때만 함수를 실행시켜주세요. let 문법 사용
        supportActionBar?.let {
            setCustomActionBar()
        }

    }

}