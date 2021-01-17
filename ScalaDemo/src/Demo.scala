import scala.util.control.Breaks.{break, breakable}

object Demo {
  def main(args: Array[String]): Unit = {
    var i = 10
    val x = while (i < 15) {
      i += 1
    }
    println(x)
  }

  breakable {
    for (j <- 1 to 10) {
      if (j % 2 == 0) {
        break()
      }
    }
  }

  def sumInts(a: Int, b: Int): Int = {
    if (a > b) 0 else a + sumInts(a + 1, b)
  }

  def sumCubes(a: Int, b: Int): Int = {
    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
  }

  def sumFactorials(a: Int, b: Int): Int = {
    if (a > b) 0 else fact(a) + sumFactorials(a + 1, b)
  }

//  求立方
  def cube(i: Int): Int = {
    i * i * i
  }

//求阶乘
  def fact(n: Int): Int = {
    if (n == 0) return 1
    n * fact(n - 1)
  }
}
