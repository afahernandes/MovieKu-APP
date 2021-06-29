package com.app.moviekuapp.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.app.moviekuapp.data.db.repository.MovieRepository
import com.app.moviekuapp.data.model.Event
import com.app.moviekuapp.data.model.GoToMovie
import com.app.moviekuapp.data.model.entity.Movie
import com.app.moviekuapp.ui.BaseViewModel
import com.app.moviekuapp.util.extension.appendList
import com.app.moviekuapp.util.extension.liveDataBlockScope


class MoviesViewModel : BaseViewModel(), GoToMovie {

    private val movieRepository = MovieRepository()
    private val loadedMovies: LiveData<List<Movie>>
    private val moviesPage = MutableLiveData<Int>().apply { value = 1 }

    override val goToMovieDetailsEvent: MutableLiveData<Event<Movie>> = MutableLiveData()

    val movieList = MediatorLiveData<MutableList<Movie>>()

    init {
        loadedMovies = moviesPage.switchMap {
            liveDataBlockScope {
                movieRepository.loadDiscoverList(it) { mSnackBarText.postValue(Event(it)) }
            }
        }

        movieList.addSource(loadedMovies) { it?.let { list -> movieList.appendList(list) } }
    }

    fun loadMoreMovies() {
        moviesPage.value = moviesPage.value?.plus(1)
    }
}