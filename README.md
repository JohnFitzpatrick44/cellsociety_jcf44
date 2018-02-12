CompSci 308 Cell Society Project

Authors: Jack Fitzpatrick, Hemanth Yakkali, Ryan Fu
Start Date: 1/26/18
End Date: 2/12/18

## Roles
### Jack Fitzpatrick
General back-end classes. Mainly worked on the cellTypes package, with the various Cell, CellMover, and Cell simulation classes and related interfaces. Worked to implement them with Grid. 

### Hemanth Yakkali
Worked on creating grids, set up framework for project in Main and MainView classes. Worked with Jack on cells and their simulations. Coordinated with Ryan to ensure backend and frontend work together.

### Ryan Fu
General front-end design. Worked on creating an XML reader that takes in a file and handles exceptions. In addition, created multiple button classes with different functionalities that extended an abstract ActionButton class. All of these buttons were used to develop the user interface including features such as file upload, animation speed, pause, play, reset, and overall aesthetics of the program. Also worked on error-checking for the XML Reader and the dynamic chart design.

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
 * The user can click the FILE button to upload an XML file to create a personalized simulation.
 * The user can switch shapes between triangle and rectangle
 * The user can switch between finite and toroidal neighbors
 * The user can click the CHART button to make a window appear depicting a dynamic line chart that shows the number of cells for each cell type.
 * A slider can be used to increase the speed of the animation of both the simulation and the dynamic chart
 
## Error Checking
 * The file upload button ensures that only XML files can be uploaded directly to the program. Programs without the XML extension
 	will not be uploaded. 
 * The XML Reader checks to make sure that every parameter for a simulation is labeled correctly with an appropriate value. If there is 
 	a mistake, missing value, or incorrect data type, the program will automatically upload a working DEFAULT simulation for the program 		to run.
 * If an unknown simulation type is uploaded, the program will simply print out "Wrong Simulation" to inform the user that the simulation 		type is not available. 

## Assumptions
 * It is assumed that a moving cell (such as in segregation or predator) may occupy an empty space left by another moving cell, that left that spot in the same step.

## Possible Improvements
 * Handling different window sizes dynamically
 * Improve design of grids so that adding a new simulation does not require the creation of two new classes
 * Charting could be more reliable, accurate, and more clear as to what information is being presented