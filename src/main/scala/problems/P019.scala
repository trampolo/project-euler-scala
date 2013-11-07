/*

You are given the following information, 
but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, 
but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during 
the twentieth century (1 Jan 1901 to 31 Dec 2000)?

*/

package problems

import org.joda.time.DateTime
import org.joda.time.DateTimeConstants.SUNDAY

object P19 extends App {

	def days(d: DateTime): Stream[DateTime] = d #:: days(d.plusDays(1))

	val startDay = new DateTime(1901, 1, 1, 0, 0)
	println(days(startDay).takeWhile(_.getYear <= 2000)
		.filter(d => (d.getDayOfWeek == SUNDAY) && (d.getDayOfMonth == 1))
			.foldLeft(0)((s, x) => s + 1))

}