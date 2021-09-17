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
	private var goal: Int = 0
	private var tryCount: Int = 0
	private val maxTry: Int = 5

	private val min: Int = 0
	private val max: Int = 30

	private lateinit var slider: SeekBar
	private lateinit var sliderCount: TextView
	private lateinit var sMin: TextView
	private lateinit var sMax: TextView
	private lateinit var submitBtn: Button

	@RequiresApi(Build.VERSION_CODES.O)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		slider = findViewById(R.id.main_seekBar_slider)
		sliderCount = findViewById(R.id.main_textView_sliderCount)
		sMin = findViewById(R.id.main_textView_min)
		sMax = findViewById(R.id.main_textView_max)
		submitBtn = findViewById(R.id.main_button_submit)

		slider.reset(min, max, true)

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
			++tryCount
			when {
				tryCount >= maxTry -> {
					Toast.makeText(this, "응틀림", Toast.LENGTH_SHORT).show()
					slider.reset(min, max, true)
				}
				n == goal -> {
					slider.reset(min, max, true)
					Toast.makeText(this, "정답 ㅊㅊ", Toast.LENGTH_SHORT).show()
				}
				else -> {
					if (n > goal) slider.reset(slider.min, n - 1)
					else slider.reset(n + 1, slider.max)
				}
			}
		}
	}

	@RequiresApi(Build.VERSION_CODES.O)
	fun SeekBar.reset(min: Int, max: Int, totally: Boolean = false) {
		if (totally) {
			tryCount = 0
			goal = (Math.random() * (max - min + 1)).toInt() + min
			Log.e("goal", goal.toString())
		}

		this.min = min
		this.max = max
		this.progress = (slider.max / 2) + (slider.min / 2)

		resetView()
	}

	@RequiresApi(Build.VERSION_CODES.O)
	fun resetView() {
		sMin.text = slider.min.toString()
		sMax.text = slider.max.toString()
		sliderCount.text = slider.progress.toString()
	}
}