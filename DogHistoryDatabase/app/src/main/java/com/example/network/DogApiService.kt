package com.example.network

import com.example.database.DogEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL =
        "https://dog.ceo/api/"

/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
// create a Moshi object
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Used Retrofit.builder to create the Retrofit object
//The Retrofit object with the Moshi converter.
private val retrofit = Retrofit.Builder()

    // added an instance of ScalarsConverterFactory and the BASE_URL we provided
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
  // we called build() to create the Retrofit object
    .build()

// Creates a DogApiService interface, and define a getProperties() method to reques the JSON response String
//A public interface that exposes the [getPhotos] method
interface DogsApiService {
    /**
     * Returns a List Array of DogPhotos class and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "photos" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("breeds/image/random")
    suspend fun getPhotos(): DogsPhoto
//a suspend function. So that you can call this method from within a coroutine.
// Telling retrofit to return a list of DogPhoto objects from the Json array instead of returning a JSON String

@GET("breed/{breed}/images/random")
suspend fun getRandomBreed(
    @Path("breed") breed:String
): DogsPhoto
}

//A public Api object that exposes the lazy-initialized Retrofit service
object DogsApi {// can be accessed from the rest of the app
    val retrofitService : DogsApiService by lazy {
    //"lazy instantiation" is when object creation is purposely delayed until you actually need that object to avoid unnecessary computation or use of other computing resources.
        retrofit.create(DogsApiService::class.java)
    }
}


