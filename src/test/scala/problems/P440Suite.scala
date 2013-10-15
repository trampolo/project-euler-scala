package problems

import org.scalatest._
import scala.math.BigInt

class P440Suite extends FunSuite {


	test("T(n) be the number of ways to tile a board of length n") {
		assert(new SolverP440(1).tsolutions === 10)
		assert(new SolverP440(2).tsolutions === 101)
	}

	test("S(L) be the triple sum ∑a,b,c gcd(T(ca), T(cb)) for 1 ≤ a, b, c ≤ L") {
		assert(new SolverP440(2).ssolutions === 10444)
		//assert(new Solver(3).ssolutions === BigInt("1292115238446807016106539989"))
	}

}