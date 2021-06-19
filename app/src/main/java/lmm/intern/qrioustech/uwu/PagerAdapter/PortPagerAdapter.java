package lmm.intern.qrioustech.uwu.PagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import lmm.intern.qrioustech.uwu.Fregment.AppsFragment;
import lmm.intern.qrioustech.uwu.Fregment.WebFragment;
import lmm.intern.qrioustech.uwu.R;

public class PortPagerAdapter extends FragmentPagerAdapter {
    public PortPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new WebFragment();
        } else{
            return new AppsFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
