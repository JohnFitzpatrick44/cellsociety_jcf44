Part 1:

1. The implementation decision for my design is to utilize an interface and specifying abstract methods that can be implemented when creating new objects. 

2. The inheritance hierarchy could have a abstract xmlParser with specific simulation classes that inherit the behaviors of the xmlParser class. Based on the type of simulation that is need to run, the program will call on subclasses that inherit the xmlParser class in order to create these separate class simulation files. 

3. The xmlParser will be closed for modification and only the subclasses that inherit xmlParser will have an open module so that additional and unique features can be added based on each simulation.

4. 	Nullpointerexception in case files don’t have enough arguments to fully run the simulation
	IllegalArgumentexception in case the file is not the correct input for the xmlParser
	
5. I think my design is good because it has a clear strategy, using the interface and inheritance design strategy to clearly outline how each class interacts with each other. This will help make the code more flexible especially when a variety of simulations are added with unique features and extend the xmlParser class.

Part 2:
1. In my visualizer class, I will need to work with the cell class to correctly display the right number of cells in the grid. This visualizer class is reliant on the cell class to make the right calculations when determining the number of neighbors that need to be displayed on the grid. 
2. These dependences are based on the other class’s behavior because each object of the Cell class has information on its neighbors which is consistently updated. 
3. I believe that this is the minimized number of dependencies. The visualizer relies on the cell class to obtain the information for what cells to display. This is an essential for allowing the program to run.
4. One pair is the xmlParser superclass and the spreadingFire subclass. The spreadingFire extends the xmlParser and obtains data and features specific to the spreadingFire simulation. Other simulations will also extend xmlParser, but using this inheritance design will allow the program to be more flexibly when more simulations are added.


Part 3:
1.  	*User choosing a file from simulation
	*Using the reset button and jump button to reset the grid and jump to a future frame
	*User changing simulations from (example) spreadingFire to game of Life
	*Stopping animation and playing animation
	*Parsing the file correctly

2. XML Parser design

3. Connecting all the classes and utilizing the interface/inheritance design. 
