import processing.core.{PApplet, PVector}

class Rectangle( pos: PVector,  _p: PApplet = new PApplet) extends GeoShape(pos, _p){
  def drawShape(): Unit ={
    //p.rectMode(p.CENTER)
    p.rect(0,0,40,40)
  }
}
