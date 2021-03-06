package com.example.appideas_user4.fragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by appideas-user4 on 10/5/18.
 */

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        if (position == 0) {
            fragment = FragmentOne()
        } else if (position == 1) {
            fragment = FragmentTwo()
        } else if (position == 2) {
            fragment = FragmentThree()
        }
        return fragment
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        if (position == 0) {
            title = "First"
        } else if (position == 1) {
            title = "Second"
        } else if (position == 2) {
            title = "Third"
        }
        return title
    }
}