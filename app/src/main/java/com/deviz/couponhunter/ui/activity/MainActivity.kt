package com.deviz.couponhunter.ui.activity

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.deviz.couponhunter.R
import com.deviz.couponhunter.base.BaseActivity
import com.deviz.couponhunter.databinding.ActivityMainBinding
import com.deviz.couponhunter.ui.fragment.AdditionalInfoFragment
import com.deviz.couponhunter.ui.fragment.CouponListFragment
import com.deviz.couponhunter.ui.fragment.MapViewFragment
import com.deviz.couponhunter.ui.fragment.ShopListFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    //각 프래그먼트가 실제로 필요할 때까지 메모리에 로드 안됨. 상태유지 이슈 고려.
    private val mapViewFragment by lazy { MapViewFragment() }
    private val couponListFragment by lazy { CouponListFragment() }
    private val shopListFragment by lazy { ShopListFragment() }
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun initNavigationBar() {
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        binding.btmNav.run {
            setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.navigation_map -> {
                        changeFragment(mapViewFragment)
                    }
                    R.id.navigation_coupon_list -> {
                        changeFragment(couponListFragment)
//                        navController.navigate(R.id.navigation_coupon_list)
                    }
                    R.id.navigation_shop_list -> {
                        changeFragment(shopListFragment)
                    }
                    R.id.navigation_additional_info -> {
                        initNavigationDrawer()
                    }
                }
                true
            }
            selectedItemId = R.id.navigation_map
        }
    }

    private fun initNavigationDrawer() {
        val drawLayout = binding.drawerLayout
        drawLayout.openDrawer(GravityCompat.END)
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_item_2 -> {
                 Timber.d("dd")
                }

            }
            drawLayout.closeDrawers()
            true
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