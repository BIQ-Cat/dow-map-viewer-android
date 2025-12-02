package io.github.biqcat.dowmapviewer.gamemap

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.InputStream


@Parcelize
class GameMap(
    val width: Int,
    val height: Int,
    val heightMap: List<Int>,
    val passabilityMap: List<Boolean>,
    val entities: HashMap<Int, Entity>
) : Parcelable {
    companion object {
        fun fromSGB(sgbInputStream: InputStream) : GameMap {
            TODO("Not yet implemented")
        }
    }
}