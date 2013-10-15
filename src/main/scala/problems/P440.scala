package problems

import scala.math.pow

case class Board(val length: Int) 
case class Block(val pos: Int, digit: Option[Int]) {
	override def toString = digit match {
			case Some(x) => x.toString
			case None => "None"
		}
		
}

object EmptyBlock extends Block(2, None)

class Solver(n: Int) {

	val board = Board(n)
	val blocks = EmptyBlock +: (0 to 9).map(i => Block(1, Some(i))).toList

	//val tsolutions: Set[List[Block]] = ???

	def combinations(k: Int): List[List[Block]] = k match {
		case 0 => List(List())
		case _ => for {
			bl <- blocks
			c <- combinations(k - 1)
		} yield bl :: c
	}

	def blockSumPos(xs: List[Block]) = xs.foldLeft(0)((s, b) => s + b.pos)

	def t(x: Int) = (for {
		k <- 1 to x
		combs <- combinations(k)
		if (blockSumPos(combs) == x)
	} yield 't).size

	def s(x: Int) = (for {
		a <- 1 to x
		b <- 1 to x
		c <- 1 to x
		x: BigInt = t(pow(c, a).toInt)
		y: BigInt = t(pow(c, b).toInt)
	} yield x.gcd(y)).sum

	def tsolutions = t(n)
	def ssolutions = s(n)

}


object P440 extends App {

	// [error] (run-main) java.lang.OutOfMemoryError: Java heap space
	println(new Solver(2000).ssolutions)

}