app.service('QueryOntopAPI', function ($http, $q, Utils) {

        this.executeQuery = function(query) {

            var deferred = $q.defer();

            $http
                .get('http://localhost:8081/query?query=' + window.encodeURIComponent(query))
                .then(function (response) {
                    if ( response.status !== 200) {
                        return [];
                    }
                    deferred.resolve(response.data);

                }, function (err) {
                    deferred.reject('error when calling QueryOntopAPI')
                });

            return deferred.promise;
        };

        this.getAcordaoResource = function(identifier) {

            var deferred = $q.defer();

            $http
                .get('http://localhost:8081/acordao/' + identifier.replace(new RegExp(' ', 'g'), '_'))
                .then(function (response) {
                    if ( response.status !== 200) {
                        return [];
                    }
                    deferred.resolve(response.data);

                }, function (err) {
                    deferred.reject('error when calling QueryOntopAPI')
                });

            return deferred.promise;
        }
    }
);

app.service('Utils', function () {

    this.removeURI = function( field ) {
        var fieldMatched = field.match( /#(\w)*/ );

        if( fieldMatched !== null ) {
            var element = fieldMatched[0];

            element = element.replace(new RegExp('#', 'g'), '');
            element = element.replace(new RegExp('_', 'g'), ' ');

            return element;
        }else{

            return field;
        }

    };

    this.convertToMapOfArray = function( data ){
        var m = {},
            rows = data;

        for( var index = 0; index < rows.length; index++ ){
            var objectKeys = Object.keys( rows[ index ] );
            var objectKey = objectKeys[ 0 ];
            var key = rows[ index ][ objectKey ].value;

            if( !m[ key ] ) {
                m[ key ] = [];
            }

            m[ key ].push( rows[ index ] );
        }

        return m;

    };

    this.replaceAll = function(target, search, replacement) {
        return target.replace(new RegExp(search, 'g'), replacement);
    };
});
