package com.sheygam.masa_2017_31_01_18;

import com.arellomobile.mvp.MvpView;

/**
 * Created by gregorysheygam on 31/01/2018.
 */

public interface IMainView  extends MvpView{
    void showProgress();
    void hideProgress();
    void updateCount(String count);
    void showResult();
}
