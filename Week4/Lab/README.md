# Java Basics for Android
 <img align="left" src="Images/robotje.png" style="padding: 10px"> This week the focus will be on exceptions. You probably already have encoutered them a few times in your programming, especially the famous `NullPointerException`. The focus in this tutorial will be on different kind of exceptions, when they might occur and how to handle them appropriately. Furthermore, starting this week we will put additional focus on code quality, which is also tied to handling exceptions well!
 <br>
 <br>
 <br>

## Table of contents

### Exceptions
When running programs, sometimes unexpected things happen, even if the code compiled correctly beforehand. This could for example be you trying to access an index in an array that is out of bounds, trying to call a method on an object that does not exist, etc. 

In Java, these events usually produce an `Exception` of some kind. You probably have seen an exception resembling the following printed to the console in a nice bright red at some point:

        java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.ListView.setAdapter(android.widget.ListAdapter)' on a null object reference

Exeptions like these are not the only kind of exception, although you will probably see this kind a lot in the beginning. Exceptions contain information on what went wrong, so that you can solve the problem or help avoid it. 