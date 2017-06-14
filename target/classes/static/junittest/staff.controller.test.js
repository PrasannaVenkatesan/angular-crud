describe("staffapp", function () {
    beforeEach(module("staffapp"));
    describe('controller: staffController', function () {
        var ctrl, Staff, $scope;
     

        beforeEach(inject(function ($rootScope, $controller) {
            $scope = $rootScope.$new();
            Staffs = {
                query: function () { 
                   
                },
                save:function () {
                    $scope.result = '{"result":true}';
                },
                 update:function () {
                    $scope.result = '{"result":true}';
                },
                delete:function () {
                     $scope.result = '{"result":true}';
                }
              
            };
             spyOn(Staffs, 'query').and.returnValue('[{"id":1,"name":"aravind","depart":"dev","subject":"os","age":"30"}]'); // <----------- HERE

            ctrl = $controller('staffController', { $scope: $scope, Staff: Staffs });
        }));

        it('Should call get all()', function () {
            console.log($scope.Staffs);     
            expect($scope.Staffs).toBe('[{"id":1,"name":"aravind","depart":"dev","subject":"os","age":"30"}]');
        });
        
        it('Should call create', function () {
            $scope.Staff = {"name":"reka","depart":"Dev","subject":"daa","age":"57"}
            console.log($scope.Staff);
            $scope.saveStaff($scope.Staff);
            expect($scope.result).toBe('{"result":true}');
        });

        it('should call update',function()
        {
            $scope.Staff={"name":"nirmal","depart":"cse","subject":"os","age":25}
            console.log($scope.Staffs);
            $scope.updateStaff($scope.Staff);
            expect($scope.result).toBe('{"result":true}');

        });

 });
        });