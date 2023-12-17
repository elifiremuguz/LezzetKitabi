package elifirem.uguz.lezzetkitabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import elifirem.uguz.lezzetkitabi.activites.MainActivity3
import elifirem.uguz.lezzetkitabi.databinding.ActivityMainBinding
import elifirem.uguz.lezzetkitabi.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button5.setOnClickListener {
            intent = Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            intent = Intent(applicationContext, HomeFragment::class.java)
            startActivity(intent)
        }
    }
}

