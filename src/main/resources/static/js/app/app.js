'use strict'

var minhaLanchoneteApp = angular.module('minhaLanchonete', [ 'ui.bootstrap', 'minhaLanchoneteApp.controllers',
		'minhaLanchoneteApp.services' ]);
demoApp.constant("CONSTANTS", {
	getUserByIdUrl : "/user/getUser/",
	getAllUsers : "/user/getAllUsers",
	saveUser : "/user/saveUser",
	localHost: "http://localhost:8080/minha-lanchonete/s"
});