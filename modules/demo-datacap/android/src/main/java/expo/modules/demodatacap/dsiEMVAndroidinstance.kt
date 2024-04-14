package expo.modules.demodatacap

import android.content.Context
import com.datacap.android.dsiEMVAndroid

object dsiEMVAndroidinstance {
    @Volatile
    private var instance: dsiEMVAndroid? = null
    @JvmStatic
    fun getInstance(context: Context?): dsiEMVAndroid? {
        if (instance == null) {
            synchronized(dsiEMVAndroid::class.java) {
                if (instance == null) {
                    instance = dsiEMVAndroid(context)
                }
            }
        }
        return instance
    }
}
