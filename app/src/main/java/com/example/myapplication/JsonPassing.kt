package com.example.myapplication

import com.google.gson.annotations.SerializedName
import org.json.JSONArray

data class JsonPassing(
    var id: Int,
    var title: String,
    var body: String,
    var userId: Int,
    var country: JSONArray,
    var number: Int,
    var geo : Geo) {
    override fun toString(): String {
        return "Post(id=$id, title='$title', body='$body', userId=$userId, tags=$country, reactions=$number, geo=$geo)"
    }

}
data class Geo(val lat : Double ,val lng : Double){
}


