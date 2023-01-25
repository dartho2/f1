# Introduction

We are asking you to start a small database holding information about historical Formula 1
results. For starters, all we need to know are the championship winners in the 21st century:
their name, their nationality and the team they won for. We start with 2001, when the
championship was won by Michael Schumacher from Germany, driving for Ferrari back then.
Yes, we need you to look up the rest of the champions on the internet, dating from 2002
to 2022.
# Your task
### Your task is to:
1. Design a normalized relational database structure that will be able to store the
   aforementioned information:
*  The champion’s name,
* The champion’s nationality,
*  The championship year,
* The team the champion won for the particular year.
2. Design a Java application using a framework of your choice (Spring / Quarkus / Helidon /
   plain JavaEE) that will expose the data stored in the database as a REST API. We expect
   the API to have at least two endpoints:
*  One for getting a map of how many championships were won by a particular driver
   for a particular team and how many in total.
*  One for getting a map of how many championships were won for a particular team
   by drivers from a particular country and how many in total.
   Example sanity check – in the 21st century, Michael Schumacher won the championship four
   times, on all occasions for Ferrari. Also, Mercedes drivers won 7 championships, 6 of which by
   a British driver and 1 by a German.

 
   The rest is entirely up to you, you may choose to deliver the project as simple or as
   complicated as you wish. You may choose any LTS Java version (8, 11, 17) and the
   corresponding language features. Use Hibernate, Liquibase, Flyway, Spring Security, Docker
   Compose or any other technology only if it helps you to achieve the goal easier or faster.
   Our final request is to use Maven for dependency management and project description - none
   of our reviewers is a particular Gradle fan

## Endpoint

|     |                     resource                     |                 description                  | description |
|:---:|:------------------------------------------------:|:--------------------------------------------:|:-----------:|
| GET |                    /champions                    |              ALL Champions List              |             |
| GET |                 /champions/{id}                  |               Champion by {id}               |             |
| GET |  /driver/ {driverId} /team/ {teamId} /champions  | Driver {driverId} wins for the team {teamId} |      *      |
| GET |         /driver/ {id_driver} /champions          |       List win for driver {id_driver}        |             |
| GET | /team/ {teamId} /country/ {countryId} /champions |    |
| GET |       /driver/ {driverId} /team/ {teamId}        ||

## DB relationship

![alt text](https://i.ibb.co/82ymWLw/2-Many-to-Many-2023-01-25-21-16.png)