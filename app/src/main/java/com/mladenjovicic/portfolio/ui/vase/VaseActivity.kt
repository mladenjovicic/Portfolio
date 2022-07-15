package com.mladenjovicic.portfolio.ui.vase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mladenjovicic.portfolio.R
import com.mladenjovicic.portfolio.ui.vase.vaseShow.VaseShowFragment

class VaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vase_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, VaseShowFragment.newInstance())
                .commitNow()
        }
    }
}