package com.example.wind.tofind.menu_mvp.other;

/**
 * when news loaded, this interface is called
 */
public interface OnLoadDataListener {
    void onSuccess();
    void onFailure(String msg);
}
