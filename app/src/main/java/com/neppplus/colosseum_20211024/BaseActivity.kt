package com.neppplus.colosseum_20211024

import androidx.appcompat.app.AppCompatActivity


// kotlin은 class를 만들면 final class로 만들어지기 때문에 상속해줄수없음
abstract class BaseActivity : AppCompatActivity() {

    abstract fun setupEvents()
    abstract fun setValues()


}