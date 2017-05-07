package main

import functional._

object IntToCommand {

  private val mapping: Map[Int, Command] = Map(
    1 -> PutOnFootwear,
    2 -> PutOnHeadwear,
    3 -> PutOnSocks,
    4 -> PutOnShirt,
    5 -> PutOnJacket,
    6 -> PutOnPants,
    7 -> LeaveHouse,
    8 -> TakeOffPajamas
  )

  def apply(i: Int): Command = mapping(i)

}
