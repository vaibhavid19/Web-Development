(function(){
	var app = angular.module("ContactApp");

	app.service("ContactDataSvc", function($http) {

		console.log("From inside contact data service");
		var self =this;
		//Returns this.contacts as a list of JSON objects 
		
		self.getContacts = function(){

			var promise1 = $http.get('http://localhost:9090/telenotes/webapi/vaibhavi');
			var promise2 = promise1.then(function(response) {
				return response.data;
			})
			.catch(function(error) {
        	// pass the error the the error service
       			 //return errorService.handleError(error);
    		});
			
			console.log("From inside getContacts before returning..");
			return promise2;
		}
		
		self.saveContact = function(contact) {
			console.log("Inside save,before put" + contact);
			$http.put('http://localhost:9090/telenotes/webapi/vaibhavi', contact)
			.then(function(response){
				console.log(response);
			})
		}
		
		this.removeContact = function(cName) {
			console.log("Inside delete,before put" + contact);
			$http.delete('http://localhost:9090/telenotes/webapi/vaibhavi/' + cName)
			.success(function (data, status, headers) {
                $scope.ServerResponse = data;
            });
		}
		


	});

})();