/*
MIGRATION SCRIPT:
  Sets up the league and league_type tables
  Seeds data for league_type
*/

CREATE TABLE IF NOT EXISTS `league_type` (
  `type_id` INT(11) NOT NULL AUTO_INCREMENT,
  `label` VARCHAR(100) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (type_id)
) ENGINE=InnoDB;

INSERT INTO league_type (label) VALUES ('Basketball');
INSERT INTO league_type (label) VALUES ('Baseball');
INSERT INTO league_type (label) VALUES ('Soccer');
INSERT INTO league_type (label) VALUES ('Football');
INSERT INTO league_type (label) VALUES ('Kickball');
INSERT INTO league_type (label) VALUES ('Lacrosse');

CREATE TABLE IF NOT EXISTS `league` (
  `league_id` INT(11) NOT NULL AUTO_INCREMENT,
  `type_id` INT(11) NOT NULL,
  `label` VARCHAR(150) NOT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (league_id),
  constraint `fk_LeagueType` foreign key `league_type_id` (type_id) references league_type(type_id)
) ENGINE=InnoDB;