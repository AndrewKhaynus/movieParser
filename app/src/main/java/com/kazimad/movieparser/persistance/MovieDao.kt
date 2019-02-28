package com.kazimad.movieparser.persistance

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kazimad.movieparser.models.response.MovieData

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieData(movieData: MovieData)

    @Update
    fun updateMovieData(movieData: MovieData)

    @Delete
    fun deleteMovieData(movieData: MovieData)

    @Query("SELECT * FROM MovieData WHERE id ==:id")
    fun getMovieDataById(id: Int): LiveData<MovieData>

    @Query("SELECT * FROM MovieData")
    fun getMovieDatas(): LiveData<List<MovieData>>
}