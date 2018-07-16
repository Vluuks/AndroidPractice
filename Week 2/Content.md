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


## Concepts

### Access 
This week we will focus on the different access rights that methods and variables can have in Java. This will matter once the scope of your apps gets bigger and you work with more different activities and model classes. Sometimes you don’t want certain variables from a class to be accessed outside it, for example.

You might have noticed that many of the variables and methods used in your code have a keyword such as `private`, `public` or `protected`. This has to do with the location from which these variables and methods can be accessed. 

`private` access restricts the access of a variable or method to within that class. 

`public` is quite the opposite, allowing access from outside the class, as well as from other [packages](https://docs.oracle.com/javase/tutorial/java/concepts/package.html). This is the least restrictive access modifier.

`protected` is a term we often see in Android Studio as well, it refers to a more toned down version of `public`. This modifier allows for access from within a package and subclasses that are located in other packages, but not for access from unrelated classes in other packages. 

In general, it is good practice to keep the access of your variables and methods as limited as possible, ensuring that only the parts of the program that really *need* access are getting it. 



## Practice
Grab the following file [LINK NAAR FILE]. 


### Exercises



### Tips

To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName

If you have trouble getting your Java programs to run in the IDE, run `update50`. If that does not work try:

        sudo apt-get update
        sudo apt-get install default-jdk

## Plain Java vs Android Studio