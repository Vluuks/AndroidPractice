# Java Basics for Android
 <img align="left" src="Images/robotje.png" style="padding: 10px"> This week the focus will be on exceptions. You probably already have encoutered them a few times in your programming, especially the famous `NullPointerException`. The focus in this tutorial will be on different kind of exceptions, when they might occur and how to handle them appropriately. Furthermore, starting this week we will put additional focus on code quality, which is also tied to handling exceptions well!
 <br>
 <br>
 <br>

## Table of contents
- [Concepts](#concepts)
	 * [Exceptions](#exceptions)
	 * [Try Catch](#try-catch)
- [Practice](#practice)
	 * [Exercises](#exercises)
- [Plain Java vs. Android Studio](#plain-java-vs.-android-studio)
	 * [Unraveling exceptions](#unraveling-exceptions)
	 * [Logcat tips](#logcat-tips)
	 * [When to use try catch](#when-to-use-try-catch)

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

The catch block should then of course do something to alleviate the problem and/or alert the user that something went wrong. Chances are that if the app would have crashed otherwise, something is amiss and you might want to notify the user that something unexpected happened. In this example, you might want to set `i` to another number if index 10 does not exist because it is out of bounds. The program can continue running, even if an otherwise fatal error occured. You can try this out yourself in the [following snippet](http://bit.ly/2voT5Hc).

If the catch can prevent crashes, why not just wrap everything in try-catch structures and be safe from exceptions? Some solution to that might be to just catch everything:

        try {

        }
        catch(Exception e) {

        }

While the generic catch might seem a great solution, catching all exceptions ever with just one, it is actually bad practice. In almost all cases, different exceptions should not be treated the same way, especially as applications get bigger. In large projects, new exceptions might be added and you would never know, due to the super generic catch. 


<a name="practice"></a>

## Practice
 Oh no! A very sloppy programmer has made a weird class with a method inside that throws all kind of exceptions and thus crashes almost every time it is run. When it runs succesfully, it prints "Success!" to the console, but as of now the program usually crashes before that ever happens. Luckily, we now know what to do about that. [Grab the following zipped files](Java/ExceptionTest.zip).  After downloading, you can add these file to your CS50 IDE. If you are not sure anymore how to set this IDE up, refer to the practice section of [Week 1](SOME URL TODO). 

To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName

If you have trouble getting your Java programs to run in the IDE, run `update50`. If that does not work try:

        sudo apt-get update
        sudo apt-get install default-jdk


<a name="exercises"></a>

### Exercises 

1. Compile and run `ExceptionTest.java`. What happens? Does it run `doSomething()` the expected 50 times? 

2. Add a `try catch` block to the code that catches all exceptions. What does catching all exceptions do in this case?

3. Inside the catch block, find a way to discover what kind of exceptions are thrown by the method. Remember that exceptions were in fact objects? This means they have methods associated with them as well. Use [the documentation](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/Exception.html) to your advantage!

4. When you have discovered the different errors the `doSomething()` method produces, change your generic catch block to multiple catch blocks that each handle a specific exception.

<a name="java-vs-android"></a>

## Plain Java vs. Android Studio
Naturally, you will encounter different kinds of exceptions in Android Studio as well. These exceptions will be printed to the console. To accurately solve them it is important to understand why they happen and where they come from. Sometimes the content of these exceptions gets very long, which makes them rather cryptic. In this section we will look at a few common exceptions and explain what to look for and how to discover where they came from. 

<a name="unraveling-exceptions"></a>

### Unraveling exceptions
When exceptions occur during the testing of your app, they are printed to the logcat console. Most of the times the exception starts with a timestamp and the keywords `FATAL EXCEPTION: main` indicating that it occured on the main thread and caused the app to crash. This is followed by a lot of information like below, which can be hard to read. 

        08-07 09:10:30.091 14777-14777/com.example.renske.nativeapppractice E/AndroidRuntime: FATAL EXCEPTION: main
            Process: com.example.renske.nativeapppractice, PID: 14777
            java.lang.RuntimeException: Unable to start activity ComponentInfo{com.example.renske.nativeapppractice/com.example.renske.nativeapppractice.MainActivity}: java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.ListView.setAdapter(android.widget.ListAdapter)' on a null object reference
                at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2778)
                at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2856)
                at android.app.ActivityThread.-wrap11(Unknown Source:0)
                at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1589)
                at android.os.Handler.dispatchMessage(Handler.java:106)
                at android.os.Looper.loop(Looper.java:164)
                at android.app.ActivityThread.main(ActivityThread.java:6494)
                at java.lang.reflect.Method.invoke(Native Method)
                at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:438)
                at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:807)
            Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.ListView.setAdapter(android.widget.ListAdapter)' on a null object reference
                at com.example.renske.nativeapppractice.MainActivity.onCreate(MainActivity.java:34)
                at android.app.Activity.performCreate(Activity.java:7009)
                at android.app.Activity.performCreate(Activity.java:7000)
                at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1214)
                at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2731)
                at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2856) 
                at android.app.ActivityThread.-wrap11(Unknown Source:0) 
                at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1589) 
                at android.os.Handler.dispatchMessage(Handler.java:106) 
                at android.os.Looper.loop(Looper.java:164) 
                at android.app.ActivityThread.main(ActivityThread.java:6494) 
                at java.lang.reflect.Method.invoke(Native Method) 
                at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:438) 
                at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:807) 

