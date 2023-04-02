package org.sperixlabs.androidsecuritysuite

import android.content.Context
import android.content.pm.ApplicationInfo
import android.os.Build
import com.scottyab.rootbeer.RootBeer

class AndroidSecuritySuite(context: Context) {
    private val rootBeer: RootBeer
    private val ctx: Context = context

    init {
        rootBeer = RootBeer(context)
    }

    /*
    * This method is used to determine the true/false device root status
    * */
    fun isRooted(): Boolean {
        return rootBeer.isRooted
    }

    /*
    This method is used to determine if an application is being debugged
    */
    fun amIDebugged(): Boolean {
        return 0 !=  ctx.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE
    }

    /*
       This method is used to determine if an application is being run in an emulator
    */
    fun amIRunInEmulator(): Boolean {
        return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.HARDWARE.contains("goldfish")
                || Build.HARDWARE.contains("ranchu")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || Build.PRODUCT.contains("sdk_google")
                || Build.PRODUCT.contains("google_sdk")
                || Build.PRODUCT.contains("sdk")
                || Build.PRODUCT.contains("sdk_x86")
                || Build.PRODUCT.contains("sdk_gphone64_arm64")
                || Build.PRODUCT.contains("vbox86p")
                || Build.PRODUCT.contains("emulator")
                || Build.PRODUCT.contains("simulator")
    }

}