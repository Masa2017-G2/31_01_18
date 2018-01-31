package com.sheygam.masa_2017_31_01_18;

import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

/**
 * Created by gregorysheygam on 31/01/2018.
 */
@InjectViewState
public class MainPresenter extends MvpPresenter<IMainView> implements IMainPresenter{
    @Override
    public void actionStart() {
        new AsyncTask<Void,String,Void>(){

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                getViewState().showProgress();
            }

            @Override
            protected void onProgressUpdate(String... values) {
                getViewState().updateCount(values[0]);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                for (int i = 0; i < 10; i++) {
                    publishProgress(String.valueOf(i));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().hideProgress();
                getViewState().showResult();
            }
        }.execute();
    }
}
