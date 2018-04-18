import forcomp.Anagrams.Occurrences

def subtract(x: Occurrences, y: Occurrences): Occurrences = x match {
  case head :: tail => y filter (p => p._1 == head._1) match {
    case h :: _ => if (head._2 > h._2) (head._1, head._2 - h._2) :: subtract(tail, y) else subtract(tail, y)
    case _ => head :: subtract(tail, y)
  }
  case _ => List()
}

subtract(List(('a', 2)), List(('a', 2)))