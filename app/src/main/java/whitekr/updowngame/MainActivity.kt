package whitekr.updowngame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val slider: SeekBar = findViewById(R.id.main_seekBar_slider)
		val sliderCount: TextView = findViewById(R.id.main_textView_sliderCount)
		val min: TextView = findViewById(R.id.main_textView_min)
		val max: TextView = findViewById(R.id.main_textView_max)
	}
}