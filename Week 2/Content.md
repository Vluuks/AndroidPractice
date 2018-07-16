# Java Basics for Android
In this course, we will use the programming language Java to create our Android apps, so the first part of each week will focus on explaining Java concepts to you.  Additionally, these concepts will be related to actual "Android" code, showing you how these plain Java concepts are relevant all throughout your app! This will be done using written text and mini exercises.

## Table of contents
- [Concepts](#concepts)
    * [Access](#classes)
    * [Static Variables](#constructor)
    * [Enums](#parameters)
- [Practice](#practice)
	* [Getting started](#getting-started)
	* [Exercises](#exercises)
- [Plain Java vs. Android Studio](#java-vs-android)
    * [Classes](#android-classes)
    * [Parameters and return values](#android-params)

<a name="concepts"></a>

## Concepts

<a name="access"></a>

### Access 
This week we will focus on the different access rights that methods and variables can have in Java. This will matter once the scope of your apps gets bigger and you work with more different activities and model classes. Sometimes you don’t want certain variables from a class to be accessed outside it, for example.

You might have noticed that many of the variables and methods used in your code have a keyword such as `private`, `public` or `protected`. This has to do with the location from which these variables and methods can be accessed.

- `private` access restricts the access of a variable or method to within that class. 

- `public` is quite the opposite, allowing access from outside the class, as well as from other [packages](https://docs.oracle.com/javase/tutorial/java/concepts/package.html). This is the least restrictive access modifier. Basically, the variable or method is usable all throughout your app.

- `protected` is a term we often see in Android Studio as well, it refers to a more toned down version of `public`. This modifier allows for access from within a package and subclasses that are located in other packages, but not for access from unrelated classes in other packages. 

- If you omit the access keyword, the variable or method is accessible within its own package only. Subclasses in other packages do not get access, as opposed to the `protected` keyword.

In general, it is good practice to keep the access of your variables and methods as limited as possible, ensuring that only the parts of the program that really *need* access are getting it. 

Most of the time we will make use of `private` and `public` for the classes and variables we construct ourselves, as during this course we do not make a lot of use of different packages, since the apps are rather small.

### Getters and setters

Consider the `Student` class once again, with some adjustments:

        class Student {

            // Properties of the class
            public String name;
            public String program;
            public int studentNumber;
            public int EC;

            // Constructor of the class
            public Student(String aName, String aProgram, int aStudentNumber, int someEC) {
                name = aName;
                program = aProgram;
                studentNumber = aStudentNumber;
                EC = someEC;
            }
        }

Often when a class has private properties that does not mean they should never be accessed at all. Most of the time this is done through getter and setter methods. This is also called *encapsulation*.

A benefit of encapsulation is that instead of allowing someone to edit properties of an object using the dot operator, this must be done through a set method. This method takes as an argument the new value to be set, but can of course also check whether this value makes sense at all. 

A good example could be the EC property. In this case its access is public so that means we can access it through the dot operator. Imagine we want to adjust the EC for the student object `s`. Using the dot operator we might do something like this:

        s.EC = 40;

However, nothing really stops us from supplying a bogus value, like `-30` or some other integer that does not make sense. This is the case for many other properties classes could have, even for something as simple as a `Student` class!

Instead of having the `EC` property be public, we could set it to `private` instead.By doing this, it can only be accessed from within the class, thus we are required to call the `setEC()` method if we want to modify it. This method does not just adjust the EC, but also verify that the number makes sense and act appropriately. In this case we check if it's above zero and only then set the new value, otherwise we keep it at zero. 

    class Student {

        // Properties of the class
        private String name;
        private String program;
        private int studentNumber;
        private int EC;

        // Constructor of the class
        public Student(String aName, String aProgram, int aStudentNumber, int someEC) {
            name = aName;
            program = aProgram;
            studentNumber = aStudentNumber;
            EC = someEC;
        }

        public void setEC(int someEC) {
            if(someEC > 0) {
                EC = someEC;
            }
            else {
                EC = 0;
            }
        }

        public int getEC() {
            return EC;
        }
    }

The point is that through this method, the handling of the EC property is much more foolproof. It is managed through its respective getter and setter methods. By keeping the access inside the class, you have much more control over which values should be adjustable from outside the class and which ones shouldn't.

Of course, to be able to get and set all of the other properties of the `Student` class now that their access is also set to `private`, extra getter and setter methods would have to be added.


<a name="practice"></a>

## Practice
Grab the following file [LINK NAAR FILE]. This time we will not practice in the IDE but instead practice with the different access methods in Android Studio itself. The file contains a familiar class depicting a student. Open up a new Android Studio project, and copy the file from your downloads directory into your main package folder located under `app > java > com.example.yourname.yourappname` so that it is alongside your `MainActivity.java` file:

![An image depicting the file tree as shown in Android Studio, with the package folder highlighted](paste-location.png)

> The IDE allows for different depictions of the files representing your app. If yours does look different, try switching the mode to 'Android' instead by using the dropdown in the top left corner.

We will use this file to try out and play with the various access rights of variables, methods and the class itself. 

<a name="exercises"></a>

### Exercises

1) Create the getters and setters for the other properties in the `Student` class.

2) You can imagine that for EC it might not be the most useful to set the value every time. A method that increments them makes way more sense. Add a method to your Student class that increments a student's current EC by a given amount. Does this interfere with the getters and setters, why (not)?

3) 

<a name="tips"></a>

### Tips

To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName

If you have trouble getting your Java programs to run in the IDE, run `update50`. If that does not work try:

        sudo apt-get update
        sudo apt-get install default-jdk

<a name="java-vs-android"></a>

## Plain Java vs Android Studio