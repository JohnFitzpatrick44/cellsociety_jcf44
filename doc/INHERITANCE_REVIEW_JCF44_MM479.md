# Inheritance Review
Jack Fitzpatrick and Maya Messinger
2/1/18

## Jack's Design
### Part 1
 - My design for the cells is hiding its internal state logic from the rest of the program. Each cell decides how it will react to its neighbors. Its state is visible, but how it determines that state is not. Additionally, setting its color is also hidden.
 - Cell extends rectangle, so that it can be placed and moved in the simulation. Additionally, Cell tracks its neighbors and can read their states, so Grid can tell it when to store neighbor states, and when to update. Specific simulation cells have logic based on their respective simulation, which is activated by the update state command. They also update their colors when they update state.
 - The open part of my code is the ability to add simulation specific Cells, but the Cell class itself is closed off from Grid
 - Exceptions - 
 - My design is good because it's very easy to make a new cell class, and interfaces keep those classes closed and somewhat private, encapsulation.

### Part 2
 - Only one link through an interface to Grid
 - Behavioral dependencies
 - Use interfaces to limit interaction, only allow Grid access over positioning and telling cell when to update

## Maya's Design
### Part 1
 - One Cell class, multiple simulations
 - Simulation class does state logic, passes states to grid
 - Cell just contains a color
 - Simulation class is closed, subclasses contain logic, have hashmaps with integer/color combos
 - Simulation subclasses, cell subclasses are easy to add, open
 - Simulation is one overseeing body, easy to make new ones, good use of smart/dumb classes
 
### Part 2
 - Simulation calls grid, grid places cells, viewer makes grid visuals
 - Implementation dependency with simulation, all else behavioral
 - Cut down parameters being passed between classes
 - Neighborhood scheme could be improved, included within Cell