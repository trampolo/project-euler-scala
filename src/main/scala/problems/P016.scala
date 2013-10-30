/*

215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 21000?

*/

package problems

object P16 extends App {

  println((1 to 1000).foldLeft(BigInt(1))((p, x) => p * 2).toString.map(c => c.toString.toInt).sum)
}