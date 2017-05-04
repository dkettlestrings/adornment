package functional

case class DressState(footwear: Option[Footwear],
                      headwear: Option[Headwear],
                      socks: Option[Socks.type],
                      shirt: Option[Shirt.type],
                      jacket: Option[Jacket.type],
                      legwear: Option[Legwear],
                      pajamas: Option[Pajamas.type])

object DressState {

  val initialState = DressState(None, None, None, None, None, None, Some(Pajamas))
}
