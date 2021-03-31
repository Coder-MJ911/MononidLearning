package selfMonoid

import helpers.Specification
import version.Version1._

class Version1Spec extends Specification{

  "version 1 sum" in {
    sum(List(1, 2, 3, 4, 5)) shouldEqual 15
  }

  "version 1 multi" in {
    multi(List(1, 2, 3, 4, 5)) shouldEqual 120
  }

}
