class Computer($x: Int, $y: Int, $z:Int) {
  private var x: Int = $x
  private var y: Int = $y
  private var z: Int = $z


  def run(program: String): String = {
    var instructionList: List[Int] = program.split(',').map(_.charAt(0).asDigit).toList
    var ip: Int = 0
    var ret: List[Int] = List()
    while (ip < instructionList.length){
      val opcode = instructionList(ip)
      val literal_operand = instructionList(ip + 1)
      val combo_operand = literal_operand match {
        case n if n >= 0 && n <= 3 => n
        case 4 => x
        case 5 => y
        case 6 => z
        case _ => throw new RuntimeException("Invalid operand")
      }

      opcode match {
        case 0 => x = x / math.pow(2, combo_operand).toInt
        case 1 => y = y ^ literal_operand
        case 2 => y = combo_operand % 8
        case 3 => if (x == 0) {} else ip = literal_operand - 2
        case 4 => y = y ^ x
        case 5 => ret = ret :+ (combo_operand % 8)
        case 6 => y = x / math.pow(2, combo_operand).toInt
        case 7 => z = x / math.pow(2, combo_operand).toInt
      }

      ip += 2
    }
    return ret.mkString(", ")
  }
}



object Main {
  def main(args: Array[String]): Unit = {
    val StartState_1 = new Computer(3729, 0, 0)
    val result_1 = StartState_1.run("0,1,5,4,3,0")

    val StartState_2 = new Computer(8642024, 0, 0)
    val result_2 = StartState_2.run("0,3,5,4,3,0")

    System.out.println(result_1)
    System.out.println(result_2)
  }
}

