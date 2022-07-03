package com.example.newsapp.database;

import androidx.room.TypeConverter;

import com.example.newsapp.database.model.Source;

import org.json.JSONException;
import org.json.JSONObject;

public class SourceTypeConverter {

   //Convert Source as object to String
    @TypeConverter
    public String fromSource(Source source){
        try {
           JSONObject json = new JSONObject();
           json.put("id",source.getId());
           json.put("name",source.getName());
           return json.toString();
        } catch (JSONException e) {
            return null;
        }
    }


    @TypeConverter
    public Source toSource(String source){

        try {
            JSONObject json = new JSONObject(source);
            return new Source((String) json.get("id"),json.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
