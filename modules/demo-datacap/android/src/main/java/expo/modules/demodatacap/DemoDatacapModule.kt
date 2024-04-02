package expo.modules.demodatacap

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition


// NOTE: This does not work correctly
import com.datacap.android.dsiEMVAndroid;

// Errors: "Unresolved reference: MainActivity"
// val dsiEMVAndroid = dsiEMVAndroid(MainActivity.this)

class DemoDatacapModule : Module() {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  override fun definition() = ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('DemoDatacap')` in JavaScript.
    Name("DemoDatacap")

    // Defines a JavaScript synchronous function that runs the native code on the JavaScript thread.
    Function("hello") {
      "Hello world! 👋"
    }

    // TODO: uncomment this and call dsiEMVAndroid -> ProcessTransaction
    // AsyncFunction("ProcessTransaction") { xmlString: String ->
    //   val mDSIEMVAndroid = dsiEMVAndroid(MainActivity())

    //   // pass in xml datacap command for running a sale or any other transaction
    //   Thread {
    //     mDSIEMVAndroid.ProcessTransaction(xmlString)
    //   }.start()

    //   //listen for the process transaction response
    //   DSIEMVAndroidInstance.getInstance(MainActivity()).AddProcessTransactionResponseListener(object : ProcessTransactionResponseListener {
    //     override fun OnProcessTransactionResponseChanged(response: String) {
    //       // read and process xml response
    //     }
    //   })
    // }
    
  }
}
