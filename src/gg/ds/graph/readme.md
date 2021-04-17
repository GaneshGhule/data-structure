1. **Game of Life**

    According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
    
    Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
    
    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
    
    Example:
    
        Input: 
        [
          [0,1,0],
          [0,0,1],
          [1,1,1],
          [0,0,0]
        ]
        Output: 
        [
          [0,0,0],
          [1,0,1],
          [0,1,1],
          [0,1,0]
        ]
        
    Follow up:
    
    Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

2. **Parallel Courses**
    There are N courses, labelled from 1 to N.
    
    We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: course X has to be studied before course Y.
    
    In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.
    
    Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses, return -1.
    
    Example 1:
    
        Input: N = 3, relations = [[1,3],[2,3]]
        Output: 2
        Explanation: 
        In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.
    Example 2:
    
        Input: N = 3, relations = [[1,2],[2,3],[3,1]]
        Output: -1
        Explanation: 
        No course can be studied because they depend on each other.
     
    Note:
    
    1 <= N <= 5000
    1 <= relations.length <= 5000
    relations[i][0] != relations[i][1]
    There are no repeated relations in the input.
    
3. **Alien Dictionary**

    There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
    
    Example 1:
        
        Given the following words in dictionary,
        [
          "wrt",
          "wrf",
          "er",
          "ett",
          "rftt"
        ]
        The correct order is: "wertf".
        
    Example 2:
    
        Given the following words in dictionary,
        [
          "z",
          "x"
        ]
        The correct order is: "zx".
        
    Example 3:
    
        Given the following words in dictionary,
        [
          "z",
          "x",
          "z"
        ]
        The order is invalid, so return "".
        
    Note:
    
    You may assume all letters are in lowercase.
    You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
    If the order is invalid, return an empty string.
    There may be multiple valid order of letters, return any one of them is fine.    