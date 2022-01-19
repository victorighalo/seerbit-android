package com.seerbit.seerbit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.seerbit.seerbitandroid.view.webviews.TransactionModel;
import com.seerbit.seerbitandroid.view.presentation.SeerbitView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    SeerbitView seerbitWebView;
    FrameLayout webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
        TransactionModel transactionModel = new TransactionModel();
        String transRef = String.valueOf(System.currentTimeMillis());
        transactionModel.setTranref(transRef);
        transactionModel.setCurrency("NGN");
        transactionModel.setEmail("adewoleopw@gmail.com");
        transactionModel.setAmount("1000");
        transactionModel.setDescription("Payment of bils");
        transactionModel.setCountry("NG");
        transactionModel.setCallbackurl("https://whatever.com");
        transactionModel.setPublic_key("SBTESTPUBK_y9xF4issbbpKaMEnP5Fv4y0u75523ko2");
        transactionModel.setFull_name("Adewole Opeyemi");
        transactionModel.setCloseOnSuccess(false);
        transactionModel.setClosePrompt(false);
        transactionModel.setSetAmountByCustomer(false);
        seerbitWebView = new SeerbitView(this);
        webView.addView(seerbitWebView);
        seerbitWebView.open(transactionModel);
        getSupportActionBar().hide();
    }
}