package com.myapp.irfanirawansukirman.data.source.remote

import com.myapp.irfanirawansukirman.base.BaseResponse
import com.myapp.irfanirawansukirman.data.model.Movie
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    /**
     * Service for getting movie list
     *
     * @return Single<BaseResponse<List<Movie>>>
     */
    @GET("3/discover/movie?api_key=1b2f29d43bf2e4f3142530bc6929d341&sort_by=popularity.desc")
    fun getMovies(): Single<BaseResponse<List<Movie>>>

}