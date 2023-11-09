package com.yll.simplerecyclerview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


private const val ARG_NAME = "name"
private const val ARG_DESCRIPTION = "description"
private const val ARG_IMAGE_ID = "image_id"

class FlowerDetailFragment : Fragment() {

    private var name: String? = null
    private var description: String? = null
    private var image: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            description = it.getString(ARG_DESCRIPTION)
            image = it.getInt(ARG_IMAGE_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_flower_detail, container, false)
        val flowerNameText: TextView = view.findViewById(R.id.flower_detail_name)
        val flowerDescriptionText: TextView = view.findViewById(R.id.flower_detail_description)
        val flowerImageView: ImageView = view.findViewById(R.id.flower_detail_image)

        flowerNameText.text = name
        flowerDescriptionText.text = description
        flowerImageView.setImageResource(image!!)

        view.setOnTouchListener { v, event -> true }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(name: String, description: String, image: Int): FlowerDetailFragment {
            return FlowerDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_DESCRIPTION, description)
                    putInt(ARG_IMAGE_ID, image)
                }
            }
        }
    }
}