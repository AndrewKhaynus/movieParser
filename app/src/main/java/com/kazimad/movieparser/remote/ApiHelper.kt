//package com.kazimad.movieparser.remote
//
//import com.kazimad.movieparser.models.error.ResponseException
//import io.reactivex.functions.Predicate
//import retrofit2.Response
//import java.net.HttpURLConnection
//
//object ApiHelper {
//    private const val RESPONSE_CODE_BAD_REQUESTS = HttpURLConnection.HTTP_BAD_REQUEST
//
//    fun <T : Any> baseApiFilterPredicate(): Predicate<Response<T>> {
//        return Predicate {
//            if (it.code() >= RESPONSE_CODE_BAD_REQUESTS) {
//                throw Throwable(it.message())
//            }
//            if (it.body() == null) {
//                throw ResponseException(it.message())
//            }
//            true
//        }
//    }
//}