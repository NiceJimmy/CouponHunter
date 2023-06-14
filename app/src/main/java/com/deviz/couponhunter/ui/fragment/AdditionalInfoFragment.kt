package com.deviz.couponhunter.ui.fragment

import com.deviz.couponhunter.R
import com.deviz.couponhunter.base.BaseFragment
import com.deviz.couponhunter.databinding.FragmentAdditionalInfoBinding
import com.deviz.couponhunter.databinding.FragmentCouponListBinding
import com.deviz.couponhunter.viewmodel.AdditionalInfoViewModel
import com.deviz.couponhunter.viewmodel.CouponListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdditionalInfoFragment : BaseFragment<FragmentAdditionalInfoBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_additional_info
}