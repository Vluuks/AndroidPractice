# Java Basics for Android
In this section we will look at asynchronous code and interfaces. When building apps that require content from the internet, you often have to wait for requests to complete before things can continue. Since code runs very fast, this often causes issues where the code has already continued running while the request is done yet. The callback is a principle that takes care of this issue. To implement callbacks into your apps, the interface functionality of the Java language is used. 

## Table of contents
- [Concepts](#concepts)
	 * [Asynchronous code](#asynchronous-code)
	 * [Interfaces](#interfaces)
	 * [Interface syntax](#interface-syntax)
- [Practice](#practice)
	 * [Exercises](#exercises)
- [Plain Java vs. Android Studio](#plain-java-vs.-android-studio)
     * ...

<a name="concepts"></a>

## Concepts

<a name="asynchronous-code"></a>

### Asynchronous code

![Image showing sequential and one threaded execution of tasks, from 1 to 6. The image is accompanied by a horizontal line representing time passed.](async1.png)

In the image above we first see a regular set of tasks that the computer executes sequentially. There is no problem when these things do not take extra time, like adding numbers together.

The second example shows us that task 3 is taking extra time to complete, because for example it performs a network request to download some information off the internet:

![Image showing sequential and one threaded execution of tasks, from 1 to 6. 3 is a task that takes time, like a network request, so the time it takes to execute everything is greatly increased.](async2.png)

If we wanted to keep everything one one thread, we would have to wait for it to complete before continuing, especially if some task at a later point in time is dependent on the information acquired during task 3. This renders the program unresponsive for the time it takes for 3 to complete, because no other tasks can be executed: progress has stalled.

The last example shows us the effects of asynchronous code. 

![Image showing one threaded execution of tasks, from 1 to 6. 3 still takes extra time, but is not executed asynchronously.](async3.png)

While task 3 is started and still in progress, task 4, 5 and 6 are started in sequence, even though task 3 has not finished yet! This has different implications:

- It is faster, because tasks after task 3 do not have to wait for its completion if they are independent of it. Because of this the program is not unresponsive during the wait for 3.

- However, tasks that are dependent on task 3 cannot be called in sequence after starting task 3 (like in example 2), because there is no way of knowing whether task 3 has finished yet.

Asynchronous code can greatly boost efficiency of things, but it adds a layer of difficulty as well, because you have to be aware of the duration of tasks and the dependency of other tasks on them. If task 4 were dependent on 3, then the third example it would fail, because task 4 is started before task 3 has acquired the appropriate data.

To benefit from continuing the regular program flow and still know when to call 4 as soon as task 3 is done, we can use a concept called the *callback*. A callback is used to inform the program that a certain task that was running has finished. 

In the last example, we would create a callback inside task 3, so that when it is finished, it can notify the other tasks that depend on it, like task 4. This allows tasks 5 and 6 to be executed without having to wait for 3 if there is time to do so, but prevents task 4 from failing because task 3 is not done yet. 

In this example, there is time to start and finish 5, but then the callback of 3 is triggered, signaling that 3 has finished and thus 4 can start. 4 is then run. 

![Image showing the sequence of tasks, indicating that when 3 finishes its time consuming task, it invokes a callback that indicates that task 4 can now be started.](callback.png)

Of course, in practice not everything happens on one thread like pictured here. Applications often utilize multiple threads so this example is greatly simplified. It just serves to illustrate the concept of a callback method and how it can be used to invoke methods that are dependent on another method that runs asynchronously. 


<a name="interfaces"></a>

### Interfaces
When building your apps, code with different functionality is often spread over multiple files. Classes that take care of contacting an API or making another web request are not contained in the Activity, but have their own files. When a class in one of those files is working on a task that takes some time, we can of course wait until it is finished. 

If we stop all execution of code and wait, that works. However, this also means that the app will be unresponsive for the duration of that task. For this reason, Android Studio does not allow you to make network requests on the main thread, because that would mean the app freezes during these requests. It's not hard to imagine that using such an app would be very frustrating! 

When waiting for a response from the server or for some other task to finish, we need to have a way to communicate back to our activity that the task has finished. This becomes especially important with asynchronous code, because we cannot just continue running things in our Activity that are dependent on our network request, we might need to wait for the other class to finish what we are doing before we want anything to happen. 

Imagine you want to show a list of movies obtained from IMDB in a ListView. You cannot do that until the network request downloading said list has finished. So any code that sets or updates the adapter needs to wait for the request and only fire once the request has completed succesfully and we have our list of data.

However, we don't want all our functionality to reside in the Activity, but separate in classes with each their own responsibility. This meanst that there needs to be a way to invoke a method in the Activity from inside some other class. In the example below there is an activity, `CategoriesActivity` that uses the helper class `CategoriesRequest` to perform a network request. Then, when this is done, depending on whether it was succesful or not, this class performs a callback. It invokes either `gotCategories()` (the data was retrieved) or `gotCategoriesError()` (something failed, like the internet stopped working or there was no response from the server). 

![UML depiction of one activity and class and respective methods, showing that when the helper class is done with a particular task, it invokes the callback and code in the Activity that was dependent on the task can be executed now.](callback-uml.png)

When the callback `gotCategories()` is performed, we can now be sure that the appropriate data is there and continue running code as necessary.

To do this communication between Activity classes and other classes effectively, we can make use of the `interface` functionality of the Java programming language.

<a name="interface-syntax"></a>

### Interface syntax

...

<a name="practice"></a>

## Practice
...

Activity en Java class simuleren? Interface ook gebruiken voor multiple inheritance of alleen callback achtig?

MainActivity achtige class, helperclass die iets doet, dat duurt lang, dan callback naar main class wanneer het klaar is. Gewoon met timer ofzo simuleren dat het lang duurt? Gaat meer om het idee. Dan op basis van die timer een andere method aanroepen. Eerst laten zien dat als je het gewoon onder elkaar zit het niet op elkaar wacht als het async is. Even kijken hoe ik dat moet simuleren in plain java.

Zelf interface laten schrijven en extend etc.

<a name="practice"></a>

### Exercises
...