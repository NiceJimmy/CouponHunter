package com.deviz.couponhunter.ui.fragment

import com.deviz.couponhunter.R
import com.deviz.couponhunter.base.BaseFragment
import com.deviz.couponhunter.databinding.FragmentMapViewBinding
import com.deviz.couponhunter.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapViewFragment : BaseFragment<FragmentMapViewBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_map_view
}