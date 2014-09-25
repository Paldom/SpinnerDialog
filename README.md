SpinnerDialog
=============

PhoneGap waiting dialog / progress dialog plugin with spinner for Android, iOS and Windows Phone 8.

Installation:

```cordova plugin add https://github.com/Paldom/SpinnerDialog.git```
or
```phonegap local plugin add https://github.com/Paldom/SpinnerDialog.git```


Usage:

    // Show spinner dialog
    window.plugins.spinnerDialog.show();
    
    // Show spinner dialog with title and/or message (Android only)
    window.plugins.spinnerDialog.show("title","message");
    
    // Show spinner dialog with message (WP8 only)
    window.plugins.spinnerDialog.show(null, "message");
    
    // Hide spinner dialog
    window.plugins.spinnerDialog.hide();
    
Note: on Android platfrom, multiple show calls builds up a stack (LIFO) which means hide will dismiss the last spinner added with show call. 
