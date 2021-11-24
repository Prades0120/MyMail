package com.example.mymail.ui.outbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mymail.databinding.FragmentOutboxBinding

class OutboxFragment : Fragment() {

    private lateinit var outboxViewModel: OutboxViewModel
    private var _binding: FragmentOutboxBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        outboxViewModel =
            ViewModelProvider(this).get(OutboxViewModel::class.java)

        _binding = FragmentOutboxBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textOutbox
        outboxViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}