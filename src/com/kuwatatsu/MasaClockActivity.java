package com.kuwatatsu;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.widget.TextView;

public class MasaClockActivity extends Activity implements Runnable, OnInitListener {
	private TextView textView = null;
	private ScheduledExecutorService scheduledExecutorService = null;
	private MediaPlayer mediaPlayer1 = null;
	private MediaPlayer mediaPlayer2 = null;
	private Handler handler = null; 
	private TextToSpeech textToSpeech = null;
	private String currentTimeString = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView)findViewById(R.id.TextView01);

    	handler = new Handler();    	
    	textToSpeech = new TextToSpeech(this, this);
    	mediaPlayer1 = MediaPlayer.create(this, R.raw.s1);
    	mediaPlayer2 = MediaPlayer.create(this, R.raw.s2);
    }

    @Override
    protected void onResume() {
    	super.onResume();
    	scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(this, 1000, 1000, TimeUnit.MILLISECONDS);
    };
    
    @Override
	public void run() {
    	long currentTimeMillis = System.currentTimeMillis();
    	long currentTime = ((int)(currentTimeMillis / 1000));
    	int s = (int)currentTime % 60;
    	currentTime = currentTime / 60;
    	int m = (int)currentTime % 60;
    	currentTime = currentTime / 60;
    	int h = (int)currentTime % 24;
    	
		currentTimeString = String.format("%02d:%02d:%02d", h, m, s);

		handler.post(new Runnable() {
			@Override
			public void run() {
				textView.setText(currentTimeString);
			}
		});
		switch (s) {
		case 0:
			textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			mediaPlayer2.seekTo(0);
			mediaPlayer2.start();
			break;
		case 1:
		case 2:
			break;
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			mediaPlayer1.seekTo(0);
			mediaPlayer1.start();
			break;
		case 10:
			textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			mediaPlayer2.seekTo(0);
			mediaPlayer2.start();
			break;
		case 11:
		case 12:
			break;
		case 13:
		case 14:
		case 15:
		case 16:
		case 17:
		case 18:
		case 19:
			mediaPlayer1.seekTo(0);
			mediaPlayer1.start();
			break;
		case 20:
			textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			mediaPlayer2.seekTo(0);
			mediaPlayer2.start();
			break;
		case 21:
		case 22:
			break;
		case 23:
		case 24:
		case 25:
		case 26:
		case 27:
		case 28:
		case 29:
			mediaPlayer1.seekTo(0);
			mediaPlayer1.start();
			break;
		case 30:
			textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			mediaPlayer2.seekTo(0);
			mediaPlayer2.start();
			break;
		case 31:
		case 32:
			break;
		case 33:
		case 34:
		case 35:
		case 36:
		case 37:
		case 38:
		case 39:
			mediaPlayer1.seekTo(0);
			mediaPlayer1.start();
			break;
		case 40:
			textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			mediaPlayer2.seekTo(0);
			mediaPlayer2.start();
			break;
		case 41:
		case 42:
			break;
		case 43:
		case 44:
		case 45:
		case 46:
		case 47:
		case 48:
		case 49:
			mediaPlayer1.seekTo(0);
			mediaPlayer1.start();
			break;
		case 50:
			textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			mediaPlayer2.seekTo(0);
			mediaPlayer2.start();
			break;
		case 51:
		case 52:
			break;
		case 53:
		case 54:
		case 55:
		case 56:
		case 57:
		case 58:
		case 59:
			mediaPlayer1.seekTo(0);
			mediaPlayer1.start();
			break;
		default:
			break;
		}
	}
    
    @Override
    protected void onPause() {
    	super.onPause();
    	scheduledExecutorService.shutdownNow();
    }

	@Override
	public void onInit(int arg0) {
		Locale loc = new Locale("en", "");
		if (textToSpeech.isLanguageAvailable(loc) >= TextToSpeech.LANG_AVAILABLE) {
			textToSpeech.setLanguage(loc);
		}
	}
}