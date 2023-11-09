package com.yll.simplerecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yll.simplerecyclerview.data.Flower

class MainActivity : AppCompatActivity() {

    private val flowerListViewModel by viewModels<FlowerListViewModel> {
        FlowerListViewModel.FlowerListViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.flower_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val flowerListAdapter = FlowerAdapter { flower -> adapterOnClick(flower) }
        recyclerView.adapter = flowerListAdapter

        flowerListViewModel.flowerLiveData.observe(this) {
            it?.let {
               flowerListAdapter.submitList(it as MutableList<Flower>)
            }
        }

        val addFlowerButton: Button = findViewById(R.id.add_flower)
        val deleteFlowerButton: Button = findViewById(R.id.delete_flower)

        addFlowerButton.setOnClickListener {
            flowerListViewModel.addFlower()
        }
        deleteFlowerButton.setOnClickListener {
            flowerListViewModel.deleteFlower(this)
        }
    }

    private fun adapterOnClick(flower: Flower) {
        val flowerDetailFragment = FlowerDetailFragment.newInstance(flower.name, flower.description, flower.image)
        supportFragmentManager.beginTransaction()
            .replace(R.id.flower_detail_fragment, flowerDetailFragment)
            .addToBackStack(null)
            .commit()
    }
}