import HelloWorld._

import frege.run8.{Thunk , Box}

object Main extends App {

  def time(f: => Unit): Double = {
    val initial = System.nanoTime()
    f
    (System.nanoTime() - initial) * 1e-6
  }

  val fregeTime = time { fact(new Box(120000)) }
  val scalaTime = time { (BigInt(2) to 120000).product }
  val scalaTime2 = time { (BigInt(2) to 120000).par.product }

  println(fregeTime, scalaTime, scalaTime2)

  println(salute.call())
}
