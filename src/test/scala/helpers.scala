import org.scalatest.OneInstancePerTest
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

package object helpers {
  trait Specification extends AnyWordSpec with Matchers with OneInstancePerTest
}
