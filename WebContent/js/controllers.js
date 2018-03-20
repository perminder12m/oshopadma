/**
 * 
 */
var myAppModule= angular.module('myApp',[])
myAppModule.controller('HelloController', function($scope) {
	$scope.greeting = {text:'Hello', name:'perminder', age:'35'};
});
myAppModule.controller('HeadingTableController', function() {
	
});

myAppModule.directive('oshoPadmaModal', function(){
	return{
		restrict: 'E',
		templateUrl:'modalDirective.html',
		scope:{},		
		link: function(scope, element, attrs){
				scope.modalType='Login';		
				scope.signUpClicked=function(){
					scope.modalType='SignUp';
					$('.modal-footer').addClass('disable');
				};
			
		}
	};
});

myAppModule.controller('loginModalFooter', function($scope) {
	
});