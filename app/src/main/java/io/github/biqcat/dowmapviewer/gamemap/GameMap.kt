package io.github.biqcat.dowmapviewer.gamemap

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.BufferedInputStream


@Parcelize
class GameMap(
    val width: Int,
    val height: Int,
    val heightMap: List<Int>,
    val passabilityMap: List<Boolean>,
    val entities: HashMap<Int, Entity>,

    var texture: Bitmap
) : Parcelable {

    constructor(
        width: Int,
        height: Int,
        heightMap: List<Int>,
        passabilityMap: List<Boolean>,
        entities: HashMap<Int, Entity>
    ) : this(
        width, height, heightMap, passabilityMap, entities,
        Bitmap.createBitmap(2, 2, Bitmap.Config.RGB_565)
    ) {
        val canvas = Canvas(texture)

        val color1 = Paint()
        color1.color = 0xD3FF4F
        val color2 = Paint()
        color2.color = 0xFF5672

        canvas.drawRect(0f, 0f, 1f, 1f, color1)
        canvas.drawRect(1f, 0f, 2f, 1f, color2)
        canvas.drawRect(0f, 1f, 1f, 2f, color2)
        canvas.drawRect(1f, 1f, 2f, 2f, color1)

        canvas.save()
    }

    companion object {
        fun fromSGB(sgbInputStream: BufferedInputStream): GameMap {
            TODO("Not yet implemented")
        }
    }
}