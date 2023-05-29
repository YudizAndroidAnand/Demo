package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject


class JsonPassingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_passing)
        val data = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"Leanne Graham\",\n" +
                "  \"username\": \"Bret\",\n" +
                "  \"email\": \"Sincere@april.biz\",\n" +
                "  \"address\": {\n" +
                "    \"street\": \"Kulas Light\",\n" +
                "    \"suite\": \"Apt. 556\",\n" +
                "    \"city\": \"Gwenborough\",\n" +
                "    \"zipcode\": \"92998-3874\",\n" +
                "    \"geo\": {\n" +
                "      \"lat\": \"-37.3159\",\n" +
                "      \"lng\": \"81.1496\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"phone\": \"1-770-736-8031 x56442\",\n" +
                "  \"website\": \"hildegard.org\",\n" +
                "  \"company\": {\n" +
                "    \"name\": \"Romaguera-Crona\",\n" +
                "    \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                "    \"bs\": \"harness real-time e-markets\"\n" +
                "  }\n" +
                "}"
        val json = JSONObject(data)
        val id = json.getInt("id")
        val name = json.getString("name")
        val street = json.getJSONObject("address").getString("street")
        val lng = json.getJSONObject("address").getJSONObject("geo").getDouble("lng")
        val phone = json.getString("phone")
        val companyName = json.getJSONObject("company").getString("name")
        println(id)
        println(name)
        println(street)
        println(lng)
        println(phone)
        println(companyName)
    }
}