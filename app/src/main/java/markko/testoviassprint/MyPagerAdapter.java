package markko.testoviassprint;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

import markko.testoviassprint.Pitanja.Pitanje;

/**
 * Created by Markko on 2/9/2016.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {


    public MyPagerAdapter(FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public Fragment getItem(int position) {

        if (position<40) {
            if (position<20)
                return TeorijaFragment.newInstance(position);
            else {
                int br = MainActivity.kontroler.getPitanja().get(position).brojOdgovora();
                switch ((br)) {
                    case 2:
                        return Pitanje2Fragment.newInstance(position);
                    case 3:
                        return Pitanje3Fragment.newInstance(position);
                    case 4:
                        return Pitanje4Fragment.newInstance(position);
                }
                return Pitanje2Fragment.newInstance(position);
            }
        }
        else
            return ZavrsiFragment.newInstance("a", "a");
    }

    @Override
    public int getCount() {
        return 41;
    }

}
