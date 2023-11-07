package com.yll.simplerecyclerview

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yll.simplerecyclerview.data.*
import kotlin.random.Random

class FlowerListViewModel(val datasource: FlowerDatasource): ViewModel() {
    val flowerLiveData = datasource.getFlowerList()

    fun addFlower() {
        val currentList = flowerLiveData.value
        if (currentList != null && currentList.size < 15) {
            val newFlower = Flower(
                Random.nextLong(),
                flowerNameList[flowerNameList.indices.random()],
                flowerImageList[flowerImageList.indices.random()],
                flowerDescriptionList[flowerDescriptionList.indices.random()]
            )
            datasource.addFlower(newFlower, 0)
        }
    }

    fun deleteFlower(context: Context) {
        val currentList = flowerLiveData.value
        if (currentList != null) {
            if (currentList.isNotEmpty()) {
                if (currentList.size > 1) {
                    datasource.deleteFlower(1)
                } else {
                    datasource.deleteFlower(0)
                }
            }
            else {
                Toast.makeText(context, "No more flower can be deleted", Toast.LENGTH_SHORT).show()
            }
        }
    }

    class FlowerListViewModelFactory(private val context: Context): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FlowerListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return FlowerListViewModel(
                    datasource = FlowerDatasource.getDatasource(context.resources)
                ) as T
            }
            throw IllegalStateException("Unknown model class")
        }
    }
}