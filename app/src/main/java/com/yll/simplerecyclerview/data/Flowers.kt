package com.yll.simplerecyclerview.data

import android.content.res.Resources
import android.util.Log
import com.yll.simplerecyclerview.R

val flowerNameList: List<String> = listOf(
    "daffodil", "dahlia", "daisy", "freesia",
    "lilac", "lily", "marigold", "peony",
    "poppy", "rose", "sunflower", "tulip"
)

val flowerImageList: List<Int> = listOf(
    R.drawable.daffodil, R.drawable.dahlia, R.drawable.daisy,
    R.drawable.freesia, R.drawable.lilac, R.drawable.lily,
    R.drawable.marigold, R.drawable.peony, R.drawable.poppy,
    R.drawable.rose, R.drawable.sunflower, R.drawable.tulip
)

val flowerDescriptionList: List<String> = listOf(
    "Daffodils are referred to as Lent Lilies in England.",
    "Dahlia is named after the Swedish botanist Anders Dah.",
    "Daisies are cousins with Sunflowers.",
    "Freesias bloom during spring and are native to Africa.",
    "Lilacs belong to the olive family.",
    "Lilies have the longest in vase lifespan of any cut bloom.",
    "Marigolds come in orange, reed, maroon and yellow.",
    "Peony plants can live to be 100 years old.",
    "Poppies can be over 3 feet tall.",
    "Rose comes from the Latin word Rosa. There are over 100 species of the rose.",
    "Mature Sunflowers face east and are native too the United States.",
    "There are over 150 species of tulips."
)

fun initFlowerList(resources: Resources): List<Flower> {
    val flowerList = mutableListOf<Flower>()
    for (i in flowerNameList.indices) {
        flowerList.add(Flower(i.toLong(),
            flowerNameList[flowerNameList.indices.random()],
            flowerImageList[flowerImageList.indices.random()],
            flowerDescriptionList[flowerDescriptionList.indices.random()])
        )
    }

    return flowerList
}