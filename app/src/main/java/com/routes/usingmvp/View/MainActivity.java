package com.routes.usingmvp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.routes.usingmvp.Presenter.MainActivityPresenter;
import com.routes.usingmvp.R;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    private MainActivityPresenter presenter;
    private TextView myTextView, nameStrong;
    private ProgressBar progressBar;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  Toolbar toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        presenter = new MainActivityPresenter(this);

        myTextView = findViewById(R.id.myTextView);
        nameStrong = findViewById(R.id.nameStrong);
        EditText userName = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        initProgressBar();


        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.updateFullName(s.toString());

                presenter.userNameStrong(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                hideProgressBar();
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.updateEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                hideProgressBar();
            }
        });

    }



    private void initProgressBar() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);
        progressBar.setIndeterminate(true);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Resources.getSystem().getDisplayMetrics().widthPixels,
                250);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addContentView(progressBar, params);
        showProgressBar();
    }

    @Override
    public void updateUserInfoTextView(String info) {
        myTextView.setText(info);
    }

    @Override
    public void userNameStrong(String usernameStrong) {
        nameStrong.setText(usernameStrong);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
