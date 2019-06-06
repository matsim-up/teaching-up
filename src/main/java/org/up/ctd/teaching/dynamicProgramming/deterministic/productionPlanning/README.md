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

<img alt="$f_t(i)\triangleq$" src="svgs/3f224ddc86b2f8b8810eaeb575ba0a15.svg" align="middle" width="49.63586759999998pt" height="30.137058600000014pt"/> the minimum costs for months <img alt="$t,t+1,...,4$" src="svgs/4f8c1aa08e5de7dbff18dfa5c791bca4.svg" align="middle" width="84.01812704999998pt" height="21.18721440000001pt"/> given that
there is <img alt="$i$" src="svgs/77a3b857d53fb44e33b53e4c8b68351a.svg" align="middle" width="5.663225699999989pt" height="21.68300969999999pt"/> units in inventory at the start of month <img alt="$t$" src="svgs/4f4f4e395762a3af4575de74c019ebb5.svg" align="middle" width="5.936097749999991pt" height="20.221802699999984pt"/>.

The formulation for <img alt="$t=T=5$" src="svgs/7844a64f489e558876104e0124ca7b62.svg" align="middle" width="69.87987929999998pt" height="22.465723500000017pt"/> (the end of month 4) is then simply

<img alt="$f_T(i)\equiv 0$" src="svgs/9dbca326beaa3a5b07042406ae6f0084.svg" align="middle" width="66.98907929999999pt" height="24.65753399999998pt"/>

For <img alt="$t &lt; T$" src="svgs/04fd676c61dc97e52185a18b1445e7f3.svg" align="middle" width="39.74304179999999pt" height="22.465723500000017pt"/> we formulate the recursion as

<img alt="$f_t(i)=\min\limits_{\shortstack{x_t\leq 5\\i+x_t\geq d_t}}\left\{ 3\delta\left(x_t\right) + f_{t+1}(i+x_t-d_t)\right\}$" src="svgs/0ea3cd0a2f9833af9c6da2413f64ce60.svg" align="middle" width="327.0396359999999pt" height="69.22359840000001pt"/>
