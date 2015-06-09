package models

class VolumeObject(val h: Int, val w: Int, val d: Int){
  def calculateVolume(): Int = {
    h*w*d
  }

  override def toString(): String = {
    s"params ${this.h}, ${this.w}, ${this.d}"
  }

  def fits(vol: VolumeObject): Boolean = {
    if (this.h > vol.h && this.w > vol.w && this.d > vol.d) true
    else false
  }
  
  def fitSome(x: Int, y: Int): Map = {
      
  }
  
  def position(vol: VolumeObject): Map = {
      this.fitSome(vol.h, vol.w)
      this.fitSome(vol.w, vol.d)
      this.fitSome(vol.d, vol.h)
  }
}
