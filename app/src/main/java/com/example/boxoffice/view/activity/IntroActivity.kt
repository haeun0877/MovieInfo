package com.example.boxoffice.view.activity

import android.content.Intent
import android.os.Bundle
import com.example.boxoffice.R
import com.example.boxoffice.base.BaseActivity
import com.example.boxoffice.databinding.ActivityIntroBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class IntroActivity : BaseActivity<ActivityIntroBinding>(R.layout.activity_intro) {

    @OptIn(DelicateCoroutinesApi::class)
    override fun init() {
        val intent = Intent(this, MainActivity::class.java)

        GlobalScope.launch {
            delay(2000)

            startActivity(intent)
            finish()
        }
    }
}