# Production planning and inventory

This problem is taken from Winston (2004), _Introduction to Probability Models_,
Chapter 6, Example 4.

A company knows that the demand for its product during each of the next four 
months will be as follows: month one, 1 unit; month two, 3 units; month three, 
2 units; and month four, 4 units. At the beginning of each month, the company 
must determine how many units should be produced during the current month. 
During a month in which any units are produced, a setup cost of USD3 are incurred. 
In addition, there is a variable cost of USD1 for every unit produced. At the end 
of each month a holding cost of 50c per unit on hand is incurred. Capacity 
limitations allow a maximum of 5 units to be produced during each month. The 
size of the company's warehouse restricts ending inventory for each month to at 
most 4 units. The company wants to determine a production schedule that will 
meet all demands on time and will minimise the sum of production and holding 
costs during the four months. Assumes that 0 units are on hand at the beginning 
of the first month.

We can define the recursion as

$f_t(i)\triangleq$ the minimum costs for months $t,t+1,...,4$ given that
there is $i$ units in inventory at the start of month $t$.

The formulation for $t=T=5$ (the end of month 4) is then simply

$f_T(i) = 0.5i$

For $t < T$ we formulate the recursion as

$f_t(i)=\min\limits_{\substack{x_t\leq 5 \\ i+x_t\geq d_t}}\left\{ 0.5i + \delta\left(x_t\right) + f_{t+1}(i+x_t-d_t)\right\}$

where 

$\delta\left(x_t\right) = 
	\begin{cases} 
		3 + x_t & \text{if } x_t > 0 \\ 
		0 & \text{otherwise.} 
	\end{cases}$

We start calculating at $f_T(i)$ for $i\in\{0,\ldots,4\}$ and work our way back
to $f_1(0)$.

