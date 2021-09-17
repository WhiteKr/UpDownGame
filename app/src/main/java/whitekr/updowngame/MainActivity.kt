package whitekr.updowngame

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
	var goal: Int = 0

	private val min: Int = 0
	private val max: Int = 30

	lateinit var slider: SeekBar
	lateinit var sliderCount: TextView
	lateinit var sMin: TextView
	lateinit var sMax: TextView
	lateinit var submitBtn: Button

	@RequiresApi(Build.VERSION_CODES.O)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		slider = findViewById(R.id.main_seekBar_slider)
		sliderCount = findViewById(R.id.main_textView_sliderCount)
		sMin = findViewById(R.id.main_textView_min)
		sMax = findViewById(R.id.main_textView_max)
		submitBtn = findViewById(R.id.main_button_submit)

		reset()

		slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
			override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
				sliderCount.text = progress.toString()
			}

			override fun onStartTrackingTouch(p0: SeekBar?) {
			}

			override fun onStopTrackingTouch(p0: SeekBar?) {
			}
		})

		submitBtn.setOnClickListener {
			val n: Int = slider.progress
			if (n == goal) {
				reset()
				Toast.makeText(this, "정답 ㅊㅊ", Toast.LENGTH_SHORT).show()
			}
		}
	}

	@RequiresApi(Build.VERSION_CODES.O)
	fun reset() {
		goal = (Math.random() * (max - min + 1)).toInt() + min
		Log.e("goal", goal.toString())

		slider.min = min
		slider.max = max
		sMin.text = slider.min.toString()
		sMax.text = slider.max.toString()
		slider.progress = max / 2
		sliderCount.text = slider.progress.toString()
	}
}