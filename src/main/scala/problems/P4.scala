package problems

case class SolverP4(n: Int) {

	def isPalindrome(x: Int) = x.toString.reverse == x.toString

	lazy val solution = for {
		a <- (n to 100 by -1)
		b <- (n to 100 by -1)
		if (isPalindrome(a * b)) 
	} yield (a * b, a, b)
}

object P4 extends App {
	println(SolverP4(999).solution.maxBy(_._1))
}