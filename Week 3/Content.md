# Java Basics for Android
This week, we will focus on an important part of Android: the adapter. Android's `Adapter` class helps you translate lists of data to layout objects on the screen. To help you understand how it works, we will first take a look at different kinds of arrays and lists in Java and then provide a very barebones example of what an adapter does in plain Java. Finally, we will use this knowledge to use Android's actual `Adapter` class effectively. 

## Table of contents


<a name="concepts"></a>

## Concepts

<a name="arrays and lists"></a>

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

- `add(int index)` and `add(int index, Element e)` can be used to add an element to the end of the list, or at a specific index.
- `get(int index)` returns the element at the specified position in this list.
- `remove(int index)` removes the element at the specified position in this list.
- `size()` returns the number of elements in this list.
- `clear()` removes all elements from the list.
- `contains(Object o)` returns true if this list contains the specified element.
- `indexOf(Object o)` returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.

<a name="from list to layout"></a>

### From list to layout
In Android, you often want to display your lists of data in an appropriate way. Imagine a restaurant's menu, a list of contacts, a playlist in a video app... There are countless applications for lists that require some layout to display them in. 

This is where the `Adapter` class comes into play. Its prime functionality is that it can take in a list of data, either an array or `ArrayList` and usually some kind of layout definition, it then combines these two to generate the appropriate layout for each element in the list. 

Because the Android API `Adapter` class can be overwhelming at first glance, we have created a plain Java adapter that kind of does the same thing, but takes it down to the basics.

        class ArrayAdapter {
            
            private Student[] studentArray;
            private LayoutType layoutType;
            
            public ArrayAdapter(Student[] studentArray, LayoutType layoutType) {
                this.studentArray = studentArray;
                this.layoutType = layoutType;
            }
            
            public void start() {
                for (int i = 0; i < studentArray.length; i++) {
                    Student currentStudent = studentArray[i];
                    String currentRow = createRow(currentStudent);
                    System.out.println(currentRow);
                }
            }
            
            private String createRow(Student student) {

                String horizontalBorder, verticalBorder;

                switch(layoutType) {
                    case DASH:
                        horizontalBorder = "\n---------------------\n";
                        verticalBorder = "|";
                        break;
                    case CIRCLE:
                        horizontalBorder = "\no 0 o 0 o 0 o 0 o 0 o\n";
                        verticalBorder = "0";
                        break;
                    case STAR:
                        horizontalBorder = "\n*********************\n";
                        verticalBorder = "*";
                        break;
                    default:
                        horizontalBorder = "\n---------------------\n";
                        verticalBorder = "|";
                        break;
                }

                return horizontalBorder + verticalBorder + " " + student.getName() + " " + horizontalBorder;

            }
        }

The class above can be instantiated using the constructor, which creates the `ArrayAdapter` object. After that, we can call `start()` to start iterating over the entries of the list we supplied to the constructor earlier. In this example, we created a list of `Student` objects. During this iteration, the `createRow()` method will be called for each entry in the list, with that specific entry as its argument. This method then creates the "layout" in this case just a multiline string, and adds the correct data. 

What is essential is that there is some kind of information on what the layout should look like (what kind of border to use), and there is a list (the student objects). This information is then combined by the adapter, which iterates over the list and generates the appropriate layout  for every item. In essence, this is all very similar to what the actual adapter class does in Android Studio. But more on that later!

<a name="practice"></a>

## Practice

<a name="exercise"></a>

### Exercise

1. comment elke method
2. maak een lijst met dummy data, maak de adapter aan en activeer deze


## Adapter in Android Studio
Now that we have seen what an adapter is supposed to do, we can take a look at the `ArrayAdapter` class in Android studio! You can create one yourself by generating a new Java file and choosing `ArrayAdapter` as its superclass. This should leave you with an empty class file.

        public class StudentAdapter extends ArrayAdapter {

        }

A lot of functionality is already there for you, so you do not need to do everything. Because of this we can extend `ArrayAdapter`. This will leave us with some things to take care of: we need to be able to instantiate our adapter and we need to define what should be rendered for every entry in our list. 

### Adding the constructor
Our class does not have a constructor yet, which is the first thing we need. So hit `CTRL+O` (Windows) or [MAC SNELTOETS] to open the override dialog and choose the constructor that takes the following three arguments: the context, a resource id, and a list of objects. It should look like this once overridden:

        public StudentAdapter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
        }

- `@NonNull Context context` The context contains information about the global application environment. This part is very Android specific and we haven't seen it in our Java example. However, it is not adapter-specific and is used for a lot of things in the Android platform so you will often see it. A lot of classes need a reference to the context to function properly.

- `int resource` The resource id refers to a layout file so that the adapter knows what template to use to create the appropriate layout for each list entry. Remember how in the plain Java example, we told the adapter what kind of border we wanted? Instead of just defining what border string to print, we can do much more layout wise in Android! This resource id will refer to an XML file that will contain information on what each row in the list should look like. 

- `@NonNull List objects` Finally, the constructor requires the list that we want the adapter to work with. An adapter can actually be called on an empty list without problems (in that case, it will simply not show anything), but the list itself must of course exist: it can't be null. Because objects of the  `List` type can hold both `ArrayList` and `LinkedList`, you are not forced to change the type to `ArrayList`, even if you pass one as an argument to the constructor. 

> Most adapter classes have many different constructors. They also have variations that take a regular array as an argument instead of a `List`. In this explanation we focus on this particular constructor but it goes without saying that different circumstances might require a different constructor.

### Specifing the layout
As specified before, the constructor needs a reference to a resource id before the adapter can be created. We can define an XML that determines what it looks like, just like activities have layout files. However, whereas the activity layout is used once, the layout we define for the row is reused as many times as there are items in the list. We can add a new layout file by going to the `layout` directory and through right click `new > layout resource file` a layout XML file can be added.

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

