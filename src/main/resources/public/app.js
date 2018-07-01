
var app = angular.module('ToDoListApp', ['ngRoute','ngResource']);

		app.config(function($routeProvider){
				$routeProvider
				.when('/tasks',
				{
					controller: 'ListTasksController',
					templateUrl: '/views/tasks.html'
				})	
				.otherwise({
					redirectTo: '/tasks'
				})

		});
		