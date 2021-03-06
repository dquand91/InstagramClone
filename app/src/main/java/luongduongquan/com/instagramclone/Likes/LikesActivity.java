package luongduongquan.com.instagramclone.Likes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import luongduongquan.com.instagramclone.R;
import luongduongquan.com.instagramclone.Utils.BottomNavigationViewHelper;

public class LikesActivity extends AppCompatActivity {
	private static final String TAG = "LikesActivity";

	private static  final int ACTIVITY_NUM = 3;

	private Context mContext = LikesActivity.this;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Log.d(TAG, "onCreate: ");
		setupBottomNavigationView();

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
}
