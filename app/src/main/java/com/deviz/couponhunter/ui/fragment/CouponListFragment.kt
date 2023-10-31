package com.deviz.couponhunter.ui.fragment

import com.deviz.couponhunter.R
import com.deviz.couponhunter.base.BaseFragment
import com.deviz.couponhunter.databinding.FragmentCouponListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CouponListFragment : BaseFragment<FragmentCouponListBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_coupon_list
}