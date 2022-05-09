--list restaurant names in alphabetical order and their address names

select restaurants.name, addresses.name
from addresses
left join restaurants on restaurants.restaurant_id = addresses.restaurant_id
group by restaurants.name, addresses.name
order by restaurants.name;

--list restaurant names in alphabetical order and their number of locations

select restaurants.name, count(*) as num_of_locations
from restaurants
left join addresses on addresses.restaurant_id = restaurants.restaurant_id
group by restaurants.name
order by restaurants.name;

--list restaurant names in alphabetical order

select * from restaurants
order by name;

--list address names in alphabetical order and each restaurant's name in that address

select addresses.name, restaurants.name
from addresses
left join restaurants on restaurants.restaurant_id = addresses.restaurant_id
group by addresses.name, restaurants.name
order by addresses.name;

--list address names in order, food types, schedule, and matching restaurant name

select addresses.name, addresses.food_types, addresses.schedule, restaurants.name
from addresses
full join restaurants on restaurants.restaurant_id = addresses.restaurant_id
order by addresses.name;

--list restaurant names in order, address names, food types, schedule

select restaurants.name, addresses.name, addresses.food_types, addresses.schedule
from addresses
full join restaurants on restaurants.restaurant_id = addresses.restaurant_id
order by restaurants.name;