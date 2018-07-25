# Java Basics for Android
This week, we will focus on an important part of Android: the adapter. Android's `Adapter` class helps you translate lists of data to layout objects on the screen. To help you understand how it works, we will first take a look at different kinds of arrays and lists in Java and then provide a very barebones example of what an adapter does in plain Java. Finally, we will use this knowledge to use Android's actual `Adapter` class effectively. 

## Table of contents
- [Concepts](#concepts)
	 * [Arrays and lists](#arrays-lists)
	 * [From list to layout](#list-layout)
- [Practice](#practice)
	 * [Exercise](#exercise)
- [Plain Java vs Android Studio](#java-vs-android)
     * [Adapter in Android Studio](#adapter-android)
	 * [Adding the constructor](#adding-constructor)
	 * [Specifying the layout](#layout)
	 * [Dynamic content](#dynamic-content)

<a name="concepts"></a>

## Concepts

<a name="arrays-lists"></a>

### Arrays and lists

While programming applications, you often have to represent lists of data. In Java, there are different ways to do this. We will discuss the array and the list. A regular array can be used to store a fixed number of elements. This means that upon declaring it, you must specify the amount of elements:

        int[] intArray = new int[10];
        String[] stringArray = new String[10]

The line of code above creates an array that has space for 10 integers and another array that has space for 10 strings. Because the array's size cannot be changed, we would have to reinitialize the array if we wanted to have 11 elements, for example. 

To solve this problem and also allow for easier modification of the array's contents (adding/removing/sorting elements for example) the `ArrayList` exists. It functions as a dynamically re-sizing array. It allows you to add or remove elements at specific indices or just the end. 

For most operations using lists of data that require you to have a dynamically resizable list, `ArrayList` is the way to go. Its main strength is that it is fast to read data at specific indices. To initialize an `ArrayList` you can use the following syntax:

        ArrayList<Integer> integerList = new ArrayList<String>();
        ArrayList<String> stringList = new ArrayList<String>(20);

The type between the `<>` tells the compiler what the type of the elements you want to store in the list is. This can be a type such as `String`, but also a custom object such as `Student`. If practical, you can also specify the initial size of your `ArrayList`. However since it can be dynamically resized, you are free to add extra elements at any point!

> While you can declare regular arrays with primitive types such as `int` and `boolean`, the `List` interface requires you to use their respective wrapper classes `Integer` and `Boolean`. All primitive types have such a wrapper class, should you need it.

The class contains many functionalities. Below is a list of ones that will be used throughout this course, but it is by no means exhaustive! Refer to [the documentation](https://developer.android.com/reference/java/util/ArrayList) for a full overview of the available methods. 

- `add(Element e)` and `add(int index, Element e)` can be used to add an element to the end of the list, or at a specific index.
- `get(int index)` returns the element at the specified position in this list.
- `remove(int index)` removes the element at the specified position in this list.
- `size()` returns the number of elements in this list.
- `clear()` removes all elements from the list.
- `contains(Object o)` returns true if this list contains the specified element.
- `indexOf(Object o)` returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.

<a name="list-layout"></a>

### From list to layout
In Android, you often want to display your lists of data in an appropriate way. Imagine a restaurant's menu, a list of contacts, a playlist in a video app... There are countless applications for lists that require some layout to display them in. 

This is where the `Adapter` class comes into play. Because the Android API `Adapter` class can be overwhelming at first glance, we have created a plain Java adapter that kind of does the same thing, but takes it down to the basics.  Its prime functionality is that it can take in a list of data, either a regular array or an `ArrayList` and usually some kind of layout definition. 

It then combines these two to generate the appropriate layout for each element in the list. This layout is then shown in a container of some sort. In this example we just use the terminal, but we have still constructed a container class to represent the idea of a container.

The adapter class can be instantiated using the constructor, which creates the `ArrayAdapter` object. In this example, we created an adapter that can create a (very simple) graphical representation of `Student` objects, but many kinds of adapters are of course possible! 

        class ArrayAdapter {
            
            private Student[] studentArray;
            private LayoutType layoutType;
            
            public ArrayAdapter(Student[] studentArray, LayoutType layoutType) {
                this.studentArray = studentArray;
                this.layoutType = layoutType;
            }
            
            public String createRow(int index) {

                String row;
                String horizontalBorder, verticalBorder;
                
                Student currentStudent = studentArray[index];

                horizontalBorder = layoutType.horizontalBorder;
                verticalBorder = layoutType.verticalBorder;

                row = horizontalBorder + verticalBorder + " " + currentStudent.getName() + " " + horizontalBorder;
                return row;
            }
            
            public int getItemCount() {
                return studentArray.length;
            }
        }

The following enum contains the information about the layout. It does not much, except determine that certain string patterns belong with a certain name. This avoids having to define the options as constants elsewhere in the code and keeps everything layout related neatly together.

        enum LayoutType {
            DASH("\n---------------------\n", "|"), 
            CIRCLE("\no 0 o 0 o 0 o 0 o 0 o\n", "0"), 
            STAR("\n*********************\n", "*");
            
            String horizontalBorder, verticalBorder;
            
            // Constructor
            private LayoutType(String horizontalBorder, String verticalBorder) {
                this.horizontalBorder = horizontalBorder;
                this.verticalBorder = verticalBorder;
            }
        }

As mentioned before, the adapter is not used on its own, it is paired with a list container. This list container is in control how much room there is on the screen, or how many rows we actually want to show. On a screen with limited space, like a phone, you don't want to do unnecessary work, thus you only want to ask the adapter to do things for the items you have room for. We simulate this in the terminal by having a predetermined number of rows that we want to show. 

        class ListContainer {
            
            private int rowsToShow;

            public ListContainer(int rowsToShow) {
                this.rowsToShow = rowsToShow;
            }
            
            public void setAdapter(ArrayAdapter adapter) {
                for (int i = 0; i < Math.min(adapter.getItemCount(), rowsToShow); i++) {
                    String currentRow = adapter.createRow(i);
                    System.out.println(currentRow);
                }
            }
        }

Because the container class is in control of the amount of rows shown, it is also the one that is used to iterate over the items in the list inside the `setAdapter()` method. 

Through the instance of `ArrayAdapter`, it calls the `createRow()` method which then creates the "layout" using the strings defined in the `enum`. The method then uses the index it received from the container class to get the right `Student` object out of the array. With this object, the correct data can be displayed in the row. This string representing the row is returned to the instance of `ListContainer` that called it, which then prints the result to the terminal.

What is essential is that there is some kind of information on what the layout should look like (what kind of border to use), and there is a list (the student objects). To determine how many elements are shown, there is also a container. This information is then combined, having the container determine what index should be rendered, which is then passed on to the adapter, which generates the appropriate layout for every item. 

This is all very similar to what the actual adapter class does in Android Studio. But more on that later!

<a name="practice"></a>

## Practice

This time we will not write that much new code ourselves, but mostly use existing functionality. This is in line with the idea that the Adapter provided by the Android API does already a lot of the work for us as well. However, sometimes code that is given to you can be complex and its purpose not clear at first glance. In such a case, it's important to look at every part of the code and think about what it does.

<a name="exercise"></a>

### Exercise

[Get this file](AdapterTest.java) and read through the code in the adapter class carefully. As you can see, it has not been commented. 

1. Add a header comment to each of the three adapter-related classes explaining their purpose. Also add header comments to the methods inside the classes. If you think some lines of code are in need of extra explanation, comment those as well. 

You are encouraged to discuss the purpose of the code with others (without completely spoiling the answer of course) and asking the TA's if in doubt! Adapters are a recurring topic in the course so a good understanding of them will go a long way!

2. Although the adapter class is given to you, it is not called yet in our plain Java example. Think about what the adapter needs to be instantiated and pass the correct parameters to it. Since the adapter goes together with the `ListContainer`, you need to instantiate this one as well. After instantiating both, call `setAdapter()`.

3. Reset the adapter, but with a different `enum` as a parameter. What happens when you do this?

4. Instead of printing just the student's name, add another variable that is printed for every student as well. You can also add another layout variation to the `enum`, if you wish.

<a name="java-vs-android"></a>

## Plain Java vs Android Studio

<a name="adapter-android"></a>

### Adapter in Android Studio

Now that we have seen what an adapter is supposed to do, we can take a look at the `ArrayAdapter` class in Android studio! You can create one yourself by generating a new Java file. You can do this while reading this guide, but you are not required to. There will be examples provided in this text where necessary.

![An image depicting the menu in Android studio allowing users to enter a class name and select a superclass. The currently selected superclass is ArrayAdapter.](adapter-superclass.png)

Because we use the Android API and not just plain Java, a lot of functionality is already there for you, so you do not need to do everything. Because of this we can choose to extend the class `ArrayAdapter` by entering this class as our superclass. If you start typing `ArrayAdapter` Android will only show you the available superclasses that match this search. This should leave you with an empty class file.

        public class StudentAdapter extends ArrayAdapter {

        }

This will leave us with some things to take care of: we need to be able to instantiate our adapter and we need to define what should be rendered for every entry in our list. This is similar to the functionalities of the plain Java adapter class, which also had some representation of a layout (the `enum`)

<a name="adding-constructor"></a>

### Adding the constructor
Our class does not have a constructor yet, which is the first thing we need. Just like in the Java example, we need a way to instantiate our `StudentAdapter` class. So hit `CTRL+O` (Windows) or [MAC SNELTOETS] to open the override dialog and choose the constructor that takes the following three arguments: the context, a resource id, and a list of objects. It should look like this once overridden:

        public StudentAdapter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
        }

- `@NonNull Context context` The context contains information about the global application environment. This part is very Android specific and we haven't seen it in our Java example. However, it is not adapter-specific and is used for a lot of things in the Android platform so you will often see it. A lot of classes need a reference to the context to function properly. Needless to say, it can't be null.

- `int resource` The resource id refers to a layout file so that the adapter knows what template to use to create the appropriate layout for each list entry. Remember how in the plain Java example, we told the adapter what kind of border we wanted? Instead of just defining what border string to print, we can do much more layout wise in Android! This resource id will refer to an XML file that will contain information on what each row in the list should look like. 

- `@NonNull List objects` Finally, the constructor requires the list that we want the adapter to work with. An adapter can actually be called on an empty list without problems (in that case, it will simply not show anything), but the list itself must of course exist: it can't be null. Because objects of the  `List` type can hold both `ArrayList` and `LinkedList`, you are not forced to change the type to `ArrayList`, even if you pass one as an argument to the constructor. 

> Most adapter classes have many different constructors. They also have variations that take a regular array as an argument instead of a `List`. In this explanation we focus on this particular constructor but it goes without saying that different circumstances might require a different constructor.

<a name="layout"></a>

### Specifying the layout
As specified before, the constructor needs a reference to a resource id before the adapter can be created. We can define an XML that determines what it looks like, just like activities have layout files. However, whereas the activity layout is used once, the layout we define for the row is reused as many times as there are items in the list. We can add a new layout file by going to the `layout` directory and through right click `New > Layout resource file` a layout XML file can be added.

This XML is the blueprint that will be used to construct the layout/row for every item, so if we just want to show the student name and student number, we could for example define a very simple layout with two `TextView` elements:

        <?xml version="1.0" encoding="utf-8"?>
        <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
            android:orientation="vertical" android:layout_width="match_parent"
            android:layout_height="match_parent">

            <TextView
                android:id="@+id/tvStudentName"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="TextView" />

            <TextView
                android:id="@+id/tvStudentNumber"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="TextView" />
        </LinearLayout>

We can later access these layout elements in our adapter class, so that we can dynamically generate the content that should go into these `TextView` elements as we iterate through our list. Any static things that you (probably) want to be the same for every entry in your list can best be defined here, like for example margins, font size and padding. 


<a name="dynamic-content"></a>

### Dynamic content
... TODO

