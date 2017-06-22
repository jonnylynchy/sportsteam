(function () {
    var window = this,
        $ = window.jQuery,
        self = this;

    $(function () {
        console.log('window is ready');
        console.log($('.container'));
        $.getJSON( "/api/v1/teams", function( data ) {
            var items = [];
            $.each( data, function( key, team ) {
                items.push( "<li id='" + team.id + "'><b>" + team.name + "</b><br>" + team.description + "</li>" );
            });

            $( "<ul/>", {
                "class": "my-new-list",
                html: items.join( "" )
            }).appendTo( ".teams" );
        });

    });
})();