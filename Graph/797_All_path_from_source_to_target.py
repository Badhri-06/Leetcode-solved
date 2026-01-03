'''
# All Paths From Source to Target (DAG)

## Problem
Given a directed acyclic graph (DAG) of `n` nodes labeled from `0` to `n-1`, find all possible paths from node `0` to node `n-1`.

The graph is represented as an adjacency list where:
- `graph[i]` contains all nodes reachable from node `i`.

Return all possible paths in any order.

---

## Approach
- Use **Depth First Search (DFS)** with **backtracking**
- Maintain a current `path`
- When the target node is reached, store a copy of the path
- Backtrack using `pop()` to explore other paths

---

## Algorithm
1. Start DFS from node `0`
2. Add neighbors to the path
3. Recurse until target is reached
4. Backtrack to try other branches

---

## Time Complexity
- **O(P × L)**  
  Where `P` = number of paths, `L` = average path length

## Space Complexity
- **O(L)** due to recursion stack

---

## Example
**Input**
```python
graph = [[1,2],[3],[3],[]]
'''


class Solution:


    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        res=[]
        path=[]
        target=len(graph)-1
        def dfs(node,path):
            if node==target:
                res.append(path[:])
                return

            for neighbor in graph[node]:
                path.append(neighbor)
                dfs(neighbor,path)
                path.pop()
        dfs(0,[0])
        return res