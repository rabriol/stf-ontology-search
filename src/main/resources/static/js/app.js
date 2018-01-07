var app = angular
            .module('app', [
                'ngRoute',
                'ngResource',
                'angularModalService',
                'ngAnimate'
            ])
            .config(function($routeProvider){
                $routeProvider
                    .when('/',{
                        templateUrl: '/views/result.html',
                        controller: 'QueryAnswerController'
                    })
                    .otherwise(
                        { redirectTo: '/'}
                    );
                }
            );