When confronted with this, there are a few things to look out for. 

1) The kind of exception that occured.

2) The offending file.

3) The line inside that file that caused the exception. 

The kind of exception can be spotted two times in this case, it is the least indented line preceded by "Caused by:". In this case we are dealing with the infamous `java.lang.NullPointerException`. This line also tells us the other things we need to know:

        Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.ListView.setAdapter(android.widget.ListAdapter)' on a null object reference

We attempted to invoke (call) a method, `setAdapter()`  on a null object reference. This does *not* mean that `setAdapter()` itself was null. It means that the object on which we attempted to call `setAdapter()` was null. When debugging this is an important distinction to make, as squashing bugs becomes hard when you are not taking care of the actual culprit!

Now that we understand what went wrong, we of course want to know where it went wrong. Luckily for us Android studio also mentions the location of the error. Since apps are complex the error resonates in a lot of other locations, hence the list of "at ...". However the line we are looking for is this one:

        at com.example.renske.nativeapppractice.MainActivity.onCreate(MainActivity.java:34)

Here we can clearly see that the error occurs in `MainActivity`'s `onCreate` at line 34. In Android Studio, this part will be highlighted (usually in blue, depending on your color theme) and when clicked will take you to exactly this line. Neat!

When we take a look at the code, we see the following:

        listView.setAdapter(new PlantAdapter(this, R.layout.row_item, plants));

With the information we know, `setAdapter()` being called on something that is apparently `null`, we can now solve it. We need to check and verify that the variable `listView` is correctly initialized, because according to the error this variable is `null`. This could be due to different reasons, but the important part is that we are aware what exact part of our program is causing the error.


<a name="logcat-tips"></a>

### Logcat tips

 The logcat often puts out a lot of things, which can make it hard to find what you need to know. To make reading the exceptions and solving them a bit easier, there are a few things you can do.

- You can filter the logcat output by using the dropdowns on top. By setting it to "Error", it will only show messages that fit this description, like exceptions. Additionally, you can use the search function as well. (Don't forget to unset the filter/search if you are looking for other things that do not fit this category later!)

    ![A short gif showing the different purposes and effects of the logcat dropdowns.](logcat-dropdowns.gif)

- These dropdowns also distinguish between different devices (for example the emulator and your phone) and processes. Sometimes a process is indicated as dead and does not update the log anymore. Usually when you rerun the app, the log automatically restarts, but sometimes it stays on the dead process. This means that if you rerun the app, you need to switch to the other, active process if it is not doing so automatically.

- To free up some space (especially on smaller monitors), you can go to the logcat settings. These are behind the cogwheel icon ![An icon showing the cogwheel logo.](settings-icon.png) , which is sometimes hidden behind a small arrow icon if your logcat's height is too small. In these settings, you can uncheck "show process and thread ID" and "show package" as these are not important to us in this course. This frees up some space.

- To increase readability and avoid scrolling, you can turn on wraparound, which has its own icon on the left bar. ![An icon showing the wraparound logo.](wraparound-icon.png)


<a name="when-to-use-try-catch"></a>

### When to use try catch
When creating your app, Java sometimes forces you to use a try-catch structure. This is mostly when you are working with I/O such as loading files or reading things from the raw/assets folder. Parsing JSON will also require you to use try-catch.

It is of course not a solution to surround every potential null pointer with try catch for basic things like initializing views. In general you should still be aware of errors. However if you have an operation that might fail at runtime and crash the app, for example due to loss of connection, files that aren't where they are supposed to be etc. then it is a good idea to use the try-catch structure to prevent a runtime crash. 