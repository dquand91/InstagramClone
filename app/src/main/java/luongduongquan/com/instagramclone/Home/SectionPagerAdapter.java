package luongduongquan.com.instagramclone.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

// Class stores fragments for tabs

public class SectionPagerAdapter extends FragmentPagerAdapter {

	private static final String TAG = "SectionPagerAdapter";

	private final List<Fragment> mListFragment = new ArrayList<>();

	public SectionPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		return mListFragment.get(position);
	}

	@Override
	public int getCount() {
		return mListFragment.size();
	}

	public void addFragment(Fragment fragment){
		mListFragment.add(fragment);
	}
}
