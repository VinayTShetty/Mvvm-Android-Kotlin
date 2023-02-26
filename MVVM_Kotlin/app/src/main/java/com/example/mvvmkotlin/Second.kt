package com.example.mvvmkotlin
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvmkotlin.databinding.FragmentSecondBinding

class Second : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    /**
     * Delegating the activityViewModel to Fragment.
     */
    private val mySharedViewModel: MySharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        mySharedViewModel.country.observe(viewLifecycleOwner, { country ->
            binding.secondEditTxt.setText(country)
        })
        binding.secondButon.setOnClickListener {
            mySharedViewModel.saveCountry(binding.secondEditTxt.text.toString())
            findNavController().navigate(R.id.action_second_to_frist)
        }
        // Inflate the layout for this fragment

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}