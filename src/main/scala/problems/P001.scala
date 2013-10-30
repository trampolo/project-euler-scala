package problems
import scala.language.postfixOps

case class SolverP1(n: Int) {

  def solution = (1 until n) filter (x => (x % 3 == 0) || (x % 5 == 0)) sum
}

object P1 extends App {
  println(SolverP1(1000).solution)
}