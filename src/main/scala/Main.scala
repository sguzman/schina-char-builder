trait ProgTrait extends App {
  import scala.io.Source

  type tup3 = Tuple3[Char, String, String]

  val f1 : Array[String] => String
  val f2 : String => Source
  val f3 : Source => String
  val f4 : String => Array[String]
  val f5 : Array[String] => Array[Array[String]]
  val f6 : Array[Array[String]] => Array[String]

  val ff1 : String => Array[String]
  val ff2 : Array[String] => String

  final def f = f1 andThen f2 andThen f3 andThen f4
}

class Prog extends ProgTrait {
  import scala.io.Source

  override final val f1 = _ apply 0
  override final val f2 = Source fromFile _
  override final val f3 = _.getLines.mkString
  override final val f4 = _ split "\n"
  override final val f5 = _ map ff1
  override final val f6 = _ map ff2

  override final val ff1 = _ split "\t"
  override final val ff2 = (list: Array[String]) => s"{\n" +
    s"\"char\": ${list(0)},\n" +
    s"\"pro\": ${list(1)},\n" +
    s"\"def\": ${list(2)}\n" +
    s"}"

  def apply(args: Array[String]) = super.f(args)
}

object Main {
  def main(args: Array[String]): Unit = {
    println("hi")
    args foreach println
    val prog = Prog()
    val output = prog(args)
    output foreach println

    println("bye")
  }
}
