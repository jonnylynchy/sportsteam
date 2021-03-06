/*
MIGRATION SCRIPT:
  Seeds data for fake players (by using a stored procedure)
*/

DROP PROCEDURE IF EXISTS CREATEPLAYERS;
DELIMITER ;;

CREATE PROCEDURE CREATEPLAYERS()
BEGIN
DECLARE n INT;
DECLARE i INT;

# We're doing basketball, so each team (4) gets 12 players
SET n=48;
SET i=0;
WHILE i<n DO
  # insert player
  INSERT INTO user (active, email, last_name, first_name, password)
  VALUES (1, CONCAT('player_',i,'@email.com'), 'Smith', CONCAT('Player',i), 'Temp123');

  # insert user role
  INSERT INTO user_role (user_id, role_id)
  VALUES ((SELECT user_id FROM user WHERE email = CONCAT('player_',i,'@email.com')), 4);

  # insert user league
  INSERT INTO user_league (user_id, league_id)
  VALUES ((SELECT user_id FROM user WHERE email = CONCAT('player_',i,'@email.com')), (SELECT league_id FROM league WHERE label = 'Micro Brewery Basketball'));

  # insert user team
  # Will do manually

  SET i = i + 1;
END WHILE;
End;
;;

DELIMITER ;
CALL CREATEPLAYERS();