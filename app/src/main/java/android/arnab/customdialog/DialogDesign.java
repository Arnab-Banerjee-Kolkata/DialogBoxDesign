package android.arnab.customdialog;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class DialogDesign extends AppCompatActivity
{
    android.arnab.customdialog.DrawCircles circlesRegion;
    RelativeLayout balloonLayout;
    float radius[]={40,80,120,160};
    float centerX,centerY;
    boolean started=false;
    int val=0,chk=0;
    Handler handler=new Handler();
    int col[];
    EditText ev;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_design);
        RelativeLayout fadedBg=(RelativeLayout)findViewById(R.id.fadedBg);
        circlesRegion=(android.arnab.customdialog.DrawCircles)findViewById(R.id.circlesRegion);
        balloonLayout=(RelativeLayout)findViewById(R.id.balloonLayout);
        ev=(EditText)findViewById(R.id.ev);

        ev.setText("");
        int colors[]={getApplicationContext().getResources().getColor(R.color.color1),getApplicationContext().getResources().getColor(R.color.color2),getApplicationContext().getResources().getColor(R.color.color3),
                getApplicationContext().getResources().getColor(R.color.color4)};
        col=colors;

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = 1800;
        params.width = 1100;

        this.getWindow().setAttributes(params);
        ImageButton cancel=(ImageButton)findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        centerX=170;
        centerY=120;
        circlesRegion.draw(centerX,centerY,radius,colors,radius.length);
        start();
    }

    public void start()
    {
        started = true;
        handler.postDelayed(runnable, 100);
    }
    private Runnable runnable= new Runnable() {
        @Override
        public void run()
        {
            if(val<=10 && chk==0)
                val++;
            if(val>=-10 && chk==1)
                val--;
            for(int a=0;a<radius.length;a++)
            {
                if(chk==0)
                    radius[a]++;
                else
                    radius[a]--;
            }
            if(val==10)
                chk=1;
            if(val==-10)
                chk=0;
            circlesRegion.draw(centerX,centerY,radius,col,radius.length);
            Log.w("val",radius[3]+"");

            if(started)
            {
                start();
            }
        }
    };
}
