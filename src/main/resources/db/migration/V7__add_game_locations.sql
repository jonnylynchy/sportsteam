/*
MIGRATION SCRIPT:
  Seeds data for game_location
*/

INSERT INTO game_location (
  location_label, location_description, location_street_address_1, location_city,
  location_state_province, location_country, location_zip_postal
)
VALUES (
  'Hobby Field',
  'Large community park with soccer fields, a playground & an area to fly radio-controlled airplanes.',
  '12200 Garland Rd',
  'Dallas',
  'TX',
  'United States',
  '75218'
);

INSERT INTO game_location (
  location_label, location_description, location_street_address_1, location_city,
  location_state_province, location_country, location_zip_postal
)
VALUES (
  'Uptown Sports Complex',
  'Sports complex offering fitness classes for kids, with a few classes for adults, plus batting cages.',
  '170 W 233rd St',
  'Bronx',
  'NY',
  'United States',
  '10463'
);

INSERT INTO game_location (
  location_label, location_description, location_street_address_1, location_city,
  location_state_province, location_country, location_zip_postal
)
VALUES (
  'Balboa Sports Center',
  'Public indoor/outdoor sports facility for basketball, handball, tennis & football, among others.',
  '17015 Burbank Blvd',
  'Encino',
  'CA',
  'United States',
  '91316'
);

INSERT INTO game_location (
  location_label, location_description, location_street_address_1, location_city,
  location_state_province, location_country, location_zip_postal
)
VALUES (
  'Minneapolis Sports Center',
  'Sports complex in Minneapolis, Minnesota',
  '2121 E Lake St',
  'Minneapolis',
  'MN',
  'United States',
  '55407'
);

INSERT INTO game_location (
  location_label, location_description, location_street_address_1, location_city,
  location_state_province, location_country, location_zip_postal
)
VALUES (
  'Southridge Sports Complex',
  'Sports complex in Kennewick, Washington',
  '2901 Southridge Blvd',
  'Kennewick',
  'WA',
  'United States',
  '99337'
);