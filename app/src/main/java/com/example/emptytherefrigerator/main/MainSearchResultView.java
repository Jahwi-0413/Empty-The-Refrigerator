package com.example.emptytherefrigerator.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emptytherefrigerator.R;
import com.example.emptytherefrigerator.entity.RecipeIn;

import java.util.ArrayList;

//검색 결과
public class MainSearchResultView extends AppCompatActivity {

    private View view;

    private Button btnBack;
    private SearchView searchRecipe;
    private CheckBox recipeChkBox;
    private RecyclerView resultRecyclerView;
    private TextView btnRecipeOut;

    private ArrayList<RecipeIn> resultList;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_search_result);

        initializeView();
        setListener();
        setResultRecipe();
    }

    public void initializeView()
    {
        btnBack = (Button)findViewById(R.id.btnBack);
        searchRecipe = (SearchView)findViewById(R.id.searchRecipe);
        recipeChkBox = (CheckBox) findViewById(R.id.recipeChkBox);
        resultRecyclerView = (RecyclerView)findViewById(R.id.resultRecyclerView);
        btnRecipeOut = (TextView)findViewById(R.id.btnRecipeOut);
    }

    public void setListener()
    {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnRecipeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setResultRecipe()
    {
        //RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this); //상하
        resultRecyclerView.addItemDecoration(new RecyclerDecoration(50)); //아이템 간격
        resultRecyclerView.setLayoutManager(layoutManager);
        resultRecyclerView.setAdapter(new MainSearchResultAdapter(insertItemList()));       //어댑터

        //리사이클러뷰 구분선
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(resultRecyclerView.getContext(), new LinearLayoutManager(this).getOrientation());
        resultRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    // test 데이터 넣는 곳
    ArrayList insertItemList(){
        resultList = new ArrayList<>(  );
        RecipeIn recipeList1 = new RecipeIn();

        String userId = "유저 아이디";
        String title = "타이틀";
        String recipeImagePath = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/PNG_transparency_demonstration_1.png/420px-PNG_transparency_demonstration_1.png," +
                "https://upload.wikimedia.org/wikipedia/commons/5/5f/%EA%B4%91%ED%99%94%EB%AC%B8_Gwanghwamun_%E5%85%89%E5%8C%96%E9%96%80_-_panoramio.jpg," +
                "https://upload.wikimedia.org/wikipedia/commons/0/02/Nordsee_Wellen.JPG," +
                "https://upload.wikimedia.org/wikipedia/commons/5/5f/%EA%B4%91%ED%99%94%EB%AC%B8_Gwanghwamun_%E5%85%89%E5%8C%96%E9%96%80_-_panoramio.jpg";
        String recipePerson = "1";
        String recipeTime = "30";
        String ingredient = "식재료1,식재료2,식재료3";
        String ingredientUnit = "1개,2개,3개";
        String recipeContents = "요리방법 1,요리방법 2,요리방법3";
        int commentCount = 10;
        int likeCount = 50;
        String uploadDate = "2020-10-24";

        recipeList1.setUserId(userId);
        recipeList1.setTitle(title);
        recipeList1.setRecipeImagePath(recipeImagePath);
        recipeList1.setRecipePerson(Integer.parseInt(recipePerson));
        recipeList1.setRecipeTime(Integer.parseInt(recipeTime));
        recipeList1.setIngredient(ingredient);
        recipeList1.setIngredientUnit(ingredientUnit);
        recipeList1.setContents(recipeContents);
        recipeList1.setCommentCount(commentCount);
        recipeList1.setLikeCount(likeCount);
        recipeList1.setUploadDate(uploadDate);

/*        Recipe recipeList2 = new Recipe();
        Recipe recipeList3 = new Recipe();*/

        resultList.add(recipeList1);
        resultList.add(recipeList1);
        resultList.add(recipeList1);
        resultList.add(recipeList1);
        return resultList;
    }
}