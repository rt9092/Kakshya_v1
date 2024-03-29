package adapter;

import in.wadersgroup.hth.FavoriteFragment;
import in.wadersgroup.hth.NGOFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// NGO fragment activity
			return new NGOFragment();

		case 1:
			// Favorites fragment activity
			return new FavoriteFragment();

		}

		return null;

	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 2;
	}

}