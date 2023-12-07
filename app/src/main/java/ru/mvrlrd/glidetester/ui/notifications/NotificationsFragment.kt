package ru.mvrlrd.glidetester.ui.notifications

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.transition.Transition
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.mvrlrd.glidetester.ImageTools
import ru.mvrlrd.glidetester.MainActivity
import ru.mvrlrd.glidetester.databinding.FragmentNotificationsBinding
import ru.mvrlrd.glidetester.loadImage
import ru.mvrlrd.glidetester.loadWithCoil
import ru.mvrlrd.glidetester.loadWithGlide
import kotlin.system.measureTimeMillis

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         binding.iv.loadWithGlide(this)

//         binding.iv.loadWithCoil()

        (requireActivity() as MainActivity).loadImage(ImageTools.GLIDE)

    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}