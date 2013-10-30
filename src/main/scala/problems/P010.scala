/*

The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.

*/

package problems

import scala.math.BigInt

object P10 extends App {

  def from(x: BigInt): Stream[BigInt] = x #:: from(x + 1)

  lazy val primes: Stream[BigInt] = BigInt(2) #:: from(3)
    .filter(i => primes.takeWhile { j => j * j <= i }.forall { k => i % k > 0 })

  def solution(n: BigInt): BigInt =
    primes.takeWhile(j => j < n).toList.sum

  println(solution(2000000))
}