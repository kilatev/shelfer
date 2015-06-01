import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import models.VolumeObject

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class VolumeObjectSpec extends Specification {

  "VolumeObject" should {

    "calculate volume of 1, 2 ,3 " in new WithApplication{
      val vol = new VolumeObject(1, 2, 3)

      vol.calculateVolume() must beEqualTo(6)
    }

    "2,3,4 should fit 1,2,3" in new WithApplication{
      val vol1 = new VolumeObject(2, 3, 4)
      val vol2 = new VolumeObject(1, 2, 3)
      vol1.fits(vol2) must beTrue
    }
  }
}
