SpinnerDialog
=============

PhoneGap waiting dialog / progress dialog plugin with spinner for Android and iOS.

Installation:

```cordova plugin add https://github.com/Paldom/SpinnerDialog.git```
or
```phonegap local plugin add https://github.com/Paldom/SpinnerDialog.git```


Usage:

    // Show spinner dialog
    window.plugins.spinnerDialog.show();
    
    // Show spinner dialog with message (Android only)
    window.plugins.spinnerDialog.show("title","message");
    
    // Hide spinner dialog
    window.plugins.spinnerDialog.hide();
    
Note: on Android platfrom, multiple show calls builds up a stack (LIFO) which means hide will dismiss the last spinner added with show call. 
