cordova.commandProxy.add("SpinnerDialog", {
	createEventWithOptions: function (successCallback, errorCallback, params) {
		var msgBox = new Windows.UI.Popups.MessageDialog("prova");
		msgBox.showAsync();
	}
});