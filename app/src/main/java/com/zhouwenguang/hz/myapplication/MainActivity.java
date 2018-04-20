package com.zhouwenguang.hz.myapplication;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech tts;
    private Button btnSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSpeak = (Button) findViewById(R.id.btnSpeak);
        btnSpeak.setOnClickListener(new MyOnClickListener());
        tts = new TextToSpeech(this, new MyOnInitialListener());

    }

    class MyOnInitialListener implements TextToSpeech.OnInitListener {

        @Override
        public void onInit(int status) {

            // tts.setEngineByPackageName("com.iflytek.vflynote");
            tts.setLanguage(Locale.CHINESE);

        }

    }

    class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnSpeak:
                    tts.speak("科大讯飞是做语音得AI公司", TextToSpeech.QUEUE_FLUSH, null);


                    break;

                default:
                    break;
            }

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (tts != null) { // 关闭TTS引擎
            tts.shutdown();
        }
    }
}