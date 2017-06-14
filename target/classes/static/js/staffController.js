(function () {
    'use strict';



    angular
        .module('staffapp')
        .controller('staffController', staffController);

    staffController.$inject = ['$scope','Staff']; 

    function staffController($scope, Staff) {
       
    	
         $scope.Staffs = Staff.query();
         
         
        $scope.result = "";
        $scope.saveStaff = function() {
            //alert(JSON.stringify($scope.Staff)+"<-----------Test");
             //$scope.Staff.empid = 0;
             //$scope.Staff.Designation=Staff.Designation;
             
             Staff.save($scope.Staff,function(success){
              //alert(JSON.stringify(success));
              $scope.result = JSON.stringify(success);
              window.location.href = '#/';
             },function(error){
               ////alert(JSON.stringify(error));
             });
             //window.location.href = '#/';
             
        }
        
        $scope.updateStaff = function(){
            //alert(JSON.stringify($scope.Staff)+"<-----------Test");
           Staff.update($scope.Staff,function(success){
                //alert(JSON.stringify(success));
                $scope.result = JSON.stringify(success);
                window.location.href = '#/'; 
            },function(error){
                
            });
            //window.location.href = '#/';
        }
       
       
          
        $scope.deleteStaff = function(){
            //alert(JSON.stringify($scope.Staff)+"<-----------Test");
            Staff.delete($scope.Staff,function(success){
            //alert(JSON.stringify(success));
            $scope.result = JSON.stringify(success);
                window.location.href = '#/';
            },function(error){
                
            });
           
        }
    }
    app.controller('UserListCtrl', ['$scope', 'UsersFactory', 'UserFactory', '$location',
                                    function ($scope, UsersFactory, UserFactory, $location) {

                                        // callback for ng-click 'editUser':
                                        $scope.editUser = function (userId) {
                                            $location.path('/getstaff/' + userId);
                                        };

                                       

                                        $scope.users = UsersFactory.query();
                                    }]);
                                  /* ... */
 
})();

