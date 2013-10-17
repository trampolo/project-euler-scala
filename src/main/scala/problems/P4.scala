/*

A palindromic number reads the same both ways. The largest palindrome made
from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.

*/

package problems

case class SolverP4(n: Int) {

	def isPalindrome(x: Int) = x.toString.reverse == x.toString

	lazy val solution = for {
		a <- (n to 100 by -1)
		b <- (n to 100 by -1)
		if (isPalindrome(a * b)) 
	} yield (a * b, a, b)
}

object P4 extends App {
	println(SolverP4(999).solution.maxBy(_._1))
}