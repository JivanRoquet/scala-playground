sealed trait Action {
  def score(other: Action): Int
}

case object Betray extends Action {
  override def toString = "betrays"
  def score(other: Action) = other match {
    case Betray => 5
    case Cover  => 0
  }
}

case object Cover extends Action {
  override def toString = "covers"
  def score(other: Action) = other match {
    case Betray => 8
    case Cover  => 1
  }
}

object Game {
  def turn(a: Prisoner, b: Prisoner) = {
    val (actionA, actionB) = (a.play, b.play)
    println(s"$a $actionA – $b $actionB")
    val scoreA = actionA.score(actionB)
    val scoreB = actionB.score(actionA)
    a.history = actionB :: a.history
    b.history = actionA :: b.history
    a.years += scoreA
    b.years += scoreB
  }

  def main(args: Array[String]) = {
    val prisoners = List(NiceGuy, Bastard, TitForTat, Average, Alternate, Rotate)
    for {
      pA <- prisoners
      pB <- prisoners
      if pA != pB
    } yield {
      pA.history = List[Action]()
      pB.history = List[Action]()
      (1 to 10).foreach { _ =>
        turn(pA, pB)
      }
      println()
    }

    prisoners.foreach { prisoner =>
      println(s"$prisoner: ${prisoner.years} years in prison")
    }
  }
}

trait Prisoner {
  var history = List[Action]()
  var years = 0
  def play(): Action
}

object NiceGuy extends Prisoner {
  override def toString = "NiceGuy"
  def play: Action = Cover
}

object Bastard extends Prisoner {
  override def toString = "Bastard"
  def play: Action = Betray
}

object TitForTat extends Prisoner {
  override def toString = "TitForTat"
  def play: Action = history.headOption match {
    case Some(action) if action == Betray => Betray
    case Some(action) if action == Cover  => Cover
    case None         => Cover
  }
}

object Average extends Prisoner {
  override def toString = "Average"
  def play: Action =
    if (history.count(_ == Betray) > history.count(_ == Cover)) Betray
    else Cover
}

object Alternate extends Prisoner {
  override def toString = "Alternate"
  def play: Action =
    if (history.length % 2 == 0) Betray
    else Cover
}

object Rotate extends Prisoner {
  override def toString = "Rotate"
  def play: Action =
    if (history.length % 3 == 0) Betray
    else Cover
}
