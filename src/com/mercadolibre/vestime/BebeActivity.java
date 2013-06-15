package com.mercadolibre.vestime;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class BebeActivity extends Activity {

    LinearLayout slideHome;
    ImageButton menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bebes);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
