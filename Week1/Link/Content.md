# Java Basics for Android
 <img align="left" src="Images/robotje.png" style="padding: 10px"> In this course, we will use the programming language Java to create our Android apps, so the first part of each week will focus on explaining Java concepts to you.  Additionally, these concepts will be related to actual "Android" code, showing you how these plain Java concepts are relevant all throughout your app! This will be done using written text and mini exercises. 
 
 This week's focus will be on the basic features of Java: classes and their associated methods. Since it's an object oriented language, we will take a look at classes and how to use them. Then we will focus on methods and their parameters and return values.
<br>
<br>
<br>

## Table of contents
- [Concepts](#concepts)
    * [Classes](#classes)
    * [Classes and instances](#classes-instances)
    * [The constructor](#constructor)
    * [Parameters of the constructor](#parameters)
    * [Return values](#return-values)
- [Practice](#practice)
	* [Getting started](#getting-started)
	* [Exercises](#exercises)
- [Plain Java vs. Android Studio](#java-vs-android)
    * [Classes](#android-classes)
    * [Parameters and return values](#android-params)

<a name="concepts"></a>

## Concepts

<a name="classes"></a>

### Classes 
Java is a programming language that makes use of classes. A class is similar to a `struct` in C, but instead of just holding data, they can hold code that can be run as well. The data inside a Java class are commonly called *properties*, whereas the code that can be executed inside the class is called a *method*. Below is a very simple example of a Java class, which depicts a student with just three properties, and one method.

        class Student {

            // Properties of the class
            public String name;
            public String program;
            public int studentNumber; 

            // Method of the class
            public void printInfo() {
                System.out.println("This student is called " + name);
                System.out.println("they are studying " + program);
                System.out.println("and their student number is " + studentNumber);
            }
        }

As you can see this class does not just hold data (like the name, program and student number), it contains runnable code as well, in the form of the method `printInfo()`. When called, this method will print information about the student to the console.

<a name="classes-instances"></a>

### Classes and instances
In Java, in order to use classes like the `Student` class, they need to be instantiated before they can be used. The `Student` class can be seen as a blueprint. It exists, but before we can use the properties or methods inside, we first need to create an *instance* of the class. An instance of a class is often called an object as well. A class is a blueprint which you use to create objects. These objects are instances of that particular class.

This instance will contain actual information about a particular student, which the class blueprint does not. In the example below you can see the difference between the class (blueprint) and the instances. While the blueprint dictates what *kind* of information the class can hold, only the instances actually embody this information and represent actual students. 

![An image depicting the student class and its properties, with on the other side of the image two example instances of the student class.](Images/classes-instances.png)

Let's say we wanted to create some instances of `Student`. As of now we do not really have a practical way to do that. We could instantiate empty objects and then add the properties as we go:

        Student a = new Student();
        a.name = "John Smith";
        a.program = "Chemistry";
        a.studentNumber = 12824212;

It works as intended, but the problems with this are twofold. We need a lot of lines to create the basics of a `Student` object. For now there are three properties, but if there were more we would need a line for every assignment we make. Furthermore, this structure allows us to create incomplete objects as well:

        Student b = new Student();
        b.program = "Graphic Design";
        b.studentNumber = 21401851;

The above is valid syntax, so nothing is stopping us from never assigning a name to a particular student, which would of course not really make sense. You can imagine that missing basic properties might cause issues for other things you might want to represent in a class as well! 

To solve these issues, the instantiating of objects in Java is handled using a special method, the constructor.

<a name="constructor"></a>

### The constructor
The constructor is an important and special method inside the class that we can call to create instances of that class. By default, classes are provided with a constructor that takes no arguments and does not alter the properties of the class. We called this constructor in the example above: `Student a = new Student();`. It just creates the object with the associated properties, but does not set their values. 

Often the constructor is used to set the properties of the class to meaningful values. In this case we want to set the values of the name, the program the student is attending and the student number. The constructor of the class can be made with this in mind, allowing us to insert these values.

To do this, we simply need to add the constructor method to the class definition. While the class  only contained the properties and the method `printInfo()` before, we can now adjust it to hold our constructor as well!

        class Student {

            // Properties of the class
            public String name;
            public String program;
            public int studentNumber; 

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

The constructor is defined by using the name of the class as the name of the method, and then specifying the parameters it should take. Inside the method body, these parameters are passed on to the appropriate fields of the class. The next section will cover these parameters in more depth.

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

Due to the concept of [method overloading](https://beginnersbook.com/2013/05/method-overloading/) in Java, we can also define multiple constructors with different parameters for a class. If we wanted to define a constructor that does not take the program of the student as an argument, but just their name and number, it would look like this:

            public Student(String aName, int aStudentNumber) {
                name = aName;
                studentNumber = aStudentNumber;
            }

We can then add this constructor to the `Student` class as well, and when instantiating students, we can choose which one of the constructors to use. If we know everything we need, we can use the first constructor. If we do not know their program yet, then we can choose the latter. The program will then remain `null` until we set it to a value later. The final file with both constructors present would look like [this](Java/StudentExample.java).


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

However, the kind of variable to be returned must be specified in the method declaration. We can clearly see this, as the declaration of `createInfoString()` is preceded by the keyword `String`. When a method does not return anything, like `printInfo()` we use `void`. An exception to this is the constructor: no return type keyword is used in its declaration. 

<a name="practice"></a>

## Practice
You can try this out by grabbing the [following file](Java/StudentTest.java). It contains the code we have seen this far, though the strucure in which we present it in order to be able to run it is slightly different. 

Note that in regular Java, the point of entry of the program is the `main` method (just like we are used to in C!). The main method needs to be contained in a class as well, which we have called `StudentTest`. 

From this main method, we can access the `Student` class and create instances of it, as well as invoke the methods contained within the student class through the references we created before. Essentially, this is where the action happens most of the time. If you want to make changes to the contents of the `Student` class itself, this should of course be done inside that class instead!

<a name="getting-started"></a>

### Getting started
To run Java programs, you need to have Java installed. You might already have it on your own computer, but if not, use the following instructions to be able to use Java online. If you already have a CS50 IDE, you can just create a new folder in your workspace and start there!

1. First, register for an account on edx.org, which will provide you with an account to log on to the CS50 IDE. If you already have an edX account, it’s no problem to use that one.

2. Now head to cs50.io and log on to the CS50 IDE. You may be prompted (again) for your email address. If so, after providing it, click Private under Hosted workspace, then click Create workspace.

3. You should then be informed that CS50 IDE (aka Cloud9, the software that underlies CS50 IDE) is “creating your workspace” and “creating your container,” which might take a moment. You should eventually see your workspace. If not, do just email your instructor to inquire!

To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName

If you have trouble getting your Java programs to run in the IDE, run `update50`. If that does not work try:

        sudo apt-get update
        sudo apt-get install default-jdk

<a name="exercises"></a>

### Exercises 

0) Instantiate a third student.

1) Make calls to the method `printInfo()` so that the information of all three students is printed to the terminal. 

2) Add a property that represents study credits to the student class, and make sure this property is correctly initialized when you create instances of the student object.

3) Create a method inside the student class, which both checks how many credits a certain student has and prints to the console whether they can ask for their diploma (which you need 180 for), or they still have to study some more!

4) Rewrite the method created at 3 so that instead of just printing everything directly, it makes a call to another method which handles the credit checking part and returns true or false, depending on whether the student is eligible for their diploma. 

Be sure to save your final file, as you will need to show us later.

<a name="java-vs-android"></a>

## Plain Java vs. Android Studio
Most concepts in Java also apply to the way we write code in Android Studio, however they might take a slightly different shape. In this section we will review how the concepts of this week are used in Android Studio. This can help you understand the tools needed to build this week's app. 

<a name="android-classes"></a>

###  Classes in Android Studio
In Android Studio, you will see classes as well, though the way in which they are used is slightly different. In your app, the different screens are represented by `Activities`. These activities are actually classes as well! 

However, instead of having a `main` method associated with them as in the example above, they make use of the method `onCreate` which is called when the respective activity is (surprise) created. Inside this method, the corresponding layout for the activity is set, after which you can start adding your own code.

        public class MainActivity extends AppCompatActivity {

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                // Now we can start doing things!
            }
            
        }

Of course, Android Studio allows for you to create custom classes that depict something tangible, like the `Student` one as well. However throughout an app you will see classes that take many other shapes. All runnable code you write for your app will be contained inside a method of some kind, which is in turn containde inside a class.

Imagine a super simple app that contains information about one student and shows this information when the user clicks a button. In this particular app, there are two classes that interact. These classes are often depicted in what is called an UML diagram. They are helpful because they give a quick overview of what classes, variables and methods are present in the program's architecture. 

![A gif depicting the app described above.](Images/app-example.gif) 

![A UML diagram showing MainActivity and the Student model class](Images/mini-uml-classes.png)

In the image above, we can see the `Student` model class with its fields and method and a hypothetical `MainActivity` containing a field to hold a `Student` object, a click handler for a button of some sort and of course `onCreate()`. These kind of diagrams are often used to illustrate how classes relate to each other and what kind of content they contain.

<a name="android-params"></a>

## Parameters and return values in Android Studio
The concept of parameters and return values applies in Android Studio as well. A structure that is often present in Android code is a click handler that responds to click events on some element of the UI, for example a button:

        // This method will be called when the button inside the activity is clicked
        public void onClick(View view) {
            int id = view.getId();
            Log.d("View id:", Integer.toString(id));
        }

This method gets a parameter, a `View` object called `view`. This object refers to the element in the layout, which are called views in Android, that triggered the method. This `View` object is available in the scope of the `buttonClicked` method, which means that we can use methods associated with the `view` object. 

Classes like `View` in Android studio often have a lot of such methods, which are accessed by the dot operator, just like in Exercise 1. Usually the IDE will provide you with a list of these methods once you add a dot after the object and begin typing, like for example to access the `getId()` method, which returns the associated id number (an integer) of the view in question (see the gif below). Many methods like this return a specific type of value, which in turn can be used to determine your program's logic or perform other operations. The return value of the methods is also shown on the right side of the dropdown menu in the IDE.

![A gif depicting a user starting to type,  placing a dot after the View object which prompts the IDE to supply the list of available methods beloning to the View class.](Images/view-methods-ide.gif)

However, sometimes it's useful to see all of them to understand what they do and which one you need. For this, [Android's official documentation](https://developer.android.com/reference/) is your best friend! For example, [this page](https://developer.android.com/reference/android/view/View) contains information about the `View` class. Useful!

 In addition to methods that we write ourselves and methods that handle events like a click, some methods are called by the app itself automatically when needed. A good example of this is `onCreate`, this method is run when the app starts, but we do not have to call it. 
 
 Even though the method is called automatically, it still gets something passed as a parameter: `Bundle saveInstanceState`. This `Bundle` object can be accessed all throughout the scope of the `onCreate` method, and contains information about the state of the app if it was restored from an earlier time. There are many such methods that are called automatically, a lot of which are part of the [activity lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle#java) which handles the different states of different screens inside an app throughout time. This week we will use `onCreate()` (of course) and `onSaveInstanceState()` in our app. 

