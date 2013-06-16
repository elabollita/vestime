package com.mercadolibre.vestime;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.content.Intent;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends TabActivity {

	LinearLayout slideHome;
	ImageButton menuBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        TabHost tabHost = getTabHost();

        // Tab for MenActivity
        TabSpec menSpec = tabHost.newTabSpec("Men");
        // setting Title and Icon for the Tab
        menSpec.setIndicator("Men", getResources().getDrawable(R.drawable.ic_launcher));
        Intent menIntent = new Intent(this, MenActivity.class);
        menSpec.setContent(menIntent);

        // Tab for WomenActivity
        TabSpec WomenSpec = tabHost.newTabSpec("Women");
        WomenSpec.setIndicator("Women", getResources().getDrawable(R.drawable.ic_launcher));
        Intent WomenIntent = new Intent(this, WomenActivity.class);
        WomenSpec.setContent(WomenIntent);

        // Tab for WomenActivity
        TabSpec NinoSpec = tabHost.newTabSpec("Niño");
        NinoSpec.setIndicator("Niño", getResources().getDrawable(R.drawable.ic_launcher));
        Intent NinoIntent = new Intent(this, NeneActivity.class);
        NinoSpec.setContent(NinoIntent);

        // Tab for WomenActivity
        TabSpec NinaSpec = tabHost.newTabSpec("Niña");
        NinaSpec.setIndicator("Niña", getResources().getDrawable(R.drawable.ic_launcher));
        Intent NinaIntent = new Intent(this, NenaActivity.class);
        NinaSpec.setContent(NinaIntent);

        // Tab for WomenActivity
        TabSpec BebeSpec = tabHost.newTabSpec("Bebe");
        BebeSpec.setIndicator("Bebe", getResources().getDrawable(R.drawable.ic_launcher));
        Intent BebeIntent = new Intent(this, BebeActivity.class);
        BebeSpec.setContent(BebeIntent);

        // Adding all TabSpec to TabHost
        tabHost.addTab(menSpec);
        tabHost.addTab(WomenSpec);
        tabHost.addTab(NinoSpec);
        tabHost.addTab(NinaSpec);
        tabHost.addTab(BebeSpec);

        menuBtn = (ImageButton)findViewById(R.id.menuBtn);

        menuBtn.setOnClickListener(gotoSection);

        intent = new Intent(MylocalData.getInstance().context, MenuActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MylocalData.getInstance().context.startActivity(intent);
        overridePendingTransition( R.anim.slide_in_left, R.anim.slide_in_right );


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
