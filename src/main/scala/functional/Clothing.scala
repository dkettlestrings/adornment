package functional

sealed trait Clothing

sealed trait Footwear extends Clothing
case object Sandals extends Footwear
case object Boots extends Footwear

sealed trait Headwear extends Clothing
case object Sunglasses extends Headwear
case object Hat extends Headwear

case object Socks extends Clothing

case object Shirt extends Clothing

case object Jacket extends Clothing

sealed trait Legwear extends Clothing
case object Shorts extends Legwear
case object Pants extends Legwear

case object Pajamas extends Clothing
