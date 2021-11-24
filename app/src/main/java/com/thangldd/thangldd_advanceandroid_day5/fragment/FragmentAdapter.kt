package com.thangldd.thangldd_advanceandroid_day5.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val numPage = 3

    override fun getItemCount(): Int {
        return numPage
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> DashboardFragment()
            2 -> NotificationsFragment()
            else -> HomeFragment()
        }
    }
}


