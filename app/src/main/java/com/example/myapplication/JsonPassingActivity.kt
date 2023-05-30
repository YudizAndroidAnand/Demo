package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject


class JsonPassingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_passing)
        val jsonString = "{\"id\":1," +
                "\"title\":\"His mother had always taught him\"," +
                "\"body\":\"He never looked down on those who were less fortunate or who had less money than him. But the stupidity of the group of people he was talking to made him change his mind.\"," +
                "\"userId\":9," +
                "\"tags\":[\"history\",\"american\",\"crime\"]," +
                "\"reactions\":2," +
                "\"geo\": {\n" +
                " \"lat\": \"-37.3159\",\n" +
                " \"lng\": \"81.1496\"\n" +
                " }  }"
        val jsonObject = JSONObject(jsonString)
        val id = jsonObject.getInt("id")
        val title = jsonObject.getString("title")
        val body = jsonObject.getString("body")
        val userId = jsonObject.getInt("userId")
        val tags = jsonObject.getJSONArray("tags")
        val reactions = jsonObject.getInt("reactions")
        val geoLat = jsonObject.getJSONObject("geo").getDouble("lat")
        val geoLng = jsonObject.getJSONObject("geo").getDouble("lng")
        val result = "$id/n $title/n $body/n $userId/n $tags/n $reactions/n $geoLat/n $geoLng"
        print(result)
    }
}