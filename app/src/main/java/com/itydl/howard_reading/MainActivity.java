package com.itydl.howard_reading;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.itydl.howard_reading.fragment.FindFragment;
import com.itydl.howard_reading.fragment.NewsFragment;
import com.itydl.howard_reading.fragment.RecommendFragment;
import com.itydl.howard_reading.fragment.WeatherFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private BottomBar bottomBar;
    private NavigationView navigationView;
    private long time;
    private DrawerLayout mDrawerLayout;
    private FrameLayout mFrameLayout;
    private Fragment oldFragment;
    private FragmentManager mFragmentManager;
    private RecommendFragment mRecommendFragment;
    private FindFragment mFindFragment;
    private NewsFragment mNewsFragment;
    private WeatherFragment mWeatherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        initFragmentContent(savedInstanceState);
    }

    /**
     * 设置中间内容页
     */
    private void initFragmentContent(Bundle savedInstanceState) {
        if(mRecommendFragment == null){
            mRecommendFragment = new RecommendFragment();
        }
        if (savedInstanceState == null) {
            /*=============== FrameLayout添加Fragment的另一种方式add ===============*/
            getSupportFragmentManager().beginTransaction().add(R.id.fl_content, mRecommendFragment).commit();
        }
        //记录上一次的Fragment
        oldFragment = mRecommendFragment;
    }

    private void initView() {
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        navigationView = (NavigationView) findViewById(R.id.nv_left);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_main);
        mFrameLayout = (FrameLayout) findViewById(R.id.fl_content);
    }

    private void initEvent() {
        /**左侧菜单的监听事件*/
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                /**在这设置左侧菜单的item的点击事件。切换不同的fragment**/
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.menu_recommend:
                        toFragment(mRecommendFragment);
                        break;
                    case R.id.menu_find:
                        if(mFindFragment == null){
                            mFindFragment = new FindFragment();
                        }
                        toFragment(mFindFragment);
                        break;
                    case R.id.menu_news:
                        if(mNewsFragment == null){
                            mNewsFragment = new NewsFragment();
                        }
                        toFragment(mNewsFragment);
                        break;
                    case R.id.menu_weather:
                        if(mWeatherFragment == null){
                            mWeatherFragment = new WeatherFragment();
                        }
                        toFragment(mWeatherFragment);
                        break;

                    default:
                        toFragment(mRecommendFragment);
                        break;
                }
                /*=============== 点击任何一个tab，都会关闭左侧菜单 ===============*/
                mDrawerLayout.closeDrawers();
            }
        });
    }

    /**
     * 切换至指定Fragment
     */
    private void toFragment(Fragment currentFragment) {
        if (currentFragment == oldFragment)
            return;

        //Fragment切换所带动画效果
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().setCustomAnimations(
                android.R.anim.fade_in, android.R.anim.fade_out
        );

        if (!currentFragment.isAdded()) {    // 先判断是否被add过
            transaction.hide(oldFragment).add(R.id.fl_content, currentFragment).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            transaction.hide(oldFragment).show(currentFragment).commit(); // 隐藏当前的fragment，显示下一个
        }
        //标记当前Fragment为老的Fragment
        oldFragment = currentFragment;
    }

    //按两次离开页面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - time <= 2000) {
                finish();
            } else {
                time = System.currentTimeMillis();
                Toast.makeText(getApplicationContext(), "再按一次可退出柚阅", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

            default:
                break;
        }
        return true;
    }
}
