package luongduongquan.com.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import luongduongquan.com.instagramclone.R;
import luongduongquan.com.instagramclone.Utils.BottomNavigationViewHelper;

public class ProfileActivity extends AppCompatActivity {
	private static final String TAG = "ProfileActivity";

	private static  final int ACTIVITY_NUM = 4;

	private Context mContext = ProfileActivity.this;
	private ProgressBar mProgressBar;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		Log.d(TAG, "onCreate: ");

		mProgressBar = findViewById(R.id.progressBar_Profile);
		mProgressBar.setVisibility(View.GONE);

		setupBottomNavigationView();
		setupToolbar();
	}

	private void setupToolbar(){
		android.support.v7.widget.Toolbar toolbar = findViewById(R.id.profileToolBar);
		setSupportActionBar(toolbar);

		ImageView btnProfileMenu = findViewById(R.id.img_profileMenu);
		btnProfileMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClick: intent to AccountSettings");
				Intent intent = new Intent(ProfileActivity.this, AccountSettingsActivity.class);
				startActivity(intent);
			}
		});
	}

	private void setupBottomNavigationView(){

		Log.d(TAG, "setupBottomNavigationView: set up");
		BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNaviViewBar);
		BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);

		BottomNavigationViewHelper.startIntentFromNavigation(mContext, bottomNavigationViewEx);

		Menu menu = bottomNavigationViewEx.getMenu();
		MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
		menuItem.setChecked(true);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//
////		getMenuInflater().inflate(R.menu.profile_menu, menu);
//
//		return true;
//	}
}
