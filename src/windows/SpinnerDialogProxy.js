cordova.commandProxy.add("SpinnerDialog", {
	show: function (successCallback, errorCallback, params) {
		if(!document.getElementById("SpinnerDialogPlugin"))
			addSpinner();
		showSpinner();
	},
	hide: function (successCallback, errorCallback, params) {
		hideSpinner();
	}
});

function showSpinner(){
	var element = document.getElementById("SpinnerDialogPlugin");
	if(element) element.style.display = "block";
};

function hideSpinner(){
	var element = document.getElementById("SpinnerDialogPlugin");
	if(element) element.style.display = "none";
};

function addSpinner() {
	var element = element || document.createElement("div");
	element.setAttribute("id", "SpinnerDialogPlugin");
	element.style.width = "100%";
	element.style.height = "100%";
	element.style.position = "absolute";
	element.style.top = "0px";
	element.style.left = "0px";
	element.style.opacity = .5; //For real browsers;
	element.style.filter = "alpha(opacity=50)"; //For IE;
	element.style.background = "#000000";
	element.style.zIndex = "999999";
	element.style.display = "none";
	
	element.innerHTML = "<progress class=\"win-ring\" style=\"position: absolute; top: 50%; left: 50%;transform: translate(-50%, -50%);\"></progress>";
	
	document.body.appendChild(element);
};