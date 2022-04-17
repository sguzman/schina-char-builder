trait Prog extends App {
  import scala.io.Source

  type tup3 = Tuple3[Char, String, String]

  def f1 : Array[String] => String
  def f2 : String => Source
  def f3 : Source => String
  def f4 : String => List[String]
  def f5 : List[String] => List[tup3]
  def f6 : List[tup3] => List[String]

  def ff1 : String => tup3
  def ff2 : tup3 => String

  def ff = ff1 andThen ff2
  def ffmap(l: List[String]) = l map ff

  def f = f1 andThen f2 andThen f3 andThen f4 andThen ffmap
}

object Main {
  def main(args: Array[String]): Unit = {
    println("hi")
    args foreach println
    val arg = args.head


    println("bye")
  }
}
