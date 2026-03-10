//> using jvm "system"
//> using scala "3.3.1"
//> using test.dep "junit:junit:4.13.2"
//> using test.dep "com.novocode:junit-interface:0.11"
//> using mainClass "Main"

class Computer($x: Int, $y: Int, $z:Int) {
  private var x: Int = $x
  private var y: Int = $y
  private var z: Int = $z


  def run(program: String): String = {
    val instructionList: List[Int] = program.split(',').map(_.charAt(0).asDigit).toList
    var ip: Int = 0
    var ret: List[Int] = List()
    while (ip < instructionList.length & ip >= 0){
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
        case _ => throw new RuntimeException("Invalid opcode")
      }

      ip = ip + 2
    }
    ret.mkString(", ")
  }
}



object Main {
  def main(args: Array[String]): Unit = {

    // use Computer(x_start, y_start, z_start) to create a new computer for assessment purposes
    // use yourComputer.run(<program>) to run and it will return the result.

    val StartState_1 = new Computer(3729, 0, 0)
    val result_1 = StartState_1.run("0,1,5,4,3,0")

    val StartState_2 = new Computer(8642024, 0, 0)
    val result_2 = StartState_2.run("0,3,5,4,3,0")


    System.out.println("Here is the result for start state 1: " + result_1)
    System.out.println("here is the result for start state 2: " + result_2)

    System.out.println()
    System.out.println("Now enter custom start state and program in the specific format: x/y/z/program")
    val in = scala.io.StdIn.readLine()
    val input = in.split("/")
    System.out.println(runWithStartState(input(0).toInt, input(1).toInt, input(2).toInt, input(3)))
  }

  def runWithStartState(x: Int, y: Int, z: Int, program: String): String = {
    val computer = new Computer(x, y, z)
    computer.run(program)
  }
}

