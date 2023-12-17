package elifirem.uguz.lezzetkitabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import elifirem.uguz.lezzetkitabi.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btngirisedon.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }


        binding.btnkaydet.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
