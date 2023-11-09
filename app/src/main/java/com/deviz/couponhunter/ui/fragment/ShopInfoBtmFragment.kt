package com.deviz.couponhunter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.deviz.couponhunter.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ShopInfoBtmFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shop_info_btm, container, false)
    }

    companion object {
        fun newInstance(): ShopInfoBtmFragment {
            return ShopInfoBtmFragment()
        }
    }

}