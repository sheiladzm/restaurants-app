# restaurants-app

This is a web application that displays a list of food trucks/restaurants in San Francisco. It is built with Java and Vue with PostgreSQL for the database. Users are able to add restaurants to the current list, click on restaurant to view details such as name, addres, and food types, and can view the addresses by restaurant.

I used Spring JDBC for the backend and integrated with a 3rd party RESTful API to make HTTP requests to the server. 

An example of OOP can be found in my use of Interfaces to create complete abstraction of methods that retrieve/manipulate data in the database. Many other examples can be found throughout the backend Java application.

<h3>Key points of the app's user flow, views, components, and my thought process:</h3>

I decided to focus on two tables for my database (Restaurants and Addresses) and designed my Java classes, views, and components in Vue with that initial organization in mind.

I used the MVC design pattern and commented on important sections such as methods to communicate/explain code to make it easy for other developers to read/understand my code and make it easy to maintain in the long-term. 

<h4>Views and Components in Vue:</h4>

Display View with DisplayRestaurants Component: Lists all restaurants in alphabetical order and can click on View Details to see more data such as locations of the restaurant, food types, and schedule for each location.

![Screen Shot 2022-05-11 at 8 16 53 AM](https://user-images.githubusercontent.com/101483745/167886395-6722f657-18b3-4be3-a372-3abcad48ed68.png)

Example of Detail View with RestaurantDetail component: Lists all locations for a specific restaurant and its corresponding details.

![Screen Shot 2022-05-11 at 8 16 27 AM](https://user-images.githubusercontent.com/101483745/167886420-548459f6-bfd0-467a-802d-6a34e607ab0a.png)

Form inside AddRestaurant component to add a new restaurant to the database.

![Screen Shot 2022-05-11 at 8 17 28 AM](https://user-images.githubusercontent.com/101483745/167886693-da199724-c8e4-4b2b-b552-aa133d8659db.png)

Form inside AddAddress component to add a new location to an existing restaurant in the database.

![Screen Shot 2022-05-11 at 8 17 51 AM](https://user-images.githubusercontent.com/101483745/167886731-f99bcf21-d0ed-46c4-a21a-4b36066bddae.png)

I chose a one to many relationship to describe the relationship between restaurants and addresses as each restaurant had one or more locations.

<img width="685" alt="R-App_ERD" src="https://user-images.githubusercontent.com/101483745/167368479-a271a18e-30f7-4b7c-8048-7d5a26cd876c.png">

Since there was only a short amount of time to complete this project, I decided on less views and components while still being able to sort the data and make it accessible for users with a simple UI.

![R-App Rough Wireframe](https://user-images.githubusercontent.com/101483745/167884880-0cc323b4-6b44-4255-a776-50c6d6a7b892.jpg)

<h3>Tips on running the application:</h3>

- Open the restaurants_app_java folder in IntelliJ IDEA CE and find the file RestaurantsAppApplication.java to run the server.

- Open the restaurants_app_vue folder in VSCode, type "npm install" on the command line, and "npm run serve" to view the webapp via a localhost URL

- You may have to refresh the display restaurant detail page a few times in order to see the locations and details on that page.

<h3>Future Iterations and Practices to Improve:</h3>

- Add pagination

- View schedule as a short link instead of full URL

- Increase number of commits

- Add a homepage

- Add a search bar with filter functionalities 
