package com.chuumong.loopingimage

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.bekawestberg.loopinglayout.library.LoopingLayoutManager
import com.chuumong.loopingimage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val loopAdapter by lazy {
        LoopAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvLoop.layoutManager = LoopingLayoutManager(
            this,
            OrientationHelper.HORIZONTAL
        )
        binding.rvLoop.adapter = loopAdapter
        loopAdapter.submitList(
            listOf(
                R.drawable.ic_baseline_ac_unit_50,
                R.drawable.ic_baseline_android_50,
                R.drawable.ic_baseline_beach_access_50,
                R.drawable.ic_baseline_bedtime_50,
                R.drawable.ic_baseline_brightness_high_50
            )
        )

        startLoopAnimation()
    }

    private fun startLoopAnimation() {
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                binding.rvLoop.scrollBy(2, 0)
                handler.post(this)
            }
        }

        handler.post(runnable)
    }
}