package br.com.cabral.eventos.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import br.com.cabral.eventos.databinding.DialogFragmentCheckInBinding
import br.com.cabral.eventos.ui.util.Constants.Companion.DIALOG_FRAGMENT_BUNDLE_EMAIL
import br.com.cabral.eventos.ui.util.Constants.Companion.DIALOG_FRAGMENT_BUNDLE_NAME
import br.com.cabral.eventos.ui.util.Constants.Companion.DIALOG_FRAGMENT_KEY

class CheckInDialogFragment : DialogFragment() {

    private lateinit var binding: DialogFragmentCheckInBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogFragmentCheckInBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setView(binding.root)

        binding.btnMakeReservation.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()

            Bundle().apply {
                putString(DIALOG_FRAGMENT_BUNDLE_NAME, name)
                putString(DIALOG_FRAGMENT_BUNDLE_EMAIL, email)
                parentFragmentManager.setFragmentResult(DIALOG_FRAGMENT_KEY, this)
            }
            dismiss()
        }

        return dialog.create()
    }

}