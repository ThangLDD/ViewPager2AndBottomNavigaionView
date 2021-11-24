package com.thangldd.thangldd_advanceandroid_day5

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.thangldd.thangldd_advanceandroid_day5.fragment.FragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        listenUser()
    }

    private fun listenUser() {
        bottomNavigation.setOnItemSelectedListener { item -> onNavigationViewItemClicked(item) }
        viewPager2.registerOnPageChangeCallback(pageChangeCallback)
    }

    private var pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            when (position) {
                0 -> bottomNavigation.menu.findItem(R.id.menuHome).isChecked = true
                1 -> bottomNavigation.menu.findItem(R.id.menuDashboard).isChecked = true
                2 -> bottomNavigation.menu.findItem(R.id.menuNotifications).isChecked = true
            }
        }
    }

    private fun onNavigationViewItemClicked(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuHome -> {
                viewPager2.currentItem = 0
            }
            R.id.menuDashboard -> {
                viewPager2.currentItem = 1
            }
            R.id.menuNotifications -> {
                viewPager2.currentItem = 2
            }
        }
        return true
    }

    private fun initializeView() {
        viewPager2.adapter = FragmentAdapter(this)
    }
}
