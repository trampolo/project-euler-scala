package problems 

import scala.language.postfixOps

case class SolverP5(n: Int) {

	def factorize(k: Int) = (1 until n) filter (x => x % k == 0) toSet

	val solution = for {
		x <- (n to 1 by -1)
	} yield x
}