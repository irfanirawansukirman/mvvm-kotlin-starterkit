package com.avanzaxeniaclubid.acxi.irfanirawansukirman.util;

import android.annotation.TargetApi;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.os.Build;

//This LiveData emits NetWork information when network availability status changes and there is an active observer to it
public class ConnectivityUtil extends LiveData<Network> {
    private ConnectivityManager connectivityManager;

    private NetworkCallback listener = new NetworkCallback() {
        @Override
        public void onAvailable(Network network) {
            //this part runs on background thread so use postValue
            postValue(network);
        }

        @Override
        public void onLost(Network network) {
            postValue(network);
        }
    };

    public ConnectivityUtil(Context context) {
        //get connectivity system service
        connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Override
    protected void onActive() {
        //onActive is called when there is an active observer to this LiveData
        //since active LiveData observers are there, add network callback listener to connectivity manager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(listener);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onInactive() {
        //onActive is called when there is no active observer to this LiveData
        //as no active observers exist, remove netwrok callback from connectivity manager
        connectivityManager.unregisterNetworkCallback(listener);
    }
}
