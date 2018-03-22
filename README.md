# VacationPlanner

The key class in this implementation is Parser.java.
Here I parse the input files for both the areas and the locations.
When i parse i already keep track of the the cheapest location, and i introduce every
location in the location Tree Map of each area(Region, Country, City). In this way, the
locations are already sorted when i do the operations in them. 

The main database contains hash maps for locations, cities regions and countries so i can 
find easily which areas or locations i have available.

Using this implementation the complexities for the main operations are:
    
    -Finding info about a specific location: O(n)
    -Finding the cheapest location: O(1)
    -Finding top locations for a specific country, city region in a specific date: O(n)
    
However, the insertion time for tree maps is O(log n) instead of O(1) for hash maps, but i
this a good trade off.

I wrote myself a small test (call it a sanity check) with a few locations and areas, to 
check if the implementation is working fine. For the lack of time and imagination i didn't
write a very complex test case, but this implementation should work easily and fast for 
over 10 000 locations. The input files for both areas and locations are written in csv style.

Even if the introduction of the areas was not required, i found it very useful and better
suited to the task. 

It is easy to add more area types in my implementation and i left room for more details 
regarding each activity or location. From this point i can evolve this app in a lot of ways
making it way more complex.