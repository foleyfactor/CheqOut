package com.masseyhacks.sjam.cheqout;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.LineItem;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.PaymentMethodTokenizationParameters;
import com.google.android.gms.wallet.PaymentMethodTokenizationType;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.WalletConstants;
import com.google.android.gms.wallet.fragment.SupportWalletFragment;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.masseyhacks.sjam.cheqout.cart.CartActivity;

import java.util.HashMap;

public class PaymentActivity extends FragmentActivity{// implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
//    public static String TAG = "StripePayment";
//
    private HashMap<String, Double> items;
    private int total;
//
//    private GoogleApiClient googleApiClient;
//
//    // You will need to use your live API key even while testing
//    public static final String PUBLISHABLE_KEY = "pk_live_XXX";
//
//    // Unique identifiers for asynchronous requests:
//    private static final int LOAD_MASKED_WALLET_REQUEST_CODE = 1000;
//    private static final int LOAD_FULL_WALLET_REQUEST_CODE = 1001;
//
//    private SupportWalletFragment walletFragment;
//
//    //keep track of your current environment,
//    //change to WalletConstants.ENVIRONMENT_PRODUCTION when you're ready to go live
//    public static final int mEnvironment = WalletConstants.ENVIRONMENT_TEST;
//
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        Intent intent = getIntent();
//        items = (HashMap) intent.getSerializableExtra("items");
//        total = intent.getIntExtra("total", 0);
//        Log.w(TAG, String.valueOf(total));
//        Log.w(TAG, items.toString());
//
//        googleApiClient = new GoogleApiClient.Builder(this)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .addApi(Wallet.API, new Wallet.WalletOptions.Builder()
//                        .setEnvironment(WalletConstants.ENVIRONMENT_TEST)
//                        .setTheme(WalletConstants.THEME_LIGHT)
//                        .build())
//                .build();
//
//        Wallet.Payments.isReadyToPay(googleApiClient).setResultCallback(
//                new ResultCallback<BooleanResult>() {
//                    @Override
//                    public void onResult(@NonNull BooleanResult booleanResult) {
//                        if (booleanResult.getStatus().isSuccess()) {
////                            if (booleanResult.getValue()) {
//                                Log.w(TAG, "SHOWING ANDROID PAY SHOWING ANDROID PAY SHOWING ANDROID PAY SHOWING ANDROID PAY SHOWING ANDROID PAY");
//                                showAndroidPay();
////                            } else {
////                                // Hide Android Pay buttons, show a message that Android Pay
////                                // cannot be used yet, and display a traditional checkout button
////                                Log.e(TAG, "YOU BROKES IT");
////                            }
//                        } else {
//                            // Error making isReadyToPay call
//                            Log.e(TAG, "isReadyToPay:" + booleanResult.getStatus());
//                        }
//                    }
//                });
//    }
//
//    public void showAndroidPay() {
//        setContentView(R.layout.activity_payment);
//
//        walletFragment =
//                (SupportWalletFragment) getSupportFragmentManager().findFragmentById(R.id.wallet_fragment);
//
//        MaskedWalletRequest maskedWalletRequest = MaskedWalletRequest.newBuilder()
//
//                // Request credit card tokenization with Stripe by specifying tokenization parameters:
//                .setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters.newBuilder()
//                        .setPaymentMethodTokenizationType(PaymentMethodTokenizationType.PAYMENT_GATEWAY)
//                        .addParameter("gateway", "stripe")
//                        .addParameter("stripe:publishableKey", PUBLISHABLE_KEY)
//                        .addParameter("stripe:version", com.stripe.Stripe.VERSION)
//                        .build())
//
//                // You want the shipping address:
//                .setShippingAddressRequired(true)
//
//                // Price set as a decimal:
//                .setEstimatedTotalPrice("20.00")
//                .setCurrencyCode("CAD")
//                .build();
//
//        // Set the parameters:
//        WalletFragmentInitParams initParams = WalletFragmentInitParams.newBuilder()
//                .setMaskedWalletRequest(maskedWalletRequest)
//                .setMaskedWalletRequestCode(LOAD_MASKED_WALLET_REQUEST_CODE)
//                .build();
//
//        // Initialize the fragment:
//        walletFragment.initialize(initParams);
//    }
//
//    public void onStart() {
//        super.onStart();
//        googleApiClient.connect();
//    }
//
//    public void onStop() {
//        super.onStop();
//        googleApiClient.disconnect();
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == LOAD_MASKED_WALLET_REQUEST_CODE) { // Unique, identifying constant
//            if (resultCode == Activity.RESULT_OK) {
//                MaskedWallet maskedWallet = data.getParcelableExtra(WalletConstants.EXTRA_MASKED_WALLET);
//                FullWalletRequest fullWalletRequest = FullWalletRequest.newBuilder()
//                        .setCart(Cart.newBuilder()
//                                .setCurrencyCode("USD")
//                                .setTotalPrice("20.00")
//                                .addLineItem(LineItem.newBuilder() // Identify item being purchased
//                                        .setCurrencyCode("USD")
//                                        .setQuantity("1")
//                                        .setDescription("Premium Llama Food")
//                                        .setTotalPrice("20.00")
//                                        .setUnitPrice("20.00")
//                                        .build())
//                                .build())
//                        .setGoogleTransactionId(maskedWallet.getGoogleTransactionId())
//                        .build();
//                Wallet.Payments.loadFullWallet(googleApiClient, fullWalletRequest, LOAD_FULL_WALLET_REQUEST_CODE);
//            }
//        } else if (requestCode == LOAD_FULL_WALLET_REQUEST_CODE) {
//            if (resultCode == Activity.RESULT_OK) {
//                FullWallet fullWallet = data.getParcelableExtra(WalletConstants.EXTRA_FULL_WALLET);
//                String tokenJSON = fullWallet.getPaymentMethodToken().getToken();
//
//                //A token will only be returned in production mode,
//                //i.e. WalletConstants.ENVIRONMENT_PRODUCTION
//                if (mEnvironment == WalletConstants.ENVIRONMENT_PRODUCTION)
//                {
//                    com.stripe.model.Token token = com.stripe.model.Token.GSON.fromJson(
//                            tokenJSON, com.stripe.model.Token.class);
//
//                    // TODO: send token to your server
//                }
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }
//
//    @Override
//    public void onConnectionFailed(ConnectionResult connectionResult) {}
//
//    @Override
//    public void onConnected(Bundle bundle) {}
//
//    @Override
//    public void onConnectionSuspended(int i) {}

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        Intent intent = getIntent();
        items = (HashMap) intent.getSerializableExtra("items");
        total = intent.getIntExtra("total", 0);
        Log.w("a", String.valueOf(total));
        Log.w("a", items.toString());

        Toast.makeText(getApplicationContext(), "Payment accepted", Toast.LENGTH_LONG).show();

        Intent intent2 = new Intent(getApplicationContext(), CartActivity.class);
        intent2.putExtra("items", items);
        intent2.putExtra("brain", true);
        startActivity(intent2);
    }
}
