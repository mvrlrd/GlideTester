package ru.mvrlrd.glidetester.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.Coil
import coil.imageLoader
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.mvrlrd.glidetester.IMAGE_URL
import ru.mvrlrd.glidetester.ImageTools
import ru.mvrlrd.glidetester.MainActivity
import ru.mvrlrd.glidetester.R
import ru.mvrlrd.glidetester.TAG
import ru.mvrlrd.glidetester.databinding.FragmentDashboardBinding
import ru.mvrlrd.glidetester.loadImage
import ru.mvrlrd.glidetester.loadWithCoil
import ru.mvrlrd.glidetester.loadWithGlide
import ru.mvrlrd.glidetester.log

import kotlin.system.measureTimeMillis

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        log(TAG, "onCreate")

              binding.iv.loadWithGlide(this)

              binding.iv.loadWithCoil()

            (requireActivity() as MainActivity).loadImage(ImageTools.GLIDE)

    }






    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}