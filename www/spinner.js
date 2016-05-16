var exec = require('cordova/exec');

module.exports = {

	show : function(title, message, cancelCallback, color, backgroundColor) {
        if (cancelCallback == true && typeof cancelCallback !== "function") {
            cancelCallback = function () {};  
        }
        cordova.exec(cancelCallback, null, 'SpinnerDialog', 'show', [ title, message, !!cancelCallback, color, backgroundColor ]);
    },

    hide : function(success, fail) {
        cordova.exec(success, fail, 'SpinnerDialog', 'hide', [ "","" ]);
    }

};