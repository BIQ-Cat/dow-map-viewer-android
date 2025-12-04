package io.github.biqcat.dowmapviewer

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.biqcat.dowmapviewer.gamemap.GameMap

class MainActivity : AppCompatActivity() {
    private var gameMapTexture: Bitmap? = null

    private val openSGB = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            contentResolver.openInputStream(uri)?.use { sgbInputStream ->
                val gameMap = sgbInputStream.buffered().use { bufferedInputStream ->
                    GameMap.fromSGB(bufferedInputStream)
                }

                if (gameMapTexture != null)
                    gameMap.texture = gameMapTexture!!

                val intent = Intent(this, RenderActivity::class.java)
                intent.putExtra(GAME_MAP, gameMap)
                startActivity(intent)
            }
        } else {
            Toast.makeText(applicationContext, R.string.no_file_was_chosen, Toast.LENGTH_SHORT)
        }
    }

    val selectTexture = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            contentResolver.openFileDescriptor(uri, "r")?.use { parcelFd ->
                gameMapTexture = BitmapFactory.decodeFileDescriptor(parcelFd.fileDescriptor)
            }
        } else {
            Toast.makeText(applicationContext, R.string.no_file_was_chosen, Toast.LENGTH_SHORT)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.choose_texture).setOnClickListener {
            selectTexture.launch("image/x-tga")
            (it as Button).setText(R.string.got_bitmap)
        }

        findViewById<Button>(R.id.render_sgb).setOnClickListener {
            openSGB.launch("application/octet-stream")
        }
    }

    companion object {
        const val GAME_MAP = "GameMap"
    }
}