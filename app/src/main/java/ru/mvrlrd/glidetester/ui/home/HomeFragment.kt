package ru.mvrlrd.glidetester.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mvrlrd.glidetester.ImageTools
import ru.mvrlrd.glidetester.MainActivity
import ru.mvrlrd.glidetester.databinding.FragmentHomeBinding
import ru.mvrlrd.glidetester.loadImage
import ru.mvrlrd.glidetester.loadWithCoil
import ru.mvrlrd.glidetester.loadWithGlide
import kotlin.system.measureTimeMillis

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//         binding.iv.loadWithGlide(this)
//
           binding.iv.loadWithCoil()





    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}