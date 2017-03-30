package com.itydl.howard_reading.fragment;

import com.itydl.howard_reading.base.BaseFragment;

import java.util.HashMap;

/**
 * @author ydl
 *         Fragment的工厂
 */

public class FragmentFactory {

    public static HashMap<Integer, BaseFragment> fragments = new HashMap<>();

    public static BaseFragment getFragment(int position) {
        BaseFragment fragment = fragments.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new RecommendFragment();
                    fragments.put(0, fragment);
                    break;
                case 1:
                    fragment = new FindFragment();
                    fragments.put(1, fragment);
                    break;
                case 2:
                    fragment = new NewsFragment();
                    fragments.put(2, fragment);
                    break;
                case 3:
                    fragment = new WeatherFragment();
                    fragments.put(3, fragment);
                    break;

                default:
                    break;
            }
        } else {
            return fragment;
        }
        return null;
    }
}
