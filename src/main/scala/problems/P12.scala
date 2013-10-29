/*

The sequence of triangle numbers is generated by adding the natural numbers.
So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first
ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28

We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred
divisors?

*/


package problems

import scala.language.postfixOps
import scala.collection.SortedSet
import scala.annotation.tailrec

object P12 extends App {

	def from(n: BigInt): Stream[BigInt] = n #:: from(n + 1)
	lazy val primes: Stream[BigInt] = BigInt(2) #:: from(3)
    	.filter(i => primes.takeWhile {j => j * j <= i}.forall {k => i % k > 0})
	
	/* sum of firsts n number */
	def triangles(n: BigInt) = (n * (n + 1)) / 2

	/* List of prime factors of n */
	def primesFactors(n: BigInt) = {
		def loop(x: BigInt, acc: List[BigInt], xs: Stream[BigInt]): List[BigInt] = x match {
			case k if xs(0) > k => acc
			case k if (k % xs(0) == 0) => loop(k / xs(0), xs(0) :: acc, xs)
			case k => loop(k, acc, xs.drop(1))
		}
		loop(n, List(), primes) 
	}

	/* combinations of prime factors */
	def combinations(xs: List[BigInt]) = 
		for {
			i <- 1 to xs.length
			c <- xs.combinations(i)
		} yield c


	val x = from(100).dropWhile ( n => {
			val t = triangles(n)
			val pf = primesFactors(t) 
			val c = combinations(pf)
			val dn = c.length + 1
			dn < 500
		}
	)(0)

	val t = triangles(x)
	val pf = primesFactors(t) 
	val c = combinations(pf)
	val dn = c.length + 1
	println(s"Triangle: ${t}")
	println(s"Factors: ${pf}")
	println(s"Combinations: ${c}")
	println(s"Divisors Number: ${dn}")


}