app.directive( 'callRoute', function ( $location ) {

    return function ( scope, element, attrs ) {
        var path;

        attrs.$observe( 'callRoute', function (val) {
            path = val;
        });

        element.bind( 'click', function () {
            scope.$apply( function () {
                $location.path( path );
            });
        });
    };
});

app.directive( 'expand' , function () {
    return {
        restrict: 'A',
        controller: ['$scope', function ($scope) {
            $scope.$on('onExpandAll', function (event, args) {
                $scope.expanded = args.expanded;
            });
        }]
    };
});