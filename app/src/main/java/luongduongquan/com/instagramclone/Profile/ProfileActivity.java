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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import luongduongquan.com.instagramclone.R;
import luongduongquan.com.instagramclone.Utils.BottomNavigationViewHelper;
import luongduongquan.com.instagramclone.Utils.GridImageAdapter;
import luongduongquan.com.instagramclone.Utils.UniversalImageLoader;

public class ProfileActivity extends AppCompatActivity {
	private static final String TAG = "ProfileActivity";

	private static  final int ACTIVITY_NUM = 4;
	private static final int NUM_GRID_COLUMNS = 3;

	private Context mContext = ProfileActivity.this;
	private ProgressBar mProgressBar;
	private ImageView imgProfilePhoto;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		Log.d(TAG, "onCreate: ");

		mProgressBar = findViewById(R.id.progressBar_Profile);
		mProgressBar.setVisibility(View.GONE);

		setupBottomNavigationView();
		setupToolbar();

		setupActivityWidgets();
		setProfileImage();
		tempGridSetup();
	}

	private void tempGridSetup(){
		ArrayList<String> imgURLs = new ArrayList<>();
		imgURLs.add("https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg");
		imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
		imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg");
		imgURLs.add("http://i.imgur.com/EwZRpvQ.jpg");
		imgURLs.add("http://i.imgur.com/JTb2pXP.jpg");
		imgURLs.add("https://i.redd.it/59kjlxxf720z.jpg");
		imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
		imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
		imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
		imgURLs.add("http://i.imgur.com/j4AfH6P.jpg");
		imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
		imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");

		setupImageGridView(imgURLs);
	}

	private void setupImageGridView(ArrayList<String> imgURLs){
		GridView gridView = (GridView) findViewById(R.id.gridView);

		int gridWidth = getResources().getDisplayMetrics().widthPixels;
		int imageWidth = gridWidth/NUM_GRID_COLUMNS;
		gridView.setColumnWidth(imageWidth);

		GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgURLs);
		gridView.setAdapter(adapter);


	}

	private void setProfileImage(){
		Log.d(TAG, "setProfileImage: setting Profile photo");
		String url = "https://mk0gizmoidsbgcpdmtk7.kinstacdn.com/wp-content/uploads/2015/11/REL-Android.png";
		UniversalImageLoader.setImage(url, imgProfilePhoto,null, "");
	}

	private void setupActivityWidgets(){
		mProgressBar = findViewById(R.id.progressBar_Profile);
		mProgressBar.setVisibility(View.GONE);
		imgProfilePhoto = findViewById(R.id.imgAvatar_Profile);

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
