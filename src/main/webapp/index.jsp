<!DOCTYPE html>
<html ng-app="ContactApp">

<head>
	<title> My Contacts App </title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="lib/angular.js"></script>
	<script src="lib/app.js"></script>
	<script src="lib/contactdata.service.js"></script>
	<script src="lib/contact.controller.js"></script>
	<script src="lib/appname.service.js"></script>
	<script src="lib/appconfig.service.js"></script>
</head>

<body>
	<h1>My Contacts App</h1>
	<div class='container'ng-controller="ContactCtrl as ctrl">
		<ul class="list-group">
			<li class="list-group-item" ng-repeat="contact in ctrl.contacts" ng-click="ctrl.selectContact($index)">
				<div class="row borders">
					<div class="col "> {{ contact.companyName }} </div>
					<div class="col"> {{ contact.contactName }} </div>
					<div class="col"> {{ contact.phoneNumber }} </div>
				</div>
     		</li>
       	</ul>
       	<div class="col">
       			<span ng-hide="ctrl.editMode"> {{ ctrl.selected.companyName }}</span>
				<input type="text" ng-show="ctrl.editMode" ng-model="ctrl.selected.companyName">
				<input type="text" ng-model="ctrl.selected.contactName">
				<input type="text" ng-model="ctrl.selected.phoneNumber">
		</div>
       	
	</div>
	<div class='container'>
				<div class="col">
					<div class="row">
						<button ng-show="ctrl.editMode" ng-click="ctrl.toggleEditMode()">Add</button>
						<button ng-click="ctrl.putContact()">Update</button>
						<button ng-click="ctrl.deleteContact()">Delete</button>
					</div>
     			</div>
    </div>
	
</body>

</html>


