class Computer($x: Int, $y: Int, $z:Int) {
  var x: Int = $x
  var y: Int = $y
  var z: Int = $z


  def run(code: String): String = {
    var ip: Int = 0
    var ret: List[Int] = List()
    return "0"
  }
}



@main
def main(): Unit = {
  val StartState_1 = new Computer(3729, 0, 0)
  val result_1 = StartState_1.run("0,1,5,4,3,0")

  val StartState_2 = new Computer(8642024, 0, 0)
  val result_2 = StartState_1.run("0,3,5,4,3,0")
}

