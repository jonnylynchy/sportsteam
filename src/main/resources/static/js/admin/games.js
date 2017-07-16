(function () {
    var window = this,
        $ = window.jQuery,
        locationContainer = $('.location'),
        dateContainer = $('.datetime'),
        leaguesContainer = $('.leagues'),
        teams1Container = $('.teams1'),
        teams2Container = $('.teams2'),
        locationSelect = locationContainer.find('select'),
        dateInput = dateContainer.find('input'),
        leagueSelect = leaguesContainer.find('select'),
        team1Select = teams1Container.find('select'),
        team2Select = teams2Container.find('select'),
        leagueId = 0,
        btnSubmit = $('button.btn-primary'),
        teamListInput = $('#teams');

    // add date/time picker to date field
    $('#inputGameDateTime').datetimepicker();

    locationSelect.change(function () {
        validateSubmit();
    });

    dateInput.blur(function (){
        validateSubmit();
    });

    leagueSelect.change(function() {
        if($(this).val() != "") {
            teams1Container.removeClass('hide');
            leagueId = $(this).val();
            fetchTeams(leagueId, team1Select);
        } else {
            teams1Container.addClass('hide');
        }
        teams2Container.addClass('hide');
        validateSubmit();
    });

    team1Select.change(function() {
        if($(this).val() != "") {
            teams2Container.removeClass('hide');
            fetchTeams(leagueId, team2Select);
        } else {
            teams2Container.addClass('hide');
        }
        validateSubmit();
    });

    team2Select.change(function() {
        validateSubmit();
    });

    function validateSubmit() {
        // if all fields have values...
        if(locationSelect.val() !== "" && dateInput.val() !== "" && isValidDate(dateInput.val()) && leagueSelect.val() !== ""
            && team1Select.val() !== "" && team2Select.val() !== "") {
            teamListInput.val(team1Select.val() + ',' + team2Select.val());
            enableSubmit();
        } else {
            disableSubmit();
        }
    }

    function isValidDate(strDate) {
        var date = new Date(strDate);
        return date instanceof Date && !isNaN(date.valueOf());
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
            }
            // TODO: maybe add a message for no teams if non exist?
            // else {
            //     items.push('<div>No teams exist for this league.</div>')
            // }

            $(teamSelector).html(items.join( "" ));
            validateSubmit();
        });
    }
})();

