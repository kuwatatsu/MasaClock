package com.kuwatatsu.masaclock;

import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import com.kuwatatsu.R;

public class MasaClockActivity extends Activity implements Runnable, OnInitListener {
	private static TextView textView = null;
	private ScheduledExecutorService scheduledExecutorService = null;

	private static MediaPlayer mediaPlayer1 = null;
	private static MediaPlayer mediaPlayer2 = null;
	private Handler handler = null; 
	private static TextToSpeech textToSpeech = null;
	private static String currentTimeString = null;
	private TimeZone timeZone = null;
	
	private static long timezone_offset = 0;
	
	private boolean soundOn = true;
	private boolean ttsOn = true;
	
	private static final int MENU_EXIT_ID = Menu.FIRST;
	private static final int MENU_SOUND_OFF_ID = Menu.FIRST + 1;
	private static final int MENU_TTS_OFF_ID = Menu.FIRST + 2;
	private static final int MENU_SOUND_ON_ID = Menu.FIRST + 3;
	private static final int MENU_TTS_ON_ID = Menu.FIRST + 4;
	private static final int MENU_SET_ID = Menu.FIRST + 5;

	private static final String SOUND_MODE_KEY = "sound";
	private static final String TTS_MODE_KEY = "tts";

	private static final Runnable sound1 = new Runnable() {
		@Override
		public void run() {
			mediaPlayer1.seekTo(0);
			mediaPlayer1.start();
		}
	};

	private static final Runnable sound2 = new Runnable() {
		@Override
		public void run() {
			mediaPlayer2.seekTo(0);
			mediaPlayer2.start();
		}
	};

