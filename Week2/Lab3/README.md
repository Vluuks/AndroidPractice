# Java Basics for Android
 <img align="left" src="https://raw.githubusercontent.com/Vluuks/AndroidPractice/labified/Week2/Lab3/robotje.png" style="padding: 10px"> This week we focus on concepts that have to do with the way classes, variables and methods are accessed and modified. As the scope of your application gets bigger, not everything needs to be reachable from all points in the app. This week we will focus on the different access rights that methods and variables can have in Java. This will matter once the scope of your apps gets bigger and you work with more different activities and model classes. Sometimes you don’t want certain variables from a class to be accessed outside it, for example.
 
 A good understanding of what can be accessed or modified helps you keep control over all your program's components. We will also pay attention to what is good practice in regards to structuring your variables and how to incorporate them in control structures.
<br>
<br>
<br> 

## Table of Contents
This week's practice content consists of the following parts:

- Access
- Getters and setters
- Static vs. non-static
- Constants
- Enums
<br>
<br>
<br>

{% next "Next: access" %}
&nbsp;
<a name="access"></a>

### Access 
You might have noticed that many of the variables and methods used in your code have a keyword such as `private`, `public` or `protected`. This has to do with the location from which these variables and methods can be accessed.

- `private` access restricts the access of a variable or method to within that class. 

