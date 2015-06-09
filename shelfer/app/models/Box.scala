package models

abstract class Volume(implicit w: Int, implicit h: Int, implicit d: Int) {
    def hasSpace(): Boolean
}

class FullBox extends Volume {
    def hasSpace(): Boolean = false
}

class Box extends Volume {
    def fits(box: Box): Boolean = {
        if (this.h > box.h && this.w > box.w && this.d > box.d) true
        else false
      }
      
    def hasSpace(box: Box): Boolean = {
        return fits(Box(box.w, box.d, box.h)) || fits(Box(box.w, box.h, box.d)) || fits(Box(box.d, box.w, box.h)) || fits(Box(box.d, box.h, box.w))
    }
    
    def howMuch(wi:Integer, di:Integer): (Integer, Integer, Integer) = { // return total, wnumber, dnumber
      //finds maximal rectangle that fits current box
    }
    
    def getSpaceOne(wi:Integer, di:Int): (Integer, Box, Box) = { // number, Box 1, Box2
      //SpaceOne takes w and the d for boxes
      val (number, wnumber, dnumber) = howMuch(wi, di)
      val rbw = this.w - wnumber*wi
      val rbd = this.d
      val tbw = wi-rbw
      val tbd = this.d-dnumber*di
      return (number, new Box(rbw, rbd), new Box(tbw, tbd))
    }
    
    def getSpaceTwo(inner: Box): Integer = {
      //SpaceOne takes w and the d for boxes
      val (number, wnumber, dnumber) = howMuch(wi, di)
      
      val tbw = this.w
      val tbd = this.d-dnumber*di
      val rbw = this.w - wnumber*wi
      val rbd = this.d-tbd
      return (number, new Box(rbw, rbd), new Box(tbw, tbd))
    }

}

trait BoxerBase {
    def number: Integer
    def calculate: BoxerBase
    
}

class EmptyBoxer() extends BoxerBase = {
    def number: Integer = 0
    def calculate: BoxerBase = throw new Error("EmptyBoxer could not be calculated")
}

class Boxer(outer: Box, inner: Box) extends BoxeBase{
    val lef
    def calculate(): List[Boxer] = {
        if !outer.hasSpace(inner)
            return EmptyBoxer()
        else
            return left::calculate
    }
}

