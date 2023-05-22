import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.myapplication.WorkManagerActivity

class FileDownloadWorker : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("Action", intent?.action.toString())
        when (intent?.action) {
            "Start" -> Log.d("Start", "Register")
            "Stop" -> Log.d("Stop", "UnRegister")

            override fun onReceive(context: Context?
                , intent: Intent
                ) {
                val actionOnBroadCast = WorkManagerActivity()
                Log.d("Action", intent?.action.toString())
                val percentageData = intent?.getIntExtra("level", 0)

                // actionOnBroadCast.liveBatteryData.text = "Your battery percentage is "+percentageData.toString()+"%"
                try {
                    when (intent.action) {
                        "Start" -> {
                            actionOnBroadCast.register(percentageData)
                            Toast.makeText(context, "Start", Toast.LENGTH_SHORT).show()
                        }
                        "Stop" -> {
                            actionOnBroadCast.unregister()
                            Toast.makeText(context, "Stop", Toast.LENGTH_SHORT).show()
                        }
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "$e", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}