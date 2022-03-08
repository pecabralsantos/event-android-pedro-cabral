package br.com.cabral.eventos.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        setupValidation()
        setupObservers()

        return dialog.create()
    }

    private fun setupValidation() {
        binding.etName.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validateButton()
            }

            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                validateButton()
            }

            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    private fun validateButton() {
        binding.btnMakeReservation.isEnabled =
            !(binding.etName.text.toString().isEmpty() || binding.etEmail.text.toString().isEmpty())
    }

    private fun setupObservers() {
        binding.btnCancel.setOnClickListener { dismiss() }

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
    }

}