package com.deviz.couponhunter.ui.fragment

import com.deviz.couponhunter.R
import com.deviz.couponhunter.base.BaseFragment
import com.deviz.couponhunter.databinding.FragmentShopListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopListFragment : BaseFragment<FragmentShopListBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_shop_list
}