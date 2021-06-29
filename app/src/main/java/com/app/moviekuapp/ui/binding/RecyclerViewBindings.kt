package com.app.moviekuapp.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.moviekuapp.data.model.*
import com.app.moviekuapp.data.model.entity.*
import com.app.moviekuapp.ui.adapter.*


@BindingAdapter("bind_cast_list", "bind_view_model")
fun RecyclerView.bindCastList(items: List<Cast>?, goTo: GoToCast) {
    if (items == null) return
    if (this.adapter == null) this.adapter = CastListAdapter(goTo)
    (this.adapter as CastListAdapter).submitList(items)
}

@BindingAdapter("bind_video_list", "bind_view_model")
fun RecyclerView.bindVideoList(items: List<Video>?, goTo: GoToVideo) {
    if (items == null) return
    if (this.adapter == null) this.adapter = VideoListAdapter(goTo)
    (this.adapter as VideoListAdapter).submitList(items)
}

@BindingAdapter("bind_genre_list", "bind_view_model")
fun RecyclerView.bindGenreList(items: List<Genre>?, goTo: GoToGenre) {
    if (items == null) return
    if (this.adapter == null) this.adapter = GenreListAdapter(goTo)
    (this.adapter as GenreListAdapter).submitList(items)
}

@BindingAdapter("bind_review_list", "bind_view_model")
fun RecyclerView.bindReviewList(items: List<Review>?, goTo: GoToReview) {
    if (items == null) return
    if (this.adapter == null) this.adapter = ReviewListAdapter(goTo)
    (this.adapter as ReviewListAdapter).submitList(items)
}
@BindingAdapter("bind_image_list", "bind_view_model")
fun RecyclerView.bindImageList(items: List<Image>?, goTo: GoToImage) {
    if (items == null) return
    if (this.adapter == null) this.adapter = ImageListAdapter(goTo)
    (this.adapter as ImageListAdapter).submitList(items)
}

@BindingAdapter("bind_credits_list", "bind_view_model")
fun RecyclerView.bindCreditsList(items: List<Credit>?, goTo: GoToCredit) {
    if (items == null) return
    if (this.adapter == null) this.adapter = CreditsListAdapter(goTo)
    (this.adapter as CreditsListAdapter).submitList(items)
}

@BindingAdapter("bind_movie_list", "bind_load_more", "bind_view_model")
fun RecyclerView.bindMovieList(
    items: List<Movie>?,
    loadMoreContent: () -> Unit,
    goTo: GoToMovie
) {
    if (items == null) return
    if (this.adapter == null) {
        this.adapter =
            MovieListAdapter(goTo, InfiniteContentScrollListener(this) { loadMoreContent() })
    }
    (this.adapter as MovieListAdapter).submitList(items)
}
