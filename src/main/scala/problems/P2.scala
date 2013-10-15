package problems

import scala.math.BigInt
import scala.language.postfixOps

case class SolverP2(n: Int) {

	
	lazy val fibs: Stream[BigInt] = 
		BigInt(1) #:: BigInt(2) #:: fibs.zip(fibs.tail).map {n => n._1 + n._2}

	def solution = fibs takeWhile (_ < n) filter (_ % 2 != 0) sum
}

object P2 extends App {
	println(SolverP2(100).solution)
	println(SolverP2(4000000).solution)
}