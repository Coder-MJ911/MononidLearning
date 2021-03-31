package selfMonoid

import helpers.Specification
import version.Version6._
import testHelper.helperInstance._

class Version6Spec extends Specification{

  "ultimate goal to use implicit with singleton" in {
    fold(List(1, 2, 3, 4, 5)) shouldEqual 15
    //Todo: The writing in this last version is very similar to the writing in the Cats library.
  }

}
