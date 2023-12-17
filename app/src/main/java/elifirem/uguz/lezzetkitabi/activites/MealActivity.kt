package elifirem.uguz.lezzetkitabi.activites

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import elifirem.uguz.lezzetkitabi.R
import elifirem.uguz.lezzetkitabi.databinding.ActivityMealBinding
import elifirem.uguz.lezzetkitabi.fragments.HomeFragment
import elifirem.uguz.lezzetkitabi.pojo.Meal
import elifirem.uguz.lezzetkitabi.videoModel.MealViewModel

class MealActivity : AppCompatActivity() {
    private lateinit var mealId:String
    private lateinit var mealName:String
    private lateinit var mealthumb:String
    private lateinit var binding: ActivityMealBinding
    private lateinit var youtubeLink:String
    private lateinit var mealMvvm:MealViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mealMvvm = ViewModelProviders.of(this)[MealViewModel::class.java]

        getMealInformationFromIntent()

        setInformationInViews()

        loadingCase()
        mealMvvm.getMealDetail(mealId)
        observerMealDeatialsLiveData()

        onYoutubeImageClick()
    }

    private fun onYoutubeImageClick() {
        binding.imgYoutube.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLink))
            startActivity(intent)
        }
    }

    private fun observerMealDeatialsLiveData() {
        this.mealMvvm.observerMealDetailsLiveData().observe(this,object : Observer<Meal>{
            fun onChanged(t: Meal?) {
                onResponseCase()
                val meal = t

                binding.tvCategory.text = "Kategori : ${meal!!.strCategory}"

                youtubeLink = meal.strYoutube
            }

            override fun onChanged(value: Meal) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun setInformationInViews() {
        Glide.with(applicationContext)
            .load(mealthumb)
            .into(binding.imgMealDetail)

        binding.collapsingToolbar.title = mealName
        binding.collapsingToolbar.setCollapsedTitleTextColor(resources.getColor(R.color.TODO))
        binding.collapsingToolbar.setExpandedTitleColor(resources.getColor(R.color.TODO))
    }

    private fun getMealInformationFromIntent() {
        val intent = intent
        mealId = intent.getStringExtra(HomeFragment.MEAL_ID)!!
        mealName = intent.getStringExtra(HomeFragment.MEAL_NAME)!!
        mealthumb = intent.getStringExtra(HomeFragment.MEAL_THUMB)!!
    }


    private fun loadingCase(){
        binding.progressBar.visibility = View.VISIBLE
        binding.btnAddToFav.visibility = View.INVISIBLE
        binding.tvInstructions.visibility = View.INVISIBLE
        binding.tvCategory.visibility = View.INVISIBLE
        binding.imgYoutube.visibility = View.INVISIBLE
    }
    private fun onResponseCase(){
        binding.progressBar.visibility = View.INVISIBLE
        binding.btnAddToFav.visibility = View.VISIBLE
        binding.tvInstructions.visibility = View.VISIBLE
        binding.tvCategory.visibility = View.VISIBLE
        binding.imgYoutube.visibility = View.VISIBLE
    }

}