# Java Basics for Android
 <img align="left" src="https://raw.githubusercontent.com/Vluuks/AndroidPractice/labified/Week1/Lab/robotje.png" style="padding: 10px"> In this course, we will use the programming language Java to create our Android apps, so the first part of each week will focus on explaining Java concepts to you. We will do this in "lab" form, which means we make use of a split screen, combining the explanation with an built-in editor and terminal.
 
 This week's focus will be on the basic features of Java: classes and their associated methods. Since it's an object oriented language, we will take a look at classes and how to use them. Then we will focus on methods and their parameters and return values.
<br>
<br>
<br>

{% next "Next: Working with Java classes" %}
&nbsp;
<a name="classes"></a>

### Working with Java classes
Java is a programming language that makes use of classes. A class is similar to a `struct` in C, but instead of just holding data, they can hold code that can be run as well. The data inside a Java class are commonly called *properties*, whereas the code that can be executed inside the class is called a *method*. In the editor on the right is a very simple example of a Java class called `Student`, which depicts a student with just three properties, and one method.

To make use of this class and run code, we use another class. This class is called `StudentTest` and can also be found in the editor's other tab. This class does not contain properties, but rather just a method called `main`. This method is the point of entry of the program (just like we are used to in C!). Because of the way Java works, this main method needs to be contained in a class as well, hence we've got the class `StudentTest` surrounding it.

From this main method, we can access the `Student` class and create instances of it, as well as invoke the methods contained within the student class through the references we created before. Essentially, this main method is where the action happens most of the time. If you want to make changes to the contents of the `Student` class itself, this should of course be done inside that class instead!

Java is a compiled language, and as such we need to compile our code before we can run it. We will compile the file that contains the main method, and because it contains code that makes use of the `Student` class, `Student.java` will automatically be compiled as well! 

To compile your `StudentTest.java` to a .class file, use this command on the terminal:

        javac StudentTest.java

After compilation, you can run your program using:

        java StudentTest

It will now execute the code inside the main method. Meaning, "Running main!" should be printed to the terminal. If you run into problems, ask for help! 

<a name="classes"></a>
{% next "Next: Classes and properties" %}
&nbsp;

### Classes and properties
Classes in Java like the `Student` class can contain various properties. These properties can have all kind of types. They can represent simple things like an `int`, `boolean`,  or `String`, but also lists of items and even other classes! Properties represent information that can be contained in the class. 

In Java, variable and method names are written using camelCase, such as `studentNumber`. Classes on the other hand, use PascalCase, such as `StudentTest`. This is the standard for Android apps as well, so get used to this kind of casing!

➡️ *Exercise 1.1:* *In the editor on the right, find the `Student.java` file and add another property to the class, right below the `studentNumber` property.*

Verify that your code still compiles by executing `javac StudentTest.java` at the terminal. You can also run the code by using `java StudentTest` afterwards, but the output will still be the same. (Why?)

{% next "Next: Classes and instances - part 1" %}
&nbsp;
<a name="classes-instances"></a>

### Classes and instances
In Java, in order to use classes like the `Student` class, they need to be instantiated. The `Student` class can be seen as a blueprint. It exists, but before we can use the properties or methods inside, we first need to create an *instance* of the class. An instance of a class is often called an object as well. 

This instance will contain actual information about a particular student, which the class blueprint does not. In the example below you can see the difference between the class (blueprint) and the instances. While the blueprint dictates what *kind* of information the class can hold, only the instances actually embody this information and represent actual students. A class is a blueprint which you use to create objects. These objects are instances of that particular class.

![An image depicting the student class and its properties, with on the other side of the image two example instances of the student class.](classes-instances-robot.png)

Let's say we wanted to create some instances of `Student`. As of now we do not really have a practical way to do that. We could instantiate empty objects and then add the properties as we go:

        Student a = new Student();
        a.name = "Tim Steward";
        a.program = "Business & IT";
        a.studentNumber = 12458824;

➡️ *Exercise 2.2:* *Using the syntax described above, create three instances of the `Student` class inside the `main` method and assign them values for the three properties and the property you added yourself in exercise 1. Compile and run your code.*

{% next "Next: Classes and instances - part 2" %}
&nbsp;
<a name="classes-instances"></a>

### Classes and instances

As you can see in the editor on the right, this class does not just hold data (like the name, program and student number), it contains runnable code as well, in the form of the method `printInfo()`. When called, this method will print information about the student to the console. 

➡️ *Exercise 2.3:* *Make calls to the method `printInfo()` so that the information of all three students is printed to the terminal.* 

If you did everything right, the code you just wrote works as intended, but the problems with this are twofold. We need a lot of lines to create the basics of a `Student` object. For now there are three properties, plus the one you added, but if there were more we would need a line for every assignment we make. Furthermore, this structure allows us to create incomplete objects as well:

        Student b = new Student();
        b.program = "Graphic Design";
        b.studentNumber = 21401851;

➡️ *Exercise 2.4:* *Instantiate another student, but this time without assigning values to their properties. What happens when you call `printInfo()` on this student? Why do you think that is?* 

The above is valid syntax, so nothing is stopping us from never assigning a name to a particular student, which would of course not really make sense. You can imagine that missing basic properties might cause issues for other things you might want to represent in a class as well! To solve these issues, the instantiating of objects in Java is handled using a special method, the constructor.

{% next "Next: The constructor" %}
&nbsp;
<a name="constructor"></a>

### The constructor
The constructor is an important and special method inside the class that we can call to create instances of that class. By default, classes are provided with a constructor that takes no arguments and does not alter the properties of the class. We called this constructor in the example above: `Student a = new Student();`. It just creates the object with the associated properties, but does not set their values. 

