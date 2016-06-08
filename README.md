# A* Path finding

An implementation of the A* path finding algorithm.

###Pre-requisites:

* Git
* Java 1.7
* Python 3
* Maven
* SonarQube

#### Basis for assignment

Movement Cost for Terrain:
  * Non-walkable:
        N/A = Water (~)
  * Walkable:
    1 = Flatlands (. or @ or X)
    2 = Forest (*)
    3 = Mountain (^)

```java
Test Map:
  @*^^^    @ = User start
  ~~*~.    X = The goal tile
  **...
  ^..*~
  ~~*~X
  
Test Map Solution:
  ##^^^    # = Best path
  ~~#~.
  **.#.
  ^..#~
  ~~*~#
```

#### Run the algorithm

**Download** or **clone** the repo, and follow these instructions:

```java
// cd into the directory
cd a-star_assignment/

// place your input files into the directory
e.g. my_map.txt

// open the command line and enter the following
py find_path.py <file-name> (Windows) or python find_path.py <file-name> (Linux)
e.g. py find_path.py my_map.txt

// the solution will be prepared and displayed
```
Done using [Kevin Glass's](http://www.cokeandcode.com/main/tutorials/path-finding//) amazing tutorial as a reference.

Enjoy.