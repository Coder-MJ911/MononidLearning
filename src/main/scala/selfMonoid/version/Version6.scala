package selfMonoid.version

import selfMonoid.SelfMonoid
import selfMonoid.version.Version4.Foldable

object Version6 {
  def fold[F[_], A](as: F[A])(implicit evf: Foldable[F], eva: SelfMonoid[A]): A = {
    evf.foldleft(as)(eva.zero)(eva.combine)
  }

}

