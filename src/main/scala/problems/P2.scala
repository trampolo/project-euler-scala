/**	Even Fibonacci numbers
 * Problem 2
 * Each new term in the Fibonacci sequence is generated 
 * by adding the previous two terms. By starting with 1 and 2, 
 * the first 10 terms will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values 
 * do not exceed four million, find the sum of the even-valued terms.
 */

package problems

import scala.math.BigInt
import scala.language.postfixOps

case class SolverP2(n: Int) {

	
	lazy val fibs: Stream[BigInt] = 
		BigInt(1) #:: BigInt(2) #:: fibs.zip(fibs.tail).map {n => n._1 + n._2}

	def solution = fibs takeWhile (_ < n) filter (_ % 2 == 0) sum
}

object P2 extends App {
	println(SolverP2(100).solution)
	println(SolverP2(4000000).solution)
}