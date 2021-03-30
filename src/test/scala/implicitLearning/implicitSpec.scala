package implicitLearning

import helpers.Specification

class implicitSpec extends Specification{

  "what is implicit" should {
    "Implicit conversions easy" in {
      implicit def convertDoubleToInt(input: Double): Int = input.toInt

      val userId: Int = 29.12344567

      userId.toString shouldEqual "29"
    }

    "Implicit conversions complex" in {
      case class Baby(id: Int)
      case class Student(id: Int, name: String)
      implicit def convertBabyToStudent(baby: Baby): Student = Student(baby.id, "name")

      val babyStu: Student = Baby(2)
      babyStu.toString shouldEqual "Student(2,name)"
    }

    "Implicit parameters" in {

      def transport(name: String)(implicit remote: Remote, home: Home): String =
        s"To celebrate Spring Festival, go from $remote to $home, by $name"

      implicit val remote: Remote = Remote("Shanghai")
      implicit val home: Home = Home("Shanxi")
      transport("Train") shouldEqual
        "To celebrate Spring Festival, go from Remote(Shanghai) to Home(Shanxi), by Train"
    }

    "implicitly using" in {

      def transport(name: String): String = {
        //Todo: @inline def implicitly[T](implicit e: T) = e
        implicit val remote1: Remote = Remote("Shanghai")
        implicit val home1: Home = Home("Shanxi")

        val remote = implicitly[Remote]
        val home = implicitly[Home]
        s"To celebrate Spring Festival, go from $remote to $home, by $name"
      }

      transport("Airplane") shouldEqual
        "To celebrate Spring Festival, go from Remote(Shanghai) to Home(Shanxi), by Airplane"
    }
  }

}

case class Remote(str: String)
case class Home(str: String)