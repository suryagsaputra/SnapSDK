package com.example.andro.midtranssdktesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.midtrans.sdk.corekit.callback.CheckoutCallback;
import com.midtrans.sdk.corekit.callback.TransactionCallback;
import com.midtrans.sdk.corekit.callback.TransactionOptionsCallback;
import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.core.SdkCoreFlowBuilder;
import com.midtrans.sdk.corekit.core.TransactionRequest;
import com.midtrans.sdk.corekit.models.snap.EnabledPayment;
import com.midtrans.sdk.corekit.models.snap.Token;
import com.midtrans.sdk.corekit.models.snap.Transaction;

import java.util.List;
import java.util.UUID;

public class BaseActivity extends AppCompatActivity {

    public TransactionCallback callback;
    public String tokenAuth;
    public List<EnabledPayment> enabledPaymentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSDKMidtrans();
        //sdkInstance.paymentUsingBCAKlikpay(tokenAuth, callback);
    }

    public void setTransactionRequest(int grossAmount) {
        TransactionRequest transactionRequest = new TransactionRequest(UUID.randomUUID().toString(), grossAmount);
        transactionRequest.setItemDetails(UserInfo.getListItemDetails());
        transactionRequest.setBillingAddressArrayList(UserInfo.getListBillingAddress());
        MidtransSDK.getInstance().setTransactionRequest(transactionRequest);
    }

    void initSDKMidtrans() {
        SdkCoreFlowBuilder
                .init(this, BuildConfig.CLIENT_KEY, BuildConfig.BASE_URL)
            .enableLog(true)
            .buildSDK();
    }

    void initCheckout() {
        MidtransSDK.getInstance()
            .checkout(new CheckoutCallback() {
                @Override
                public void onSuccess(Token token) {
                    // Checkout token will be used to charge the transaction later
                    tokenAuth = token.getTokenId();
                    // Action when succeded
                    getTransactionOptions();
                }

                @Override
                public void onFailure(Token token, String reason) {
                    // Action when failed
                }

                @Override
                public void onError(Throwable error) {
                    // Action when error
                }
            });
    }


    public void getTransactionOptions() {
        MidtransSDK.getInstance()
            .getTransactionOptions(tokenAuth, new TransactionOptionsCallback() {
                @Override
                public void onSuccess(Transaction transaction) {
                    // List of enabled payment method string
                    enabledPaymentList = transaction.getEnabledPayments();
                }

                @Override
                public void onFailure(Transaction transaction, String reason) {
                }

                @Override
                public void onError(Throwable error) {
                }
            });
    }
}
