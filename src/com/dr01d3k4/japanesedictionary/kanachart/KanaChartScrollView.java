package com.dr01d3k4.japanesedictionary.kanachart;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;


public class KanaChartScrollView extends ScrollView implements View.OnSystemUiVisibilityChangeListener,
	View.OnClickListener {
	
	private final int baseSystemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | SYSTEM_UI_FLAG_LAYOUT_STABLE;
	private int lastSystemUiVisibility;
	
	private final Runnable navigationHider = new Runnable() {
		@Override
		public void run() {
			setNavVisibility(false);
		}
		
	};
	
	
	public KanaChartScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOnSystemUiVisibilityChangeListener(this);
	}
	
	
	public void init() {
		setNavVisibility(true);
	}
	
	
	@Override
	public void onClick(View v) {
		// int curVis = getSystemUiVisibility();
		// setNavVisibility((curVis & SYSTEM_UI_FLAG_LOW_PROFILE) != 0);
		setNavVisibility(true);
	}
	
	
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		setNavVisibility(false);
	}
	
	
	@Override
	protected void onWindowVisibilityChanged(int visibility) {
		super.onWindowVisibilityChanged(visibility);
		setNavVisibility(true);
		getHandler().postDelayed(navigationHider, 5000);
	}
	
	
	@Override
	public void onSystemUiVisibilityChange(int visibility) {
		int diff = lastSystemUiVisibility ^ visibility;
		lastSystemUiVisibility = visibility;
		if ((diff & SYSTEM_UI_FLAG_LOW_PROFILE) != 0 && (visibility & SYSTEM_UI_FLAG_LOW_PROFILE) == 0) {
			setNavVisibility(true);
		}
		
		setNavVisibility(true);
	}
	
	
	private void setNavVisibility(boolean visible) {
		int newVis = baseSystemUiVisibility;
		if (!visible) {
			newVis |= SYSTEM_UI_FLAG_LOW_PROFILE | SYSTEM_UI_FLAG_FULLSCREEN;
		}
		final boolean changed = (newVis == getSystemUiVisibility());
		
		if (changed || visible) {
			Handler h = getHandler();
			if (h != null) {
				h.removeCallbacks(navigationHider);
			}
		}
		
		setSystemUiVisibility(newVis);
	}
}
