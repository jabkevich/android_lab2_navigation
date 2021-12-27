package com.example.lr2.ui.four

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lr2.R
import com.example.lr2.databinding.FragmentFourBinding
import com.example.lr2.databinding.FragmentHomeBinding

class FourFragment : Fragment() {

    private lateinit var homeViewModel: FourViewModel
    private var _binding: FragmentFourBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(FourViewModel::class.java)

        _binding = FragmentFourBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btn.setOnClickListener {
            findNavController().navigate(R.id.action_fourFragment_to_blankFragment)
        }
        val textView: TextView = binding.textFour
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}