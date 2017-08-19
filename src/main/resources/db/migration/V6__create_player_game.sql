/*
MIGRATION SCRIPT:
  Creates the user_game table
*/

CREATE TABLE `user_game` (
  `user_game_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `game_id` int(11) NOT NULL,
  `score` int(3) NOT NULL DEFAULT 0,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_game_id`),
  FOREIGN KEY fk_user_game_user(user_id) REFERENCES user(user_id),
  FOREIGN KEY fk_user_game_game(game_id) REFERENCES game(game_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;