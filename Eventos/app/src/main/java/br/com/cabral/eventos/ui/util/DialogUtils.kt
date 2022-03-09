package br.com.cabral.eventos.ui.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import br.com.cabral.eventos.R

class DialogUtils {

    companion object {

        fun alert(
            context: Context,
            title: Int? = null,
            message: Int? = null,
            onClickListener: DialogInterface.OnClickListener
        ): AlertDialog {
            val builder = AlertDialog.Builder(context)
                .setTitle(title ?: R.string.call_error_title)
                .setMessage(message ?: R.string.call_error_msg)
                .setPositiveButton(R.string.button_ok, onClickListener)

            val dialog: AlertDialog = builder.create()
            dialog.show()

            return dialog
        }

    }

}