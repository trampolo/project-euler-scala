package problems

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import scala.math.BigInt

class P2Suite extends FlatSpec with ShouldMatchers {

	"SolverP2" should 
		"return the sum of the even-valued terms in the Fibonacci sequence whose values do not exceed four million" in {
		SolverP2(100).solution should equal (44)
		SolverP2(4000000).solution should equal (4613732)
	}
	
}