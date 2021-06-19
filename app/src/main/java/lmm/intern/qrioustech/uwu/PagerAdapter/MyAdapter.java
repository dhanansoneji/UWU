package lmm.intern.qrioustech.uwu.PagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import lmm.intern.qrioustech.uwu.Fregment.AboutUsFragment;
import lmm.intern.qrioustech.uwu.Fregment.ContactUsFragment;
import lmm.intern.qrioustech.uwu.Fregment.LiveChatFragment;
import lmm.intern.qrioustech.uwu.Fregment.PortfolioFragment;

public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new PortfolioFragment();
        } else if (position == 1) {
            return new LiveChatFragment();
        } else if (position == 2) {
            return new ContactUsFragment();
        } else{
            return new AboutUsFragment();
        }

    }
}

