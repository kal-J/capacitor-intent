package cz.firest.intent;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import android.util.Log;
import android.content.Intent;
import android.net.Uri;
import android.content.ActivityNotFoundException;

@CapacitorPlugin(name = "CapacitorIntent")
public class CapacitorIntentPlugin extends Plugin {
    public static final String LOG_TAG = "Intent";

    @PluginMethod
    public void startActivityForResult(PluginCall call) {
        JSObject data = call.getData();
        final String action = data.has("action") ? data.getString("action") : null;
        final String packageName = data.has("packageName") ? data.getString("packageName") : null;
        final String className = data.has("className") ? data.getString("className") : null;
        final String PROGRAM_GUID = data.has("PROGRAM_GUID") ? data.getString("PROGRAM_GUID") : null;
        final String RELIANT_GUID = data.has("RELIANT_GUID") ? data.getString("RELIANT_GUID") : null;
        final String REQUEST_CODE = data.has("REQUEST_CODE") ? data.getString("REQUEST_CODE") : null;
        final String REQUEST_DATA = data.has("REQUEST_DATA") ? data.getString("REQUEST_DATA") : null;
        Log.d(LOG_TAG, "Action: " + action);
        Log.d(LOG_TAG, "Action: " + packageName);
        Log.d(LOG_TAG, "Action: " + className);

        if (action != null && packageName != null && className != null) {
            final Intent intent = new Intent(action);
            intent.setType("text/plain");
            intent.setComponent(new ComponentName(packageName, className));
            intent.putExtra("PROGRAM_GUID", PROGRAM_GUID);
            intent.putExtra("RELIANT_GUID", RELIANT_GUID);
            intent.putExtra("REQUEST_CODE", REQUEST_CODE);
            intent.putExtra("REQUEST_DATA", REQUEST_DATA);

            try {
                this.startActivityForResult(call, intent, 1);
                call.success();
            } catch (ActivityNotFoundException activityError) {
                call.error(activityError.getMessage());
            }
        } else {
            call.error("No action provided");
        }
    }
}
