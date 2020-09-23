# Project Name
- Wildlife Tracker

## About the Project
- The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir. 
- Before this proposal may be approved, they must complete an environmental impact study. 
- This application allows Rangers to track wildlife sightings in the area.
- The application tracks two categories of wildlife: endangered species and non-endangered.

## Live Link
https://innocentwildlifetracker.herokuapp.com/

## Setup Instructions
- Fork from https://github.com/George-Okumu/Wildlife-Tracker
- Git clone

## Database Set-Up Instructions
   -This is project uses Postgres to store its data, 
   -You will be required to create two databases, by running this command in your psql terminal:
   1.  <em>the wildlife_tracker</em>  which is the development database
   2. wildlife_tracker_test which is the test Database
   
  - `CREATE DATABASE wildlife_tracker`
  - `CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker`
 3. You should also have two table names
 - `CREATE TABLE animals (id serial PRIMARY KEY, animalName varchar, animalId int, type)`
 - `CREATE TABLE sightings (id serial PRIMARY KEY, rangerName varchar, location varchar)`
 
 ## 
 
 ## Technologies used
 1. Gradle
 2. Maven dependencies
 3. Java spark framework
 4. CSS and Bootstrap
 5. PostgreSql
 
 ## Licence
 - MIT copyright @georgeOkumu-Wildlife.com
    


