# movieRecommender
Assignment 2 - Movie Recommender.
Name: Mozeeb Abdulha

Overview.
The objective of this assignment is to make a program that will parse in data from csv file and store it into an XML file.
The user should then be able to get access to the data to search for movies ect.


Functionality
. . . . . List of the functional features I implemented from the specification . . . .

Import data from MovieLens data set
Search for movies based on title
Provided a log in facility
Used a simple user interface (Cliche)
Did Unit testing of the code


Installation requirements
. . . . List of softw are, libraries and tools used . . . . . . .
Java JRE v1.8
Guava v18.0
cliche 110413
stdlib-package
xstream 1.4.10

Getting started

The project comes w ith data in CSV format that can be used to prime the application w ith initial data.
In the CLI, execute the prime command to import data from the CSV movie files:
The Cliche Movie Shell

Enter ?l to list available commands.
Movies> ?list
abbrev name params
li log-in (user name, password)
p prime ()
Movies> p
Movies>
Log in as the administrator user (moz)
Movies> li moz secret
You are logged in as moz
Admin
Movies/moz>



. . . . . Examples of program's user interface (e.g. CLI) (see example below ) . . . . . . .

Get top ten movies
Movies/Leonard> gttm
Movie{1, Toy Story (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Toy%20Story%20(1995), 3}
Movie{8, Babe (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Babe%20(1995), 3}
Movie{10, Richard III (1995), 22-Jan-1996, http://us.imdb.com/M/title-exact?Richard%20III%20(1995), 2}
Movie{3, Four Rooms (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Four%20Rooms%20(1995), 1}
Movie{6, Shanghai Triad (Yao a yao yao dao waipo qiao) (1995), 01-Jan-1995, http://us.imdb.com/Title?Yao+a+yao+yao+dao+waipo+qiao+(1995), 1}
Movie{7, Twelve Monkeys (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Twelve%20Monkeys%20(1995), 1}
Movie{2, GoldenEye (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?GoldenEye%20(1995), 0}
Movie{4, Get Shorty (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Get%20Shorty%20(1995), -1}
Movie{9, Dead Man Walking (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Dead%20Man%20Walking%20(1995), -2}
Movie{5, Copycat (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Copycat%20(1995), -3}
Getting movie recommendations for Gregory (test data):
Movies/Gregory> gur
Movie{10, Richard III (1995), 22-Jan-1996, http://us.imdb.com/M/title-exact?Richard%20III%20(1995), 2}
Movie{6, Shanghai Triad (Yao a yao yao dao waipo qiao) (1995), 01-Jan-1995, http://us.imdb.com/Title?Yao+a+yao+yao+dao+waipo+qiao+(1995), 1}
Movies/Gregory>
