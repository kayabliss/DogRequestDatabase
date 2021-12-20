package com.example.dogrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProviders
import com.example.Repository.DogRepository
import com.example.application.DogApplication
import com.example.database.DogEntity
import com.example.project1android2.R
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private val viewModel: DogsViewModel by viewModels{
        DogViewModelFactory((application as DogApplication).database.dogImageDao())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newDogButton: Button = findViewById(R.id.button)
        val prevDogButton :Button = findViewById(R.id.prevButton)

        viewModel.currentImage.observe(this,
            {
                val mainImage : ImageView = findViewById(R.id.DogImageHolder)
                Picasso.with(this).load(it.url).into(mainImage)
            })

        newDogButton.setOnClickListener {
            val currentImgUrl = viewModel.currentImage.value?.url
            val newDogImage = currentImgUrl?.let { num1 -> DogEntity(imageUrl = num1) }


            viewModel.getNewDog()
            if (newDogImage != null) {
                viewModel.addDog(newDogImage)
            }
            //viewModel.deleteMostRecentDog()
        }

        prevDogButton.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }


}
