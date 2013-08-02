package com.buloogis.ui;

import android.os.Bundle;
import android.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;

import com.buloogis.ui.fragment.*;
import com.slidingmenu.lib.SlidingMenu;

//import com.esri.android.map.MapView;
//import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;

public class MapActivity extends SlidingActivity {
	//private MapView mMapView = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_frame_content);
		setBehindContentView(R.layout.map_frame_menu);
		
    	//mMapView = (MapView)findViewById(R.id.mapview);
    	//if (mMapView == null) {
    	//	return;
    	//}
    	//mMapView.addLayer(new ArcGISTiledMapServiceLayer(getResources().getString(R.string.map_url)));
		
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        MapLeftMenuFragment menuFragment = new MapLeftMenuFragment();
        fragmentTransaction.replace(R.id.map_menu, menuFragment);
        fragmentTransaction.replace(R.id.map_content, new MapContentFragment());
        fragmentTransaction.commit();
        
        // customize the SlidingMenu
        SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidth(50);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffset(200);
        sm.setFadeDegree(0.35f);
        //设置slding menu的几种手势模式
        //TOUCHMODE_FULLSCREEN 全屏模式，在content页面中，滑动，可以打开sliding menu
        //TOUCHMODE_MARGIN 边缘模式，在content页面中，如果想打开slding ,你需要在屏幕边缘滑动才可以打开slding menu
        //TOUCHMODE_NONE 自然是不能通过手势打开啦
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);

        //使用左上方icon可点，这样在onOptionsItemSelected里面才可以监听到R.id.home
        getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		//mMapView.unpause();
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		//mMapView.pause();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            //toggle就是程序自动判断是打开还是关闭
            toggle();
//          getSlidingMenu().showMenu();// show menu
//          getSlidingMenu().showContent();//show content
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
