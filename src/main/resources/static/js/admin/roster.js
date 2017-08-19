/*
 Contains all the javascript for the roster (edit) page
*/

(function () {
    var window = this,
        $ = window.jQuery,
        leaguesContainer = $('.leagues'),
        teamsContainer = $('.teams'),
        playersContainer = $('.players'),
        playerListSelector = playersContainer.find('.playerList'),
        leagueSelect = leaguesContainer.find('select'),
        teamSelect = teamsContainer.find('select'),
        leagueId = 0,
        btnSubmit = $('button.btn-primary'),
        positionsHolder = $('<select></select>');

    leagueSelect.change(function() {
        if($(this).val() !== "") {
            teamsContainer.removeClass('hide');
            leagueId = $(this).val();
            fetchTeams(leagueId, teamSelect);
        } else {
            teamsContainer.addClass('hide');
        }
        playersContainer.addClass('hide');
        validateSubmit();
    });

    teamSelect.change(function() {
        if($(this).val() !== "") {
            // populate and show players list
            fetchPlayers($(this).val(), playerListSelector);
            playersContainer.removeClass('hide');
        } else {
            // hide players list
            playersContainer.addClass('hide');
        }
        validateSubmit();
    });

    function validateSubmit() {
        // if all fields have values...
        if(leagueSelect.val() !== "" && teamSelect.val() !== "") {
            // teamListInput.val(team1Select.val() + ',' + team2Select.val());

            // Disable for now...
            enableSubmit();
        } else {
            disableSubmit();
        }
    }

    function enableSubmit() {
        btnSubmit.prop('disabled', false);
        btnSubmit.removeClass('disabled');
    }

    function disableSubmit() {
        btnSubmit.prop('disabled', true);
        btnSubmit.addClass('disabled');
    }

    function fetchTeams(leagueId, teamSelector) {
        $.getJSON( "/api/v1/teams/league/" + leagueId, function( data ) {
            var items = ['<option value="">Select Team</option>'];
            if(data.length > 0) {
                $.each( data, function( key, team ) {
                    items.push('<option value="'+ team.teamId + '">' + team.name + '</option>');
                });
                fetchPositions(data[0].league.leagueType.typeId);
            }
            // TODO: maybe add a message for no teams if non exist?
            // else {
            //     items.push('<div>No teams exist for this league.</div>')
            // }

            $(teamSelector).html(items.join( "" ));

            //validateSubmit();

        });
    }

    function fetchPositions(leagueTypeId) {
        $.getJSON( "/api/v1/positions/leagueType/" + leagueTypeId, function( data ) {
            var items = ['<option selected>Position</option>'];
            $.each( data, function( key, position ) {
                items.push('<option value="'+ position.positionId +'">' + position.label + '</option>')
            });
            positionsHolder.html(items.join( "" ));
        });
    }

    function fetchPlayerPositions(playerId) {
        // console.log("fetching positions for: ", playerId);
        $.getJSON( "/api/v1/player/" + playerId + "/position/", function( data ) {
            var $playerPositionSelect = $('.playerList').find('.row[value="'+ playerId +'"]').find('select');
            if(data.length > 0) {
                $playerPositionSelect.find('option[value="'+ data[0].positionId +'"]').prop('selected', true);
            }
        });
    }

    function fetchPlayers(teamId, playerListSelector) {
        $.getJSON( "/api/v1/teams/" + teamId + "/players/", function( data ) {
            var items = [];
            if(data.length > 0) {
                $.each( data, function( key, player ) {
                    items.push('<div class="row" value="'+ player.id + '"><div class="col-8">' + player.firstName + ' ' + player.lastName +
                        '</div><div class="col-4 text-right"><select class="custom-select" name="'+ player.id +'">' + positionsHolder.html() + '</select></div></div>' +
                        '<div class="row"><div class="col-12"><hr></div></div>');
                    fetchPlayerPositions(player.id);
                });
            } else {
                items.push('<div>There are no players on this team</div>');
            }

            $(playerListSelector).html(items.join( "" ));
            validateSubmit();
        });
    }

})();

