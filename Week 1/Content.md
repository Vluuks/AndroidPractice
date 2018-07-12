# Java Basics for Android
In this course, we will use Java to create our Android apps, so the first part of each week will focus on explaining Java concepts to you. Additionally, these concepts will be related to actual "Android" code, showing you how these plain Java concepts are relevant all throughout your app! This will be done using written text and mini exercises.

## Classes
Java is a programming language that makes use of classes. A class is similar to a `struct` in C, but instead of just holding data, they can hold code that can be run as well. The data inside a Java class are commonly called *properties*, whereas the code that can be executed inside the class is called a *method*. Below is a very simple example of a Java class, which depicts a student.

        class Student {

            // Properties of the class
            private String name;
            private String program;
            private int studentNumber; 

            // Constructor of the class
            public Student(String aName, String aProgram, int aStudentNumber) {
                name = aName;
                program = aProgram;
                studentNumber = aStudentNumber;
            }

            // Method of the class
            public void printInfo() {
                System.out.println("This student is called " + name);
                System.out.println("they are studying " + program);
                System.out.println("and their student number is " + studentNumber);
            }
        }

As you can see this class does not just hold data (like the name, program and student number), it contains runnable code as well, in the form of the method `printInfo()`. When called, this method will print information about the student to the console.

Another important part of the class is the *constructor*. In Java, in order to use classes like the `Student` class, they need to be instantiated before they can be used. The `Student` class can be seen as a blueprint. It exists, but before we can use the properties or methods inside, we first need to create an *instance* of the class. The constructor is used to do so. Often the constructor is used to set the properties of the class to meaningful values, in this case we want to set the values of the name, the program the student is attending and the student number. The constructor of the class is made with this in mind, allowing us to insert these values.

Suppose we wanted to create a new student object for the student Ada Lovelace and store it in the variable `al`:

        Student al = new Student("Ada Lovelace", "Computer Science", 61283);

Now, the variable `al` contains the values we initialized it with, because inside the constructor method, the values are stored in the properties of the student object. If we wanted to initialize another student as well, we can of course do so! 

        Student ik = new Student("Immanuel Kant", "Philosophy", 81148);

The variables `al` and `ik` can be seen as references to the respective objects. They each use the `Student` blueprint, but the contents of the properties are different. 

## Practice
You can try this out by grabbing the following file [LINK NAAR BESTAND]. It contains the code we have seen this far, though the strucure in which we present it in order to be able to run it is slightly different. 

Note that in regular Java, the point of entry of the program is the `main` method (just like we are used to in C!). The main method needs to be contained in a class as well, which we have called `StudentTest`. From this main method, we can access the `Student` class and create instances of it, as well as invoke the methods contained within the student class (more on that later).







