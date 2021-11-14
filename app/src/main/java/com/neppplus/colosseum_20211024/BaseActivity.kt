package com.neppplus.colosseum_20211024

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


// kotlin은 class를 만들면 final class로 만들어지기 때문에 상속해줄수없음
abstract class BaseActivity : AppCompatActivity() {

    val mContext = this

    abstract fun setupEvents()
    abstract fun setValues()

    fun setCusomActionBar() {

//        일반 함수를 물려준다. -> 그 실행 내용까지 같이 내려줌.
//        자식 (다른 화면) 에서는 -> 이 함수를 실행만 하면 바로 사용 가능.

        val defActionBar = supportActionBar!!
        defActionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM

        defActionBar.setCustomView(R.layout.my_custom_action_bar)

        val toolbar = defActionBar.customView.parent as Toolbar
        toolbar.setContentInsetsAbsolute(0,0)



    }

}