package com.example.appideas_user4.myapplication

import android.app.ProgressDialog.show
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View
import android.widget.Toast
import com.example.appideas_user4.fragment.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_home_menu.*

class HomeMenu : AppCompatActivity() {

    internal lateinit var viewpageradapter: ViewPagerAdapter //Declare PagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_menu)

        val bottomNavigation = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
         bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.home ->
                    // Action when tab 1 selected
                    Toast.makeText(this@HomeMenu, "home", Toast.LENGTH_SHORT).show()
                R.id.twitter ->{
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this@HomeMenu, "twitter", Toast.LENGTH_SHORT).show()
                }

                    // Action when tab 2 selected

                R.id.web ->
                    // Action when tab 3 selected
                    Toast.makeText(this@HomeMenu, "other", Toast.LENGTH_SHORT).show()
            }
            true
        }


        viewpageradapter= ViewPagerAdapter(supportFragmentManager)

        this.viewPager.adapter=viewpageradapter  //Binding PagerAdapter with ViewPager
        this.tab_layout.setupWithViewPager(this.viewPager) //Binding ViewPager with TabLayout
    }
}
