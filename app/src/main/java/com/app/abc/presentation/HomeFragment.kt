package com.app.abc.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2
import com.app.abc.databinding.FragmentHomeBinding
import com.app.abc.presentation.adapter.CarouselAdapter
import com.app.abc.presentation.adapter.NewsListAdapter
import com.app.abc.util.gone
import com.app.abc.util.visible
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val carouselCallBack = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            clearTextFocus()
            homeViewModel.carouselChanged(position)
        }
    }

    private fun clearTextFocus() {
        binding.searchText.setQuery("", false)
    }

    private val searchTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            binding.searchText.clearFocus()
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            newText?.let { homeViewModel.onQueryChanged(newText) }
            return true
        }

    }
    private var _binding: FragmentHomeBinding? = null
    private val carouselAdapter = CarouselAdapter()
    private val binding get() = _binding!!

    private val homeViewModel by activityViewModels<HomeViewModel>()
    private val adapter : NewsListAdapter = NewsListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
        addObserver()


    }

    private fun addObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED){
                launch{
                    homeViewModel.newsList.collect { data ->
                        binding.rvListItem.adapter = adapter
                        if (data != null && data.articles.isNotEmpty()) {
                            binding.tvEmpty.gone()
                            adapter.submitList(data.articles)
                        } else {
                            binding.tvEmpty.visible()
                            adapter.submitList(emptyList())
                        }
                    }
                }
            }
        }
    }

    private fun initializeViews() {
        with(binding){
            viewpagerCarousel.adapter = carouselAdapter
            viewpagerCarousel.registerOnPageChangeCallback(carouselCallBack)
            TabLayoutMediator(
                tabLayoutDotIndicator,
                viewpagerCarousel
            ) { _, _ -> }.attach()
            carouselAdapter.submitList(homeViewModel.getCarouselData)
            searchText.setOnQueryTextListener(searchTextListener)
            searchText.setOnCloseListener {
                searchText.setQuery("",false)
                return@setOnCloseListener true
            }
            fabBtn.setOnClickListener {
                homeViewModel.getAnalysisOccurrence()
                val analysisSheet = CustomBottomSheet()
                analysisSheet.show(activity?.supportFragmentManager!!, "")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}