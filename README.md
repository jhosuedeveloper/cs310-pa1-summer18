# Painting Nested Polygons

- CS 310 Programming Assignment 1 Due: **June 18th** 11:59pm, 2018

<img src="https://cdn.rawgit.com/jmlien/cs310-pa1-summer18/b0e0a79d/output/example2.svg" width="800">

## Assignment Objective
- Write a program to paint nested polygons
- Build linked list to represent polygon and store a list of polygons
- Sort polyongs in nested order from outside to inside
- Write a method to check if a polygon is inside another polygon using *winding number*; [Learn more about winding number from Wikipedia](https://en.wikipedia.org/wiki/Winding_number)

## Table of Contents
1. [Input/Output](#input-output)
2. [Examples](#examples)
4. [Definitions](#definitions)
5. [Tasks](#tasks)
6. [Rules](#rules)
7. [Submission Instructions](#submission-instructions)
8. [Grading Rubric](#grading-rubric)
9. [Useful Links](#external-links)

## Input Output

### Input
- A list of **poly** files, each poly file defines a polygon
 - A poly file starts with 3 integers defining the color in (R,G,B) that follows by a sequence of 2D coordinates (X,Y)
 ```
 Red Green Blue
 X1 Y1
 X2 Y2
 ....
 ```
 
 For example, you can open poly/box1.poly in any text editor and see a red 20x20 square.
 ```
 255 0 0 
 -10 -10 10 -10 10 10 -10 10
 ```
 <img src="https://cdn.rawgit.com/jmlien/cs310-pa1-summer18/master/output/1box.svg">

- All poygons are disjoint

### Output

Your program should output: (1) polygons ordered from outside to inside and (2) a SVG image.

- A list of polygons ordered from outside to inside. If multuple polygons have the same nesting level, order them by area. Each line of your terminal output (System.out) will contain 
  1. the name of the polygon
  2. the area of the polygon
- An image file, in svg format. 
  - The image filename must be named **output.svg**
- See [example output](#examples) below; your program must reproduce the same output.

## Examples

2. One polygon

```
> java cs310pa1 poly/box1.poly
polygon poly/box1.poly area= 400.0
- Saved result to output.svg
```

Here is the output.svg
 <img src="https://cdn.rawgit.com/jmlien/cs310-pa1-summer18/master/output/1box.svg">

2. Two polygons

```
> java cs310pa1 poly/box1.poly poly/box2.poly 
polygon poly/box2.poly area= 1600.0
polygon poly/box1.poly area= 400.0
- Saved results to output.svg
```

Here is the output.svg
 <img src="https://cdn.rawgit.com/jmlien/cs310-pa1-summer18/master/output/2boxes.svg">

3. Three polygons

```
> java cs310pa1 poly/box1.poly poly/box2.poly poly/box3.poly 
polygon poly/box3.poly area= 10000.0
polygon poly/box2.poly area= 1600.0
polygon poly/box1.poly area= 400.0
- Saved results to output.svg
```

4. Need more examples? Look under [output folder](https://github.com/jmlien/cs310-pa1-summer18/blob/master/output)

## Definitions

Please familiarize yourself with these terms and their definitions before you move on.

### Point
- All points are 2D points

### Polygon

- In this assignment, a polygon is a circular list of 2D points
- All polygons are simple polygons, namely there are no hole and self-intersections. 
- All polygons have positive area
- All polygons are disjoint

### Nested Polygons and Winding number

- Give a pair of polygons A and B, there are 3 possible nesting order: A inside B, B inside A, None, as illustrated below. 
  - If A is inside B, the all points in A must have positive winding number with respect to B
  - If B is inside A, the all points in B must have positive winding number with respect to A
  - Otherwise, the all points in A must have zero winding number with respect to B AND all points in B must have zero winding number with respect to A


## Tasks

There are **5** tasks in this assignment. It is recommended that you implement these tasks in the given order. 

### Task 0: Read the given code (0%)

Read and familiarize yourself with the code, in particular the following classes and methods

This will save you a lot of time later.

```java

//in ListItem.java
public class ListItem<T> 

// in Polygon.java

//compute the winding number of a given point at (x,y)
public int winding_number(double x, double y)

//get the area of the polygon
public float area()

//in PaintPolygons.java

//sort the polygons from outside to inside
//if two polygons are in the same level, sort by areas in ascending order
//(i.e., small to large)
public void sortPolygons()
```

### Task 1: Implement Linkede List (50%)
```java
//in SimpleLinkedList.java

//add a new record to the end of the list
//(15%)
public void add(T data)
{
	//TODO: your code here
}

//swap two nodes in linked list
//(20%)
private void swap(ListItem<T> n1, ListItem<T> n2)
{
	//TODO: your code here
}

//reverse the order of the nodes
//(15%)
public void reverse()
{
	//TODO: your code here
}
```

### Task 2: Imeplement Polygon Comparator (15%)
```java
//in PaintPolygons.java

//
// compare two polygons using winding number and areas
// (15%)
//
private class PolygonComparator implements Comparator<Polygon>
{
	public int compare(Polygon p1, Polygon p2)
	{
	//TODO: your code here
	return 0;
	}
}
```

### Task 3: Sort Polygons (25%)

```java
//in SimpleLinkedList.java

//sort all elements in this list in decending order
//(25%)
public void bubble_sort(Comparator<T> comp)
{
	//TODO: your code here
	//you can find bubble sort pseudocode here:
	//https://en.wikipedia.org/wiki/Bubble_sort#Pseudocode_implementation
}
```

### Task 4: Output Results (5%)

```java
//in PaintPolygons.java

//
// print the polygons to screen in sorted order
// (5%)
//
void print()
{
	//TODO: your code here
}
```

### Task 5: Complete README.txt (5%)

Fill out README.txt **(NOT README.md, which is this document)** with your information (goes in your user folder)
Provide sufficient details in README.txt to help us understand your code.

## Rules

### You must

1. Have a style (indentation, good variable names, etc.)
2. Comment your code well in JavaDoc style (no need to overdo it, just do it well)
3. Have code that compiles with the command: javac *.java in your user directory
4. **Print regions to terminal by size, large to small**

### You may 

1. Import the following libraries
```java
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
```

### You cannot 
1. Make your program part of a package.
2. Import any additional libraries/packages
3. Copy code from your text book _Data Structures and Problem Solving Using Java_, 4th Edition by _Mark A. Weiss_

## Submission Instructions
- Use the cloud or some other server to backup your code!
- Remove all test files, jar files, class files, etc.
- You should just submit your java files and your readme.txt
- Zip your user folder (not just the files) and name the zip “username-p1.zip” (no other type of archive) where “username” is your username.
- Submit to blackboard.

## Grading Rubric
[back to top](#table-of-contents)

### No Credit
- Non submitted assignments
- Late assignments after 48 hours (**late tokens will be automatically applied**)
- Non compiling assignments
- Non-independent work
- "Hard coded" solutions
- Code that would win an obfuscated code competition with the rest of CS310 students.

### How will my assignment be graded?
- Grading will be divided into two portions:
  1. Manual/Automatic Testing (100%): To assess the correctness of programs.
  2. Manual Inspection (10% off the top points): [A checklist](#manual-code-inspection-rubric-10-off-the-top-points) of features your programs should exhibit. These comprise things that cannot be easily checked via unit tests such as good variable name selection, proper decomposition of a problem into multiple functions or cooperating objects, overall design elegance, and proper asymptotic complexity. These features will be checked by graders and assigned credit based on level of compliance. See the remainder of this document for more information.
- You CANNOT get points (even style/manual-inspection points) for code that doesn't compile or for submitting just the files given to you with the assignment. You CAN get manual inspection points for code that (a) compiles and (b) is an "honest attempt" at the assignment, but does not pass any unit tests.

#### Manual/Automatic Testing (100%)
- Your output images will be compared with our output via the following command
```
diff your-output.svg my-ouput.svg
```

#### Manual Code Inspection Rubric (10% "off the top" points)
These are all "off the top" points (i.e. items that will lose you points rather than earn you points):

Inspection Point | Points | High (all points) | Med (1/2 points) | Low (no points)
:---: | :---: | :--- | :--- | :--- 
Submission Format (Folder Structure) |  2 |  Code is in a folder which in turn is in a zip file. Folder is correctly named. | Code is not directly in user folder, but in a sub-folder. Folder name is correct or close to correct. | Code is directly in the zip file (no folder) and/or folder name is incorrect.
Code Formatting | 2 | Code has a set indentation and formatting style which is kept consistent throughout and code looks "well laid out".| Code has a mostly consistent indentation and formatting style, but one or more parts do not match.|Code indentation and formatting style changes throughout the code and/or the code looks "messy".
JavaDocs | 3 | The entire code base is well documented with meaningful comments in JavaDoc format. Each class, method, and field has a comment describing its purpose. Occasional in-method comments used for clarity. | The code base has some comments, but is lacking comments on some classes/methods/fields or the comments given are mostly "translating" the code. | The only documentation is what was in the template and/or documentation is missing from the code (e.g. taken out).
Coding conventions | 3 | Code has good, meaningful variable, method, and class names. All (or almost all) added fields and methods are properly encapsulated. For variables, only class constants are public. | Names are mostly meaningful, but a few are unclear or ambiguous (to a human reader) [and/or] Not all fields and methods are properly encapsulated. |  Names often have single letter identifiers and/or incorrect/meaningless identifiers. [Note: i/j/k acceptable for indexes.] [and/or] Many or all fields and methods are public or package default.

### External Links
- TBD

