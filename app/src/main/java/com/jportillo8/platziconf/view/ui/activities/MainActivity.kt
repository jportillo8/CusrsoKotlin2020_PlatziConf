package com.jportillo8.platziconf.view.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.jportillo8.platziconf.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(findViewById(R.id.toolbarMain))
       configNav()

    }

    fun configNav() {
        NavigationUI.setupWithNavController(
            bnvMenu,
            Navigation.findNavController(this, R.id.fragContent)
        )
    }
}
