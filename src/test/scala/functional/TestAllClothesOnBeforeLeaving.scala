package functional

import org.scalatest.{FunSpec, Matchers}

class TestAllClothesOnBeforeLeaving extends FunSpec with Matchers {

  describe("AllClothesOnBeforeLeaving") {

    val coldWeatherClothes = DressState(
      footwear = true,
      headwear = true,
      socks = true,
      shirt = true,
      jacket = true,
      legwear = true,
      pajamas = false
    )

    val hotWeatherClothes = DressState(
      footwear = true,
      headwear = true,
      socks = false,
      shirt = true,
      jacket = false,
      legwear = true,
      pajamas = false
    )


    it("should pass if all cold-weather clothes are on and it is cold") {

      AllClothesOnBeforeLeaving(coldWeatherClothes, LeaveHouse, COLD) should be (Pass)

    }

    it("should fail if all cold-weather clothes are on plus pajamas and it is cold") {

      val coldWeatherClothesAndPjs = coldWeatherClothes.withPajamas
      AllClothesOnBeforeLeaving(coldWeatherClothesAndPjs, LeaveHouse, COLD) should be (Fail)

    }

    it("should fail if any cold weather clothes are missing and it is cold") {

      val coldWeatherClothesMinusBoots = coldWeatherClothes.withOutFootwear
      AllClothesOnBeforeLeaving(coldWeatherClothesMinusBoots, LeaveHouse, COLD) should be (Fail)

    }


    it("should pass if only hot weather clothes are on and it is hot") {

      AllClothesOnBeforeLeaving(hotWeatherClothes, LeaveHouse, HOT) should be (Pass)

    }

    it("should fail if only hot weather clothes are on plus pajamas and it is hot") {

      val hotWeatherClothesPlusPjs = hotWeatherClothes.withPajamas
      AllClothesOnBeforeLeaving(hotWeatherClothesPlusPjs, LeaveHouse, HOT) should be (Fail)

    }

    it("should fail if any hot-weather clothes are missing and it is hot") {

      val hotWeatherClothesExceptShirt = hotWeatherClothes.withOutShirt
      AllClothesOnBeforeLeaving(hotWeatherClothesExceptShirt, LeaveHouse, HOT) should be (Fail)

    }


    it("should pass if you are not trying to leave the house") {

      val inPJs = DressState.initialState
      AllClothesOnBeforeLeaving(inPJs, PutOnShirt, COLD) should be (Pass)

    }
  }

}
