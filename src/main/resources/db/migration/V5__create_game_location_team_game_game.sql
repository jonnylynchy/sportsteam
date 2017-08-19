/*
MIGRATION SCRIPT:
  Creates the game_location, game, and team_game tables
*/

CREATE TABLE `game_location` (
  `game_location_id` int(11) NOT NULL AUTO_INCREMENT,
  `location_label` VARCHAR(100) NOT NULL,
  `location_description` VARCHAR(255) NULL,
  `location_street_address_1` varchar(150) NOT NULL,
  `location_street_address_2` varchar(150) NULL,
  `location_city` varchar(150) NOT NULL,
  `location_state_province` varchar(150) NOT NULL,
  `location_country` varchar(100)	not null,
  `location_zip_postal` VARCHAR(25) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`game_location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `game` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_location_id` int(11) NOT NULL,
  `date_time` DATETIME NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`game_id`),
  FOREIGN KEY fk_game_location(game_location_id) REFERENCES game_location(game_location_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `team_game` (
  `team_game_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) NOT NULL,
  `game_id` int(11) NOT NULL,
  `is_home` boolean NOT NULL,
  `score` int(3) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`team_game_id`),
  FOREIGN KEY fk_team(team_id) REFERENCES team(team_id),
  FOREIGN KEY fk_game(game_id) REFERENCES game(game_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;