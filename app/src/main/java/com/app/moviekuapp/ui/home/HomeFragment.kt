package com.app.moviekuapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.moviekuapp.data.model.EventObserver
import com.app.moviekuapp.data.model.MovieListType
import com.app.moviekuapp.databinding.FragmentHomeBinding
import com.app.moviekuapp.ui.BaseFragment
import com.app.moviekuapp.util.extension.showSnackBar

class HomeFragment : BaseFragment(false) {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var viewDataBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewDataBinding =
            FragmentHomeBinding.inflate(inflater, container, false).apply {
                viewmodel = viewModel
                lifecycleOwner = this@HomeFragment.viewLifecycleOwner
            }
        return viewDataBinding.root
    }

    override fun setupViewModelObservers() {
        viewModel.snackBarText.observe(viewLifecycleOwner, EventObserver { view?.showSnackBar(it) })
        viewModel.goToShowAllEvent.observe(
            viewLifecycleOwner,
            EventObserver { navigateToShowAll(it) })
        viewModel.goToMovieDetailsEvent.observe(
            viewLifecycleOwner,
            EventObserver { navigateToMovieDetails(it.id, it.title) })
    }

    private fun navigateToShowAll(movieListType: MovieListType) {
        val action = HomeFragmentDirections.actionNavigationHomeToShowAllFragment(movieListType)
        findNavController().navigate(action)
    }

    private fun navigateToMovieDetails(movieId: Int, movieTitle: String) {
        val action =
            HomeFragmentDirections.actionNavigationHomeToMovieDetailsFragment(movieId, movieTitle)
        findNavController().navigate(action)
    }
}

