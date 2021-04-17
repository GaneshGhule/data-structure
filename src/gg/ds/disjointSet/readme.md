1. **The Earliest Moment When Everyone Become Friends**

    In a social group, there are N people, with unique integer ids from 0 to N-1.
    
    We have a list of logs, where each logs[i] = [timestamp, id_A, id_B] contains a non-negative integer timestamp, and the ids of two different people.
    
    Each log represents the time in which two different people became friends. Friendship is symmetric: if A is friends with B, then B is friends with A.
    
    Let's say that person A is acquainted with person B if A is friends with B, or A is a friend of someone acquainted with B.
    
    Return the earliest time for which every person became acquainted with every other person. Return -1 if there is no such earliest time.
    
        Example 1:
        
        Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
        Output: 20190301
        Explanation:
        The first event occurs at timestamp = 20190101 and after 0 and 1 become friends we have the following friendship groups [0,1], [2], [3], [4], [5].
        The second event occurs at timestamp = 20190104 and after 3 and 4 become friends we have the following friendship groups [0,1], [2], [3,4], [5].
        The third event occurs at timestamp = 20190107 and after 2 and 3 become friends we have the following friendship groups [0,1], [2,3,4], [5].
        The fourth event occurs at timestamp = 20190211 and after 1 and 5 become friends we have the following friendship groups [0,1,5], [2,3,4].
        The fifth event occurs at timestamp = 20190224 and as 2 and 4 are already friend anything happens.
        The sixth event occurs at timestamp = 20190301 and after 0 and 3 become friends we have that all become friends.
        
2. **Regions Cut By Slashes**

    In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.
    
    (Note that backslash characters are escaped, so a \ is represented as "\\".)
    
    Return the number of regions.    
    
        Input:
        [
          " /",
          "/ "
        ]
        Output: 2
        
        Input:
        [
          " /",
          "  "
        ]
        Output: 1
        
         Input:
        [
          "\\/",
          "/\\"
        ]
        Output: 4
        
         Input:
        [
          "/\\",
          "\\/"
        ]
        Output: 5
        
         Input:
        [
          "//",
          "/ "
        ]
        Output: 3
       
3. **Connecting Cities With Minimum Cost**    

    There are N cities numbered from 1 to N.
    
    You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
    
    Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.    
    
    Example 1:
    
        Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
        Output: 6
        Explanation: 
        Choosing any 2 edges will connect all cities so we choose the minimum 2.

    Example 2:
    
        Input: N = 4, connections = [[1,2,3],[3,4,4]]
        Output: -1
        Explanation: 
        There is no way to connect all cities even if all edges are used.
        
    Note:
        
    1 <= N <= 10000
    1 <= connections.length <= 10000
    1 <= connections[i][0], connections[i][1] <= N
    0 <= connections[i][2] <= 10^5
    connections[i][0] != connections[i][1]
    
  
4. **Lexicographically Smallest Equivalent String**   

    Given strings A and B of the same length, we say A[i] and B[i] are equivalent characters. For example, if A = "abc" and B = "cde", then we have 'a' == 'c', 'b' == 'd', 'c' == 'e'.
    Equivalent characters follow the usual rules of any equivalence relation:
    Reflexivity: 'a' == 'a'
    Symmetry: 'a' == 'b' implies 'b' == 'a'
    Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'
    For example, given the equivalency information from A and B above, S = "eed", "acd", and "aab" are equivalent strings, and "aab" is the lexicographically smallest equivalent string of S.
    Return the lexicographically smallest equivalent string of S by using the equivalency information from A and B.
    
    Example 1:
    
        Input: A = "parker", B = "morris", S = "parser"
        Output: "makkek"
        Explanation: Based on the equivalency information in A and B, we can group their characters as [m,p], [a,o], [k,r,s], [e,i]. The characters in each group are equivalent and sorted in lexicographical order. So the answer is "makkek".
       
    Example 2:
   
        Input: A = "hello", B = "world", S = "hold"
        Output: "hdld"
        Explanation:  Based on the equivalency information in A and B, we can group their characters as [h,w], [d,e,o], [l,r]. So only the second letter 'o' in S is changed to 'd', the answer is "hdld".
       
    Example 3:
    
        Input: A = "leetcode", B = "programs", S = "sourcecode"
        Output: "aauaaaaada"
        Explanation:  We group the equivalent characters in A and B as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in S except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".
       
    Note:
    String A, B and S consist of only lowercase English letters from 'a'- 'z'.
    The lengths of string A, B and S are between 1 and 1000.
    String A and B are of the same length. 