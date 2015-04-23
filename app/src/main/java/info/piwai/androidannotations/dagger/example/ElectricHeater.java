package info.piwai.androidannotations.dagger.example;

import android.content.Context;
import android.widget.Toast;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;

@EBean
class ElectricHeater implements Heater {
	boolean heating;

	@RootContext
	Context context;

	@Override
	public void on() {
		System.out.println("~ ~ ~ heating ~ ~ ~");
		reportHeating();
		heating = true;
	}

	@UiThread
	void reportHeating() {
		Toast.makeText(context, "Electric heater heating!", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void off() {
		heating = false;
	}

	@Override
	public boolean isHot() {
		return heating;
	}
}
