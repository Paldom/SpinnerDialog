cordova.commandProxy.add("SpinnerDialog", {
	show: function (successCallback, errorCallback, params) {
		var msgBox = new Windows.UI.Popups.MessageDialog("prova");
		msgBox.showAsync();
	}
});