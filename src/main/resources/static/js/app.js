(function () {
    'use strict';

    angular.module('staffapp', [
        // Angular modules 
        'ngRoute','ngResource'

        // Custom modules 
        
        // 3rd Party Modules
        
    ]).config(['$routeProvider', function ($routeProvider) {
  $routeProvider
   
    .when("/", { templateUrl: "partial/details.html", controller: "staffController" })
    .when("/create", { templateUrl: "partial/create.html", controller: "staffController" })
    .when("/update", { templateUrl: "partial/Update.html", controller: "staffController" })
    .when("/delete", { templateUrl: "partial/delete.html", controller: "staffController" })
    .when("/getstaff/", { templateUrl: "partial/getbyid.html", controller: "staffController" })
    .otherwise("/404", {templateUrl: "partials/404.html"});
}]);
})();