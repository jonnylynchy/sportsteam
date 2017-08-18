(function () {
    var window = this,
        $ = window.jQuery,
        $gameTDs = $('.teamGame'),
        teamId = $('h2').attr('data-teamId')
    ;

    function populateTeamGames() {
        var gameIds = [];
        $gameTDs.each(function(idx){
            var gameId = $(this).attr('data-gameId');
            gameIds.push({gameId: gameId, container: $(this)});
        });
        timeOutGetGames(gameIds);
    }

    function timeOutGetGames(gameIds) {
        console.log('fetching games...');
        if(gameIds.length > 0) {
            var gameToFetch = gameIds.pop();
            setTimeout(function(){
                timeOutGetGames(gameIds);
            }, 500);
            fetchTeamGames(gameToFetch);
        }
    }

    function fetchTeamGames(gameToFetch) {
        var gameId = gameToFetch.gameId,
            $container = gameToFetch.container,
            scoreObj = {},
            gameStatus = "",
            teamStyle = "",
            $statusTd = $container.next(),
            scoreHtml
        ;

        $.getJSON( "/api/v1/game/" + gameId, function( data ) {
            $.each( data, function( key, teamGame ) {
                var score = teamGame.score;
                if(teamGame.teamId == teamId) {
                    scoreObj.thisTeam = score;
                } else {
                    scoreObj.opposingTeam = score;
                }
            });

            if (scoreObj.thisTeam === 0 && scoreObj.opposingTeam === 0) {
                gameStatus = "N/A";
                teamStyle = "color:#ccc";
                scoreHtml = "N/A";
            } else if(scoreObj.thisTeam > scoreObj.opposingTeam) {
                gameStatus = "win";
                teamStyle = "color:#5cb85c";
            } else if(scoreObj.thisTeam === scoreObj.opposingTeam) {
                gameStatus = "draw";
                teamStyle = "color:#777";
            } else {
                gameStatus = "loss";
                teamStyle = "color:#d9534f";
            }
            var teamMarkup = '<span style="' + teamStyle + '">' + scoreObj.thisTeam + '</span>';
            var opposingTeamMarkup = '<span>' + scoreObj.opposingTeam + '</span>';
            scoreHtml = scoreHtml || teamMarkup + " to " + opposingTeamMarkup;
            $container.html(scoreHtml);
            $statusTd.text(gameStatus).addClass(gameStatus);
            console.log(scoreObj);
        });
    }

    populateTeamGames();
})();

