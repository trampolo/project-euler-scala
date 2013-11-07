/*

n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

*/

package problems

object P20 extends App {

	val sd = (1 to 100).foldLeft(BigInt(1))((p, x) => x * p)
	println(sd)
	println(sd.toString.map {c => c.toString.toInt}.sum)
		
}