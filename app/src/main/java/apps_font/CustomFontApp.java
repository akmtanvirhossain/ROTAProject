package apps_font;

import android.app.Application;

/**
 * Created by mchd.dms on 24-Sep-17.
 */

public class CustomFontApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "nikoshban.ttf");
    }
}
