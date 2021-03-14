package co.spoonradio.recruit.presentation.detail

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import co.spoonradio.recruit.R

class LoadingDialogFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        isCancelable = false
        return inflater.inflate(R.layout.fragment_loading_dialog, container, false)
    }

    override fun show(manager: FragmentManager, tag: String?) {
        try {
            val transaction = manager.beginTransaction()
            transaction.add(this, tag)
            transaction.commitAllowingStateLoss()
        } catch (ignored: IllegalStateException) {

        }
    }
}