package com.example.myapplication.json.Dataparsing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.gson.Gson
import org.json.JSONObject


class JsonPassingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_passing)
        val jsonString = "{\"id\":1," +
                "\"title\":\"my company name is yudiz\"," +
                "\"body\":\".\"," +
                "\"userId\":9," +
                "\"country\":[\"india\",\"america\",\"japan\"]," +
                "\"number\":2," +
                "\"geo\": {\n" +
                " \"lat\": \"-37.3159\",\n" +
                " \"lng\": \"81.1496\"\n" +
                " }  }"
        val jsonObject = JSONObject(jsonString)
        val id = jsonObject.getInt("id")
        val title = jsonObject.getString("title")
        val body = jsonObject.getString("body")
        val userId = jsonObject.getInt("userId")
        val tags = jsonObject.getJSONArray("country")
        val reactions = jsonObject.getInt("number")
        val geoLat = jsonObject.getJSONObject("geo").getDouble("lat")
        val geoLng = jsonObject.getJSONObject("geo").getDouble("lng")
        val result = "$id\n $title\n $body\n $userId\n $tags\n $reactions\n $geoLat\n $geoLng"
        print(result)
        val gson = Gson()
        //val deserialize : JsonData = gson.fromJson(jsonString,JsonData::class.java)
        //val serialize : String = gson.toJson(JsonData::class.java)

    }
}