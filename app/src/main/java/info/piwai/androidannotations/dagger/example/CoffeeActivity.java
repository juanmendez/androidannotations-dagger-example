package info.piwai.androidannotations.dagger.example;

import javax.inject.Inject;

import android.app.Activity;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

import info.piwai.androidannotations.dagger.example.R;

import dagger.ObjectGraph;

@EActivity(R.layout.main)
public class CoffeeActivity extends Activity {

	@App
	CoffeeApplication coffeeApplication;

	@Inject
	CoffeeMaker coffeeMaker;

	@AfterInject
	void daggerInject() {
		ObjectGraph objectGraph = coffeeApplication.getObjectGraph();
		long start = SystemClock.elapsedRealtime();
		objectGraph.inject(this);
		long duration = SystemClock.elapsedRealtime() - start;
		Log.d("CoffeeActivity", "CoffeeActivity Dagger injection duration in ms: " + duration);
	}

	@Click
	@Background
	void brewButtonClicked() {
		coffeeMaker.brew();
		coffeeBrewed();
	}

	@UiThread
	void coffeeBrewed() {
		Toast.makeText(this, "Get your coffee in the logs!", Toast.LENGTH_LONG).show();
	}

}
