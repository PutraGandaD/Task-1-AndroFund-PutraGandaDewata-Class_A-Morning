package com.putragandad.tugasfundamentalandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentContainer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)

        val fragmentManager = supportFragmentManager
        val aboutAppFragment = AboutAppFragment()
        val fragment = fragmentManager.findFragmentByTag(aboutAppFragment::class.java.simpleName)

        if (fragment !is AboutAppFragment) {
            fragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, aboutAppFragment, AboutAppFragment::class.java.simpleName)
                .commit()
        }
    }
}