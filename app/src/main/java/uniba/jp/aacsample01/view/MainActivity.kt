package uniba.jp.aacsample01.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import timber.log.Timber
import uniba.jp.aacsample01.R
import uniba.jp.aacsample01.databinding.ActivityMainBinding
import uniba.jp.aacsample01.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel

        // ActivityのライフサイクルをviewModelが監視できるようにする
        lifecycle.addObserver(viewModel)
        binding.lifecycleOwner = this


        binding.button1.setOnClickListener {
            binding.textView1.text = count++.toString()
        }
    }

    override fun onStart() {
        Timber.d("onStart")
        super.onStart()
    }

    override fun onResume() {
        Timber.d("onResume")
        super.onResume()
    }

    override fun onPause() {
        Timber.d("onPause")
        super.onPause()
    }

    override fun onStop() {
        Timber.d("onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Timber.d("onDestroy")
        super.onDestroy()
    }
}
