# Java Basics for Android
 <img align="left" src="https://raw.githubusercontent.com/Vluuks/AndroidPractice/labified/Week3/Images/robotje-array-small.png" style="padding: 10px"> This week, we will focus on an important part of Android: the adapter. Android's `Adapter` class helps you translate lists of data to layout objects on the screen. Lists are everywhere in apps, the most classic example perhaps being an inbox.

To help you understand how it works, we will first take a look at different kinds of arrays and lists in Java and then provide a very barebones example of what an adapter does in plain Java. Finally, we will use this knowledge to use Android's actual `Adapter` class effectively and practice with this as well.

## Table of Contents
This week's practice content consists of the following parts:

Introduction
 - Regular Arrays
 - ArrayList

Creating a ListAdapter
 - From list to layout
 - From list to layout: ArrayAdapter and LayoutType
 - From list to layout: List container
 - From list to layout: Everything together
<br>
<br>
<br>

{% next "Next: Arrays and lists" %}
### Regular arrays
While programming applications, you often have to represent lists of data. In Java, there are different ways to do this. We will discuss the array and the list. A regular array can be used to store a fixed number of elements. This means that upon declaring it, you must specify the amount of elements:

```java
int[] intArray = new int[10];
String[] stringArray = new String[10]
```

The line of code above creates an array that has space for 10 integers and another array that has space for 10 strings. Because the array's size cannot be changed, we would have to re-create the array if we wanted to add an 11th element.


{% next "Next: ArrayList" %}
### ArrayList
To solve this problem and also allow for easier modification of the array's contents (adding/removing/sorting elements for example) the `ArrayList` exists. It functions as a dynamically re-sizing array. It allows you to add or remove elements at specific indices or just the end. For most operations using lists of data that require you to have a dynamically resizable list, `ArrayList` is the way to go. Its main strength is that it is fast to read data at specific indices. To initialize an `ArrayList` you can use the following syntax:
```java
ArrayList<Integer> integerList = new ArrayList<String>();
ArrayList<String> stringList = new ArrayList<String>(20);
```
The type between the `<>` tells the compiler what the type of the elements you want to store in the list is. This can be a type such as `String`, but also a custom class such as `Student`. If practical, you can also specify the initial size of your `ArrayList`. However, since it can be dynamically resized, you are free to add extra elements at any point!

> Note: while you can declare regular arrays with primitive types such as `int` and `boolean`, the `List` interface requires you to use their respective wrapper classes `Integer` and `Boolean`. All primitive types have such a wrapper class, should you need it.

➡️ *Exercise 1.1:* *In the class `ArrayListTest` (but outside the main method!), declare a new `public static` `ArrayList` that holds elements of type `Student`.*

