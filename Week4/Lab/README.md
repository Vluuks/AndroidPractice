# Java Basics for Android
 <img align="left" src="https://raw.githubusercontent.com/Vluuks/AndroidPractice/labified/Week4/Lab/Images/robotje.png" style="padding: 10px"> This week the focus will be on exceptions. You probably already have encoutered them a few times in your programming, especially the famous `NullPointerException`. The focus in this tutorial will be on different kind of exceptions, when they might occur and how to handle them appropriately. Furthermore, starting this week we will put additional focus on code quality, which is also tied to handling exceptions well!
 <br>
 <br>
 <br>

## Table of contents

{% next "Exceptions - part 1" %}
### Exceptions
When running programs, sometimes unexpected things happen, even if the code compiled correctly beforehand. This could for example be you trying to access an index in an array that is out of bounds, trying to call a method on an object that does not exist, etc. 

In Java, these events usually produce an `Exception` of some kind. You probably have seen an exception resembling the following printed to the console in a nice bright red at some point:

        java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.ListView.setAdapter(android.widget.ListAdapter)' on a null object reference

Exeptions like these are not the only kind of exception, although you will probably see this kind a lot in the beginning. Exceptions contain information on what went wrong, so that you can solve the problem or help avoid it. 

{% next "Exceptions - part 2" %}
### Exceptions
Unlike a language like C, where success or failure is usually denoted using a return value like `1` or `-1`, exceptions contain more information. This is because in fact, `Exceptions` are objects as well, just like many things in Java! 

Their name is often indicative of the problem, but they are accompanied by a message further detailing the nature of the exception as well. This is useful, because if the app would just crash without raising an exception you would never know what happened. 

Although the messages might appear overwhelming or cryptic at first, a good understanding of exceptions and why they are occuring can help you debug your code quicker and avoid the same mistake in the future. 

> Of course, it's helpful to Google the more complex exceptions for help. To get better results make sure to remove the parts that are very specific to your app if they are there, like exact variable or method names that you wrote yourself.

A lot of times the Java Virtual Machine (which takes care of running the code) is the one that throws the exceptions, which appear in the console. But as a programmer, we have can also control and check for exceptions to avoid runtime crashes in our apps. The next section will cover this.

{% next "Try Catch - part 1" %}
### Try Catch
Because exceptions are objects, we can do more things with them. A common structure to prevent runtime crashes but still be aware that things went wrong is the `try catch` block. Take a look at `ExceptionTest.java` and see what it looks like.

In the first part between the curly braces, code is run as usual. The difference is that when an exception is encountered, instead of crashing, the catch block will be executed instead. In this case we are catching any exception (`Exception e`) that might occur. 

The catch block should then of course do something to alleviate the problem and/or alert the user that something went wrong. Chances are that if the app would have crashed otherwise, something is amiss and you might want to notify the user that something unexpected happened. 

In this example, you might want to set `i` to another number if index 10 does not exist because it is out of bounds. The program can continue running, even if an otherwise fatal error occured. In addition to that, when debugging you are very interested in what caused exceptions. So inside the catch block, you want to obtain this information. 

➡️ *Exercise 1.1:* *Inside ExceptionTest.java, add a statement to the catch block that prints the details of the exception. Since exceptions are instances of a certain class and thus also contain methods, you call the method `printStackTrace()` on the exception in question.*

➡️ *Exercise 1.2:* *To ensure the rest of the program can run normally, also add a line of code that sets the variable `i` to a value that makes sense, even if the exception occurs.*

{% spoiler "Reminder: Compiling and running Java code" %}
To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName

{% endspoiler %}

{% next "Try Catch - part 2" %}
### Try Catch
If the catch can prevent crashes, why not just wrap everything in try-catch structures and be safe from exceptions? Some solution to that might be to just catch everything:

        try {
            // the full program
        }
        catch(Exception e) {
            // any error ever will be caught by this catch
        }

While the generic catch might seem a great solution, catching all exceptions ever with just one, it is actually bad practice. In almost all cases, different exceptions should not be treated the same way, especially as applications get bigger. In large projects, new exceptions might be added and you would never know, due to the super generic catch.

➡️ *Exercise 1.3:* *Your call to `printStackTrace()` should have told you what kind of exact exception occured. Adjust the catch part so that this exact exception is caught, instead of just generic exceptions.*

{% next "Multiple errors" %}
### Multiple errors
 Oh no! A very sloppy programmer has made a weird class with a method inside that throws all kind of exceptions and thus crashes almost every time it is run. When it runs succesfully, it prints "Success!" to the console, but as of now the program usually crashes before that ever happens. Luckily, we now know what to do about that.

 Take a look at `ExceptionTest2.java`. In this file, the main method makes calls to the `doSomething()` method of `SomeClass`. We do not know what is inside `SomeClass`, but it surely isn't very good code!

➡️ *Exercise 2.1:* *Compile and run `ExceptionTest.java`. What happens? Does it run `doSomething()` the expected 50 times?*

➡️ *Exercise 2.2:* *Add a `try catch` block to the code that catches all exceptions. What does catching all exceptions do in this case?*

➡️ *Exercise 2.3:* *Inside the catch block, find a way to discover what kind of exceptions are thrown by the method. Remember that exceptions were in fact objects? This means they have methods associated with them as well. Use [the documentation](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/Exception.html) to your advantage!*

➡️ *Exercise 2.4:* *When you have discovered the different errors the `doSomething()` method produces, change your generic catch block to multiple catch blocks that each handle a specific exception.*

{% spoiler "Reminder: Compiling and running Java code" %}
To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName

{% endspoiler %}


