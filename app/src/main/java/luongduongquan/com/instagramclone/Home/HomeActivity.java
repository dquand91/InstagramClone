package luongduongquan.com.instagramclone.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

import luongduongquan.com.instagramclone.R;
import luongduongquan.com.instagramclone.Utils.BottomNavigationViewHelper;
import luongduongquan.com.instagramclone.Utils.UniversalImageLoader;

public class HomeActivity extends AppCompatActivity {

	private static final String TAG = "HomeActivity";
	private static  final int ACTIVITY_NUM = 0;

	private Context mContext = HomeActivity.this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Log.d(TAG, "onCreate: ");
		initImageLoader();

		setupBottomNavigationView();

		setupViewPager();
	}

	/**
	 * Responsible for adding the 3 tabs: Camera, Home, Messages
	 */
	private void setupViewPager(){
		SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
		sectionPagerAdapter.addFragment(new CameraFragment());
		sectionPagerAdapter.addFragment(new HomeFragment());
		sectionPagerAdapter.addFragment(new MessageFragment());

		ViewPager viewPager = findViewById(R.id.viewpager_container_home);
		viewPager.setAdapter(sectionPagerAdapter);

		TabLayout tabLayout = findViewById(R.id.tabs_home);
		tabLayout.setupWithViewPager(viewPager);

		tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
		tabLayout.getTabAt(1).setIcon(R.drawable.ic_instagram_black);
		tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);

	}

	private void initImageLoader(){
		UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
		ImageLoader.getInstance().init(universalImageLoader.getConfig());
	}


	/**
	 * BottomNavigationView setup
	 */
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
