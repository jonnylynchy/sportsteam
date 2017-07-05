(function () {
    var window = this,
        $ = window.jQuery,
        roleTypes = [
            'ADMIN',
            'LEAGUE_MANAGER',
            'CAPTAIN',
            'PLAYER'
        ],
        rolesContainer = $('.roles'),
        leaguesContainer = $('.leagues'),
        teamsContainer = $('.teams'),
        leagueRadios = leaguesContainer.find('input[type="radio"]'),
        teamRadios = teamsContainer.find('input[type="radio"]'),
        roleChecks = rolesContainer.find('input[type="radio"]'),
        hasLeague = false,
        hasTeam = false,
        originalTeamId;

    teamRadios.each(function() {
        if(this.checked) {
            hasTeam = true;
            originalTeamId = $(this).val();
        }
    });

    leagueRadios.each(function() {
        if(this.checked) {
            hasLeague = true;
        }
        $(this).change(function(){
            teamsContainer.find('.teamList').remove();
            fetchTeams($(this).val(), originalTeamId);
        });
    });

    if(hasLeague) {
        leaguesContainer.removeClass('hide');
    }

    if(hasTeam) {
        teamsContainer.removeClass('hide');
    }

    // show different lists based on selected role
    roleChecks.change(function(){
        var index = $(this).val();
        index--;

        var roleType = roleTypes[index];
        if(roleType === 'LEAGUE_MANAGER') {
            leaguesContainer.removeClass('hide');
            teamsContainer.addClass('hide');
        } else if((roleType === 'CAPTAIN' || roleType === 'PLAYER')) {
            teamsContainer.removeClass('hide');
        } else {
            leaguesContainer.addClass('hide');
            teamsContainer.addClass('hide');
        }
    });

    // function fetchLeagues() {
    //     $.getJSON( "/api/v1/leagues", function( data ) {
    //         var items = [];
    //         $.each( data, function( key, league ) {
    //             items.push('<div class="form-check"><label class="form-check-label"><input class="form-check-input" type="radio" name="league" id="' + league.leagueId + '" value="' + league.leagueId + '">');
    //             items.push(' ' + league.label);
    //             items.push('</label></div>');
    //         });
    //
    //         $( "<div/>", {
    //             "class": "leagueList",
    //             html: items.join( "" )
    //         }).appendTo( ".leagues" );
    //     });
    // }

    function fetchTeams(leagueId, originalTeamId) {
        $.getJSON( "/api/v1/teams/league/" + leagueId, function( data ) {
            var items = [],
                checkedAttribute = "";

            if(data.length > 0) {
                $.each( data, function( key, team ) {
                    if(team.id == originalTeamId) {
                        checkedAttribute = 'checked=checked';
                    }
                    items.push('<div class="form-check"><label class="form-check-label"><input class="form-check-input" type="radio" name="teams" id="teams' + team.id + '" value="' + team.id + '" ' + checkedAttribute +  '">');
                    items.push('<span>' + team.name + '</span>');
                    items.push('</label></div>');
                });
            } else {
                items.push('<div>No teams exist for this league.</div>')
            }

            $( "<div/>", {
                "class": "teamList",
                html: items.join( "" )
            }).appendTo( ".teams" );
        });
    }
})();

