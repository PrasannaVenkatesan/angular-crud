(function () {
    'use strict';
    var staffService = angular.module('staffapp');
    staffService.factory('Staff', ['$resource',
    function ($resource) {
    	
        
        return $resource('api/staff/:id',{id:'@id'},
         {
             sav:{method:"POST"},
             update:{method:"PUT"},
             remove:{method:"DELETE"}
             //show:{method:"GET"}
        });
        
    }
    ]);
    services.factory('UserFactory', function ($resource) {
        return $resource('api/staff/:id', {}, {
            show: { method: 'GET' },
           
        })
    });
   
})();