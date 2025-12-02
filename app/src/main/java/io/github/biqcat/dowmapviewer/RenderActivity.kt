package io.github.biqcat.dowmapviewer

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import io.github.biqcat.dowmapviewer.gamemap.GameMap

class RenderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_render)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        @Suppress("DEPRECATION") val gameMap: GameMap? =
            intent.getParcelableExtra(MainActivity.GAME_MAP)
        Snackbar.make(findViewById(R.id.main), gameMap?.width.toString(), Snackbar.LENGTH_LONG).show()
        Snackbar.make(findViewById(R.id.main), gameMap?.height.toString(), Snackbar.LENGTH_LONG).show()
        Toast.makeText(applicationContext, gameMap?.heightMap?.size.toString(), Toast.LENGTH_SHORT).show()
    }
}