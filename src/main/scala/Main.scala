trait Prog extends App {
  import scala.io.Source

  type tup3 = Tuple3[Char, String, String]

  val filePath = "./data.tsv"

  def init : Array[String] = super.args

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

@main def hello: Unit = 
  println("Hello world!")
  println(msg)

def msg = "I was compiled by Scala 3. :)"
