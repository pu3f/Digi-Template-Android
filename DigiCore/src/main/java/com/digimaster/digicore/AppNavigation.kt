package com.digimaster.digicore

import android.content.Context
import android.content.Intent

class AppNavigation {

    companion object {

        val BASE_PACKAGE_APP = "com.digimaster.template"
        /*
        Add other module package here
         */

        fun openHomeActivity(context: Context) {
            val intent =
                Intent(context, Class.forName("$BASE_PACKAGE_APP.MainActivity"))
            context.startActivity(intent)
        }

    }
}