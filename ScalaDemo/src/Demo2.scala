import scala.annotation.tailrec

object Demo2 {
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sum(f, a + 1, b)
  }

  def sumInts(a: Int, b: Int): Int = {
    sum(id, a, b)
  }

  def sumCubs(a: Int, b: Int): Int = {
    sum(cube, a, b)
  }

  def sumFactorials(a: Int, b: Int): Int = {
    sum(fact, a, b)
  }

  def id(x: Int): Int
  = x

  def cube(x: Int): Int
  = x * x * x

  @tailrec
  def fact(x: Int): Int
  = if (x == 0) 1 else fact(x - 1)
}
