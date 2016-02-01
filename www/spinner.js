var exec = require('cordova/exec');

module.exports = {

	show: function(title, message, cancelCallback) {
        if (cancelCallback === true && typeof cancelCallback !== "function") {
            cancelCallback = function () {};  
        }
		if (!this.masked) {
			this.masked = true;
			cordova.exec(cancelCallback, null, 'SpinnerDialog', 'show', [ title, message, !!cancelCallback ]);
		}
    },

    hide: function(success, fail) {
		this.masked = false;
        cordova.exec(success, fail, 'SpinnerDialog', 'hide', [ "","" ]);
    },
	
	isMasked: function() {
		return this.masked ? true : false;
	}
};
