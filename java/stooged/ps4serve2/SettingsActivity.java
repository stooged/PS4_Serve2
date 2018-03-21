package stooged.ps4serve2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;


public class SettingsActivity extends Activity {

    CheckBox checkbox1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_settings);
        checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkbox1.setChecked(Utils.GetSetting(this,"NEWJS",false) );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    public void text1_Click(View view)
    {
        finish();
    }

    public void check1_Click(View view)
    {
        if (checkbox1.isChecked())
        {
            Utils.SaveSetting(this,"NEWJS",true);
            Utils.createResFile(getBaseContext(), R.raw.userland_js, "userland.js", true);
        }
        else
        {
            Utils.SaveSetting(this,"NEWJS",false);
            Utils.createResFile(getBaseContext(), R.raw.userlando_js, "userland.js", true);
        }
    }
}