The `ArrayList` class contains many functionalities. Refer to [the documentation](https://developer.android.com/reference/java/util/ArrayList) for a full overview of the available methods. 

➡️ *Exercise 1.2:* *Once you have created some student objects, you can add these to the list. Use the documentation to find a way to add the student objects to the `ArrayList`.*

➡️ *Exercise 1.3:* *Verify that the objects have been succesfully added by using the `size()` method.*

➡️ *Exercise 1.4:* *Use the documentation and find a way to discover the exact index where the object `c` resides.*

{% spoiler "Reminder: Compiling and running Java code" %}
To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName

You can print things to the terminal with:

        System.out.println();

{% endspoiler %}

{% next "Next: From list to layout - part 1" %}
### From list to layout
 <img align="right" src="https://raw.githubusercontent.com/Vluuks/AndroidPractice/labified/Week3/Images/robotje.png" style="padding: 10px"> In Android, you often want to display your lists of data in an appropriate way. Imagine a restaurant's menu, a list of contacts, a playlist in a video app... There are countless applications for lists that require some layout to display them in. 

This is where the `Adapter` class comes into play. Because the Android API `Adapter` class can be overwhelming at first glance, we have created a plain Java adapter that kind of does the same thing, but takes it down to the basics. 

Its prime functionality is that it can take in a list of data, either a regular array or an `ArrayList` and usually some kind of layout definition, represented by `LayoutType`. It then combines these two to generate the appropriate layout for each element in the list. This layout is then shown in a container of some sort, `ListContainer`. 

![](adapter-example.png)

In this example we just use the terminal for the visual representation, but we have still constructed a container class to represent the idea of a container. This time we will not write that much new code ourselves, but mostly use existing functionality. This is in line with the idea that the Adapter provided by the Android API does already a lot of the work for us as well. However, sometimes code that is given to you can be complex and its purpose not clear at first glance. In such a case, it's important to look at every part of the code and think about what it does.

➡️ *Exercise 2.1:* *Look through the files `AdapterTest.java`, `ArrayAdapter.java`, `LayoutType.java` and `ListContainer.java` to get an overview of their purpose.*

{% next "Next: From list to layout: ArrayAdapter and LayoutType" %}
### From list to layout: ArrayAdapter and LayoutType
The adapter class can be instantiated using the constructor, which creates the `ArrayAdapter` object. In this example, we created an adapter that can create a (very simple) graphical representation of `Student` objects, but many kinds of adapters are of course possible! 

The enum `LayoutType` contains the information about the layout. It does not much, except determine that certain string patterns belong with a certain name. This avoids having to define the options as constants elsewhere in the code and keeps everything layout related neatly together.

Furthermore, we have reused the list previously created in `ArrayListTest`. Notice how we can access it from this class as well, without instantiating `ArrayListTest` because it is `static`? The same goes for the `main` method as well. 

➡️ *Exercise 2.2:* *Although the adapter class is given to you, it is not instantiated yet in our `AdapterTest`'s `main` method. Think about what the adapter needs to be instantiated and pass the correct parameters to it. Compile your code to verify that its syntax is correct*

{% spoiler "Hint: Compiling and running Java code" %}
To compile your Java file to a .class file, use this command on the terminal:

        javac YourJavaFileName.java

After compilation, you can run your program using:

        java YourJavaFileName
{% endspoiler %}

{% next "Next: From list to layout: List container" %}
### From list to layout: List container
As mentioned before, the adapter is not used on its own, it is paired with a list container. This list container is in control how much room there is on the screen, or how many rows we actually want to show. On a screen with limited space, like a phone, you don't want to do unnecessary work, thus you only want to ask the adapter to do things for the items you have room for. We simulate this in the terminal by having a predetermined number of rows that we want to show. 

Because the container class is in control of the amount of rows shown, it is also the one that is used to iterate over the items in the list inside the `setAdapter()` method. Once tihs method is called, the adapter actually takes effect, so to speak.

Through the instance of `ArrayAdapter`, it calls the `createRow()` method which then creates the "layout" using the strings defined in the `enum`. The method then uses the index it received from the container class to get the right `Student` object out of the array. With this object, the correct data can be displayed in the row. This string representing the row is returned to the instance of `ListContainer` that called it, which then prints the result to the terminal.

➡️ *Exercise 2.3:* *There are no comments present in the `ArrayAdapter` and `ListContainer` class, add a header comment atop of the class and add comments to the methods inside as well. If you feel like certain lines of code warrant a comment, feel free to do so!*

➡️ *Exercise 2.4:* *Since the adapter requires the presence of a `ListContainer`, you need to instantiate this one as well.*

➡️ *Exercise 2.5:* *Now that you have both instantiated the adapter class and the container, you can combine these two to set the adapter. Remember how to do this?*

{% next "Next: From list to layout: Everything together" %}
### From list to layout: Everything together
What is essential is that there is some kind of information on what the layout should look like (what kind of border to use), and there is a list (the student objects). To determine how many elements are shown, there is also a container. This information is then combined, having the container determine what index should be rendered, which is then passed on to the adapter, which generates the appropriate layout for every item. 

This is all very similar to what the actual adapter class does in Android Studio, as you will see later! 

➡️ *Exercise 2.6:* *Recreate and reset the adapter on the list container, but with a different `enum` as a parameter. What happens when you do this?*

➡️ *Exercise 2.7:* *Instead of printing just the student's name, add another variable that is printed for every student as well. You can also add another layout variation to the `enum`, if you wish.*

{% next "Next: wrapping it up" %}
## Wrapping it up
The adapter sees a lot of use in various apps, not just in this course. A lot of apps use lists of items, whether horizontally, vertically or on a grid. The items shown in the adapter can contain all kinds of view: text, images, buttons, checkboxes, etc. Different variations of adapters exist, but the basic principles are the same. 

Adapters can be used to render lists of custom objects, like the `Student` object, which requires you to create your custom adapter class and define the contents of the method that generates each row. In this tutorial, we saw what an adapter and list container do behind the scenes, using a plain Java example. 

The tasks boil down to iterating over the list, which is handled by the list container, and rendering the correct contents, which is handled by the adapter. The adapter and the container are strongly connected, because the container dictates what items need to be shown and thus what items should be created by the adapter. 

You are encouraged to discuss the purpose of the code with others (without completely spoiling the answer of course) and asking the TA's if in doubt! Adapters are a recurring topic in the course so a good understanding of them will go a long way!

