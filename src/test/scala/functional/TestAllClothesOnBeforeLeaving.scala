package functional

import org.scalatest.{FunSpec, Matchers}

class TestAllClothesOnBeforeLeaving extends FunSpec with Matchers {

  describe("AllClothesOnBeforeLeaving") {

    it("should pass if all cold-weather clothes are on and it is cold") {

      val coldWeatherClothes = DressState(Some(Boots), Some(Hat), Some(Socks), Some(Shirt), Some(Jacket), Some(Pants), None)
      AllClothesOnBeforeLeaving(coldWeatherClothes, LeaveHouse, COLD) should be (Pass)

    }

    it("should fail if all cold-weather clothes are on plus pajamas and it is cold") {

      val coldWeatherClothesAndPjs = DressState(Some(Boots), Some(Hat), Some(Socks), Some(Shirt), Some(Jacket), Some(Pants), Some(Pajamas))
      AllClothesOnBeforeLeaving(coldWeatherClothesAndPjs, LeaveHouse, COLD) should be (Fail)

    }

    it("should fail if any cold weather clothes are missing and it is cold") {

      val coldWeatherClothesMinusBoots = DressState(None, Some(Hat), Some(Socks), Some(Shirt), Some(Jacket), Some(Pants), None)
      AllClothesOnBeforeLeaving(coldWeatherClothesMinusBoots, LeaveHouse, COLD) should be (Fail)

    }

    it("should fail if any cold weather clothes are swapped with hot weather clothes and it is cold") {

      val coldWeatherClothesExceptSandals = DressState(Some(Sandals), Some(Hat), Some(Socks), Some(Shirt), Some(Jacket), Some(Pants), None)
      AllClothesOnBeforeLeaving(coldWeatherClothesExceptSandals, LeaveHouse, COLD) should be (Fail)

    }

    it("should pass if only hot weather clothes are on and it is hot") {

      val hotWeatherClothes = DressState(Some(Sandals), Some(Sunglasses), None, Some(Shirt), None, Some(Shorts), None)
      AllClothesOnBeforeLeaving(hotWeatherClothes, LeaveHouse, HOT) should be (Pass)

    }

    it("should fail if only hot weather clothes are on plus pajamas and it is hot") {

      val hotWeatherClothesPlusPjs = DressState(Some(Sandals), Some(Sunglasses), None, Some(Shirt), None, Some(Shorts), Some(Pajamas))
      AllClothesOnBeforeLeaving(hotWeatherClothesPlusPjs, LeaveHouse, HOT) should be (Fail)

    }

    it("should fail if any hot-weather clothes are missing and it is hot") {

      val hotWeatherClothesExceptShirt = DressState(Some(Sandals), Some(Sunglasses), None, None, None, Some(Shorts), None)
      AllClothesOnBeforeLeaving(hotWeatherClothesExceptShirt, LeaveHouse, HOT) should be (Fail)

    }

    it("should fail if any non-hot weather clothes are on (except pajamas) and it is hot") {

      val hotWeatherClothesExceptBoots = DressState(Some(Boots), Some(Sunglasses), None, Some(Shirt), None, Some(Shorts), Some(Pajamas))
      AllClothesOnBeforeLeaving(hotWeatherClothesExceptBoots, LeaveHouse, HOT) should be (Fail)

    }


    it("should pass if you are not trying to leave the house") {

      val inPJs = DressState(None, None, None, None, None, None, Some(Pajamas))
      AllClothesOnBeforeLeaving(inPJs, PutOn(Shirt), COLD) should be (Pass)

    }
  }

}
