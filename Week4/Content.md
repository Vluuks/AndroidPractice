# Java Basics for Android
This week the focus will be on exceptions. You probably already have encoutered them a few times in your programming, especially the famous `NullPointerException`. The focus in this tutorial will be on different kind of exceptions, when they might occur and how to handle them appropriately. Furthermore, starting this week we will put additional focus on code quality, which is also tied to handling exceptions well!

## Table of contents
- [Concepts](#concepts)
    * [Exceptions](#classes)
    * [Try Catch](#constructor)
    * [Parameters](#parameters)
- [Practice](#practice)
	* [Getting started](#getting-started)
	* [Exercises](#exercises)
- [Plain Java vs. Android Studio](#java-vs-android)
    * [Classes](#android-classes)
    * [Parameters and return values](#android-params)

<a name="concepts"></a>

## Concepts

<a name="exceptions"></a>

### Exceptions
When running programs, sometimes unexpected things happen, even if the code compiled correctly beforehand. This could for example be you trying to access an index in an array that is out of bounds, trying to call a method on an object that does not exist, etc. 

In Java, these events usually produce an `Exception` of some kind. You probably have seen an exception resembling the following printed to the console in a nice bright red at some point:

        java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.ListView.setAdapter(android.widget.ListAdapter)' on a null object reference

Exeptions like these are not the only kind of exception, although you will probably see this kind a lot in the beginning. Exceptions contain information on what went wrong, so that you can solve the problem or help avoid it. 

Unlike a language like C, where success or failure is usually denoted using a return value like `1` or `-1`, exceptions contain more information. This is because in fact, `Exceptions` are objects as well, just like many things in Java! 

Their name is often indicative of the problem, but they are accompanied by a message further detailing the nature of the exception as well. This is useful, because if the app would just crash without raising an exception you would never know what happened. 

Although the messages might appear overwhelming or cryptic at first, a good understanding of exceptions and why they are occuring can help you debug your code quicker and avoid the same mistake in the future. 

> Of course, it's helpful to Google the more complex exceptions for help. To get better results make sure to remove the parts that are very specific to your app if they are there, like exact variable or method names that you wrote yourself.

A lot of times the Java Virtual Machine (which takes care of running the code) is the one that throws the exceptions, which appear in the console. But as a programmer, we have can also control and check for exceptions to avoid runtime crashes in our apps. The next section will cover this.

<a name="try-catch"></a>

### Try Catch
Because exceptions are objects, we can do more things with them. A common structure to prevent runtime crashes but still be aware that things went wrong is the `try catch` block. This block consists of two parts:

        try {
            int i = integerArray[10];
        }
        catch(ArrayIndexOutOfBoundsException e) {
            ...
        }

In the first part between the curly braces, code is run as usual. The difference is that when an exception is encountered, instead of crashing, the catch block will be executed instead. In this case we are catching the `ArrayIndexOutOfBoundsException`. 

The catch block should then of course do something to alleviate the problem and/or alert the user that something went wrong. Chances are that if the app would have crashed otherwise, something is amiss and you might want to notify the user that something unexpected happened. In this example, you might want to set `i` to another number if index 10 does not exist because it is out of bounds. The program can continue running, even if an otherwise fatal error occured. 

Then, why not just wrap everything in try-catch structures and be safe from exceptions? Some solution to that might be to just catch everything:

        try {

        }
        catch(Exception e) {

        }

While the generic catch might seem a great solution, catching all exceptions ever with just one, it is actually bad practice. In almost all cases, different exceptions should not be treated the same way, especially as applications get bigger. In large projects, new exceptions might be added and you would never know, due to the super generic catch. 




