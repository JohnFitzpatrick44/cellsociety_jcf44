# cellsociety

CompSci 308 Cell Society Project

Authors: Jack Fitzpatrick, Hemanth Yakkali, Ryan Fu
Date: 2/5/18

## Roles
### Jack Fitzpatrick
General back-end classes. Mainly worked on the cellTypes package, with the various Cell, CellMover, and Cell simulation classes and related interfaces. Worked to implement them with Grid. 
### Hemanth Yakkali

### Ryan Fu

## Resources Used During Development
The reading on inheritance (Mercer's Object-Oriented Software Development: Chapter 16, Inheritance and Polymorphism) was very useful during the development of this code, and helped us to split the code into multiple subclasses to aid the development process, and increase readability.

## Included Files, Data, and Resources
 * The Main.java class used to run the program can be found in the View package, along with MainView.java, which facilitates the running of the application.
 * The XML package contains the classes used to read and parse through the XML files that contain the simulation's variables and initial states. The files it processes are in the data directory.
 * Different language options for the GUI are found in the Resources package.
 * The buttons package contains the elements of the GUI that the user can interact with.
 * The gridTypes package contain the abstract Grid, as well as simulation specific grids, to create a layout for the cells.
 * The cellTypes package contain the abstract Cell class, as well as simulation specific Cells, which update their state in different ways, depending on the simulation. Cells control their own color based on their states.
 * XML files must contain a valid simulation name, as well as relevant simulation variables. The included XML files show the correct format.
 
## Functionality and Extra Features
 * The user is able to start, stop, step through, and jump a certain number of frames in a given simulation. 
 * The user can reset the current simulation, or change to a different one with a drop down menu.
 * The user can change the state of specific cells by left or right clicking on them, to increase or decrease their states, respectively.

## Assumptions
 * It is assumed that input XML files will be formatted correctly, and contain a valid simulation.
 * It is assumed that a moving cell (such as in segregation or predator) may occupy an empty space left by another moving cell, that left that spot in the same step.

## Possible Improvements
 * Adding initial state configurations in XML
 * Refactoring Cell simulation code to take advantage of CellMover more
 * Passing in constants to Cell classes from XML variables
 * Handling different window sizes dynamically