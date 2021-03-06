package ac.ncic.syssw.pppuc03

object LongMul {
  def addNums(x: String, y: String) = {
    val padSize = x.length max y.length
    val paddedX = "0" * (padSize - x.length) + x
    val paddedY = "0" * (padSize - y.length) + y
    val (sum, carry) = (paddedX zip paddedY).foldRight(("", 0)) {
      case ((dx, dy), (acc, carry)) =>
        val sum = dx.asDigit + dy.asDigit + carry
        ((sum % 10).toString + acc, sum / 10)
    }
    if (carry != 0) carry.toString + sum else sum
  }

  def mulByDigit(num: String, digit: Int) = {
    val (mul, carry) = num.foldRight(("", 0)) {
      case (d, (acc, carry)) =>
        val mul = d.asDigit * digit + carry
        ((mul % 10).toString + acc, mul / 10)
    }
    if (carry != 0) carry.toString + mul else mul
  }

  def mul(x: String, y: String) = 
    y.foldLeft("")((acc, digit) => addNums(acc + "0", mulByDigit(x, digit.asDigit)))
}

