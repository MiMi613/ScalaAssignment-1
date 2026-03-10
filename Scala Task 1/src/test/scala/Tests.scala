import org.junit.Test
import org.junit.Assert._

class Test{

  @Test
  def testState_1(): Unit = {
    val result = Main.runWithStartState(3729, 0, 0, "0,1,5,4,3,0")
    assertEquals("0, 4, 2, 1, 4, 2, 5, 6, 7, 3, 1, 0", result)
  }

  @Test
  def testState_2(): Unit = {
    val result = Main.runWithStartState(8642024, 0, 0, "0,1,5,4,3,0")
    assertEquals("5, 7, 6, 5, 7, 0, 4, 0", result)
  }

}