	private static final Runnable tts = new Runnable() {
		@Override
		public void run() {
			textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_ADD, null);
		}
	};

	private static final Runnable hyoji = new Runnable() {
		@Override
		public void run() {
			textView.setText(currentTimeString);
		}
	};

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.main);

        textView = (TextView)findViewById(R.id.TextView01);

    	handler = new Handler();    	
    	textToSpeech = new TextToSpeech(this, this);
    	mediaPlayer1 = MediaPlayer.create(this, R.raw.s1);
    	mediaPlayer2 = MediaPlayer.create(this, R.raw.s2);
    	timeZone = TimeZone.getDefault();
    	timezone_offset = timeZone.getRawOffset();
    	
    	SharedPreferences pref = getPreferences(MODE_PRIVATE);
    	soundOn = pref.getBoolean(SOUND_MODE_KEY, true);
    	ttsOn = pref.getBoolean(TTS_MODE_KEY, true);
    }

    @Override
    protected void onResume() {
    	super.onResume();
    	scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(this, 1000, 1000, TimeUnit.MILLISECONDS);
    };
    
    @Override
	public void run() {
    	long currentTimeMillis = System.currentTimeMillis() + timezone_offset;
    	long currentTime = ((int)(currentTimeMillis / 1000));
    	int s = (int)currentTime % 60;
    	currentTime = currentTime / 60;
    	int m = (int)currentTime % 60;
    	currentTime = currentTime / 60;
    	int h = (int)currentTime % 24;
    	
		currentTimeString = String.format("%02d:%02d:%02d", h, m, s);

		handler.post(hyoji);
		switch (s) {
		case 0:
			if (soundOn) {
				handler.post(sound2);
				//mediaPlayer2.seekTo(0);
				//mediaPlayer2.start();
			}
			if (ttsOn) {
				handler.post(tts);
				//textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			}
			break;
		case 1:
		case 2:
		case 3:
			break;
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			if (soundOn) {
				handler.post(sound1);
				//mediaPlayer1.seekTo(0);
				//mediaPlayer1.start();
			}
			break;
		case 10:
			if (soundOn) {
				handler.post(sound2);
				//mediaPlayer2.seekTo(0);
				//mediaPlayer2.start();
			}
			if (ttsOn) {
				handler.post(tts);
				//textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			}
			break;
		case 11:
		case 12:
		case 13:
			break;
		case 14:
		case 15:
		case 16:
		case 17:
		case 18:
		case 19:
			if (soundOn) {
				handler.post(sound1);
				//mediaPlayer1.seekTo(0);
				//mediaPlayer1.start();
			}
			break;
		case 20:
			if (soundOn) {
				handler.post(sound2);
				//mediaPlayer2.seekTo(0);
				//mediaPlayer2.start();
			}
			if (ttsOn) {
				handler.post(tts);
				//textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			}
			break;
		case 21:
		case 22:
		case 23:
			break;
		case 24:
		case 25:
		case 26:
		case 27:
		case 28:
		case 29:
			if (soundOn) {
				handler.post(sound1);
				//mediaPlayer1.seekTo(0);
				//mediaPlayer1.start();
			}
			break;
		case 30:
			if (soundOn) {
				handler.post(sound2);
				//mediaPlayer2.seekTo(0);
				//mediaPlayer2.start();
			}
			if (ttsOn) {
				handler.post(tts);
				//textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			}
			break;
		case 31:
		case 32:
		case 33:
			break;
		case 34:
		case 35:
		case 36:
		case 37:
		case 38:
		case 39:
			if (soundOn) {
				handler.post(sound1);
				//mediaPlayer1.seekTo(0);
				//mediaPlayer1.start();
			}
			break;
		case 40:
			if (soundOn) {
				handler.post(sound2);
				//mediaPlayer2.seekTo(0);
				//mediaPlayer2.start();
			}
			if (ttsOn) {
				handler.post(tts);
				//textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			}
			break;
		case 41:
		case 42:
		case 43:
			break;
		case 44:
		case 45:
		case 46:
		case 47:
		case 48:
		case 49:
			if (soundOn) {
				handler.post(sound1);
				//mediaPlayer1.seekTo(0);
				//mediaPlayer1.start();
			}
			break;
		case 50:
			if (soundOn) {
				handler.post(sound2);
				//mediaPlayer2.seekTo(0);
				//mediaPlayer2.start();
			}
			if (ttsOn) {
				handler.post(tts);
				//textToSpeech.speak(currentTimeString, TextToSpeech.QUEUE_FLUSH, null);
			}
			break;
		case 51:
		case 52:
		case 53:
			break;
		case 54:
		case 55:
		case 56:
		case 57:
		case 58:
		case 59:
			if (soundOn) {
				handler.post(sound1);
				//mediaPlayer1.seekTo(0);
				//mediaPlayer1.start();
			}
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
		Locale loc = Locale.getDefault();
		if (textToSpeech.isLanguageAvailable(loc) >= TextToSpeech.LANG_AVAILABLE) {
			textToSpeech.setLanguage(loc);
		} else {
			textToSpeech.setLanguage(Locale.US);
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_EXIT_ID:
			getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
			mediaPlayer1.stop();
			mediaPlayer1.release();
			mediaPlayer2.stop();
			mediaPlayer2.release();
			finish();
			return true;
		case MENU_SOUND_OFF_ID:
			soundOn = false;
			return true;
		case MENU_TTS_OFF_ID:
			ttsOn = false;
			return true;
		case MENU_SOUND_ON_ID:
			soundOn = true;
			return true;
		case MENU_TTS_ON_ID:
			ttsOn = true;
			return true;
		case MENU_SET_ID:
	    	SharedPreferences pref = getPreferences(MODE_PRIVATE);
	    	Editor editor = pref.edit();
	    	editor.putBoolean(SOUND_MODE_KEY, soundOn);
	    	editor.putBoolean(TTS_MODE_KEY, ttsOn);
	    	editor.commit();

			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean result = super.onPrepareOptionsMenu(menu);
		menu.clear();
		menu.add(0, MENU_EXIT_ID, Menu.NONE, R.string.menu1);
		if (soundOn) {
			menu.add(0, MENU_SOUND_OFF_ID, Menu.NONE, R.string.menu2);
		} else {
			menu.add(0, MENU_SOUND_ON_ID, Menu.NONE, R.string.menu4);
		}
		if (ttsOn) {
			menu.add(0, MENU_TTS_OFF_ID, Menu.NONE, R.string.menu3);
		} else {
			menu.add(0, MENU_TTS_ON_ID, Menu.NONE, R.string.menu5);
		}
		menu.add(0, MENU_SET_ID, Menu.NONE, R.string.menu6);
		return result;

	}
}