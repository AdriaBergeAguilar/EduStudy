package com.edubook.android.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.edubook.android.R;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

public class LoginActivity extends FragmentActivity {
	
	protected final int AUTHORIZE_ACTIVITY_RESULT_CODE = 0;
	String[] permissions = {"publish_actions"};
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_login, menu);
        return true;
    }
    
    public void onLogin(View view) {
    	// This will launch Single Sign On if Facebook app is installed
		// else go to webview for web outh.
    	((EduStudyApplication)getApplication()).facebook.authorize(LoginActivity.this, permissions, AUTHORIZE_ACTIVITY_RESULT_CODE, new LoginDialogListener());
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	switch(requestCode) {
	    	case AUTHORIZE_ACTIVITY_RESULT_CODE: {
	    		((EduStudyApplication)getApplication()).facebook.authorizeCallback(requestCode, resultCode, data);
	    		break;
	    	}
    	}
    }
    
    private final class LoginDialogListener implements DialogListener {
    	
        public void onComplete(Bundle values) {
        	finish();
        	//Save the session and launch the Menu activity
        	((EduStudyApplication)getApplication()).saveSession();
        	startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        }

        public void onFacebookError(FacebookError error) {
    		Toast.makeText(LoginActivity.this, "Facebook Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
        }
        
        public void onError(DialogError error) {
    		Toast.makeText(LoginActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
        }

        public void onCancel() {
    		Toast.makeText(LoginActivity.this, "Action Cancelled", Toast.LENGTH_LONG).show();
        }
    }
    
}
