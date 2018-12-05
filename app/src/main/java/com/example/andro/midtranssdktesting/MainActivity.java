package com.example.andro.midtranssdktesting;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.midtrans.sdk.corekit.callback.TransactionCallback;
import com.midtrans.sdk.corekit.models.TransactionResponse;
import java.util.List;

public class MainActivity extends BaseActivity {

    Spinner enablePaymentSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTransactionRequest(10000);
        initCheckout();
    }

    public void initEnablePaymentSpinner(List<String> enablePaymentList) {
        enablePaymentSpinner = findViewById(R.id.spinner_enable_payment);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, enablePaymentList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enablePaymentSpinner.setAdapter(dataAdapter);
    }

    private void initTransactionCallback() {
        callback = new TransactionCallback() {
            @Override
            public void onSuccess(TransactionResponse transactionResponse) {

            }

            @Override
            public void onFailure(TransactionResponse transactionResponse, String s) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        };
    }
}
