package com.example.firebaseassistanttest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class FirebaseUIActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int RC_SIGN_IN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_ui);

        Button firebaseUIAuthBtn = (Button)findViewById(R.id.firebaseuiauthbtn);
        firebaseUIAuthBtn.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN){
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if(resultCode == RESULT_OK){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            }else {

            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.firebaseuiauthbtn:
                signIn();
                break;
                default:
                    break;
        }
    }

    private void signIn() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                .setTheme(getSelectedTheme())
                .setLogo(getSelectedLogo())
                .setAvailableProviders(getSelectedProviders())
                .setTosAndPrivacyPolicyUrls("https://naver.com","https://google.com")
                .setIsSmartLockEnabled(true)
                .build(),
                RC_SIGN_IN
        );
    }

    private List<AuthUI.IdpConfig> getSelectedProviders() {
        List<AuthUI.IdpConfig>selectedProviders = new ArrayList<>();
        CheckBox googlechk = (CheckBox)findViewById(R.id.goglle_provider);

        if(googlechk.isChecked()){
            selectedProviders.add(new AuthUI.IdpConfig.GoogleBuilder().build());

        }
        return selectedProviders;
    }

    private int getSelectedLogo() {
        return AuthUI.NO_LOGO;
    }

    private int getSelectedTheme() {
        return AuthUI.getDefaultTheme();
    }


}
