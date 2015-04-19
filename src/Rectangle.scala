import processing.core.{PApplet, PVector}

class Rectangle( pos: PVector,  _p: PApplet) extends GeoShape(pos, _p){
  def drawShape(): Unit ={
    p.rectMode(3)
    p.rect(0,0,40,40)
  }
}
