CREATE TABLE IF NOT EXISTS `league_type_position` (
  `position_id` INT(11) NOT NULL AUTO_INCREMENT,
  `league_type_id` INT(11) NOT NULL,
  `label` VARCHAR(150) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (position_id),
  FOREIGN KEY fk_position_LeagueType(league_type_id) REFERENCES league_type(type_id)
) ENGINE=InnoDB;

# Basketball
INSERT INTO league_type_position (league_type_id, label) VALUES (1, 'Centre');
INSERT INTO league_type_position (league_type_id, label) VALUES (1, 'Point Guard');
INSERT INTO league_type_position (league_type_id, label) VALUES (1, 'Power Forward');
INSERT INTO league_type_position (league_type_id, label) VALUES (1, 'Short Forward');
INSERT INTO league_type_position (league_type_id, label) VALUES (1, 'Shooting Guard');

# Baseball
INSERT INTO league_type_position (league_type_id, label) VALUES (2, 'Pitcher');
INSERT INTO league_type_position (league_type_id, label) VALUES (2, 'Catcher');
INSERT INTO league_type_position (league_type_id, label) VALUES (2, 'Outfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES (2, 'Short Stop');
INSERT INTO league_type_position (league_type_id, label) VALUES (2, '1st Base');
INSERT INTO league_type_position (league_type_id, label) VALUES (2, '2nd Base');
INSERT INTO league_type_position (league_type_id, label) VALUES (2, '3rd Base');

# Soccer
INSERT INTO league_type_position (league_type_id, label) VALUES (3, 'Forward');
INSERT INTO league_type_position (league_type_id, label) VALUES (3, 'Right Back');
INSERT INTO league_type_position (league_type_id, label) VALUES (3, 'Right Midfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES (3, 'Defensive Midfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES (3, 'Goalkeeper');
INSERT INTO league_type_position (league_type_id, label) VALUES (3, 'Striker');
INSERT INTO league_type_position (league_type_id, label) VALUES (3, 'Left Midfielder');

# Football
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Center');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Offensive guard');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Offensive tackle');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Quarterback');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Running back');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Wide receiver');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Tight end');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Defensive tackle');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Defensive end');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Middle linebacker');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Outside linebacker');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Cornerback');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Safety');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Nickelback');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Kicker');
INSERT INTO league_type_position (league_type_id, label) VALUES (4, 'Punter');

# Kickball // from soccer
INSERT INTO league_type_position (league_type_id, label) VALUES (5, 'Forward');
INSERT INTO league_type_position (league_type_id, label) VALUES (5, 'Right Back');
INSERT INTO league_type_position (league_type_id, label) VALUES (5, 'Right Midfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES (5, 'Defensive Midfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES (5, 'Goalkeeper');
INSERT INTO league_type_position (league_type_id, label) VALUES (5, 'Striker');
INSERT INTO league_type_position (league_type_id, label) VALUES (5, 'Left Midfielder');

# Lacrosse
INSERT INTO league_type_position (league_type_id, label) VALUES (6, 'Attack');
INSERT INTO league_type_position (league_type_id, label) VALUES (6, 'Defense');
INSERT INTO league_type_position (league_type_id, label) VALUES (6, 'Midfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES (6, 'Goalie');

CREATE TABLE IF NOT EXISTS `user_position` (
  `user_position_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `position_id` INT(11) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (user_position_id),
  FOREIGN KEY fk_user_position_User(user_id) REFERENCES user(user_id),
  FOREIGN KEY fk_user_position_position(position_id) REFERENCES league_type_position(position_id)
) ENGINE=InnoDB;