package elifirem.uguz.lezzetkitabi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.android.car.ui.recyclerview.RecyclerViewAdapterAdapterV1
import com.bumptech.glide.Glide
import elifirem.uguz.lezzetkitabi.databinding.PopularItemsBinding
import elifirem.uguz.lezzetkitabi.pojo.CategoryMeals

private val PopularItemsBinding.imgPopularMealItem: ImageView
    get() {
        TODO("Not yet implemented")
    }

class MostPopularAdapter(): RecyclerView.Adapter<MostPopularAdapter.PopularMealViewHolder> () {
    lateinit var onItemClick:((CategoryMeals) -> Unit)
    private var mealList = ArrayList<CategoryMeals>()
    
    fun setMeals(mealList:ArrayList<CategoryMeals>){
        this.mealList = mealList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMealViewHolder {
        return PopularMealViewHolder(PopularItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))    
    }

    override fun onBindViewHolder(holder: PopularMealViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(mealList[position].strMealThumb)
            .into(holder.binding.imgPopularMealItem)

        holder.itemView.setOnClickListener {
            onItemClick.invoke(mealList[position])
        }
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    class PopularMealViewHolder(var binding:PopularItemsBinding):RecyclerView.ViewHolder(binding.root)
}