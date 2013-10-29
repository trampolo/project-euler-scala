/*

The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
Although it has not been proved yet (Collatz Problem), 
it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

*/

package problems

object P14 extends App {

	def collatzChain(n: BigInt): Stream[BigInt] = n #:: collatzChain(next(n))

	def next(n: BigInt): BigInt = n match {
		case x if (x == 1) => BigInt(0)
		case x if (n % 2 > 0) => 3*n + 1
		case x => n/2
	}
	
	val cc = for {
		i <- 1 to 1000000
	} yield (i, collatzChain(i).takeWhile(x => x > 0).foldLeft(BigInt(0))((c, x) => 1 + c))
	
	println(cc.maxBy(_._2))
}