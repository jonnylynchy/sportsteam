/*
MIGRATION SCRIPT:
  Creates the team, user_team, and user_league tables
*/

CREATE TABLE `team` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` VARCHAR(100) NOT NULL,
  `team_description` VARCHAR(255) NOT NULL,
  `year_formed` int(4) NOT NULL,
  `league_id` INT(11),
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`team_id`),
  FOREIGN KEY fk_league(league_id)
  REFERENCES league(league_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_team` (
  `user_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`team_id`),
  KEY `FKuser_team_team_id` (`team_id`),
  CONSTRAINT `FKteamuser_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKuserteam_team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_league` (
  `user_id` int(11) NOT NULL,
  `league_id` int(11) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`league_id`),
  KEY `FKuser_league_league_id` (`league_id`),
  CONSTRAINT `FKleagueuser_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKuserleague_league_id` FOREIGN KEY (`league_id`) REFERENCES `league` (`league_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;