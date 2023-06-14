package com.deviz.couponhunter.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.deviz.couponhunter.R
import com.deviz.couponhunter.base.BaseActivity
import com.deviz.couponhunter.databinding.ActivityMainBinding
import com.deviz.couponhunter.ui.fragment.AdditionalInfoFragment
import com.deviz.couponhunter.ui.fragment.CouponListFragment
import com.deviz.couponhunter.ui.fragment.MapViewFragment
import com.deviz.couponhunter.ui.fragment.ShopListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mapViewFragment by lazy { MapViewFragment() }
    private val couponListFragment by lazy { CouponListFragment() }
    private val shopListFragment by lazy { ShopListFragment() }
    private val additionalInfoFragment by lazy { AdditionalInfoFragment() }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    private fun initNavigationBar() {
        binding.btmNav.run {
            setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.navigation_map -> {
                        changeFragment(mapViewFragment)
                    }
                    R.id.navigation_coupon_list -> {
                        changeFragment(couponListFragment)
                    }
                    R.id.navigation_shop_list -> {
                        changeFragment(shopListFragment)
                    }
                    R.id.navigation_additional_info -> {
                        changeFragment(additionalInfoFragment)
                    }
                }
                true
            }
            selectedItemId = R.id.navigation_map
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main, fragment)
            .commit()
    }


    override fun initView() {
        initNavigationBar()
    }
}