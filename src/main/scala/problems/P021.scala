/*

Let d(n) be defined as the sum of proper divisors of n (numbers less than n
which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b, then a and b
are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; 
therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

*/

package problems


object P21 extends App {

  def divisors(n: Int) = (1 until n).filter(d => n % d == 0)

  val xs = (1 to 10000).map(n => (n, divisors(n).sum))
  val amicables = xs.filter { t => 
      (t._1 != t._2) && xs.exists(x => (x._1 == t._2) && (x._2 == t._1)) }
  println(amicables.map(_._1).sum)

}