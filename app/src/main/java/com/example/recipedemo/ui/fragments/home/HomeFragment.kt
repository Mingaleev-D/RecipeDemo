package com.example.recipedemo.ui.fragments.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.recipedemo.common.isOnline
import com.example.recipedemo.databinding.FragmentHomeBinding
import com.example.recipedemo.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

   private var mBinding: FragmentHomeBinding? = null
   private val binding by lazy { mBinding!! }
   private val viewModel by viewModels<HomeViewModel>()

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      if (!isOnline(requireContext())) {
         Toast.makeText(requireContext(), "No internet", Toast.LENGTH_SHORT).show()
      }
   }

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentHomeBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      getRandomMeal()
      observeAndShowRandomMealInUi()


      if (!isOnline(requireContext())) {
         binding.progressBar.visibility = View.GONE
         binding.imgNoInternet.visibility = View.VISIBLE
      }

      binding.swipeRefreshLayout.setOnRefreshListener {
         Handler(Looper.getMainLooper()).postDelayed({
            requireActivity().recreate()
            binding.swipeRefreshLayout.isRefreshing = false
         }, 300)
      }
   }

   private fun observeAndShowRandomMealInUi() {

      viewModel.mealRandomLiveData.observe(viewLifecycleOwner) {
         if (it != null) {
            Glide.with(this@HomeFragment)
               .load(it.strMealThumb)
               .into(binding.imgRandomMeal)

            binding.progressBar.visibility = View.GONE

         }
      }

   }


   private fun getRandomMeal() {
      binding.progressBar.visibility = View.VISIBLE
      viewModel.getRandomMeal()
   }

   override fun onStart() {
      super.onStart()
      binding.swipeRefreshLayout.isRefreshing = false
   }


   override fun onDestroyView() {
      super.onDestroyView()
      mBinding = null
   }

}
