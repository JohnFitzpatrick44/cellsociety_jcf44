#Inheritance Review Questions
## By hy115, jbl34, dpb20

### Part 1
1. An implementation decision that this design is encapsulating is that the Cell classes get their individual neighbor states and the Grid class accesses these neighbor states. In this way, the individual cell neighbor states are hidden from the Grid class. 

2. Intending to build an abstract class for Simulation and one for Cell since there are different types of simulations each with their own set of rules and there are different types of cells. 

3. Getting and updating cell states are open because both Grid and Cell access these methods. Setting cell color, size, and width are closed to that class only. 

4. Primary exception that might occur is when edge and corner cells check for their neighbors since they will have sides that do not contain any cells at all. We need to make sure that these edge cases are taken care of and handled. There should also be error handling that will take care of an edge case that hasn't been handled yet. 

5. Having abstract classes reduces the amount of code that needs to be written and also provides a lot of flexibility if additional classes of that type need to be added. Having interfaces also provides more flexibility and safeguards against code changing too much. 

### Part 2
1. Grid class is linked to Cell class and the user interface that will display the grid of cells. The Grid class is also linked to the Simulation class which will provide the rules for a certain simulation that is being run.  

2. No these dependencies are not based on the other class's behavior but rather just gets data from certain classes and uses that data to perform a specific action. 

3. Can reduce dependencies by reducing the amount of information that has to pass between classes. Another way is to encapsulate as much into certain classes as possible so that there is little redundancy.

### Part 3
1. Create the grid of cells. Run the simulation. Update cell states. Go forward a certain number of frames. Choose a certain simulation. 

2. I am most excited to work on creating the main simulation controller because it requires the use of many different classes. It also works with the front and backend and I believe that by working on this, I will gain a lot of valuable experience with Java. I am also excited to work with interfaces and abstract classes. 

3. I am least excited to work on the Grid class because it is performs simple functions and I don't expect it to take very long. Furthermore, I have to rely on the Cell classes to be completed before I can fully test the Grid functionality so there is a chance this will be put off towards the end. 

