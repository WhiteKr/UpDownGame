package whitekr.updowngame

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
	@RequiresApi(Build.VERSION_CODES.O)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val slider: SeekBar = findViewById(R.id.main_seekBar_slider)
		val sliderCount: TextView = findViewById(R.id.main_textView_sliderCount)
		val sMin: TextView = findViewById(R.id.main_textView_min)
		val sMax: TextView = findViewById(R.id.main_textView_max)

		val (min: Int, max: Int) = intArrayOf(0, 30)
		slider.min = min
		slider.max = max
		sMin.text = slider.min.toString()
		sMax.text = slider.max.toString()
		slider.progress = max / 2
		sliderCount.text = slider.progress.toString()

		slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
			override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
				sliderCount.text = progress.toString()
			}

			override fun onStartTrackingTouch(p0: SeekBar?) {
			}

			override fun onStopTrackingTouch(p0: SeekBar?) {
			}

		})
	}
}