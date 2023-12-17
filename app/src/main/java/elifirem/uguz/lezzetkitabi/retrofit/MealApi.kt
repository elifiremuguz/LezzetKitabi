package elifirem.uguz.lezzetkitabi.retrofit

import elifirem.uguz.lezzetkitabi.pojo.CategoryList
import elifirem.uguz.lezzetkitabi.pojo.MealList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    @GET( /* value = */ "random.php")
    fun getRandomMeal():Call<MealList>

    @GET(/* value = */ "lookup.php?")
    fun getMealDetails(@Query("i") id:String) : Call<MealList>

    @GET(/* value = */ "filter.php?")
    fun getPopularItems(@Query("c")catetegoryName:String) : Call<CategoryList>
}