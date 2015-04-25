import processing.core.{PApplet, PVector}

class Hexagon ( pos: PVector,  _p: PApplet, a:Int) extends GeoShape(pos, _p, a){
  def drawShape(): Unit ={
    p.beginShape()
    p.vertex(-a/2, 0)
    p.vertex(-a/4, a/2)
    p.vertex(a/4, a/2)
    p.vertex(a/2, 0)
    p.vertex(a/4, -a/2)
    p.vertex(-a/4, -a/2)
    p.vertex(-a/2, 0)
    p.endShape()

  }

}
