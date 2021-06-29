package com.app.moviekuapp.ui.movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.moviekuapp.data.db.repository.MovieRepository
import com.app.moviekuapp.data.model.Event
import com.app.moviekuapp.data.model.GoToCast
import com.app.moviekuapp.data.model.GoToReview
import com.app.moviekuapp.data.model.GoToVideo
import com.app.moviekuapp.data.model.entity.Cast
import com.app.moviekuapp.data.model.entity.Movie
import com.app.moviekuapp.data.model.entity.Review
import com.app.moviekuapp.data.model.entity.Video
import com.app.moviekuapp.ui.BaseViewModel
import com.app.moviekuapp.util.extension.liveDataBlockScope

class MovieDetailsViewModelFactory(private val movieId: Int) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailsViewModel(movieId) as T
    }
}

class MovieDetailsViewModel(movieId: Int) : BaseViewModel(), GoToCast, GoToVideo , GoToReview {

    private val movieRepository = MovieRepository()
    val movie: LiveData<Movie>
    val videoList: LiveData<List<Video>>
    val reviewList: LiveData<List<Review>>
    val castList: LiveData<List<Cast>>

    override val goToCastDetailsEvent: MutableLiveData<Event<Cast>> = MutableLiveData()
    override val goToVideoEvent: MutableLiveData<Event<Video>> = MutableLiveData()
    override val goToReviewEvent: MutableLiveData<Event<Review>> = MutableLiveData()

    init {
        movie = liveDataBlockScope {
            movieRepository.loadDetails(movieId) { mSnackBarText.postValue(Event(it)) }
        }

        videoList = liveDataBlockScope {
            movieRepository.loadVideos(movieId) { mSnackBarText.postValue(Event(it)) }
        }
       reviewList = liveDataBlockScope {
            movieRepository.loadReview(movieId) { mSnackBarText.postValue(Event(it)) }
        }

        castList = liveDataBlockScope {
            movieRepository.loadCredits(movieId) { mSnackBarText.postValue(Event(it)) }
        }
    }
}
