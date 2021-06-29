package com.app.moviekuapp.data.model

import androidx.lifecycle.MutableLiveData
import com.app.moviekuapp.data.model.entity.*

interface GoToCast {
    val goToCastDetailsEvent: MutableLiveData<Event<Cast>>

    fun goTo(cast: Cast) {
        goToCastDetailsEvent.value = Event(cast)
    }
}

interface GoToImage {
    val goToImageEvent: MutableLiveData<Event<Image>>

    fun goTo(image: Image) {
        goToImageEvent.value = Event(image)
    }
}

interface GoToMovie {
    val goToMovieDetailsEvent: MutableLiveData<Event<Movie>>

    fun goTo(movie: Movie) {
        goToMovieDetailsEvent.value = Event(movie)
    }
}


interface GoToVideo {
    val goToVideoEvent: MutableLiveData<Event<Video>>
    fun goTo(video: Video) {
        goToVideoEvent.value = Event(video)
    }
}

interface GoToReview {
    val goToReviewEvent: MutableLiveData<Event<Review>>
    fun goTo(review: Review) {
        goToReviewEvent.value = Event(review)
    }
}

interface GoToCredit {
    val goToCreditEvent: MutableLiveData<Event<Credit>>

    fun goTo(credit: Credit) {
        goToCreditEvent.value = Event(credit)
    }
}

interface GoToGenre {
    val goToGenreEvent: MutableLiveData<Event<Genre>>

    fun goTo(genre: Genre) {
        goToGenreEvent.value = Event(genre)
    }
}