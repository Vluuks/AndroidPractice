# Java Basics for Android
In this section we will look at asynchronous code and interfaces. When building apps that require content from the internet, you often have to wait for requests to complete before things can continue. Since code runs very fast, this often causes issues where the code has already continued running while the request is done yet. The callback is a principle that takes care of this issue. To implement callbacks into your apps, the interface functionality of the Java language is used. 

## Table of contents
- [Concepts](#concepts)
	 * [Asynchronous code](#exceptions)
	 * [Interfaces](#try-catch)
- [Practice](#practice)
	 * [Exercises](#exercises)
- [Plain Java vs. Android Studio](#plain-java-vs.-android-studio)
     * ...

<a name="concepts"></a>

## Concepts

<a name="asynchronous-code"></a>

### Asynchronous code
When building your apps, code with different functionality is often spread over multiple files. Classes that take care of contacting an API or making another web request are not contained in the Activity, but have their own files. When a class in one of those files is working on a task that takes some time, we can of course wait until it is finished. If we stop all execution of code and wait, that works. However, this also means that the app will be unresponsive for the duration of that task. For this reason, Android Studio does not allow you to make network requests on the main thread, because that would mean the app freezes during these requests. It's not hard to imagine that using such an app would be very frustrating! 

However, if we can't just wait for the code to finish and then continue doing things on our main thread, we need to have a way to be notified that the time consuming task is done, so that we can then do something with the result.



<a name="interfaces"></a>

### Interfaces
When waiting for a response from the server or for some other task to finish, we need to have a way to communicate back to our activity that the task has finished. This becomes especially important with asynchronous code, because we cannot just continue running things in our Activity, we might need to wait for the other class to finish what we are doing before we want anything to happen. To do this effectively, we can make use of the `interface` functionality of the Java programming language.


<a name="practice"></a>

## Practice
...

<a name="practice"></a>

### Exercises
...