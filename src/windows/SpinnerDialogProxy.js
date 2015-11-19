cordova.commandProxy.add("SpinnerDialog", {
	show: function (successCallback, errorCallback, params) {
		//var msgBox = new Windows.UI.Popups.MessageDialog("prova");
		//msgBox.showAsync();
	    var element = element || document.createElement("div");
	    //element.style = "width:100%; height:100%; background-color: #000000";
	    element.style.width = "100%";
	    element.style.height = "100%";
	    element.style.position = "relative";
	    element.style.opacity = .5; //For real browsers;
	    element.style.filter = "alpha(opacity=50)"; //For IE;
	    element.style.background = "#000000";
	    element.style.zIndex = "999999";
		
		document.body.appendChild(element);
	}
});