import WeekDay.WeekDay

object VisitBarStrategy {
  def pick(weekDay: WeekDay): VisitBarStrategy = {
    weekDay match {
      case WeekDay.Wednesday => VisitNightTrainStrategy
      case WeekDay.Friday => VisitTivoliStrategy
      case _ => VisitRoyClubStrategy
    }
  }
}

trait VisitBarStrategy {
  def visit(): Unit
}

case object VisitRoyClubStrategy extends VisitBarStrategy {
  def visit(): Unit = {
    println("Staying way too late in Roy club!")
  }
}

case object VisitTivoliStrategy extends VisitBarStrategy {
  def visit(): Unit = {
    println("Dancing in Tivoli!")
  }
}

case object VisitNightTrainStrategy extends VisitBarStrategy {
  def visit(): Unit = {
    println("Spending very cheap night in Night Train!")
  }
}

class RovaniemiResident(name: String) {

  def goOut(weekDay: WeekDay): Unit = {
    println(s"$name going out on $weekDay...")
    VisitBarStrategy.pick(weekDay).visit()
  }

}

object WeekDay extends Enumeration {
  type WeekDay = Value
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
}

object Strategy {
  def main(args: Array[String]) {
    val kimmo = new RovaniemiResident("Kimmo")
    kimmo.goOut(WeekDay.Wednesday)
    kimmo.goOut(WeekDay.Friday)
    kimmo.goOut(WeekDay.Saturday)
  }
}
