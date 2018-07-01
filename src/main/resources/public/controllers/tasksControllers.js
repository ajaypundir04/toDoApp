app.controller('AddTasksController', function($scope, $location,
		DataTasksFactory, AddTasksFactory, $route) {
	this.addTask = function(addNewTaskCtrl) {
		AddTasksFactory.save(addNewTaskCtrl);
		DataTasksFactory.addTask(addNewTaskCtrl);
		window.setTimeout(function() {
			location.reload(true);
		}, 10);
	}
});

app.controller('ListTasksController', function($scope, $location,
		DataTasksFactory, ListTasksFactory, $route) {
	var task = ListTasksFactory.query();
	task.$promise.then(function(result) {
		DataTasksFactory.init(result);
		$scope.tasks = DataTasksFactory.getTasks();
	});

});
app.controller('CompleteActionsController', function($scope, $location,
		ListTasksByIdFactory, EditTasksFactory, DeleteTasksFactory) {
	$scope.deleteTask = function(taskid) {
		DeleteTasksFactory.delete_task({
			id : taskid
		}, null);

		window.setTimeout(function() {
			location.reload(true);
		}, 10);

	};


	});
app.controller('TasksActionsController', function($scope, $location,
		ListTasksByIdFactory, EditTasksFactory, DeleteTasksFactory) {

	$scope.checkTask = function(taskid) {
		var selectedTask = ListTasksByIdFactory.query({
			id : taskid
		});
		selectedTask.$promise.then(function(result) {
			result.isdone = "true";
			EditTasksFactory.update({
				id : taskid
			}, result);

			window.setTimeout(function() {
				location.reload(true);
			}, 10);

		});
	};
	$scope.deleteTask = function(taskid) {
		DeleteTasksFactory.delete_task({
			id : taskid
		}, null);

		window.setTimeout(function() {
			location.reload(true);
			//location.href="#tasks#pendingTasks"
		}, 10);

	};

	$scope.editTask = function(taskid) {
		var selectedTask = ListTasksByIdFactory.query({
			id : taskid
		});

		selectedTask.$promise.then(function(result) {
			// Populate scope variables
			$scope.editTaskCtrl = $scope.editTaskCtrl || {};
			$scope.editTaskCtrl.taskname = result.taskname;
			$scope.editTaskCtrl.isdone = result.isdone;
			$scope.editTaskCtrl.taskid = taskid;
		});

	};

	$scope.updateTask = function(editTaskCtrl) {
		EditTasksFactory.update({
			id : editTaskCtrl.taskid
		}, editTaskCtrl);
		
		
		var func=angular.element(document.getElementById('ctrlo')).scope().$apply();;

		window.setTimeout(function() {
			location.reload(true);
			//location.href="#tasks#pendingTasks"
				
		}, 10);

	};

	

	window.onload = function() {
		angular.element(document.querySelector("#pendingTasks")).addClass("panel-collapse collapse in");
	}
	
});
