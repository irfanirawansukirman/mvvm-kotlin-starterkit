package id.ac.unpad.profolio.util.ext

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

inline fun <FRAGMENT : Fragment> FRAGMENT.putArgs(argsBuilder: Bundle.() -> Unit):
        FRAGMENT = this.apply { arguments = Bundle().apply(argsBuilder) }

fun Fragment.onFinish() {
    activity?.finish()
}

//fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
//    ViewModelProviders.of(this, VMFactory.getInstance(application)).get(viewModelClass)