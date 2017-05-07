package functional

import language.postfixOps

case class DressState(footwear: Boolean,
                      headwear: Boolean,
                      socks: Boolean,
                      shirt: Boolean,
                      jacket: Boolean,
                      legwear: Boolean,
                      pajamas: Boolean) {

  def apply(command: Command, temperature: Temperature): DressState = command match {

    case TakeOffPajamas => this withoutPajamas
    case PutOnFootwear => this withFootwear
    case PutOnHeadwear => this withHeadWear
    case PutOnSocks => this withSocks
    case PutOnShirt => this withShirt
    case PutOnJacket => this withJacket
    case PutOnPants => this withPants
    case LeaveHouse => this
  }

  def withPajamas = DressState(footwear, headwear, socks, shirt, jacket, legwear, pajamas = true)
  def withoutPajamas = DressState(footwear, headwear, socks, shirt, jacket, legwear, pajamas = false)
  def withFootwear = DressState(footwear = true, headwear, socks, shirt, jacket, legwear, pajamas)
  def withOutFootwear = DressState(footwear = false, headwear, socks, shirt, jacket, legwear, pajamas)
  def withHeadWear = DressState(footwear, headwear = true, socks, shirt, jacket, legwear, pajamas)
  def withSocks = DressState(footwear, headwear, socks = true, shirt, jacket, legwear, pajamas)
  def withShirt = DressState(footwear, headwear, socks, shirt = true, jacket, legwear, pajamas)
  def withOutShirt = DressState(footwear, headwear, socks, shirt = false, jacket, legwear, pajamas)
  def withJacket = DressState(footwear, headwear, socks, shirt, jacket = true, legwear, pajamas)
  def withPants = DressState(footwear, headwear, socks, shirt, jacket, legwear = true, pajamas)
}

object DressState {

  val initialState = DressState(
    footwear = false,
    headwear = false,
    socks = false,
    shirt = false,
    jacket = false,
    legwear = false,
    pajamas = true
  )

  val nude = DressState.initialState withoutPajamas
}
