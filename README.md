# 3531.-Count-Covered-Buildings
#Intuition:

A building (x, y) is covered only if it has a neighbor in all four directions:
left (smaller x), right (larger x), up (larger y), and down (smaller y).
So for each x, we store all y-values that appear at that x (vertical column),
and for each y, we store all x-values that appear at that y (horizontal row).

Using TreeSet allows us to quickly get the next smaller and larger values
(lower() and higher()), so we can check if a building has neighbors
in all four directions. If yes, it is a covered building.