- `public` is quite the opposite, allowing access from outside the class, as well as from other [packages](https://docs.oracle.com/javase/tutorial/java/concepts/package.html). This is the least restrictive access modifier. 

- `protected` allows for access from within a package and subclasses that are located in other packages, but not for access from unrelated classes in other packages. In practice, you will rarely use this one yourself, but it can be seen in pre-generated code and libraries.

- If you omit the access keyword, the variable or method is accessible within its own package only. Subclasses in other packages do not get access, as opposed to the `protected` keyword.

In general, it is good practice to keep the access of your variables and methods as limited as possible, ensuring that only the parts of the program that really *need* access are getting it. Most of the time we will make use of `private` and `public` for the classes and variables we construct ourselves, as during this course we do not make a lot of use of different packages, since the apps are rather small.

➡️ **Exercise 1.1:** *Inside `StudentTest.java`, shown in the editor on the right, change the properties present from public variables to private variables.*

➡️ **Exercise 1.2:** *Write some code that changes the name of the study program of the student after it has been instantiated. What happens when you try to access or modify the properties of the student object? What do you think would happen if we gave the constructor private access as well?*

{% spoiler "Reminder: Compiling and running Java code" %}
To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName
{% endspoiler %}

{% next "Next: Java vs. Android" %}

{% next "Next: Getters and setters" %}
### Getters and setters

Consider the `Student` class once again, with the adjustments you made to its properties, making them `private`. Often when a class has private properties that does not mean they should never be accessed at all. Most of the time this is done through getter and setter methods. This is also called *encapsulation*. This means that instead of changing or adding an object's properties through the dot operator, we use a method to do this. These methods are contained in the class, just like the constructor.

        public void setName(String aName) {
            name = aName;
        }

        public String getName() {
            return name;
        }

Since they can be modified from iside the class, the so called getter and setter methods handle this part. This changes our syntax, instead of doing this when a student changes program:

        student.program = "New Program";
        System.out.println("This student is studying: " + student.program);

We call a method that does it for us, passing the new value as its parameter. This concept can also be applied in reverse, returning the string to us whenever we ask for it with `getProgram()`.

        student.setProgram("New Program")
        System.out.println("This student is studying: " + student.getProgram());

Of course, these getter and setter methods need to be created for the other properties as well.

➡️ **Exercise 2.1:** *Inside `StudentTest.java`, add the getter and setter for the name property to the class and create the getters and setters for the other properties in the `Student` class.*

A benefit of encapsulation is that instead of allowing someone to edit properties of an object using the dot operator, this must be done through a method. This method takes as an argument the new value to be set, but can of course also check whether this value makes sense at all. 

A good example could be the `credits` property. In this case its access is public so that means we can access it through the dot operator. Imagine we want to adjust the credits for the student object `s`. Using the dot operator we might do something like this:

        s.credits = 40;

However, nothing really stops us from supplying a bogus value, like `-30` or some other integer that does not make sense. This is the case for many other properties classes could have, even for something as simple as a `Student` class!

Instead of having the `credits` property be public, we could set it to `private` instead, like we did in the first part of this tutorial. By doing this, it can only be accessed from within the class, thus we are required to call the `setCredits()` method if we want to modify it. 

This method could not just adjust the credits, but also verify that the number makes sense and act appropriately. 

➡️ **Exercise 2.2:** *Adjust the set method for the credits property so that it performs a correction when the supplied value is negative.*

The point is that through this method, the handling of the `credits` property is much more foolproof. It is managed through its respective getter and setter methods. By keeping the access inside the class, you have much more control over the values of variables.

➡️ **Exercise 2.3:** *You can imagine that for EC it might not be the most useful to set the value every time. A method that increments them makes way more sense. Add a method to your Student class that increments a student's current EC by a given amount. Does this interfere with the getters and setters, why (not)?*

{% next "Next: Static vs. non-static" %}
### Static vs. non-static
Another modifier that can be added to the declaration of a method or variable is the `static` keyword. This modifier also has to do with access, but has to do with whether a class is instantiated or not. 

In our `Student` class, we have different variables that represent properties of a student, these are called instance variables (`name`, `program`, `studentNumber`, `credits`). They differ across instances of the Student object, as every time we create a new one, we supply new values for these variables to the constructor. These variables are unique for every instance of the class, as it makes sense that not all students have the same name, student number etc. The class says: all students have a name, but the instance says: "This specific student's name is Tim Steward".

In some cases it is beneficial to have another variable that is not unique for every instance, but instead applies to all instances of the class. Imagine we want to keep track of how many students there are in total. It would not make sense to keep a unique copy of that number for every student object we create, because that would be a waste of memory. Instead, we want one variable that can keep track of this count. To do this, we use a `static` variable that is common to all instances of the class.

        class Student {

            static int studentCount;

            // Properties of the class
            private String name;
            private String program;
            private int studentNumber;
            private int credits;

            ...

        }

Now that we have this variable, we of course also want to do something with it. Let's say we use this (admittedly inefficient) way of updating the student count every time we create a new student object:

        Student al = new Student("Ada Lovelace", "Computer Science", 61283, 180);
        Student.studentCount = 1;
        
        Student ik = new Student("Immanuel Kant", "Philosophy", 81148, 180);
        Student.studentCount = 2;
        
        Student ja = new Student("Jeanne d'Arc", "History", 90382, 40);
        Student.studentCount = 3;

If we were to print the value of `Student.studentCount` after running all of this, it would say 3. This is because `studentCount` is a static variable and thus it is updated for the class as a whole! Because the variable `studentCount` is `static`, we can also access through the `Student` class itself, without needing an instance. 

For things like counters that keep track how many instances have been made, this is very practical. We could for example also keep a count of the total credits amassed by all students. By referring to static variables through the class name like `Student.studentCount` it clear at one glance that the `studentCount` variable is overarching all instances and does not belong to one specific object.


➡️ **Exercise 3.1** *Continue working in `StudentTest.java`. Add the static property `studentCount` to the `Student` class like in the example.*

➡️ **Exercise 3.2** *Instead of incrementing the count manually every time we instantiate a student like in the example, move this functionality to the constructor.*

➡️ **Exercise 3.3** *Set the access of the `studentCount` variable to `private` and define a method that returns the count of students. Bear in mind we want this method to be accessible even when we do not have an instance of a `Student` present: what does this mean for the method's access modifier definition?*

{% next "Next: Constants" %}
### Constants
Let's say you want to use variables that really do not have to change at all during the runtime of your program. For this, we can use a constant. A constant in Java is denoted using the keyword `final`. If we were for example to define the name of the university as a constant within the student class, it would look like this:

    final String UNIVERSITY_NAME = "University of Amsterdam";

It is customary to use uppercase letters and underscores for the names of your constants, a concept you might be familiar with from C's `#define` functionality.

Now, the `UNIVERSITY_NAME` string is immutable. This means that any attempts to alter it at runtime will make the compiler complain. You can try this out in [the following snippet](http://bit.ly/2NXgGGO). 

➡️ **Exercise 4.1** *Compile and run `ConstantTest.java`. Does the compiler allow you to run this code?*

➡️ **Exercise 4.2** *Add another constant to the Student class and print it to the terminal.*

Notice how in the `ConstantTest.java` file, `UNIVERSITY_NAME` is both `static` and `final` in this example? This means that even though it's immutable, we still want it to be accessible without having to instantiate any students, because we assume the university is the same for all of them.

{% next "Next: Enums" %}
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


➡️ **Exercise 5.1** *Open `EnumTest.java` in the editor. Think of another shape and add it to the `enum` using the syntax explained above.*

Now that the options are contained within the `enum`, we can use it to declare and modify variables. The main difference is that now we can only assign values that are part of the `Shape` `enum` because we declared the variable to be of type `Shape`. 

        Shape shapeToShow = Shape.TRIANGLE;

Using `enum` has other benefits as well. Because all values are contained within `Shape`, it's much easier to iterate over them. They can also easily be incorporated into a `Switch` statement, which executes different code depending on the value of the variable supplied. 

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

➡️ **Exercise 5.2** *Add a case to the `switch` statement for the shape you added to the `enum` in 5.1 and change the code above to test whether your case is recognized.*

➡️ **Exercise 5.3** *Go back to `StudentTest.java`. Implement an `enum` that represents the various levels that exist: bachelor, master, PhD or some other set of constants you feel is appropriate to represent in an `enum`.*

➡️ **Exercise 5.4** *Add a method to the `Student` class that uses the `Switch` statement to print something to the terminal.*

{% next "Next: Wrapping it up" %}
### Wrapping it up
We have seen three types of modifiers related to the way variables are accessed. Each of these concepts came with its own keywords.

- The location from which classes, variables or methods can be accessed it determined through the absence of a keyword, `public`, `protected` or `private`. 

- Determining whether a variable is an instance variable or belongs to the class as a whole is done using the `static` keyword.

- Denoting a constant is done using the `final` keyword, which makes the variable immutable and comes with its own naming conventions.  

 These three can be combined to fit your specific needs. This for example, is valid syntax:

        public static final String UNIVERSITY_NAME = "University of Amsterdam";

We also saw that to define multiple constants, the `enum` is an elegant solution that helps avoid wrong assignments, simplifies iteration of the possible values and is easy to use inside a `Switch` statement. 