Often the constructor is used to set the properties of the class to meaningful values. In this case we want to set the values of the name, the program the student is attending and the student number. The constructor of the class can be made with this in mind, allowing us to insert these values. The constructor is defined by using the name of the class as the name of the method, and then specifying the parameters it should take. Inside the method body, these parameters are passed on to the appropriate fields of the class. The next section will cover these parameters in more depth.

        // Constructor of the class
        public Student(String aName, String aProgram, int aStudentNumber) {
                name = aName;
                program = aProgram;
                studentNumber = aStudentNumber;
        }

To use the constructor with the parameters we defined, we simply need to add it to the class definition. While the class  only contained the properties and the method `printInfo()` before, we can now adjust it to hold our constructor as well!

➡️ *Exercise 3* *Using the syntax from the example above, add the constructor to `Student.java`. Verify that its syntax is correct by compiling `StudentTest.java`.*

{% spoiler "Hint: Compiling and running Java code" %}
To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName
{% endspoiler %}

{% next "Next: Parameters of the constructor" %}
&nbsp;
<a name="parameters"></a>

### Parameters of the constructor
Parameters determine what kind of information can be passed on to a method. You are probably familiar with this concept as it exists in other languages as well. In Java, they are specified between the `()` of the method declaration, stating the name of the parameter and its type. 

You can see in the method declaration of the constructor that it takes three parameters: two strings and an integer. 

         public Student(String aName, String aProgram, int aStudentNumber)

When creating a method in Java, this is the way in which you specify if and which values should be passed on to that method when it is called. The arguments that are passed will be accessible within the scope of the method to which they are passed. 

Suppose we wanted to create a new student object for the student Ada Lovelace and store it in the variable `al`:

        Student al = new Student("Ada Lovelace", "Computer Science", 61283);

Now, the variable `al` contains the values we initialized it with, because inside the constructor method, the values are stored in the properties of the student object. If we wanted to initialize another student as well, we can of course do so! 

        Student ik = new Student("Immanuel Kant", "Philosophy", 81148);

The variables `al` and `ik` can be seen as references to the respective objects. They each use the `Student` blueprint, but the contents of the properties are different.

➡️ *Exercise 4.1* *Use the constructor we added in exercise 3, and replace the instantiation of the first three student objects with this constructor.*

➡️ *Exercise 4.2* *Adjust the constructor to incorporate the property you added in 1.1 and instantiate three student objects in `StudentTest.java`'s `main` method with this new constructor. Verify that it works by compiling and running your code.*

{% spoiler "Hint: Compiling and running Java code" %}
To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName
{% endspoiler %}

{% next "Next: Method overloading" %}
&nbsp;
<a name="method-overloading"></a>

### Method overloading
Due to the concept of [method overloading](https://beginnersbook.com/2013/05/method-overloading/) in Java, we can also define multiple constructors with different parameters for a class. If we wanted to define a constructor that does not take the program of the student as an argument, but just their name and number, it would look like this:

            public Student(String aName, int aStudentNumber) {
                name = aName;
                studentNumber = aStudentNumber;
            }

We can then add this constructor to the `Student` class as well, and when instantiating students, we can choose which one of the constructors to use. If we know everything we need, we can use the first constructor. If we do not know their program yet, then we can choose the latter. The program will then remain `null` until we set it to a value later. 

➡️ *Exercise 5:* *In your `Student.java` file, add a second constructor that takes only two arguments instead of four. Instantiate some student objects using this alternative constructor as well. Verify that it works by compiling and running the code.*

{% spoiler "Hint: Compiling and running Java code" %}
To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName
{% endspoiler %}

{% next "Next: Return values" %}
&nbsp;
<a name="return-values"></a>

### Return values
When taking a look at the `printInfo()` method, another aspect is important: the return type. Methods in Java specify the kind of value they return at the end. In this case, `printInfo()` is preceded by the word `void` which indicates that the method does not return any value. This is true, as it just prints anything but does not return a value to the caller. 

Suppose we had a different structure of the class in mind, which separates the tasks that are going on a bit more. Let's say we would want to split the task of building the string to be printed and the actual printing itself. Our methods could then look something like this:

        // Creates and returns a string with all info
        private String createInfoString() {
            String infoString = "This student is called " + name + 
                "they are studying " + program + " and their student number is " + studentNumber;
            return infoString;
        }

        // Prints the string info to the terminal
        public void printInfo() {
            String toPrint = createInfoString();
            System.out.println(toPrint);
        }

Now, all the `printInfo()` method does is call another method, `createInfoString()` and print the results from calling this method instead. This works because the `createInfoString()` method is defined to return a `String`. In Java, methods can return all kinds of variables and even instances of classes like `Student`! 

However, the kind of variable to be returned must be specified in the method declaration. We can clearly see this, as the declaration of `createInfoString()` is preceded by the keyword `String`. When a method does not return anything, like `printInfo()` we use `void`. An exception to this is the 
constructor: no return type keyword is used in its declaration. 

➡️ *Exercise 6.1:* *Create a method inside the student class, which both checks how many credits a certain student has and prints to the console whether they can ask for their diploma (which you need 180 for), or they still have to study some more!*

➡️ *Exercise 6.2:* *Rewrite the method created at 5.1 so that instead of just printing everything directly, it makes a call to another method which handles the credit checking part and returns true or false, depending on whether the student is eligible for their diploma.*

{% spoiler "Hint: Compiling and running Java code" %}
To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName
{% endspoiler %}

{% next "Next: Wrapping it up" %}
&nbsp;

## Wrapping it up
You have now seen how to instantiate objects in Java, using a class as a blueprint. You also practiced with methods, including their parameters and return values. These concepts will all be important when you get to building your app!