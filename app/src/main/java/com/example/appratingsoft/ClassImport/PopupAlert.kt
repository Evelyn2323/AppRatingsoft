package com.example.appratingsoft.ClassImport

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class PopupAlert {
    fun toastSuccess(context: Context?, title: String, message: String) {
        MotionToast.createColorToast(
            context as Activity,
            title,
            message,
            MotionToastStyle.SUCCESS,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.LONG_DURATION,
            ResourcesCompat.getFont(context, www.sanju.motiontoast.R.font.helvetica_regular)
        )
    }

    fun toastError(context: Context, title: String, message: String) {
        MotionToast.createColorToast(
            context as Activity,
            title,
            message,
            MotionToastStyle.ERROR,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.LONG_DURATION,
            ResourcesCompat.getFont(context, www.sanju.motiontoast.R.font.helvetica_regular)
        )
    }


    fun toastWarning(context: Context, title: String, message: String) {
        MotionToast.darkToast(
            context as Activity,
            title,
            message,
            MotionToastStyle.WARNING,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.LONG_DURATION,
            ResourcesCompat.getFont(context, www.sanju.motiontoast.R.font.helvetica_regular)
        )
    }

    fun toastError(context: Context, title: String, message: String, duration: Int = Toast.LENGTH_SHORT) {
        MotionToast.createColorToast(
            context as Activity,
            title,
            message,
            MotionToastStyle.ERROR,
            MotionToast.GRAVITY_BOTTOM,
            duration.toLong(),
            ResourcesCompat.getFont(context, www.sanju.motiontoast.R.font.helvetica_regular)
        )
    }


}