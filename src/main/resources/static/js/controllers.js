app.controller('QueryAnswerController', ['QueryOntopAPI', 'Utils', 'ModalService', '$scope',

    function(QueryOntopAPI, Utils, ModalService, $scope) {

        QueryOntopAPI.executeQuery($scope.query).then(function(data) {

            var results = Utils.convertToMapOfArray(data.results.bindings);

            if (Object.values(results)[0][0].hasOwnProperty('descricao')) {
                $scope.byDecisao = results;
            } else {
                $scope.byMinistro = results;
            }

            $scope.utils = Utils;
            $scope.result = data;
            $scope.names = Object.keys( results );

        }, function (reason) {
    });

    $scope.openModal = function(identifier) {

        QueryOntopAPI.getAcordaoResource(identifier).then(function (result) {
            console.log(result);
            ModalService.showModal({
                templateUrl: "/views/modal.html",
                controller: "ModalController",
                inputs: {
                    title: identifier,
                    result: result
                }

            }).then(function(modal) {

                modal.element.modal();
                modal.close.then(function(result) {
                });

            });
        });
    };

    $scope.expandAll = function (expanded) {
        // $scope is required here, hence the injection above, even though we're using "controller as" syntax
        $scope.$broadcast('onExpandAll', {expanded: expanded});
    };
}]);

app.controller('ModalController', ['$scope', '$element', 'title', 'result', 'close', 'Utils',

    function($scope, $element, title, result, close, Utils) {
        $scope.title = title;
        $scope.result = result;
        $scope.utils = Utils;

        $scope.close = function(result) {
            close(result, 500); // close, but give 500ms for bootstrap to animate
        };
    }]
);