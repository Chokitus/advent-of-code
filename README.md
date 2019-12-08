# advent-of-code
My solutions to the Advent of Code 2019 (https://adventofcode.com)

## Day 1
Solved using Excel, with =ROUNDDOWN(CELL/3)-2

## Day 2
Ended up changing it to Day 5, might as well just leave Day 5.

## Day 3
Pretty messy solution, unfortunaly. I tried solving it using vectors for curiosity, but it ended up being quite hard. Still, it was easier to move into part two as everything was extra, and I didn't need to change anything.

My solution did store a Starting Point, and a Vector, being that an entity with a Strength and a boolean identifying if it is vertical or not, to define path. A non-vertical, negative vector was a vector that went to the left, and that could extend to all 4 directions. Using a list of those directions, I searched for all intersections and then sorted them to get the smallest distance. By the second part, I just needed to sum all vector strenghts up to that point, and then order by that.

## Day 4
This one was pretty easy. As it is not that big of a dataset, just ended up using brute-force solution. This solution was enough for both parts of the problem.

## Day 5
This was significantly harder than the previous ones, took me some time. Ended up doing a pretty Java-ish solution. With an Abstract Class called OpCode and an Interface called Operation, I defined everything at runtime using Java 8's functional interfaces, and ended up with a pretty simple loop (although a quite complex background operation system). At least now the solution was flexible enough so that part two was completed in very little time. Hopefully, this strategy can still be used in further uses of this OpCode challenge (which has been the most fun of all).
