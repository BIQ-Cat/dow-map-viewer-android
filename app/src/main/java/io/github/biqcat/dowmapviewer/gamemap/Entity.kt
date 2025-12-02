package io.github.biqcat.dowmapviewer.gamemap

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.annotation.DrawableRes
import io.github.biqcat.dowmapviewer.R
import kotlinx.parcelize.Parcelize


@Parcelize
enum class Entity(@field:DrawableRes val colorMapDrawableRes: Int) : Parcelable {
    ControlPoint(R.drawable.flag_color_map) {

        override fun getHeightMap(): List<List<Int>> {
            return listOf(
                listOf(3, 0, 0, 0, 0, 0, 3),
                listOf(0, 2, 0, 0, 0, 2, 0),
                listOf(0, 0, 4, 3, 4, 0, 0),
                listOf(0, 0, 3, 2, 3, 0, 0),
                listOf(0, 0, 4, 3, 4, 0, 0),
                listOf(0, 2, 0, 0, 0, 2, 0),
                listOf(3, 0, 0, 0, 0, 0, 3)
            )
        }
    },
    CriticalPoint(R.drawable.crit_color_map) {
        override fun getHeightMap(): List<List<Int>> {
            return listOf(
                listOf(2, 2, 0, 2, 0, 2, 0, 2, 0),
                listOf(2, 2, 0, 2, 0, 2, 0, 2, 0),
                listOf(0, 2, 0, 4, 2, 2, 0, 2, 0),
                listOf(0, 2, 0, 4, 2, 2, 0, 2, 0),
                listOf(2, 0, 0, 4, 2, 4, 2, 0, 2),
                listOf(2, 0, 0, 4, 2, 4, 2, 0, 2),
                listOf(0, 2, 0, 0, 0, 2, 0, 2, 0),
                listOf(0, 2, 0, 0, 0, 2, 0, 2, 0),
                listOf(0, 0, 0, 2, 2, 2, 0, 0, 0),
            )
        }
    },
    RelicPoint(R.drawable.relic_color_map) {
        override fun getHeightMap(): List<List<Int>> {
            return listOf(
                listOf(0, 0, 0, 4, 0, 2, 0, 0, 0),
                listOf(0, 0, 0, 4, 0, 2, 0, 0, 0),
                listOf(0, 2, 0, 0, 0, 0, 0, 2, 0),
                listOf(0, 2, 0, 0, 0, 0, 0, 2, 0),
                listOf(0, 2, 0, 2, 2, 2, 0, 2, 0),
                listOf(0, 2, 0, 2, 2, 2, 0, 2, 0),
                listOf(0, 0, 0, 2, 0, 2, 0, 2, 0),
                listOf(0, 0, 0, 2, 0, 2, 0, 2, 0),
                listOf(2, 0, 0, 0, 0, 0, 2, 0, 2),
            )
        }
    },
    Spawn(R.drawable.spawn_color_map) {

        override fun getHeightMap(): List<List<Int>> {
            return listOf(
                listOf(0, 2, 0, 2, 2, 2, 2, 2, 0),
                listOf(0, 2, 0, 2, 2, 2, 2, 2, 0),
                listOf(0, 2, 2, 4, 4, 4, 2, 2, 0),
                listOf(0, 2, 2, 4, 4, 4, 2, 2, 0),
                listOf(0, 4, 2, 4, 4, 4, 2, 2, 2),
                listOf(0, 4, 2, 4, 4, 4, 2, 2, 2),
                listOf(0, 2, 0, 2, 2, 2, 2, 2, 0),
                listOf(0, 2, 0, 2, 2, 2, 2, 2, 0),
                listOf(0, 0, 0, 2, 2, 0, 0, 0, 0),
            )
        }
    },
    Slag(R.drawable.slag_color_map) {
        override fun getHeightMap(): List<List<Int>> {
            return listOf(
                listOf(4, 6, 6, 6, 4),
                listOf(5, 6, 6, 6, 5),
                listOf(6, 6, 8, 6, 6),
                listOf(6, 6, 8, 6, 6),
                listOf(4, 6, 6, 6, 4),
            )
        }
    };

    abstract fun getHeightMap(): List<List<Int>>
}