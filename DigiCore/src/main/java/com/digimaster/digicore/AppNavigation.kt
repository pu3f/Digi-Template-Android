package com.digimaster.digicore

import android.content.Context
import android.content.Intent

class AppNavigation {

    companion object {

        val BASE_PACKAGE_APP = "com.digimaster.template"
        val BASE_PACKAGE_FEATUREA = "com.digimaster.featurea"
        val BASE_PACKAGE_FEATUREB = "com.digimaster.featureb"

        /*
        Add other module package here
         */

        fun openHomeActivity(context: Context) {
            val intent =
                Intent(context, Class.forName("$BASE_PACKAGE_APP.MainActivity"))
            context.startActivity(intent)
        }

        fun openFeatureAActivity(context: Context){
            val intent = Intent(context, Class.forName("$BASE_PACKAGE_FEATUREA.FeatureAActivity"))
            context.startActivity(intent)
        }

        fun openFeatureBActivity(context: Context){
            val intent = Intent(context, Class.forName("$BASE_PACKAGE_FEATUREB.FeatureBActivity"))
            context.startActivity(intent)
        }
    }
}