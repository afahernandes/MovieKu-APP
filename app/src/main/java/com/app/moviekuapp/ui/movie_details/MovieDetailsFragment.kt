package com.app.moviekuapp.ui.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.app.moviekuapp.data.db.remote.TheMovieDatabaseAPI
import com.app.moviekuapp.data.model.EventObserver
import com.app.moviekuapp.databinding.FragmentMovieDetailsBinding
import com.app.moviekuapp.ui.BaseFragment
import com.app.moviekuapp.util.extension.openUrl
import com.app.moviekuapp.util.extension.showSnackBar


class MovieDetailsFragment : BaseFragment(true) {

    private val args: MovieDetailsFragmentArgs by navArgs()
    private val viewModel: MovieDetailsViewModel by viewModels { MovieDetailsViewModelFactory(args.movieIdArg) }
    private lateinit var viewDataBinding: FragmentMovieDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding =
            FragmentMovieDetailsBinding.inflate(inflater, container, false)
                .apply {
                    viewmodel = viewModel
                    lifecycleOwner = this@MovieDetailsFragment.viewLifecycleOwner
                }
        return viewDataBinding.root
    }

    override fun setupViewModelObservers() {
        viewModel.snackBarText.observe(viewLifecycleOwner, EventObserver { view?.showSnackBar(it) })
        viewModel.goToVideoEvent.observe(
            viewLifecycleOwner,
            EventObserver { openUrl(TheMovieDatabaseAPI.getYoutubeWatchUrl(it.key)) })

        viewModel.goToReviewEvent.observe(
                viewLifecycleOwner,
                    EventObserver { openUrl(TheMovieDatabaseAPI.getYoutubeWatchUrl(it.id)) }
                 )

    }






}