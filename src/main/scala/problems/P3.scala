/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

/* I'm not sure that seeking a procedural/imperative explanation is the best
way to gain understanding here. Streams come from functional programming
and they're best understood from that perspective. The key aspects of the
definition you've given are:

It's lazy. Other than the first element in the stream, nothing is computed
until you ask for it. If you never ask for the 5th prime, it will never be
computed.

It's recursive. The list of prime numbers is defined in terms of itself.

It's infinite. Streams have the interesting property (because they're lazy)
that they can represent a sequence with an infinite number of elements.
Stream.from(3) is an example of this: it represents the list [3, 4, 5, ...].

Let's see if we can understand why your definition computes the sequence of
prime numbers.

The definition starts out with 2 #:: .... This just says that the first number
in the sequence is 2 - simple enough so far.

The next part tells us how to compute the rest of the prime numbers. We start
with all the counting numbers starting at 3 (Stream.from(3)), but we obviously
need to filter a bunch of these numbers out. So let's consider each number i.
If i is not a multiple of a lesser prime number, then i is prime. That is, i
is prime if, for all primes k less than i, i % k > 0. In Scala, we could
express this as

nums.filter(i => ps.takeWhile(k => k < i).forall(k => i % k > 0)) However, it
isn't actually necessary to check all lesser prime numbers -- we really only
need to check the prime numbers whose square is less than or equal to i (this
is a fact from number theory). So we could instead write

nums.filter(i => ps.takeWhile(k => k * k <= i).forall(k => i % k > 0)) So
we've derived your definition.

Now, if you happened to try the first definition (with k < i), you would have
found that it didn't work. Why not? It has to do with the fact that this is a
recursive definition.

Suppose we're trying to decide what comes after 2 in the sequence. The
definition tells us to first see whether 3 belongs. To do so, we get the list
of primes up to the first one greater than or equal to 3 (takeWhile(k => k <
i)). The first prime is 2, which is less than 3 -- so far so good. But we
don't yet know the second prime, so we need to compute it. Fine, so we need to
first see whether 3 belongs ... BOOM!
*/
	
package problems

import scala.math.BigInt

case class SolverP3(n: BigInt) {

  def from(x: BigInt): Stream[BigInt] = x #:: from(x + 1)

  lazy val primes: Stream[BigInt] = BigInt(2) #:: from(3)
    .filter(i => primes.takeWhile {j => j * j <= i}.forall {k => i % k > 0})

  def solution = primes.takeWhile(j => j * j <= n).filter(x => n % x == 0).toList.max
}

object P3 extends App {
  println(SolverP3(BigInt("600851475143")).solution)
}

