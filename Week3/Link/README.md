## Plain Java vs Android Studio

<a name="adapter-android"></a>

### Adapter in Android Studio

Now that we have seen what an adapter is supposed to do, we can take a look at the `ArrayAdapter` class in Android studio! You can create one yourself by generating a new Java file. You can do this while reading this guide, but you are not required to. There will be examples provided in this text where necessary.

![An image depicting the menu in Android studio allowing users to enter a class name and select a superclass. The currently selected superclass is ArrayAdapter.](adapter-superclass.png)

Because we use the Android API and not just plain Java, a lot of functionality is already there for you, so you do not need to do everything. Because of this we can choose to extend the class `ArrayAdapter` by entering this class as our superclass. If you start typing `ArrayAdapter` Android will only show you the available superclasses that match this search. This should leave you with an empty class file.

        public class StudentAdapter extends ArrayAdapter {

        }

This will leave us with some things to take care of: we need to be able to instantiate our adapter and we need to define what should be rendered for every entry in our list. This is similar to the functionalities of the plain Java adapter class, which also had some representation of a layout (the `enum`) and of course a constructor.

Like with our plain Java class, the actual iteration is handled behind the scenes. In the plain Java example, the `ListContainer` class handled making calls to the adapter's `createRow()` method. In Android, the iteration is handled by the list container as well. This means that there is no need to iterate over your list inside the adapter class.  

<a name="adding-constructor"></a>

### Adding the constructor
Our class does not have a constructor yet, which is the first thing we need. Just like in the Java example, we need a way to instantiate our `StudentAdapter` class. So hit `CTRL+O` (Windows) or [MAC SNELTOETS] to open the override dialog and choose the constructor that takes the following three arguments: the context, a resource id, and a list of objects. It should look like this once overridden:

        public StudentAdapter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
        }

- `@NonNull Context context` The context contains information about the global application environment. This part is very Android specific and we haven't seen it in our Java example. However, it is not adapter-specific and is used for a lot of things in the Android platform so you will often see it. A lot of classes need a reference to the context to function properly. Needless to say, it can't be null.

- `int resource` The resource id refers to a layout file so that the adapter knows what template to use to create the appropriate layout for each list entry. Remember how in the plain Java example, we told the adapter what kind of border we wanted? Instead of just defining what border string to print, we can do much more layout wise in Android! This resource id will refer to an XML file that will contain information on what each row in the list should look like. 

- `@NonNull List objects` Finally, the constructor requires the list that we want the adapter to work with. An adapter can actually be called on an empty list without problems (in that case, it will simply not show anything), but the list itself must of course exist: it can't be null. Because objects of the  `List` type can hold both `ArrayList` and `LinkedList`, you are not forced to change the type to `ArrayList`, even if you pass one as an argument to the constructor. 

> Most adapter classes have many different constructors. They also have variations that take a regular array as an argument instead of a `List`. In this explanation we focus on this particular constructor, but it goes without saying that different circumstances might require a different constructor.

<a name="layout"></a>

### Specifying the layout
As specified before, the constructor needs a reference to a resource id before the adapter can be created. We can define an XML that determines what it looks like, just like activities have layout files. However, whereas the activity layout is used once, the layout we define for the row is reused as many times as there are items in the list. We can add a new layout file by going to the `layout` directory and through right click `New > Layout resource file` a layout XML file can be added. Let's assume we called it `row_layout.xml`.

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
Of course we also want our adapter to render dynamic content for us (which is the whole point of an adapter). The adapter class contains a method  `getView()` which is called for the items in the list that need to be rendered (i.e. will need to have a `View` created for them). 

This means that if there are 10 items visible on the screen, the method will be called 10 times. If you were scroll down slightly, it would need to be called again to show the new item appearing at the bottom of the screen.

The method `getView()` takes a few arguments, all of which will be explained:

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            
            return super.getView(position, convertView, parent);
        }

- `int position` refers to the list index of the item that needs to be shown. This means that you can use this integer to grab the correct item from your list, in order to display the properties of that item, for example.

