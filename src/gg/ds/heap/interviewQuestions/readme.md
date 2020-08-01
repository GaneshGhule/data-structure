1.  **K’th largest element in a stream**

    Given an infinite stream of integers, find the k’th largest element at any point of time.

2.  **Last Stone Weight**

    We have a collection of stones, each stone has a positive integer weight.

    Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
    At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.) 
    
        Input: [2,7,4,1,8,1]
        Output: 1
        Explanation: 
        We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
        we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
        we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
        we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.

3.  **Reorganize String**   

    Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
    
    If possible, output any possible result.  If not possible, return the empty string.   
    
    Example 1:
    
        Input: S = "aab"
        Output: "aba"
    Example 2:
    
        Input: S = "aaab"
        Output: ""
        
4. **Connect n ropes with minimum cost**

    There are given n ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two 
    ropes is equal to the sum of their lengths. We need to connect the ropes with minimum cost.        
    
    For example, if we are given 4 ropes of lengths 4, 3, 2, and 6. We can connect the ropes in the following ways.
    
    1) First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6, and 5.
    2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
    3) Finally connect the two ropes and all ropes have connected.
    
    Total cost for connecting all ropes is 5 + 9 + 15 = 29. 
    
5. **Employee free time**

    We are given a list schedule of employees, which represents the working time for each employee.
    
    Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
    
    Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.    
    
        Example 1:
        
        Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
        Output: [[3,4]]
        Explanation:
        There are a total of three employees, and all common
        free time intervals would be [-inf, 1], [3, 4], [10, inf].
        We discard any intervals that contain inf as they aren't finite.

6. **Minimum Number of Refueling Stops**

    A car travels from a starting position to a destination which is target miles east of the starting position.
    
    Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.

    The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.

    When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

    What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.
    
        Example 1:
        
        Input: target = 1, startFuel = 1, stations = []
        Output: 0
        Explanation: We can reach the target without refueling.
        
        Example 2:
        
        Input: target = 100, startFuel = 1, stations = [[10,100]]
        Output: -1
        Explanation: We can't reach the target (or even the first gas station).
        
        Example 3:
        
        Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
        Output: 2    