If all goes well, it should produce an output similar to the following:
```
2019-06-06 09:06:01,236  INFO Header:32 ====================================================================================================
2019-06-06 09:06:01,240  INFO Header:33 class org.up.ctd.teaching.dynamicProgramming.deterministic.productionPlanning.RunProductionPlanning
2019-06-06 09:06:01,240  INFO Header:34 ----------------------------------------------------------------------------------------------------
2019-06-06 09:06:01,240  INFO Header:40 ----------------------------------------------------------------------------------------------------
2019-06-06 09:06:01,249  INFO Gbl:63 JVM: 1.8.0_171; Oracle Corporation; mixed mode; 64-bit
2019-06-06 09:06:01,249  INFO Gbl:67 OS: Mac OS X; 10.14.5; x86_64
2019-06-06 09:06:01,249  INFO Gbl:70 CPU cores: 4
2019-06-06 09:06:01,252  INFO Gbl:71 max. Memory: 3641.0MB (3817865216B)
2019-06-06 09:06:01,253  INFO RunProductionPlanning:62 Stage 5...
2019-06-06 09:06:01,268  INFO RunProductionPlanning:72    f_5 (0): defined ZERO
2019-06-06 09:06:01,269  INFO RunProductionPlanning:72    f_5 (1): defined ZERO
2019-06-06 09:06:01,269  INFO RunProductionPlanning:72    f_5 (2): defined ZERO
2019-06-06 09:06:01,269  INFO RunProductionPlanning:72    f_5 (3): defined ZERO
2019-06-06 09:06:01,269  INFO RunProductionPlanning:72    f_5 (4): defined ZERO
2019-06-06 09:06:01,270  INFO RunProductionPlanning:62 Stage 4...
2019-06-06 09:06:01,274  INFO RunProductionPlanning:72    f_4 (0): Decision: Make 4; Objective: 7.0; Next stage: f_5 (0)
2019-06-06 09:06:01,275  INFO RunProductionPlanning:72    f_4 (1): Decision: Make 3; Objective: 6.0; Next stage: f_5 (0)
2019-06-06 09:06:01,275  INFO RunProductionPlanning:72    f_4 (2): Decision: Make 2; Objective: 5.0; Next stage: f_5 (0)
2019-06-06 09:06:01,276  INFO RunProductionPlanning:72    f_4 (3): Decision: Make 1; Objective: 4.0; Next stage: f_5 (0)
2019-06-06 09:06:01,276  INFO RunProductionPlanning:72    f_4 (4): Decision: Make 0; Objective: 0.0; Next stage: f_5 (0)
2019-06-06 09:06:01,276  INFO RunProductionPlanning:62 Stage 3...
2019-06-06 09:06:01,280  INFO RunProductionPlanning:72    f_3 (0): Decision: Make 2; Objective: 12.0; Next stage: f_4 (0)
2019-06-06 09:06:01,281  INFO RunProductionPlanning:72    f_3 (1): Decision: Make 5; Objective: 10.0; Next stage: f_4 (4)
2019-06-06 09:06:01,281  INFO RunProductionPlanning:72    f_3 (2): Decision: Make 0; Objective: 7.0; Next stage: f_4 (0)
2019-06-06 09:06:01,282  INFO RunProductionPlanning:72    f_3 (3): Decision: Make 0; Objective: 6.5; Next stage: f_4 (1)
2019-06-06 09:06:01,282  INFO RunProductionPlanning:72    f_3 (4): Decision: Make 0; Objective: 6.0; Next stage: f_4 (2)
2019-06-06 09:06:01,288  INFO RunProductionPlanning:62 Stage 2...
2019-06-06 09:06:01,293  INFO RunProductionPlanning:72    f_2 (0): Decision: Make 5; Objective: 16.0; Next stage: f_3 (2)
2019-06-06 09:06:01,294  INFO RunProductionPlanning:72    f_2 (1): Decision: Make 4; Objective: 15.0; Next stage: f_3 (2)
2019-06-06 09:06:01,295  INFO RunProductionPlanning:72    f_2 (2): Decision: Make 3; Objective: 14.0; Next stage: f_3 (2)
2019-06-06 09:06:01,296  INFO RunProductionPlanning:72    f_2 (3): Decision: Make 0; Objective: 12.0; Next stage: f_3 (0)
2019-06-06 09:06:01,297  INFO RunProductionPlanning:72    f_2 (4): Decision: Make 0; Objective: 10.5; Next stage: f_3 (1)
2019-06-06 09:06:01,297  INFO RunProductionPlanning:62 Stage 1...
2019-06-06 09:06:01,302  INFO RunProductionPlanning:72    f_1 (0): Decision: Make 1; Objective: 20.0; Next stage: f_2 (0)
2019-06-06 09:06:01,304  INFO RunProductionPlanning:72    f_1 (1): Decision: Make 0; Objective: 16.0; Next stage: f_2 (0)
2019-06-06 09:06:01,305  INFO RunProductionPlanning:72    f_1 (2): Decision: Make 0; Objective: 15.5; Next stage: f_2 (1)
2019-06-06 09:06:01,305  INFO RunProductionPlanning:72    f_1 (3): Decision: Make 0; Objective: 15.0; Next stage: f_2 (2)
2019-06-06 09:06:01,305  INFO RunProductionPlanning:72    f_1 (4): Decision: Make 0; Objective: 13.5; Next stage: f_2 (3)
2019-06-06 09:06:01,306  INFO RunProductionPlanning:77 Reporting the optimal sequence:
2019-06-06 09:06:01,308  INFO RunProductionPlanning:89    f_1 (0): Decision: Make 1; Objective: 20.0; Next stage: f_2 (0)
2019-06-06 09:06:01,308  INFO RunProductionPlanning:89    f_2 (0): Decision: Make 5; Objective: 16.0; Next stage: f_3 (2)
2019-06-06 09:06:01,311  INFO RunProductionPlanning:89    f_3 (2): Decision: Make 0; Objective: 7.0; Next stage: f_4 (0)
2019-06-06 09:06:01,311  INFO RunProductionPlanning:89    f_4 (0): Decision: Make 4; Objective: 7.0; Next stage: f_5 (0)
2019-06-06 09:06:01,312  INFO RunProductionPlanning:89    f_5 (0): defined ZERO
2019-06-06 09:06:01,312  INFO Gbl:145 ### elapsed time: 59 msecs; 0.059 secs; 9.833333E-4 mins; 1.6388889E-5 hours; 6.828704E-7 days ###
2019-06-06 09:06:01,312  INFO Header:48 ----------------------------------------------------------------------------------------------------
2019-06-06 09:06:01,313  INFO Header:51                                                Done
2019-06-06 09:06:01,313  INFO Header:52 ====================================================================================================

```