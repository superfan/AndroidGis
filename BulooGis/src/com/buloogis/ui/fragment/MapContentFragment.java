package com.buloogis.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.buloogis.ui.R;

import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;


public class MapContentFragment extends Fragment {
	private MapView mMapView = null;
	
    public MapContentFragment() {
    	super();
    }

   /* public MapContentFragment(String text) {
        Log.e("BulooGis", text);
        this.text = text;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflater the layout
    	View v = inflater.inflate(R.layout.map, null);
    	mMapView = (MapView)v.findViewById(R.id.mapview);
    	if (mMapView == null) {
    		return null;
    	}
    	
    	mMapView.addLayer(new ArcGISTiledMapServiceLayer(getResources().getString(R.string.map_url)));
    	mMapView.setAlwaysDrawnWithCacheEnabled(true);
    	
        return mMapView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.unpause();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
    
}
