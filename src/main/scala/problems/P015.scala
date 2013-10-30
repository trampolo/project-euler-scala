/*

Starting in the top left corner of a 2×2 grid, 
and only being able to move to the right and down, 
there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?

*/

package problems

object P15 extends App {

  println((1 to 40).foldLeft(BigInt(1))((p, x) => p * x) /
    ((1 to 20).foldLeft(BigInt(1))((p, x) => p * x) *
      (1 to 20).foldLeft(BigInt(1))((p, x) => p * x)))
}

