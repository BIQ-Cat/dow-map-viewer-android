package io.github.biqcat.dowmapviewer.gamemap

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.BufferedInputStream
import androidx.core.graphics.createBitmap


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
        createBitmap(2, 2, Bitmap.Config.RGB_565)
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
        // TODO: test all consts
        private val DATAHMAP_RAW = listOf(  // Geometry data header
            68, 65, 84, 65, 72, 77, 65, 80, 208, 7
        )
        private val DATATYPO_RAW = listOf(  // Geometry data end
            68, 65, 84, 65, 84, 84, 89, 80, 210, 7
        )
        private val PASSABILITY_RAW = listOf(  // Passability data header
            80, 97, 115, 115, 97, 98, 105, 108, 105, 116, 121, 32, 77, 97, 112
        )
        private val DATAPRMP_RAW = listOf(  // Passability data end
            68, 65, 84, 65, 80, 82, 77, 80, 208, 7
        )
        private val DATAEBPT_RAW = listOf(  // Object list header
            68, 65, 84, 65, 69, 66, 80, 84
        )
        private val FOLDENTL_RAW = listOf(  // Entity list data header
            70, 79, 76, 68,
            69, 78, 84, 76
        )
        private val DATAENTY_RAW = listOf(  // Entity data header
            68, 65, 84, 65,
            69, 78, 84, 73
        )
        private val CUT_FLAG_RAW = listOf(
            115, 116, 114, 97, 116, 101, 103,
            105, 99, 95, 112, 111, 105, 110,
            116, 95, 102, 108, 97, 103
        )
        private val CUT_RELIC_RAW = listOf(
            114, 101, 108,
            105, 99, 95,
            115, 116, 114,
            117, 99, 116
        )
        private val CUT_CRIT_RAW = listOf(
            115, 116, 114, 97, 116,
            101, 103, 105, 99, 95,
            111, 98, 106, 101, 99,
            116, 105, 118, 101, 95,
            115, 116, 114, 117, 99, 116
        )
        private val CUT_SLAG_RAW = listOf(
            115, 108, 97, 103, 95, 100,
            101, 112, 111, 115,
            105, 116, 46, 114, 103, 100
        )
        private val CUT_SPAWN_RAW = listOf(
            115, 116, 97, 114,
            116, 105, 110, 103,
            95, 112, 111, 115,
            105, 116, 105, 111, 110
        )
        private val HEADER_OFFSET = 27  // TODO: add all needed offsets for unread object raw

        fun fromSGB(sgbInputStream: BufferedInputStream): GameMap {
            TODO("Not yet implemented")
        }
    }
}