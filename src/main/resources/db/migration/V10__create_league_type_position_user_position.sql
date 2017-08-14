CREATE TABLE IF NOT EXISTS `league_type_position` (
  `position_id` INT(11) NOT NULL AUTO_INCREMENT,
  `league_type_id` INT(11) NOT NULL,
  `label` VARCHAR(150) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (position_id),
  FOREIGN KEY fk_position_LeagueType(league_type_id) REFERENCES league_type(type_id)
) ENGINE=InnoDB;

# Basketball
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Basketball'), 'Centre');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Basketball'), 'Point Guard');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Basketball'), 'Power Forward');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Basketball'), 'Short Forward');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Basketball'), 'Shooting Guard');

# Baseball
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Baseball'), 'Pitcher');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Baseball'), 'Catcher');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Baseball'), 'Outfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Baseball'), 'Short Stop');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Baseball'), '1st Base');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Baseball'), '2nd Base');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Baseball'), '3rd Base');

# Soccer
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Soccer'), 'Forward');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Soccer'), 'Right Back');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Soccer'), 'Right Midfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Soccer'), 'Defensive Midfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Soccer'), 'Goalkeeper');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Soccer'), 'Striker');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Soccer'), 'Left Midfielder');

# Football
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Center');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Offensive guard');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Offensive tackle');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Quarterback');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Running back');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Wide receiver');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Tight end');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Defensive tackle');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Defensive end');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Middle linebacker');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Outside linebacker');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Cornerback');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Safety');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Nickelback');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Kicker');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Punter');

# Kickball // from soccer
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Kickball'), 'Forward');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Kickball'), 'Right Back');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Kickball'), 'Right Midfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Kickball'), 'Defensive Midfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Kickball'), 'Goalkeeper');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Kickball'), 'Striker');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Kickball'), 'Left Midfielder');

# Lacrosse
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Lacrosse'), 'Attack');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Lacrosse'), 'Defense');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Lacrosse'), 'Midfielder');
INSERT INTO league_type_position (league_type_id, label) VALUES ((SELECT type_id FROM league_type WHERE label = 'Lacrosse'), 'Goalie');

CREATE TABLE IF NOT EXISTS `user_position` (
  `user_position_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `position_id` INT(11) NOT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (user_position_id),
  FOREIGN KEY fk_user_position_User(user_id) REFERENCES user(user_id),
  FOREIGN KEY fk_user_position_position(position_id) REFERENCES league_type_position(position_id)
) ENGINE=InnoDB;