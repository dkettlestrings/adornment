package functional

import org.scalatest.{FunSpec, Matchers}

class TestAllClothesOnBeforeLeaving extends FunSpec with Matchers {

  describe("AllClothesOnBeforeLeaving") {

    val hotWeatherClothes = DressState.nude + PutOnFootwear + PutOnHeadwear + PutOnShirt + PutOnPants

    val coldWeatherClothes = hotWeatherClothes + PutOnSocks + PutOnJacket


    it("should pass if all cold-weather clothes are on and it is cold") {

      AllClothesOnBeforeLeaving(coldWeatherClothes, LeaveHouse, COLD) should be (Pass)

    }


    it("should fail if any cold weather clothes are missing and it is cold") {

      val coldWeatherClothesMinusBoots = coldWeatherClothes - PutOnFootwear
      AllClothesOnBeforeLeaving(coldWeatherClothesMinusBoots, LeaveHouse, COLD) should be (Fail)

    }


    it("should pass if only hot weather clothes are on and it is hot") {

      AllClothesOnBeforeLeaving(hotWeatherClothes, LeaveHouse, HOT) should be (Pass)

    }


    it("should fail if any hot-weather clothes are missing and it is hot") {

      val hotWeatherClothesExceptShirt = hotWeatherClothes - PutOnShirt
      AllClothesOnBeforeLeaving(hotWeatherClothesExceptShirt, LeaveHouse, HOT) should be (Fail)

    }


    it("should pass if you are not trying to leave the house") {

      AllClothesOnBeforeLeaving(PJsOnly, PutOnShirt, COLD) should be (Pass)

    }
  }

}
