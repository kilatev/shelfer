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

}

trait BoxerBase {
    def number: Integer
    def calculate: BoxerBase
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

class EmptyBoxer() extends BoxerBase = {
    def number: Integer = 0
    def calculate: BoxerBase = throw new Error("EmptyBoxer could not be calculated")
}