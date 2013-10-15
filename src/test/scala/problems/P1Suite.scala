package problems

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import scala.math.BigInt

class P1Suite extends FlatSpec with ShouldMatchers {

	"SolverP1(n)" should 
		"return the sum of number below n that are multiples of 3 and 5" in {
		SolverP1(10).solution should equal (23)
		SolverP1(1000).solution should equal (233168)
	}
	
}