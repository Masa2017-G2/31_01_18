package com.sheygam.masa_2017_31_01_18;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpAppCompatActivity implements IMainView{

    @InjectPresenter
    MainPresenter mPresenter;

    @BindView(R.id.myProgress)
    ProgressBar myProgress;

    @BindView(R.id.resultTxt)
    TextView resultTxt;

    @BindView(R.id.startBtn)
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.startBtn)
    void startBtn(){
        mPresenter.actionStart();
    }

    @Override
    public void showProgress() {
        myProgress.setVisibility(View.VISIBLE);
        startBtn.setEnabled(false);
    }

    @Override
    public void hideProgress() {
        myProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void updateCount(String count) {
        resultTxt.setText(count);
    }

    @Override
    public void showResult() {
        resultTxt.setText("Done!");
        startBtn.setEnabled(true);
    }
}
