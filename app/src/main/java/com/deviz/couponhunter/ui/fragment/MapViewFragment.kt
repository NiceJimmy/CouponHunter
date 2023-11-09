package com.deviz.couponhunter.ui.fragment

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.deviz.couponhunter.R
import com.deviz.couponhunter.base.BaseFragment
import com.deviz.couponhunter.databinding.FragmentMapViewBinding
import com.deviz.couponhunter.viewmodel.MapViewModel
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.PolylineOverlay
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.Locale

@AndroidEntryPoint
class MapViewFragment : BaseFragment<FragmentMapViewBinding>() {
    override val layoutResourceId: Int
        get() = R.layout.fragment_map_view

    private val viewModel: MapViewModel by viewModels()

    private lateinit var naverMap: NaverMap
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map_fragment) as MapFragment
        mapFragment.getMapAsync {
            naverMap = it
            setupMarkers()
        }
    }

    private fun setupMarkers() {
        val locations = listOf(
            LatLng(37.5663, 126.9779)
        )
        locations.forEach { location ->
            val marker = Marker().apply {
                position = location
                map = naverMap
            }
            marker.setOnClickListener {
                showBottomSheet(marker)
                true
            }
        }
    }

    private fun showBottomSheet(marker: Marker) {
        val bottomSheetFragment = ShopInfoBtmFragment.newInstance(marker.position.latitude, marker.position.longitude)
        bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
    }

    override fun onResume() {
        super.onResume()
    }


}