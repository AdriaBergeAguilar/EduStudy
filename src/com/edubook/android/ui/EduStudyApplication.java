package com.edubook.android.ui;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.edubook.android.R;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.Facebook;


public class EduStudyApplication extends Application {

	private static final String TAG = "EduStudyApplication";
	private static final String APP_ID = "404163189638916";
	
	public Facebook facebook;
	public AsyncFacebookRunner asyncRunner;
	
//	public ArrayList<Drink> drinks;
	
	public String userName;
	public Bitmap userPic;
	
	@Override
	public void onCreate() {
		super.onCreate();
		facebook = new Facebook(APP_ID);
		asyncRunner = new AsyncFacebookRunner(facebook);
		
		//restore session if one exists
        ApplicationStore.restoreSession(facebook, this);
        
        /* Create a dummy drinks list.
         * Using dummy data for drink info.
         */
//        drinks = new ArrayList<Drink>();
//        drinks.add(new Drink("Cafe Latte", "2 others enjoyed this", R.drawable.latte, "Small", "http://social-cafe.herokuapp.com/latte.php"));
//        drinks.add(new Drink("Iced Mocha", "6 others enjoyed this", R.drawable.icedmocha, "Large", "http://social-cafe.herokuapp.com/icedmocha.php"));
//        drinks.add(new Drink("Earl Grey Tea", "3 others enjoyed this", R.drawable.earlgrey, "Medium", "http://social-cafe.herokuapp.com/earlgrey.php"));
        
        //load user data (name and bitmap)
//        loadUserData();
	}
	
	public void saveSession() {
        ApplicationStore.saveSession(facebook, this);
	}
	
	public void clearSession() {
        ApplicationStore.clear(this);
	}
	
//	public void saveUserData(String name, Bitmap bmp) {
//		userName = name;
//		userPic = bmp;
//		String picFilename = UUID.randomUUID().toString() + ".jpg";
//		ApplicationStore.saveUserData(name, picFilename, this);
//		OutputStream out = null;
//		try {
//			out = openFileOutput(picFilename, Context.MODE_PRIVATE);
//			bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
//		} catch (Exception e) {
//		   e.printStackTrace();
//		}
//		finally {
//			if (out != null) {
//				try {
//					out.close();
//				} catch (IOException e) {
//					Log.e (TAG, "Error closing the OutputStream: ", e);
//				}
//			}
//		}
//	}
	
//	public void loadUserData() {
//		userName = ApplicationStore.restoreUserName(this);
//		String bitmapFile = ApplicationStore.restoreUserPicFileName(this);
//		if (bitmapFile != null) {
//			String bitmapPath = getFileStreamPath(bitmapFile).getAbsolutePath();
//			userPic = BitmapFactory.decodeFile(bitmapPath);
//		}
//	}
	
	
	
	
	
	
	
	
	
	
}
