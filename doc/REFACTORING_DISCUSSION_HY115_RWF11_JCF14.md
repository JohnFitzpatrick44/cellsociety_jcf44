##Refactoring

### Duplication Refactoring

There was some duplicated code in each of the grid classes and it was fixed by simply adding an input to createGrid() and also realizing that two of the private variables will always have the same value as two of the inputs within createGrid() and so these private variables were removed. 

### Checklist Refactoring

The largest issue was with modulation because we have a class called DataHolder that holds a bunch of public static variables that are used everywhere else in the project. We fixed this huge issue by first making all the variables private and then creating a setter and getter method for each of the variables. We then realized that modulation went even lower because DataHolder has too many methods. So we created four big setter methods that would set a group of variables to their proper values at once. We considered using Java Reflections to get a group of variables at once but we decided to make the getter methods first before moving onto more advanced stuff. We will take the time to refactor this class better in the near future. 

Another area where we need more work is Flexibility. Currently, the setNeighbors methods in Grid are the primary cause for this issue because the cyclometric complexity is too high. One way to fix this is to set neighbors while the grid is being created and to make smaller methods that set diagonal neighbors and one for cardinal neighbors. 

### General Refactoring

We had a lot of errors in Code Smells and Java Notes so we added package.infos to each of the packages to reduce some of the Java Notes errors. We also ran CMD+I on some of the classes so that everything is indented properly. However, this Code Smells section seems to be a bit buggy because in some of the errors it mentions, the line that it refers to is actually in the right spot but the program detects it as being in the "wrong" spot. Some other general errors was naming conventions and making sure that final variables are all uppercase and that any non-final variables are in camel case. 




