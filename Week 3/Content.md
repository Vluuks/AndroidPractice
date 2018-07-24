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