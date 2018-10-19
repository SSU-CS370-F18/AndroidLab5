package ssu.tholland.androidlab5.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ssu.tholland.androidlab5.models.RecipeResponse;

public interface RecipeApi {

    @GET("recipes")
    Observable<RecipeResponse> getRecipes(@Query("q") String searchTerm);
}
