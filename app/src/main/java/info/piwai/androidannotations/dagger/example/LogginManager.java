package info.piwai.androidannotations.dagger.example;
import android.util.Log;

public class LogginManager
{
    public static final String TAG = "dagger.juanmendez.info";

    public static void consoleLog( String content )
    {
        Log.i( TAG, content );
    }
}
