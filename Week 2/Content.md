# Java Basics for Android
In this course, we will use the programming language Java to create our Android apps, so the first part of each week will focus on explaining Java concepts to you.  Additionally, these concepts will be related to actual "Android" code, showing you how these plain Java concepts are relevant all throughout your app! This will be done using written text and mini exercises.

## Table of contents
- [Concepts](#concepts)
	 * [Access](#access)
	 * [Getters and setters](#getters-setters)
	 * [Static vs. non-static](#static)
	 * [Constants](#constants)
	 * [Enums](#enums)
	 * [Wrapping it up](#wrapup)
- [Practice](#practice)
	 * [Exercises](#exercises)
- [Plain Java vs Android Studio](#java-vs-android)


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

<a name="getters-setters"></a>

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

<a name="static"></a>

### Static vs. non-static
Another modifier that can be added to the declaration of a method or variable is the `static` keyword. This modifier also has to do with access, but has to do with whether a class is instantiated or not. 

In our `Student` class, we have different variables that represent properties of a student, these are called instance variables (`name`, `program`, `studentNumber`, `EC`). They differ across instances of the Student object, as every time we create a new one, we supply new values for these variables to the constructor. These variables are unique for every instance of the class, as it makes sense that not all students have the same name, student number etc. The class says: all students have a name, but the instance says: "This specific student's name is Ada Lovelace".

In some cases it is beneficial to have another variable that is not unique for every instance, but instead applies to all instances of the class. Imagine we want to keep track of how many students there are in total. It would not make sense to keep a unique copy of that number for every student object we create, because that would be a waste of memory. Instead, we want one variable that can keep track of this count. To do this, we use a `static` variable that is common to all instances of the class.

        class Student {

            static int studentCount;

            // Properties of the class
            private String name;
            private String program;
            private int studentNumber;
            private int EC;

            ...

        }

Now that we have this variable, we of course also want to do something with it. Let's say we use this (admittedly inefficient) way of updating the student count every time we create a new student object:

        Student al = new Student("Ada Lovelace", "Computer Science", 61283, 180);
        al.studentCount = 1;
        
        Student ik = new Student("Immanuel Kant", "Philosophy", 81148, 180);
        ik.studentCount = 2;
        
        Student ja = new Student("Jeanne d'Arc", "History", 90382, 40);
        ja.studentCount = 3;


If we were to print the value of `al.studentCount` after running all of this, it would say 3. This is because `studentCount` is a static variable and thus even though we refer to it using the specific `Student` references, it is updated for the class as a whole! 

The counter works as intended, keeping track of the number for all instances of the class. In the example above, we used the instances `al`, `ik` and `ja` to refer to the static variable, which looks confusing because it seems as if we are updating values for every instance, rather than an overarching value that applies to the class as a whole. 

Because the variable `studentCount` is `static`, we can also access through the `Student` class itself, without needing an instance. This makes it clear at one glance that the studentCount variable is overarching all instances and is generally the advised notation.

        Student.studentCount = 2;

You can [compile and run this snippet](http://bit.ly/2NiBDdZ) to see the above in action. Feel free to play around with it a bit. 

<a name="constants"></a>

### Constants
Let's say you want to use variables that really do not have to change at all during the runtime of your program. For this, we can use a constant. A constant in Java is denoted using the keyword `final`. If we were for example to define the name of the university as a constant within the student class, it would look like this:

    final String UNIVERSITY_NAME = "University of Amsterdam";

It is customary to use uppercase letters and underscores for the names of your constants, a concept you might be familiar with from C's `#define` functionality.

Now, the `UNIVERSITY_NAME` string is immutable. This means that any attempts to alter it at runtime will make the compiler complain. You can try this out in [the following snippet](http://bit.ly/2NXgGGO). 

Notice how in the snippet linked above, `UNIVERSITY_NAME` is both `static` and `final` in this example? This means that even though it's immutable, we still want it to be accessible without having to instantiate any students, because we assume the university is the same for all of them.

<a name="enums"></a>

### Enums
Sometimes you have a program that requires multiple constants. Let's say you need to define a set of shapes. You could of course define them using the `final` keyword:

        public static final int RECTANGLE = 0;
        public static final int CIRCLE = 1;
        public static final int TRIANGLE = 2;
        public static final int SQUARE = 3;

While it does the job, it is not the best solution. Because the constants are integers, nothing stops us from assigning another integer that does not represent a shape:

This is valid:

        int shapeToShow = TRIANGLE;

But this, although illogical, is not illegal and will compile:

        int shapeToShow = -22;

To solve this problem (among other things) we can use the `enum` feature of Java. Defining an `enum` is somewhat similar to defining a class. You will have to determine the access modifier, a name for your Enum and of course the possible values that it can take. If we were to translate the constants from earlier into an enum, it would look like this:

        public enum Shape { 
            RECTANGLE, CIRCLE, TRIANGLE, SQUARE
        }

Now that the options are contained within the `enum`, we can use it to declare and modify variables. The main difference is that now we can only assign values that are part of the `Shape` `enum`. 

        Shape shapeToShow = Shape.TRIANGLE;

Using `enum` has other benefits as well. Because all values are contained within `Shape`, it's much easier to iterate over them. They can also easily be incorporated into a `Switch` statement, which executes different code depending on the value of the variable supplied. You can see this in action in [this snippet](http://bit.ly/2JuN9R2).

        switch(shapeToShow) {
            case RECTANGLE: System.out.println("It's a rectangle!");     
                            break;
            case CIRCLE:    System.out.println("It's a circle!");
                            break;
            case TRIANGLE:  System.out.println("It's a triangle!");
                            break;
            case SQUARE:    System.out.println("It's a square!");
                            break;
        }

<a name="wrapup"></a>

### Wrapping it up
We have seen three types of modifiers related to the way variables are accessed. Each of these concepts came with its own keywords.

- The location from which classes, variables or methods can be accessed it determined through the absence of a keyword, `public`, `protected` or `private`. 

- Determining whether a variable is an instance variable or belongs to the class as a whole is done using the `static` keyword.

- Denoting a constant is done using the `final` keyword, which makes the variable immutable and comes with its own naming conventions.  

 These three can be combined to fit your specific needs. This for example, is valid syntax:

        public static final String UNIVERSITY_NAME = "University of Amsterdam";

We also saw that to define multiple constants, the `enum` is an elegant solution that helps avoid wrong assignments, simplifies iteration of the possible values and is easy to use inside a `Switch` statement. 

<a name="practice"></a>

## Practice
Grab the following file [LINK NAAR BESTAND]. It contains the Student class once again, in addition to the `getEC` and `setEC` methods. You can add the file to your CS50 IDE. If you are not sure anymore how to set this up, refer to the practice section of [Week 1](SOME URL TODO). 

To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName

If you have trouble getting your Java programs to run in the IDE, run `update50`. If that does not work try:

        sudo apt-get update
        sudo apt-get install default-jdk

<a name="exercises"></a>

### Exercises

1) Create the getters and setters for the other properties in the `Student` class.

2) You can imagine that for EC it might not be the most useful to set the value every time. A method that increments them makes way more sense. Add a method to your Student class that increments a student's current EC by a given amount. Does this interfere with the getters and setters, why (not)?

3) Implement a counter that keeps track of how many student objects have been instantiated, but without incrementing it manually like in the *Static vs. non-static* section! 

4) Set the access of the count variable to `private` and define a method that returns the count of students. Bear in mind we want this method to be accessible even when we do not have an instance of a `Student` present. 

5) Implement an `enum` that represents the various levels that exist: bachelor, master, PhD or some other set of constants you feel is appropriate to represent in an `enum`. 

5) Add a method to the `Student` class that uses the `Switch` statement to print something to the terminal.

<a name="java-vs-android"></a>

## Plain Java vs Android Studio
All above concepts are applicable in Android Studio as well. Most auto-generated classes and methods have some kind of access modifier specified. A specific error related to this that you might see in Android studio is:

"Non-static method cannot be referenced from a static context"

This means that you are probably invoking a method as if it were a static method, but it is actually an instance method instead! This is clearly illustrated by the following example that would invoke this error:

    TextView.setText("nice");

While `setText()` can indeed be called on objects of the type `TextView`, the above line of code does not refer to an instance of `TextView`, but rather to the class as a whole. It does not know what `TextView` in the layout you are referring to at all.

Another things that you need to pay attention to is the location of your files. When working with your own classes in Android, it's important that you place them in the same package as the rest of your code for ease of access. Your Java files will be contained in the directory located under `app > java > com.example.yourname.yourappname`. This is where your `Activity` Java files are located, but model classes like `Student` can be placed here as well! This directory is also visible in Android studio in the menu on the left:

![An image depicting the file tree as shown in Android Studio, with the package folder highlighted](paste-location.png)

The IDE allows for different depictions of the files representing your app. If yours does look different, try switching the mode to 'Android' instead by using the dropdown in the top left corner as shown in the image above. 

When right clicking this directory, you can easily create a new Java class, which after allows you to to select `enum` in a dropdown as well. For activities however, it's best to go with `New > Activity > Empty Activity` since this also generates the required layout files and standard methods for you. 

