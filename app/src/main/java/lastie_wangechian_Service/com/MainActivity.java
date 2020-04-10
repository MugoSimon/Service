package lastie_wangechian_Service.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView_call;
    private ImageView imageView_endCall;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView_call = findViewById(R.id.imageView_makeCall);
        imageView_endCall = findViewById(R.id.imageView_endCall);
        chronometer = findViewById(R.id.simpleChronometer);


        imageView_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_call = new Intent(getApplicationContext(),Extended.class);
                startService(intent_call);
                imageView_call.setVisibility(View.INVISIBLE);
                chronometer.setVisibility(View.VISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        imageView_endCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView_call.setVisibility(View.VISIBLE);
                Intent intent_endCall = new Intent(getApplicationContext(),Extended.class);
                stopService(intent_endCall);
                chronometer.stop();
                chronometer.setVisibility(View.INVISIBLE);
            }
        });
    }

}
