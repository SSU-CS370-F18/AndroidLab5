package ssu.tholland.androidlab5.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import ssu.tholland.androidlab5.R;
import ssu.tholland.androidlab5.viewholder.RecipeViewAdapter;
import ssu.tholland.androidlab5.models.RecipeModel;
import ssu.tholland.androidlab5.presenter.RecipePresenter;

public class MainActivity extends AppCompatActivity implements RecipeView {
    private final String TAG = "MainActivity";

    private RecipePresenter presenter;

    private EditText searchEditText;
    private Button searchButton;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new RecipePresenter(this);


        searchEditText = findViewById(R.id.search_edit_text);

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);

        searchButton = findViewById(R.id.recipe_search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchParam = searchEditText.getText().toString();
                presenter.getRecipes(searchParam);
            }
        });

    }

    @Override
    public void displayRecipeData(List<RecipeModel> recipeList) {
        RecipeViewAdapter adapter = new RecipeViewAdapter(recipeList);
        recyclerView.setAdapter(adapter);
    }

}
