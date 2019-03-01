package id.ac.unpad.profolio.util

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.R

class DialogUtil {

    fun openProgressDialog(
        context: Context,
        message: String?,
        title: String?,
        cancelOutsideDialog: Boolean
    ): ProgressDialog {
        return ProgressDialog(context).apply {
            setTitle(title ?: context.getString(R.string.app_name))
            setMessage(message ?: "Loading")
            setCanceledOnTouchOutside(cancelOutsideDialog)
        }
    }

    fun openAlertDialog(
        context: Context,
        message: String?,
        title: String?,
        cancelOutsideDialog: Boolean,
        positiveTitle: String,
        negativeTitle: String,
        alertDialogCallback: AlertCallbackDialog
    ): Dialog {
        return AlertDialog
            .Builder(context)
            .setTitle(title ?: context.getString(R.string.app_name))
            .setMessage(message ?: "Loading")
            .setCancelable(cancelOutsideDialog)
            .setPositiveButton(positiveTitle) { dialog, which ->
                alertDialogCallback.onPositiveDialogClicked(
                    dialogInterface = dialog,
                    which = which
                )
            }
            .setNegativeButton(negativeTitle) { dialog, which ->
                alertDialogCallback.onNegativeDialogClicked(
                    dialogInterface = dialog,
                    which = which
                )
            }
            .create()
    }

    fun openAlertDialogWithSingleButton(
            context: Context,
            message: String?,
            title: String?,
            cancelOutsideDialog: Boolean,
            positiveTitle: String,
            alertDialogCallback: AlertCallbackDialog
    ): Dialog {
        return AlertDialog
                .Builder(context)
                .setTitle(title ?: context.getString(R.string.app_name))
                .setMessage(message ?: "Loading")
                .setCancelable(cancelOutsideDialog)
                .setPositiveButton(positiveTitle) { dialog, which ->
                    alertDialogCallback.onPositiveDialogClicked(
                            dialogInterface = dialog,
                            which = which
                    )
                }
                .create()
    }

    interface AlertCallbackDialog {
        fun onPositiveDialogClicked(dialogInterface: DialogInterface?, which: Int)
        fun onNegativeDialogClicked(dialogInterface: DialogInterface?, which: Int)
    }

}
