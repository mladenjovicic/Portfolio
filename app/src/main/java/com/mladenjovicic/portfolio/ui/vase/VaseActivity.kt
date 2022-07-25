package com.mladenjovicic.portfolio.ui.vase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mladenjovicic.portfolio.R
import com.mladenjovicic.portfolio.ui.vase.vaseEdit.VaseEditFragment
import com.mladenjovicic.portfolio.ui.vase.vaseShow.VaseShowFragment

class VaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vase_activity)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val vaseEditView = VaseEditFragment()
        val vaseShowView = VaseShowFragment()


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerVase, VaseShowFragment.newInstance())
                .commitNow()
            bottomNavigationView.setSelectedItemId(R.id.nav_show_vasa)
        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_show_vasa -> setCurrentFragment(vaseShowView)
                R.id.nav_edit_vasa -> setCurrentFragment(vaseEditView)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerVase,fragment)
            commit()
        }

}