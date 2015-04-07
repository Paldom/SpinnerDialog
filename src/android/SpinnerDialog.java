package hu.dpal.phonegap.plugins;

import java.util.Stack;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.ProgressBar;

public class SpinnerDialog extends CordovaPlugin {

	public Stack<ProgressDialog> spinnerDialogStack = new Stack<ProgressDialog>();

	public SpinnerDialog() {
	}

	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals("show")) {

			final String title = "null".equals(args.getString(0)) ? null : args.getString(0);
			final String message = "null".equals(args.getString(1)) ? null : args.getString(1);
			final boolean isFixed = args.getBoolean(2);
                
			final CordovaInterface cordova = this.cordova;
			Runnable runnable = new Runnable() {
				public void run() {
					
					DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() {
						public void onCancel(DialogInterface dialog) {
							if (!isFixed) {
								while (!SpinnerDialog.this.spinnerDialogStack.empty()) {
									SpinnerDialog.this.spinnerDialogStack.pop().dismiss();
									callbackContext.success();
								}
							}
						}
					};
					
					ProgressDialog dialog;
					if (isFixed) {
						//If there is a progressDialog yet change the text
						if (!SpinnerDialog.this.spinnerDialogStack.empty()) {
							dialog = SpinnerDialog.this.spinnerDialogStack.peek(); 
							if (title != null) {
								dialog.setTitle(title);	
							}
							if (message!=null) {
								dialog.setMessage(message);	
							}
						}
						else{
							dialog = CallbackProgressDialog.show(cordova.getActivity(), title, message, true, false, null, callbackContext);
							SpinnerDialog.this.spinnerDialogStack.push(dialog);
						}
					} else {
						//If there is a progressDialog yet change the text
						if (!SpinnerDialog.this.spinnerDialogStack.empty()) {
							dialog = SpinnerDialog.this.spinnerDialogStack.peek(); 
							if (title != null) {
								dialog.setTitle(title);	
							}
							if (message!=null) {
								dialog.setMessage(message);	
							}	
						}
						else{
							dialog = ProgressDialog.show(cordova.getActivity(), title, message, true, true, onCancelListener);
							SpinnerDialog.this.spinnerDialogStack.push(dialog);
						}
					}
					
					if (title == null && message == null) {
						dialog.setContentView(new ProgressBar(cordova.getActivity()));
					}
					

				}
			};
			this.cordova.getActivity().runOnUiThread(runnable);

		} else if (action.equals("hide")) {

			Runnable runnable = new Runnable() {
				public void run() {

					if (!SpinnerDialog.this.spinnerDialogStack.empty()) {
						SpinnerDialog.this.spinnerDialogStack.pop().dismiss();
					}

				}
			};
			this.cordova.getActivity().runOnUiThread(runnable);

		}
		
		return true;
	}

}
