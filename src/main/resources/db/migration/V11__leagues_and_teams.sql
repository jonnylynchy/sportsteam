INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Basketball'), 'Micro Brewery Basketball', 'Beer League Basketball');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Dribbling Fools', 'Dribbling Champs of the Beer League', 2011, (SELECT league_id FROM league WHERE label = 'Micro Brewery Basketball'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('Hoop Dreams', 'Hoop Hoop Hoop It Up', 2005, (SELECT league_id FROM league WHERE label = 'Micro Brewery Basketball'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Over The Hill Dream Team', 'We Were Good...Once', 1985, (SELECT league_id FROM league WHERE label = 'Micro Brewery Basketball'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Warthogs', 'Our Odor Is Our Best Defense', 2011, (SELECT league_id FROM league WHERE label = 'Micro Brewery Basketball'));



INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Basketball'), 'New York State Basketball League', 'Minor League Basketball');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Generals', 'Leading The Way', 2011, (SELECT league_id FROM league WHERE label = 'New York State Basketball League'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Pizza Boys', 'We Deliver A Cold Slice Of Victory', 2009, (SELECT league_id FROM league WHERE label = 'New York State Basketball League'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('Lob City', 'Granny Shots All Day Long', 1957, (SELECT league_id FROM league WHERE label = 'New York State Basketball League'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('Space Jam 2', 'We Couldnt Get The Toons', 2008, (SELECT league_id FROM league WHERE label = 'New York State Basketball League'));


INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Baseball'), 'Micro Brewery Baseball', 'Beer League Baseball');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('4th Base', 'We Prefer To Stay Home', 2018, (SELECT league_id FROM league WHERE label = 'Micro Brewery Baseball'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('Cant Catch This', 'Its Outta Here', 2001, (SELECT league_id FROM league WHERE label = 'Micro Brewery Baseball'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('Men Of Steal', 'Thats Mine', 2003, (SELECT league_id FROM league WHERE label = 'Micro Brewery Baseball'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Umpire Strikes Back', 'I Thought We Had Them', 1982, (SELECT league_id FROM league WHERE label = 'Micro Brewery Baseball'));


INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Baseball'), 'Pacific Coast Baseball League', 'West Coast Minor League Baseball');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Generals', 'Leading The Way', 2011, (SELECT league_id FROM league WHERE label = 'Pacific Coast Baseball League'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Hawks', 'We Always See the Ball', 2008, (SELECT league_id FROM league WHERE label = 'Pacific Coast Baseball League'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Old Birds', 'We Wish We Could See the Ball', 2009, (SELECT league_id FROM league WHERE label = 'Pacific Coast Baseball League'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Warthogs', 'Where is the Ball?', 2009, (SELECT league_id FROM league WHERE label = 'Pacific Coast Baseball League'));


INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Baseball'), 'Mile High Baseball', 'More Home Runs With Less Effort');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('Genesis', 'Oldies But Goodies', 2014, (SELECT league_id FROM league WHERE label = 'Mile High Baseball'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Dragon Eaters', 'We Can Slay Any Team', 2012, (SELECT league_id FROM league WHERE label = 'Mile High Baseball'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Blue Eagles', 'We Live for this Stuff', 2015, (SELECT league_id FROM league WHERE label = 'Mile High Baseball'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Denver Outlaws', 'We Always Steal the Game', 2009, (SELECT league_id FROM league WHERE label = 'Mile High Baseball'));



INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Soccer'), 'Little Tykes Soccer', 'Learn The Game, Save The Day');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('Westminster All-Stars', 'Running for Our Parents', 2010, (SELECT league_id FROM league WHERE label = 'Little Tykes Soccer'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Privateers', 'We Steal the Ball Without You Even Knowing', 2006, (SELECT league_id FROM league WHERE label = 'Little Tykes Soccer'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Reschedulers', 'Its Hard for Us to Show Up Most Times', 2008, (SELECT league_id FROM league WHERE label = 'Little Tykes Soccer'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Klondike', 'Were Here for a Klondike Bar', 2008, (SELECT league_id FROM league WHERE label = 'Little Tykes Soccer'));



INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Soccer'), 'Long Legged Soccer', 'Drama on the Field, With Running');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Sentinels', 'Whiney Pros Can Stay Home', 2000, (SELECT league_id FROM league WHERE label = 'Long Legged Soccer'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Dominators', 'We Dominate On And Off The Field', 2014, (SELECT league_id FROM league WHERE label = 'Long Legged Soccer'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Crying Babies', 'We Cry When Someone Looks at Us', 2006, (SELECT league_id FROM league WHERE label = 'Long Legged Soccer'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Comeback Kids', 'We Used to be Good', 2006, (SELECT league_id FROM league WHERE label = 'Long Legged Soccer'));



INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Mile High Football', 'Free Tank of O2 with Every Touchdown');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Old Dogs', 'Old And Broken Is Our Way Of Life', 1982, (SELECT league_id FROM league WHERE label = 'Mile High Football'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Pig Skins', 'Porky Pig Was Kind Enough To Donate to the Cause', 2006, (SELECT league_id FROM league WHERE label = 'Mile High Football'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Silver Knights', 'Our Wenches Are Better Than You', 2006, (SELECT league_id FROM league WHERE label = 'Mile High Football'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('Turrainasaurus Rex', 'We Can Run but We Cant Grab the Ball', 2009, (SELECT league_id FROM league WHERE label = 'Mile High Football'));



INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Football'), 'Any Given Saturday', 'Because the Pros Claimed Sundays');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Sharks', 'Win or Move to Vegas', 1999, (SELECT league_id FROM league WHERE label = 'Any Given Saturday'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Generals', 'Leading The Way', 2011, (SELECT league_id FROM league WHERE label = 'Any Given Saturday'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Dominators', 'We Dominate On And Off The Field', 2014, (SELECT league_id FROM league WHERE label = 'Any Given Saturday'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Crazy Runners', 'You Will Never Know Where We Will Be', 2008, (SELECT league_id FROM league WHERE label = 'Any Given Saturday'));



INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Kickball'), 'Micro Brewery Kickball League Dallas', 'Adult, Co-ed, Cup-In-Hand-Required League');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Bacon Kickers', 'Kicking Balls And Eating Bacon', 2014, (SELECT league_id FROM league WHERE label = 'Micro Brewery Kickball League Dallas'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Ballbarians', 'We Will Pillage Your Beer', 2003, (SELECT league_id FROM league WHERE label = 'Micro Brewery Kickball League Dallas'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('4th Base', 'We Prefer To Stay Home', 1998, (SELECT league_id FROM league WHERE label = 'Micro Brewery Kickball League Dallas'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('Dont Stop Ballieving', 'Now Its Stuck In Your Head Too', 1986, (SELECT league_id FROM league WHERE label = 'Micro Brewery Kickball League Dallas'));


INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Kickball'), 'Micro Brewery Kickball League Denver', 'Adult, Co-ed, Cup-In-Hand-Required League');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Bacon Kickers', 'Kicking Balls And Eating Bacon', 2012, (SELECT league_id FROM league WHERE label = 'Micro Brewery Kickball League Denver'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Ballbarians', 'We Will Pillage Your Beer', 2003, (SELECT league_id FROM league WHERE label = 'Micro Brewery Kickball League Denver'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('Slim Kickins', 'We Took What Was Available', 2004, (SELECT league_id FROM league WHERE label = 'Micro Brewery Kickball League Denver'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('One Kick Wonders', 'We Had A Great Kick...Once', 1992, (SELECT league_id FROM league WHERE label = 'Micro Brewery Kickball League Denver'));


INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Lacrosse'), 'Colorado United Lacrosse League', 'Lacrosse For All Ages');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('Genesis', 'Oldies But Goodies', 2014, (SELECT league_id FROM league WHERE label = 'Colorado United Lacrosse League'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Dominators', 'We Dominate On And Off The Field', 2014, (SELECT league_id FROM league WHERE label = 'Colorado United Lacrosse League'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Muffin Stuffers', 'We Know Where to Put the Ball', 2010, (SELECT league_id FROM league WHERE label = 'Colorado United Lacrosse League'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Glory Days', 'We Are Probably Too Old For This Stuff', 2009, (SELECT league_id FROM league WHERE label = 'Colorado United Lacrosse League'));



INSERT INTO league (type_id, label, description)
VALUES ((SELECT type_id FROM league_type WHERE label = 'Lacrosse'), 'Mile High Lacrosse', 'Thin Air Lacrosse League of the West');

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Dragoons', 'No Experience, No Problem', 2015, (SELECT league_id FROM league WHERE label = 'Mile High Lacrosse'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Old Dogs', 'Old And Broken Is Our Way Of Life', 1982, (SELECT league_id FROM league WHERE label = 'Mile High Lacrosse'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Misfits', 'We Were Cool Before It Was Cool', 2011, (SELECT league_id FROM league WHERE label = 'Mile High Lacrosse'));

INSERT INTO team (team_name, team_description, year_formed, league_id)
VALUES ('The Military Squad', 'Veterans for Goals', 2012, (SELECT league_id FROM league WHERE label = 'Mile High Lacrosse'));