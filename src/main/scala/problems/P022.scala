/*

Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
containing over five-thousand first names, begin by sorting it into
alphabetical order. Then working out the alphabetical value for each name,
multiply this value by its alphabetical position in the list to obtain a name
score.

For example, when the list is sorted into alphabetical order, COLIN, which is
worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?

*/

package problems

object P22 extends App {

  val alphabet = List('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 
    'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z').zip(Stream.from(1)).toMap

  val xs = scala.io.Source.fromFile("./src/resources/names.txt")
    .getLines.mkString.replaceAll("\"", "").split(',').toList.sorted.zip(Stream.from(1))

  println(xs.map(t => BigInt(t._1.map(alphabet).sum * t._2)).sum)


}