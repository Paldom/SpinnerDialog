var exec = require('cordova/exec');

module.exports = {

	show : function(title, message, isFixed) {
        cordova.exec(null, null, 'SpinnerDialog', 'show', [ title, message, !!isFixed ]);
    },


    hide : function() {
        cordova.exec(null, null, 'SpinnerDialog', 'hide', [ "","" ]);
    }

};