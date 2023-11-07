package com.yll.simplerecyclerview.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FlowerDatasource(resources: Resources) {
    private val initFlowerList = initFlowerList(resources)
    private val flowerLiveData = MutableLiveData(initFlowerList)

    fun addFlower(flower: Flower, index: Int) {
        val currentList = flowerLiveData.value
        if (currentList == null) {
            flowerLiveData.postValue(listOf(flower))
        }
        else {
            val updatedList = currentList.toMutableList()
            updatedList.add(index, flower)
            flowerLiveData.postValue(updatedList)
        }
    }

    fun addFlowerAtBeginning(flower: Flower) {
        addFlower(flower, 0)
    }

    fun addFlowerAtEnd(flower: Flower) {
        val currentList = flowerLiveData.value
        if (currentList == null || currentList.isEmpty()) {
            addFlower(flower, 0)
        }
        else {
            addFlower(flower, currentList.size)
        }
    }

    fun deleteFlower(flower: Flower) {
        val currentList = flowerLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.remove(flower)
            flowerLiveData.postValue(updatedList)
        }
    }

    fun deleteFlower(index: Int) {
        val currentList = flowerLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.removeAt(index)
            flowerLiveData.postValue(updatedList)
        }
    }

    fun deleteFirstFlower() {
        val currentList = flowerLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.removeAt(0)
            flowerLiveData.postValue(updatedList)
        }
    }

    fun deleteLastFlower() {
        val currentList = flowerLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.removeAt(currentList.size - 1)
            flowerLiveData.postValue(updatedList)
        }
    }

    fun getFlowerList(): LiveData<List<Flower>> {
        return flowerLiveData
    }

    fun getRandomFlowerImageAsset(): Int {
        val randomNumber = flowerImageList.indices.random()
        return flowerImageList[randomNumber]
    }

    companion object {
        private var INSTANCE: FlowerDatasource? = null

        fun getDatasource(resources: Resources): FlowerDatasource {
            return synchronized(FlowerDatasource::class.java) {
                val newInstance = INSTANCE?: FlowerDatasource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}