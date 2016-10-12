package apidez.com.lab1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import apidez.com.lab1.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatTextView forgotPassword, signUpFb;
    private AppCompatEditText mEmail, mPassword;
    private AppCompatButton mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        forgotPassword = (AppCompatTextView) findViewById(R.id.tvForgotPass);
        signUpFb = (AppCompatTextView) findViewById(R.id.tvSignUpFb);
        mEmail = (AppCompatEditText) findViewById(R.id.etEmail);
        mPassword = (AppCompatEditText) findViewById(R.id.etPassword);
        mLogin = (AppCompatButton) findViewById(R.id.btnLogin);
        forgotPassword.setOnClickListener(this);
        signUpFb.setOnClickListener(this);
        mLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, StreamActivity.class);
                startActivity(intent);
                //startActivity(new Intent(LoginActivity.this, StreamActivity.class));
                break;
            case R.id.tvForgotPass:
                break;
            case R.id.tvSignUpFb:
                break;
        }
    }
}
