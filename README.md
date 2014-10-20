SpinnerDialog
=============

PhoneGap waiting dialog / progress dialog plugin with spinner for Android, iOS and Windows Phone 8.

## Installation

```cordova plugin add https://github.com/Paldom/SpinnerDialog.git```
or
```phonegap local plugin add https://github.com/Paldom/SpinnerDialog.git```

## Supported Platforms

- Android
- iOS
- Windows Phone 8

## Usage

    // Show spinner dialog
    window.plugins.spinnerDialog.show();
    
    // Show spinner dialog with message 
    // Note: spinner dialog is cancelable by default on Android and iOS. On WP8, it's fixed by deafult.
    window.plugins.spinnerDialog.show(null, "message");
    
    // Set spinner dialog fixed (Android, iOS)
    window.plugins.spinnerDialog.show(null, null, true);
    
    // Set spinner dialog fixed with callback (Android, iOS)
    // Note: callback fires on tap events and hardware back button click event
    window.plugins.spinnerDialog.show(null, null, function () {console.log("callback");});
    
    // Show spinner dialog with title and message (Android only)
    window.plugins.spinnerDialog.show("title","message");
    
    // Set spinner dialog fixed (cannot be canceled with screen touch or hardware button - Android only)
    window.plugins.spinnerDialog.show("title","message", true);
    
    // Hide spinner dialog
    window.plugins.spinnerDialog.hide();
    
Note: on Android platfrom, multiple show calls builds up a stack (LIFO) which means hide will dismiss the last spinner added with show call. 
