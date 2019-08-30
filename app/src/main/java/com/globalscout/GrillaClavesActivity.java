package com.globalscout;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.app.Activity;
import android.widget.ImageView;

public class GrillaClavesActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND, WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        Display display = getWindowManager().getDefaultDisplay();

        int height = 0;
        WindowManager.LayoutParams params = getWindow().getAttributes();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            params.width = (int) (display.getWidth() * 0.6); //fixed width
            params.height = (int) (display.getWidth() * 0.6); //fixed width
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            params.width = (int) (display.getWidth() * 0.8); //fixed width
            params.height = (int) (display.getWidth() * 0.8); //fixed width
        }
        params.alpha = 1.0f;
        params.dimAmount = 0.5f;
        //Window window = getWindow();
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setCustomView(R.layout.layout_menu_dialogo);
        View actionBar =  getActionBar().getCustomView();
        ImageView home = (ImageView) actionBar.findViewById(R.id.home_icono_actionbar);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        this.setFinishOnTouchOutside(true);
        setContentView(R.layout.activity_grilla_claves);
        GridView gridClaves = (GridView) findViewById(R.id.gridClaves);
        gridClaves.setAdapter(new AdaptadorGrillaClaves(this));
    }
}
