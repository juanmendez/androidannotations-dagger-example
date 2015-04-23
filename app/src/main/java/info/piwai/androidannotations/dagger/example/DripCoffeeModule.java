package info.piwai.androidannotations.dagger.example;

import javax.inject.Singleton;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import info.piwai.androidannotations.dagger.example.CoffeeActivity_;
import info.piwai.androidannotations.dagger.example.CoffeeApplication_;
import info.piwai.androidannotations.dagger.example.ElectricHeater_;

@Module(injects = {CoffeeActivity_.class, CoffeeApplication_.class}, includes = PumpModule.class, library = true )
class DripCoffeeModule {

	private final Context context;

	public DripCoffeeModule(Context context) {
		this.context = context.getApplicationContext();
	}

	@Provides
	@Singleton
	Context applicationContext() {
		return context;
	}

	@Provides
	@Singleton
	Heater provideHeater() {
		/*
		 * Since there's no AndroidAnnotations - Dagger integration layer, we
		 * need to instantiate the AA generated classes manually.
		 */
		return ElectricHeater_.getInstance_(applicationContext());
	}
}
