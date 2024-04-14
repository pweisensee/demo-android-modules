package expo.modules.demodatacap


import com.datacap.android.dsiEMVAndroid
import expo.modules.demodatacap.dsiEMVAndroidinstance.getInstance
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

import android.content.Intent
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import java.util.logging.Logger
import androidx.room.TypeConverter
import androidx.room.TypeConverters

class Converters {
  @TypeConverter
  fun fromString(value: String): Unit {
    return Unit
  }

  @TypeConverter
  fun unitToString(unitValue: Unit): String {
    return unitValue.toString()
  }
}

class AppActivityModule : AppCompatActivity() {
  fun bringtofront() {
    runOnUiThread {
      
      Looper.prepare();
      val intent = Intent(this@AppActivityModule.applicationContext, this@AppActivityModule.javaClass)
      // You need this if starting
      //  the activity from a service
      intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
      intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
      startActivityIfNeeded(intent, 0)
    }
  }

}


@TypeConverters(Converters::class)
class DemoDatacapModule : Module() {

  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  override fun definition() = ModuleDefinition {
    
    val LOGGER = Logger.getLogger("Datacap")

    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('DemoDatacap')` in JavaScript.
    Name("DemoDatacap")


// curretly throwing error: java_vm_ext.cc:591] JNI DETECTED ERROR IN APPLICATION: JNI GetObjectRefType called with pending exception expo.modules.kotlin.exception.MissingTypeConverter: Cannot find type converter for '(kotlin.String) -> kotlin.Any'.
    Function("ProcessTransaction") { xmlString: String, callback: (String) -> Unit ->

      Looper.prepare();
      val appActivity = AppActivityModule()

      //pass the current activity as context for constructing the Android control
      // val mDSIEMVAndroid = dsiEMVAndroid(appActivity)

      //pass in xml datacap command for running a sale or any other transaction
      // Thread { mDSIEMVAndroid.ProcessTransaction(xmlString) }.start()


      Thread { //generates xml for running a sale
        //runs the sale to the connected device, this does not have to be a singleton.
        // It was used as a singleton here to support transactions through the local listener server.
        getInstance(appActivity)!!.ProcessTransaction(xmlString)
      }.start()

      //adding a response listener, since the processing the transaction could happen asynchronously we added support for a response callback.
      // This call back will return the response from the active "Process Transaction" call. In this demo app it is just displayed in the UI,
      // however normally it would be serialized into an object or parsed for receipt printing and persisted to an integrators transaction database.
      getInstance(appActivity)!!.AddProcessTransactionResponseListener { response ->
        appActivity.runOnUiThread {
//          if (mConnectedDevice == Datacap.PAX_ANDROID_IP) {
//            bringtofront()
//          }

          LOGGER.info("RESULT FOR OnProcessTransactionResponseChanged: $response")
          callback(response)
        }
      }


    }
  }

}


