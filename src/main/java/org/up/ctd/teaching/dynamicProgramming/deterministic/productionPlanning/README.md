# Production planning and inventory

This problem is taken from Winston (2004), _Introduction to Probability Models_,
Chapter 6, Example 4.

A company knows that the demand for its product during each of the next four 
months will be as follows: month one, 1 unit; month two, 3 units; month three, 
2 units; and month four, 4 units. At the beginning of each month, the company 
must determine how many units should be produced during the current month. 
During a month in which any units are produced, a setup cost of <img src="https://rawgit.com/matsim-up/teaching-up/master/svgs/ffefe523cb7fb7d0027bc3d9137bacda.svg?invert_in_darkmode" align=middle width=354.16396785pt height=22.831056599999986pt/>1 for every unit produced. At the end 
of each month a holding cost of 50c per unit on hand is incurred. Capacity 
limitations allow a maximum of 5 units to be produced during each month. The 
size of the company's warehouse restricts ending inventory for each month to at 
most 4 units. The company wants to determine a production schedule that will 
meet all demands on time and will minimise the sum of production and holding 
costs during the four months. Assumes that 0 units are on hand at the beginning 
of the first month.

We can define the recursion as

<img src="https://rawgit.com/matsim-up/teaching-up/master/svgs/27c94440bc8e96a968c0494742eed5dc.svg?invert_in_darkmode" align=middle width=63.334413449999985pt height=30.137058600000014pt/> the minimum costs for months <img src="https://rawgit.com/matsim-up/teaching-up/master/svgs/7edd2f0291755879500154d495140e80.svg?invert_in_darkmode" align=middle width=93.15057344999998pt height=22.831056599999986pt/> given that
there is <img src="https://rawgit.com/matsim-up/teaching-up/master/svgs/db08780ad2ba9746939e86b175ce5161.svg?invert_in_darkmode" align=middle width=14.79567374999999pt height=22.831056599999986pt/> units in inventory at the start of month <img src="https://rawgit.com/matsim-up/teaching-up/master/svgs/2c81564e7f8fed1d9540fdb33c3889eb.svg?invert_in_darkmode" align=middle width=15.068545799999992pt height=22.831056599999986pt/>.

The formulation for <img src="https://rawgit.com/matsim-up/teaching-up/master/svgs/7844a64f489e558876104e0124ca7b62.svg?invert_in_darkmode" align=middle width=69.87987929999998pt height=22.465723500000017pt/> (the end of month 4) is then simply
```math
f_T(i)\equiv 0
```