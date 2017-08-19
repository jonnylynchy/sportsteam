/*
MIGRATION SCRIPT:
  Needed to alter the score column for team_game to be not null and default to 0
*/

ALTER TABLE `team_game`
  CHANGE COLUMN `score` `score` INT(3) NOT NULL DEFAULT 0 COMMENT '' ;