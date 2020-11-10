package com.example.emptytherefrigerator.network;

import com.example.emptytherefrigerator.entity.LikeIn;
import com.example.emptytherefrigerator.entity.LikeOut;
import com.example.emptytherefrigerator.entity.RecipeComment;
import com.example.emptytherefrigerator.entity.RecipeIn;
import com.example.emptytherefrigerator.entity.RecipeOut;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParsing
{
    public static ArrayList<RecipeIn> parsingRecipe(String data)     //레시피 정보 파싱
    {
        ArrayList<RecipeIn> recipeListData = new ArrayList<RecipeIn>();
        try
        {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0 ; i< jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                //test
                System.out.println("jsonObject: "+ jsonObject.get("title"));

                RecipeIn recipeIn = new RecipeIn();
                recipeIn.setRecipeInId(jsonObject.getInt("recipeInId"));
                recipeIn.setTitle(jsonObject.getString("title"));
                recipeIn.setUserId(jsonObject.getString("userId"));
                recipeIn.setIngredient(jsonObject.getString("ingredient"));
                recipeIn.setIngredientUnit(jsonObject.getString("ingredientUnit"));
                recipeIn.setRecipePerson(jsonObject.getInt("recipePerson"));
                recipeIn.setRecipeTime(jsonObject.getInt("recipeTime"));
                recipeIn.setContents(jsonObject.getString("contents"));
                recipeIn.setCommentCount(jsonObject.getInt("commentCount"));
                recipeIn.setLikeCount(jsonObject.getInt("likeCount"));
                recipeIn.setUploadDate(jsonObject.getString("uploadDate"));

                JSONArray jsonArrayImage = jsonObject.getJSONArray("recipeImageBytes");
                String[] recipeImageBytes = new String [jsonArrayImage.length()];

                for(int j= 0; j < jsonArrayImage.length(); j++)
                {
                    JSONObject jsonObjectImage = jsonArrayImage.getJSONObject(j);
                    recipeImageBytes[j] = jsonObjectImage.getString("recipeImageByte");
                }
                recipeIn.setRecipeImageByte(recipeImageBytes);
                recipeListData.add(recipeIn);
            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
        return recipeListData;
    }
    public static RecipeIn parsingRecipeIn(String data)     //레시피 객체 하나만 파싱
    {
        RecipeIn recipeIn= new RecipeIn();
        try
        {
            JSONObject jsonObject = new JSONObject(data);

                //System.out.println("jsonObject: "+ jsonObject.get("title"));
            recipeIn.setRecipeInId(jsonObject.getInt("recipeInId"));
            recipeIn.setTitle(jsonObject.getString("title"));
            recipeIn.setUserId(jsonObject.getString("userId"));
            recipeIn.setIngredient(jsonObject.getString("ingredient"));
            recipeIn.setIngredientUnit(jsonObject.getString("ingredientUnit"));
            recipeIn.setRecipePerson(jsonObject.getInt("recipePerson"));
            recipeIn.setRecipeTime(jsonObject.getInt("recipeTime"));
            recipeIn.setContents(jsonObject.getString("contents"));
            recipeIn.setCommentCount(jsonObject.getInt("commentCount"));
            recipeIn.setLikeCount(jsonObject.getInt("likeCount"));
            recipeIn.setUploadDate(jsonObject.getString("uploadDate"));

            JSONArray jsonArrayImage = jsonObject.getJSONArray("recipeImageBytes");
            String[] recipeImageBytes = new String [jsonArrayImage.length()];

            for(int j= 0; j < jsonArrayImage.length(); j++)
            {
                JSONObject jsonObjectImage = jsonArrayImage.getJSONObject(j);
                recipeImageBytes[j] = jsonObjectImage.getString("recipeImageByte");
            }
            recipeIn.setRecipeImageByte(recipeImageBytes);

            return recipeIn;
        }
        catch(JSONException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<RecipeComment>parsingCommentList(String data)
    {
        ArrayList<RecipeComment> list = new ArrayList<>();
        try
        {
            JSONArray resCommentList = new JSONArray(data);
            System.out.println(data);

            for(int i=0; i<resCommentList.length(); i++)
            {
                JSONObject comment = resCommentList.getJSONObject(i);

                RecipeComment recipeComment= new RecipeComment();

                recipeComment.setRecipeId(comment.getInt("recipeInId"));
                recipeComment.setCommentId(comment.getInt("commentId"));
                recipeComment.setRecipeTitle(comment.getString("title"));
                recipeComment.setUserId(comment.getString("userId"));
                recipeComment.setContent(comment.getString("content"));
                recipeComment.setUploadDate(comment.getString("uploadDate"));

                JSONArray jsonArrayImage = comment.getJSONArray("recipeImageBytes");
                String[] recipeImageBytes = new String [jsonArrayImage.length()];

                for(int j= 0; j < jsonArrayImage.length(); j++)
                {
                    JSONObject jsonObjectImage = jsonArrayImage.getJSONObject(j);
                    recipeImageBytes[j] = jsonObjectImage.getString("recipeImageByte");
                }
                recipeComment.setRecipeImageByte(recipeImageBytes);

                list.add(recipeComment);
            }
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
        return list;
    }
    public static ArrayList<LikeIn> parsingLikeInList(String data)
    {
        ArrayList<LikeIn> list = new ArrayList<>();
        try
        {
            JSONArray likeInList = new JSONArray(data);

            for(int i=0;i<likeInList.length(); i++)
            {
                JSONObject likeIn = likeInList.getJSONObject(i);

                RecipeIn recipeIn= new RecipeIn();

                recipeIn.setRecipeInId(likeIn.getInt("recipeInId"));
                recipeIn.setTitle(likeIn.getString("title"));
                recipeIn.setUserId(likeIn.getString("userId"));      //레시피를 쓴 사람의 id
                recipeIn.setUploadDate(likeIn.getString("uploadDate"));

                JSONArray jsonArrayImage = likeIn.getJSONArray("recipeImageBytes");
                String[] recipeImageBytes = new String [jsonArrayImage.length()];

                for(int j= 0; j < jsonArrayImage.length(); j++)         //이미지 bytes
                {
                    JSONObject jsonObjectImage = jsonArrayImage.getJSONObject(j);
                    recipeImageBytes[j] = jsonObjectImage.getString("recipeImageByte");
                }
                recipeIn.setRecipeImageByte(recipeImageBytes);
                list.add(new LikeIn(recipeIn));
            }
            return list;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<LikeOut> parsingLikeOutList(String data)
    {
        ArrayList<LikeOut> list = new ArrayList<>();
        try
        {
            JSONArray likeOutList = new JSONArray(data);

            for(int i=0;i<likeOutList.length(); i++)
            {
                JSONObject object = likeOutList.getJSONObject(i);
                RecipeOut recipeOut = new RecipeOut();

                recipeOut.setRecipeOutId(object.getInt("recipeOutId"));
                recipeOut.setTitle(object.getString("title"));
                recipeOut.setLink(object.getString("link"));

                list.add(new LikeOut(recipeOut));
            }
            return list;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
