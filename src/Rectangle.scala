import processing.core.{PApplet, PVector}

class Rectangle( pos: PVector,  _p: PApplet, a: Int) extends GeoShape(pos, _p, a){
  def drawShape(): Unit ={
    p.rectMode(3)
    p.rect(0,0,a,a)
  }
}
