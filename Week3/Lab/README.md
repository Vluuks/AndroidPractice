# Java Basics for Android
 <img align="left" src="https://raw.githubusercontent.com/Vluuks/AndroidPractice/labified/Week3/Images/robotje-array-small.png" style="padding: 10px"> This week, we will focus on an important part of Android: the adapter. Android's `Adapter` class helps you translate lists of data to layout objects on the screen. Lists are everywhere in apps, the most classic example perhaps being an inbox.

To help you understand how it works, we will take a look at different kinds of arrays and lists in Java and then provide a very barebones example of what an adapter does in plain Java. This will help you understand the way the actual adapter class in Android Studio works. 


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

➡️ *Exercise 1.1:* *In `Student.java`, you will find the static method `Student.createSampleList()`, declare a new `ArrayList` that holds elements of type `Student`. Instantiate 5 sample objects of type `Student`.*

> The `ArrayList` class contains many methods to manipulate lists' contents. Refer to [the documentation](https://developer.android.com/reference/java/util/ArrayList) for a full overview of the available methods.

➡️ *Exercise 1.2:* *Once you have created `Student` objects, you can add these to the list. Use the docs to find a way to add the student objects to the `ArrayList`. Then, `return` the list.*

{% next %}

### Testing

The `AdapterTest` class contains testing code that should now work with the student class, if implemented correctly.

> Note the call of the static method `Student.createSampleList()`, which can be used anywhere in your program to generate the list.

➡️ *Exercise 1.3:* *Verify that the objects have been succesfully added by compiling and running `AdapterTest.java`.*

> We have used the `size()` method that comes with the `ArrayList` class.

➡️ *Exercise 1.4:* *For `ArrayList`s, you can't use indexing like `[0]` to retrieve items at a given position. Check the docs to find what **method** can be called instead to retrieve items like that. Try printing information about sample students.*

➡️ *Exercise 1.5:* *Also check the docs to find a way to do the reverse of indexing: how can you get the index of an item that should be in the list?*

{% next %}

### From list to layout
 <img align="right" src="https://raw.githubusercontent.com/Vluuks/AndroidPractice/labified/Week3/Images/robotje.png" style="padding: 10px"> In Android, you often want to display your lists of data in an appropriate way. Imagine a restaurant's menu, a list of contacts, a playlist in a video app... There are countless applications for lists that require some layout to display them in. 

This is where the `Adapter` class comes into play. In this lab, we use a simplified version of the adapter classes that comes with the Android platform.

An adapter's primary function is that it can take a list of data and formats it to display on the screen. In Android, the adapter makes sure that list views on screen are filled with appropriate information. In this lab, the adapter will be used by a `Printer` class that can print stuff to the screen.

We will not write that much new code ourselves, but mostly use existing functionality. This is in line with the idea that the Adapter provided by the Android API does already a lot of the work for us as well. However, sometimes code that is given to you can be complex and its purpose not clear at first glance. In such a case, it's important to look at every part of the code and think about what it does.

➡️ *Exercise 2.1:* *Look through the files `ArrayAdapter.java` and `Printer.java` to get an overview of their purpose.*

{% next %}

### From list to layout: ArrayAdapter and Formatter

The adapter class can be instantiated using the constructor, which creates the `ArrayAdapter` object. In this example, we created an adapter that can create a (very simple) graphical representation of `Student` objects, but many kinds of adapters are of course possible! 

➡️ *Exercise 2.2:* *Although the adapter class is given to you, it is not instantiated yet in our `AdapterTest`'s `main` method. Think about what the adapter needs to be instantiated and pass the correct parameters to it. Compile your code to verify that its syntax is correct*

{% next "Next: From list to layout: List printer" %}

### From list to layout: List printer

As mentioned before, the adapter is not used on its own, it is paired with a list printer. This list printer is in control how much room there is on the screen, or how many rows we actually want to show. On a screen with limited space, like a phone, you don't want to do unnecessary work, thus you only want to ask the adapter to do things for the items you have room for. We simulate this in the terminal by having a predetermined number of rows that we want to show. 

Because the printer class is in control of the amount of rows shown, it is also the one that is used to iterate over the items in the list inside the `setAdapter()` method. Once tihs method is called, the adapter actually takes effect, so to speak.

Through the instance of `ArrayAdapter`, it calls the `createRow()` method which then creates the "layout" using the strings defined in the `enum`. The method then uses the index it received from the printer class to get the right `Student` object out of the array. With this object, the correct data can be displayed in the row. This string representing the row is returned to the instance of `Printer` that called it, which then prints the result to the terminal.

➡️ *Exercise 2.3:* *There are no comments present in the `ArrayAdapter` and `Printer` class, add a header comment atop of the class and add comments to the methods inside as well. If you feel like certain lines of code warrant a comment, feel free to do so!*

➡️ *Exercise 2.4:* *Since the adapter is of no use without a `Printer`, you need to instantiate one from the `AdapterTest` class.*

➡️ *Exercise 2.5:* *Now that you have both instantiated the adapter class and the printer, you can connect them. Remember how to do this?*

{% next %}

### From list to layout: Everything together

The essential components of the above are:

- the `ArrayList` of `Student` objects, which is the data
- a `Printer` that is responsible for drawing on the screen, and which determines how many and which items are shown
- an `Adapter`, which generates the appropriate layout, but only for the items that are requested by the `Printer`

This is all very similar to what the actual adapter class does in Android Studio, as you will see later! 

➡️ *Exercise 2.6:* *Change the layout of the rows in the `createRow` method to see how easy it is to change the layout for all items at once.*

➡️ *Exercise 2.7:* *Instead of printing just the student's name, add another variable that is printed for every student as well.*

{% next %}

## Wrapping it up

The adapter sees a lot of use in various apps, not just in this course. A lot of apps use lists of items, whether horizontally, vertically or on a grid. The items shown in the adapter can contain all kinds of view: text, images, buttons, checkboxes, etc. Different variations of adapters exist, but the basic principles are the same. 

Adapters can be used to render lists of custom objects, like the `Student` object, which requires you to create a custom adapter class and define the contents of the method that generates each row. In this tutorial, we saw what an adapter and list printer do behind the scenes, using a plain Java example.

The tasks boil down to iterating over the list, which is handled by the list printer, and rendering the correct contents, which is handled by the adapter. The adapter and the printer are strongly connected, because the printer dictates what items need to be shown and thus what items should be created by the adapter. 

You are encouraged to discuss the purpose of the code with others (without completely spoiling the answer of course) and asking the TA's if in doubt! Adapters are a recurring topic in the course so a good understanding of them will go a long way!

This was Lab 3.
