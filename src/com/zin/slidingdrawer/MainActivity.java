package com.zin.slidingdrawer;

import com.zin.slidingdrawer.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.TextView;

public class MainActivity extends Activity {
	private SlidingDrawer mDrawer;
	private ImageView imbg;
	private Boolean flag = false;
	private TextView tv;

	/**
	 * 
	 * @author zin
	 *
	 */
	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imbg = (ImageView) findViewById(R.id.handle);
		mDrawer = (SlidingDrawer) findViewById(R.id.slidingdrawer);
		tv = (TextView) findViewById(R.id.tv);
		Button btn = (Button) findViewById(R.id.kaiguang);
		Animation mBigAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
		
		mDrawer.setAnimation(mBigAnimation);
		mDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
			@Override
			public void onDrawerOpened() {
				flag = true;
				imbg.setImageResource(R.drawable.btn);
			}

		});
		
		mDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {

			@Override
			public void onDrawerClosed() {
				flag = false;
				imbg.setImageResource(R.drawable.btn);
			}

		});

		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mDrawer.animateToggle();
			}
		});
	}
}