- `@Nullable View convertView` refers to a View object that is reusable. When scrolling, it is not necessary to reinflate complete views if they look similar and only the text inside changes, for example. The `convertView` allows for reuse of existing views, thus improving performance (see the image below)! This `convertView` can be null, however (hence the tag `@Nullable`, because in some cases (like the first time the adapter renders), there is no `View` object to reuse.

    ![An image depicting the reuse of views in an adapter.](adapter-recycling.png)

- `@NonNull ViewGroup parent` the parent refers to the encapsulating layout that a view should be contained in. This can for example be the `ListView` used to display the items. 

Using these arguments the most common way to set up the `getView()` method is:

1. Check whether there is a `convertView` to reuse.

2. If not, inflate a new `View` object using a layout XML. Remember the XML we defined a few steps earlier? This is where we inflate it. 

3. Use the position to grab the correct item from the list. The list that was passed in the constructor (in this case called `objects`) should of course have class wide scope for this to work. Due to the unspecified contents of the `objects` list, we need to explicitly cast the result from `get()` back to a `Student` object before it can be stored inside a variable of the type `Student`. 

4. Find the right layout elements inside the `convertView` and adjust them accordingly. In this case we want to display the name and student number. 

5. Return the generated and adjusted `View` object.

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            
            // A new view must be inflated
            if(convertView == null) {
               convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
            }

            // Access the right student in the list
            Student currentStudent = (Student) objects.get(position);

            // Make changes to the convertView, such as displaying a certain text
            TextView studentName = convertView.findViewById(R.id.tvStudentName);
            TextView studentNumber = convertView.findViewById(R.id.tvStudentNumber);

            studentName.setText(currentStudent.getName());
            studentNumber.setText(Integer.toString(currentStudent.getStudentNumber());

            return convertView;

        }

Notice that we return the altered `convertView`? Using this method, we now made sure that the name and student number of the students will be displayed inside the view. The contents are dynamically altered based on what item of the list is to be rendered, thanks to the position parameter that is passed as an argument. 

> Notice the `Integer.toString()` call? Due to [method overloading](https://beginnersbook.com/2013/05/method-overloading/), calling `setText()` with an integer as its parameter does something different. It searches for the resource with that integer id. Thus if you want to set a specific number as the text, you will need to convert it to a `String` first!



<a name="setup"></a>

### Setting everything up
Now that the adapter has been defined and the methods inside as well, we can couple it with a list container. This, again, is similar to the plain Java example. The container is initialized at some point, then the adapter is created using its constructor. Finally, the adapter is passed to the container.

        StudentAdapter adapter = new StudentAdapter(this, R.layout.row_item, studentList);
        listView.setAdapter(adapter);

If you do not set your adapter on the container, nothing will happen on the screen yet. The actual rendering of list items only starts once the adapter is connected to the container using `setAdapter()`. 


<a name="practice"></a>

## Practice

This time we will also practice with code in Android Studio, to try and make the principles of the adapter more clear. Grab the following files and insert them into the appropriate folders, `java` and `res/layout` of a new Android Studio project. MainActivity and the associated layout will have to replace the default generated ones. Don't forget to adjust the package atop each file to your own package. This package is usually your username on the PC and the name of your project. If in doubt just create a new empty Java file which generates it for you atop the file, and then copy and paste it as necessary.

1. [`MainActivity.java`](Android/MainActivity.java)
2. [`activity_main.xml`](Android/activity_main.xml)
3. [`Plant.java`](Android/Plant.java)
4. [`PlantAdapter.java`](Android/PlantAdapter.java)
5. [`row_item.xml`](Android/row_item.xml)

<a name="exercise"></a>

### Exercises

1. Set the provided adapter on the `ListView`. What would be an appropriate place to do this? 

2. Check the contents of the `Plant` class. Adjust `row_item.xml` to add views to display this content.

3. Inside the adapter, access the right `Plant` item and adjust the views defined in `row_item.xml` accordingly.

4. Verify that your adapter works by running the app!

<a name="wrapup"></a>

## Wrapping it up
The adapter sees a lot of use in various apps, not just in this course. A lot of apps use lists of items, whether horizontally, vertically or on a grid. The items shown in the adapter can contain all kinds of view: text, images, buttons, checkboxes, etc. Different variations of adapters exist, but the basic principles are the same. 

Adapters can be used to render lists of custom objects, like the `Student` object, which requires you to create your custom adapter class and define the contents of `getView()`. In this tutorial, we saw what an adapter and list container do behind the scenes, using a plain Java example. The tasks boil down to iterating over the list, which is handled by the list container, and rendering the correct contents, which is handled by the adapter. The adapter and the container are strongly connected, because the container dictates what items need to be shown and thus what items should be created by the adapter. 
