package id.ac.unpad.profolio.util.ext

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Using it for replacement fragment
 *
 * @param fragment => your fragment class
 * @param frameId => your container layout id
 */
fun AppCompatActivity.replaceFragmentInActivity(
    fragment: Fragment,
    frameId: Int
) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
    }

    //=========== How to using it ===========
    // override fun onYourMethod() {
    //      replaceFragmentInActivity(Fragment.newInstance(), R.id.frame_container)
    // }
    //=======================================
}

//fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
//    ViewModelProviders.of(this, VMFactory.getInstance(application)).get(viewModelClass)

/**
 * Using it for replacement fragment and add it into backstack
 *
 * @param fragment => your fragment class
 * @param frameId => your container layout id
 * @param TAG => your TAG usually the name of activity class
 */
fun AppCompatActivity.replaceFragmentInActivityWithBackStack(
    fragment: Fragment,
    frameId: Int,
    TAG: String?
) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
        addToBackStack(TAG)
    }

    //=========== How to using it ===========
    // override fun onYourMethod() {
    //      replaceFragmentInActivityWithBackStack(Fragment.newInstance(), R.id.frame_container, TAG)
    // }
    //=======================================
}

private inline fun FragmentManager.transact(
    action: FragmentTransaction.() -> Unit
) {
    beginTransaction().apply {
        action()
    }.commit()
}

/**
 * Using it for making your status bar is transparent
 *
 * @param decorView => your global view in activity
 */
@SuppressLint("ObsoleteSdkInt")
fun AppCompatActivity.transparentStatusBar(
    decorView: View?
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    //=========== How to using it ===========
    //override fun onCreate(savedInstanceState: Bundle?) {
    //    super.onCreate(savedInstanceState)
    //    setContentView(resLayout)
    //    transparentStatusBar(window.decorView)
    //}
    //=======================================
}

fun AppCompatActivity.refreshPage() {
    finish()
    overridePendingTransition( 0, 0)
    startActivity(intent)
    overridePendingTransition( 0, 0)
}