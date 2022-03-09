package br.com.cabral.eventos.ui.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.icu.text.CaseMap
import br.com.cabral.eventos.R

class DialogUtils {

    companion object {

        fun alert(
            context: Context,
            title: Int,
            message: Int,
            onClickListener: DialogInterface.OnClickListener
        ): AlertDialog {

            val builder = AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.button_ok, onClickListener)

            val dialog: AlertDialog = builder.create()
            dialog.show()

            return dialog
        }

    }

}