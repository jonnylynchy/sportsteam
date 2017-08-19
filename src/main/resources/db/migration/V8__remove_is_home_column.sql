/*
MIGRATION SCRIPT:
  Needed to drop is_home column for simplicity purposes
*/

ALTER TABLE team_game DROP is_home;