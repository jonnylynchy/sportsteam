(function () {
    var window = this,
        $ = window.jQuery,
        leaguesContainer = $('.leagues'),
        teams1Container = $('.teams1'),
        teams2Container = $('.teams2'),
        leagueSelect = leaguesContainer.find('select'),
        team1Select = teams1Container.find('select'),
        team2Select = teams2Container.find('select'),
        leagueId = 0;

    // add date/time picker to date field
    $('#inputGameDateTime').datetimepicker();

    leagueSelect.change(function() {
        if($(this).val() != "") {
            teams1Container.removeClass('hide');
            leagueId = $(this).val();
            fetchTeams(leagueId, team1Select);
        } else {
            teams1Container.addClass('hide');
        }
        teams2Container.addClass('hide');
    });

    team1Select.change(function() {
        if($(this).val() != "") {
            teams2Container.removeClass('hide');
            fetchTeams(leagueId, team2Select);
        } else {
            teams2Container.addClass('hide');
        }
    });

    function fetchTeams(leagueId, teamSelector) {
        $.getJSON( "/api/v1/teams/league/" + leagueId, function( data ) {
            var items = ['<option value="">Select Team</option>'];
            if(data.length > 0) {
                $.each( data, function( key, team ) {
                    items.push('<option value="'+ team.id + '">' + team.name + '</option>');
                });
            }
            // else {
            //     items.push('<div>No teams exist for this league.</div>')
            // }

            $(teamSelector).html(items.join( "" ));
        });
    }
})();

