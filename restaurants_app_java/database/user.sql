-- ********************************************************************************
-- Creates the database users and grants necessary permissions
-- ********************************************************************************

CREATE USER restaurant_appowner
WITH PASSWORD 'amazonrestaurants';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO restaurant_appowner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO restaurant_appowner;

CREATE USER restaurant_appuser
WITH PASSWORD 'restaurants';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO restaurant_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO restaurant_appuser;
