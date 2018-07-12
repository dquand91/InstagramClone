package luongduongquan.com.instagramclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import luongduongquan.com.instagramclone.R;
import luongduongquan.com.instagramclone.Utils.SectionsStatePagerAdapter;

public class AccountSettingsActivity extends AppCompatActivity {
	private static final String TAG = "AccountSettingsActivity";

	private Context mContext;

	private SectionsStatePagerAdapter statePagerAdapter;
	private ViewPager mViewPager;
	private RelativeLayout mRelativelayout;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accountsettings);
		mContext = AccountSettingsActivity.this;
		Log.d(TAG, "onCreate: start");

		mViewPager = findViewById(R.id.viewpager_container_home);
		mRelativelayout = findViewById(R.id.relLayout1_accountseting);


		setupSettingsList();

		//setup the backarrow for navigating back to "ProfileActivity"
		ImageView backArrow = (ImageView) findViewById(R.id.backArrow);
		backArrow.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(TAG, "onClick: navigating back to 'ProfileActivity'");
				finish();
			}
		});
	}

	private void setupFragment(){

		statePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
		statePagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile_fragment));//fragment 0
		statePagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out_fragment));//fragment 0

	}

	private void setViewPager(int fragmentNumber){

		mRelativelayout.setVisibility(View.GONE);
		Log.d(TAG, "setViewPager: navigation to fragment number: " + fragmentNumber);
		mViewPager.setAdapter(statePagerAdapter);
		mViewPager.setCurrentItem(fragmentNumber);


	}


	private void setupSettingsList(){
		Log.d(TAG, "setupSettingsList: initiaizing Account Settings list");
		ListView listViewSettings = findViewById(R.id.lvAccountSettings);

		ArrayList<String> listOptionsSettings = new ArrayList<>();
		listOptionsSettings.add(getString(R.string.edit_profile_fragment));
		listOptionsSettings.add(getString(R.string.sign_out_fragment));

		ArrayAdapter arrayAdapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, listOptionsSettings);
		listViewSettings.setAdapter(arrayAdapter);

		setupFragment();
		listViewSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				setViewPager(position);
			}
		});

	}
}
