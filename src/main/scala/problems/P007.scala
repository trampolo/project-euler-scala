/*

By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
we can see that the 6th prime is 13.

What is the 10 001st prime number?

*/

package problems

object P7 extends App {
  lazy val primes: Stream[Int] = 2 #:: Stream.from(3)
    .filter(i => primes.takeWhile { j => j * j <= i }.forall { k => i % k > 0 })

  println(primes.drop(10000).head)

}
