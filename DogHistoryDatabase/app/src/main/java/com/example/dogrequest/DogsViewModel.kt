package com.example.dogrequest

import androidx.lifecycle.*
import com.example.database.DogDao
import com.example.database.DogEntity
import com.example.network.DogsApi
import com.example.network.DogsPhoto
import kotlinx.coroutines.launch

class DogsViewModel (private val dogDao: DogDao): ViewModel() {//This class is the same as ViewModel, but it takes the application context as a constructor parameter and makes it available as a property.


        private val _currentImage = MutableLiveData<DogsPhoto>()
        val currentImage: LiveData<DogsPhoto>
        get() = _currentImage

        init {
            getNewDog()
        }

        fun getNewDog() {
            viewModelScope.launch {
                // are getting the first item in the list from the response.
                _currentImage.value = DogsApi.retrofitService.getPhotos()
            }
        }

        fun addDog(dogEntity: DogEntity) {
            viewModelScope.launch {
                dogDao.insertImage(dogEntity)
            }
        }

        //fun deleteMostRecentDog(){
        //  viewModelScope.launch {
        //    dogImageDao.deleteDog()
        //}
        //}

        fun getAllDogs(): LiveData<List<DogEntity>>
        {
            return dogDao.getAllDogs().asLiveData()
        }
    }

    class DogViewModelFactory(
        private val dogDao: DogDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DogsViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DogsViewModel(dogDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }

    }