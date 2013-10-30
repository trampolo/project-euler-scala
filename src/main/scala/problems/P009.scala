/*

A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
the product abc. 

*/

package problems

object P9 extends App {

  println(
    (for {
      a <- 1 to 1000
      b <- 1 to (1000 - a)
      c <- 1 to (1000 - b - a)
      if (a + b + c) == 1000
      if (a * a + b * b) == c * c
    } yield a * b * c).head)
}