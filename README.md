# Matrix Multiplier

A matrix multiplier with a sequential solution or a concurrent solution using threads.

### Prerequisites

You will need to install the modules below to run the program: 
* [java 8.0 or greater](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

### Running

There are two ways to run this software:

* Compile the IDE (Eclipse - Java IDE):
1. Just open the IDE
2. Import the project folder as a Java Project
3. After, in the top menu click:
```
Run -> Run Configuration -> Arguments
```
4. In Arguments, in the "Program arguments" section write, for example:
```
2 S
```
5. Click in the "Apply" button and then in the "Run" button.
6. From this it only interacts with the system.

* Compile by terminal:
1. Enter the src folder and compile all the .java files with the following command:
```
$ java * .java -d <target_address_name>
```
2. Enter the chosen destination directory and run the following command:
```
$ java main.Main 2 S
```
3. From this it only interacts with the system.

Note that the integer followed by the program name represents the of the square matrices that will be handled by the program and the later characters, being S or C, respectively indicate that the sequential solution or the concurrent solution will be used. The program works as follows, in the Main class, will be called the Reader class, which will read the files contained in the project input folder in the form Aixi.txt and Bixi.txt, which hold the arrays used in the multiplication, both will be read and placed in data structures in the program. Soon after, the SequentialMultiplier or ConcurrentMultiplier will be created, depending on the character passed as parameter in the program. If it is "S", the SequentialMultiplier will be created, which will the sequentially multiply the resulting matrix elements given the two input matrices. If it is "C", the ConcurrentMultiplier will be created, which will compute the resulting matrix elements given the two input arrays, threads of the Thread subclass, named ThreadElement, will be executed simultaneously, where each one will be responsible for calculating a row of the resulting matrix. Finally, the Write class will be called, which will write the resulting matrix to the form file Cixi.txt in the output folder of the project and soon after, it will be called the Calculator class, to show the worst and the best, the mean and the standard deviation of the executed measurements, thus, ending its execution.

## Built With

* [Eclipse](https://www.eclipse.org/) - A IDE used

## Authors
### Developers: 
* **Luís Eduardo Anunciado Silva ([cruxiu@ufrn.edu.br](mailto:cruxiu@ufrn.edu.br))** 
* **Erick de Oliveira Silva ([erickos@ufrn.edu.br](mailto:erickos@ufrn.edu.br))** 
### Project Advisor: 
* **Everton Ranielly de Sousa Cavalcante ([everton@dimap.ufrn.br](mailto:everton@dimap.ufrn.br))** 

See also the list of [contributors](https://github.com/cruxiu/DIM0612-MatrixMultiplier/contributors) who participated in this project.

## License

This project is licensed under the GPL 3.0 - see the [LICENSE](LICENSE) file for details

