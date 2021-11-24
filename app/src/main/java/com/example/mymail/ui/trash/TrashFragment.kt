package com.example.mymail.ui.trash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mymail.databinding.FragmentTrashBinding

class TrashFragment : Fragment() {

    private lateinit var trashViewModel: TrashViewModel
    private var _binding: FragmentTrashBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        trashViewModel =
            ViewModelProvider(this).get(TrashViewModel::class.java)

        _binding = FragmentTrashBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTrash
        trashViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}