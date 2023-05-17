package DemoSeuredPreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceManager
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.myapplication.R

class DemoSecuredSharedPreferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_secured_shared_preferences)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val data : SharedPreferences.Editor = prefs.edit()
        data.putString("name","anand")
        data.putString("age","22")
        data.putString("email","anand@yudiz.com")
        data.putString("phone","7600740075")
        data.apply()
        data.commit()

        /*getEncryptedSharedPrefs().edit()
            .putString("name","anand")
            .putString("age","22")
            .putString("email","anand@yudiz.com")
            .putString("phone","7600740075")
            .apply()
        Log.d("my number", getEncryptedSharedPrefs().getString("phone","").toString())*/
    }

    /*private fun getEncryptedSharedPrefs(): SharedPreferences {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        return EncryptedSharedPreferences.create(
            "secured_prefs",
            masterKeyAlias,
            this,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM)
    }*/
}