package hu.dpal.phonegap.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.ProgressDialog;
import android.content.DialogInterface;


public class SpinnerDialog extends CordovaPlugin {

    public ProgressDialog spinnerDialog = null;

    public SpinnerDialog() {
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("show")) {
        	
        	final String title = args.getString(0) == "null" ? null : args.getString(0);
            final String message = args.getString(1) == "null" ? null : args.getString(1);
            
        	
        	if (this.spinnerDialog != null) {
				this.spinnerDialog.dismiss();
				this.spinnerDialog = null;
			}
        	
			final CordovaInterface cordova = this.cordova;
			Runnable runnable = new Runnable() {
				public void run() {		
					
					SpinnerDialog.this.spinnerDialog = ProgressDialog.show(cordova.getActivity(), title, message, true, true,
							new DialogInterface.OnCancelListener() {
								public void onCancel(DialogInterface dialog) {
									SpinnerDialog.this.spinnerDialog = null;
								}
							});
				}
			};
			this.cordova.getActivity().runOnUiThread(runnable);
			
        }
        else if (action.equals("hide")) {
			if (this.spinnerDialog != null) {
				this.spinnerDialog.dismiss();
				this.spinnerDialog = null;
			}
        }

        callbackContext.success();
        return true;
    }

}