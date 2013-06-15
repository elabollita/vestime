package com.mercadolibre.vestime;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

public class MenActivity extends Activity {

	LinearLayout slideHome;
	ImageButton menuBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        slideHome = (LinearLayout)findViewById(R.id.slide_home);


        int content = 0;

        for(int i=0;i<9;i++){

            LinearLayout contentButton = new LinearLayout(this);
            LinearLayout.LayoutParams contentBtnParams = new LinearLayout.LayoutParams(0, 300,1f);
            contentButton.setOrientation(LinearLayout.HORIZONTAL);

            if(content == 0){
                ImageButton sImg01 = new ImageButton(this);
                ImageButton sImg02 = new ImageButton(this);

                LinearLayout.LayoutParams imgParamsLeft = new LinearLayout.LayoutParams(0, 300,0.5f);
                LinearLayout.LayoutParams imgParamsRigth = new LinearLayout.LayoutParams(0, 300,0.5f);
                imgParamsLeft.setMargins(2, 2, 2, 2);
                imgParamsRigth.setMargins(2, 2, 2, 2);

                sImg01.setBackgroundColor(Color.TRANSPARENT);
                sImg01.setImageResource(R.drawable.publicidad);
                sImg01.setScaleType(ScaleType.CENTER_CROP);
                sImg01.setPadding(0,0,0,0);
                sImg01.setLayoutParams(imgParamsLeft);

                sImg02.setBackgroundColor(Color.TRANSPARENT);
                sImg02.setImageResource(R.drawable.publicidad);
                sImg02.setScaleType(ScaleType.CENTER_CROP);
                sImg02.setPadding(0,0,0,0);
                sImg02.setLayoutParams(imgParamsRigth);

                contentButton.addView(sImg01);
                contentButton.addView(sImg02);

            }else{

                ImageButton sImg01 = new ImageButton(this);

                LinearLayout.LayoutParams imgParamsLeft = new LinearLayout.LayoutParams(0, 300,1f);
                imgParamsLeft.setMargins(2, 2, 2, 2);

                sImg01.setBackgroundColor(Color.TRANSPARENT);
                sImg01.setImageResource(R.drawable.publicidad);
                sImg01.setScaleType(ScaleType.CENTER_CROP);
                sImg01.setPadding(0,0,0,0);
                sImg01.setLayoutParams(imgParamsLeft);

                contentButton.addView(sImg01);

            }

            slideHome.addView(contentButton);

            if(i==1){

                content = 1;
            }else{
                content = 0;
            }

        }

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
