import processing.core.{PApplet, PVector}

class Hexagon ( pos: PVector,  _p: PApplet) extends GeoShape(pos, _p){
  def drawShape(): Unit ={
    p.beginShape()
    p.vertex(-20, 0)
    p.vertex(-10, 20)
    p.vertex(10, 20)
    p.vertex(20, 0)
    p.vertex(10, -20)
    p.vertex(-10, -20)
    p.vertex(-20, 0)
    p.endShape()

  }

}
