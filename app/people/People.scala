package people

import scala.collection.mutable.ListBuffer

object People {

  def People = {
    val peopleList = new ListBuffer[Person]
    for(i <- 1 to 70){
      peopleList.append(new Person(s"name${"a"*i}", 15+i))
    }
    peopleList
  }
}
