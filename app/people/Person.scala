package people

class Person(fullName: String, currentAge:Int) {
  val name: String = fullName
  val age: Int = currentAge

  override
  def toString: _root_.java.lang.String ={
    s"Full Name: $name Age: $age"

  }
}
