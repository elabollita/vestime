package com.mercadolibre.vestime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class ProductActivity extends Activity {

	LinearLayout slideHome;
	ImageButton menuBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prod_activity);

	}



	private OnClickListener gotoSection = new OnClickListener() {
		Intent intent ;
		
		public void onClick(View v) {

		}
		
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
