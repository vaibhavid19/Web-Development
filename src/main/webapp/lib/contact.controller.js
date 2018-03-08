(function() {

	var app = angular.module("ContactApp");
	app.controller("ContactCtrl", ContactCtrl)

	function ContactCtrl(ContactDataSvc) {
		var self = this;
		self.editMode= false;
		
		ContactDataSvc.getContacts()
		.then(function(data) {
			console.log("From inside getContacts.then functiong..");
			self.contacts = data;
		})
		.catch(function (error) {
        	// pass the error the the error service
       			// return errorService.handleError(error);
    	});

		
		console.log("From inside contact controller")
		//this.selected = this.contacts[1];
		this.selectContact = function(index) {
			this.selected = this.contacts[index];
			console.log("From inside selectContact " + this.selected);
		}
		
		this.toggleEditMode = function() {
			this.editMode = !this.editMode;
		}
		
		this.putContact = function(){
			console.log("Inside putContact" + this.selected);
			var contact = this.selected;
			ContactDataSvc.saveContact(contact);
			
		}
		
		this.deleteContact = function(){
			console.log("Inside deleteContact" + this.selected);
			var idToDelete = this.selected;
			ContactDataSvc.removeContact(idToDelete);
			
		}
	}
})();