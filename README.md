# Mechanics-problem
A test-case task from [LeetCode](https://leetcode.com/problems/minimum-time-to-repair-cars/?envType=daily-question&envId=2025-03-16), solving which took me a while

### _Do not spoil yourself with the answer unless desperate_

- [Stated problem](#stated-problem)
- [Why upload](#why-upload)
- [Pseudocode](#final-solution)
- [Project description](#project-description)
- [Commentary](#commentary)

## Stated problem

> You are given an integer array ranks representing the ranks of some mechanics. ranks[i] is the rank of the i-th mechanic. A mechanic with a rank r can repair n cars in r * n^2 minutes.
> You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
> Return the minimum time taken to repair all the cars.
> **Note: _All the mechanics can repair the cars simultaneously_**.

_The formula for the time `T` it takes for one mechanic of a rank `r` to repair `n` cars_:
`T = r * n ^ 2`

## Why upload
- This is the project I've been performing tests in to confirm the results / hunt the bugs
- I really like how this code looks; I think it's really clean and well-written, so I want it in my collection

## Final solution

Pseudocode:
```
func solve(int[] ranks, int cars) {
  // Can't possibly make it slower than the worst of them, working alone
  int worstRank = ranks.max();
  int maxTime = worstRank * cars * cars; // Current best result
  int minTime = 0; // Currently known maximal amount of time, which hasn't been enough to repair all cars
  int time = maxTime / 2; // Starting from the middle
  // Cars repaired in the last iteration
  int repaired = 0;
  // Do while the amount of cars repaired the last time wasn't enough, AND,
  // if enough, while there's still a large gap between minTime and maxTime
  while (repaired < cars AND (maxTime - minTime) > 1) {
    repaired = ranks.forEach(r -> Math.sqrt(time / r)).sum();
    // More than OR enough cars repaired
    if (repaired >= cars) {
      maxTime = time; // Best result
      time = (minTime + time) / 2; // Decrease
    }
    else {
      minTime = time; // Minimal limit - less than that is surely not enough
      time = (time + maxTime) / 2; // Increase
    }
  }
  // Return the best result
  return maxTime;
}
```

## Project description
_Everything is documented, may as well check it out_

_The project also contains a large amount of test cases: everything surely works_

- `SolutionMain` - the entry point, which has an example (borrowed from LeetCode) of how everything works
  - `timestamp()` - prints the time since its last call into the console
- `Tools` - various static functions:
  - Find middle number between the two other numbers
  - Find minimal, maximal number from an array
  - Count cars repaired by a mechanic by some time (different variations)
  - Count cars repaired by some number of mechanics by the same time (different variations)
- `Solutions`
  - `AbstractProblemSolution`
    - Contains a `static` method for time calculation (from the description on LeetCode)
    - Has a realization of logging mechanism (simply to console)
    - Doesn't provide the realization of the `solve` method
  - `SimpleSolution`
    - `solve` method brute-forces the result (and the result is always correct). `~30 seconds`
  - `BinarySolution`
    - `solve` method utilizes the red-black tree approach: `~40-50ms`
      - Find the maximum possible time
      - Start from the middle of that time
      - Iteratively increase towards the `maxTime` or decrease towards the `minTime` until met the required conditions
  - `FinalSolution`
    - Same as `BinarySolution`, but in a single method (the screenshot of the `FinalSolution` is below). `~10ms`

Unit test prove that:
- `BinarySolution`'s result is always the same as `SimpleSolution`'s
- `SimpleSolution`'s results satisfy LeetCode's results
- `BinarySolution` never gets stuck in an infinite loop
- ..and some other minor tests
   

## Commentary
When I encountered this task, at first I was thinking whether I am this bad at Math or not.

I was struggling to simply find the formula, which could be appliable to this case. And I couldn't.

I even started browsing tasks from Middle School Math, thinking I'm doing something wrong. That didn't help.

And the LeetCode's tip `Try using binary search` wasn't helpful either.

I was so desperate that asked DeepSeek to help me solve the problem.
After some 5 minutes of reflexion, The Whale hinted me upon the solution
(though it didn't provide me the code; I've stated my question as a Math task):

`We must iteratively, starting from 1 minute, check if the mechanics repaired enough cars, increasing the time by 1 otherwise`

So, my first attempt finally happened and looked like this:
<img src="https://github.com/user-attachments/assets/703d53e4-b548-41d8-a7e7-26e71d45967a" width="640">

No surprise that, while it passed the Test Cases, it failed the final check: it was _**extremely slow**_ (my measurements show the result of ~30 second).

So, that was when I realized what are all these words about the `binary search`.

After a lot of struggle (mostly foolish: the middle number between the two other numbers was incorrect because of a typo,
and the `while` condition wasn't properly set too) I've finally made this:
<img src="https://github.com/user-attachments/assets/050e3f44-e33f-4758-9643-69269bdab570" width="640">
> Note: This part isn't commented, but the project contains the simplified and commented variation too (which is slower by ~3-5 times, by the way)

#### LeetCode shows some different result (probably because of my ping, I'm not sure)
<img src="https://github.com/user-attachments/assets/98344df0-0406-4952-a5e8-57711f0ea6e2" width="640">




