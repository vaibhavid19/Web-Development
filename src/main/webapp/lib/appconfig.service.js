(function(){
	var app = angular.module("ContactApp");

	app.service("AppDataServiceSvc", function AppConfig(AppNameSvc) {

		this.companyName = AppNameSvc;
		this.contactName = "Vaibhavi";

	});

})();
