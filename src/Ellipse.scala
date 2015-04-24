import processing.core.{PApplet, PVector}

class Ellipse ( pos: PVector,  _p: PApplet) extends GeoShape(pos, _p){
  override def drawShape(): Unit ={
    p.beginShape()

    p.vertex(20,-20)
    p.bezierVertex(0,20, -20,0,-20,20)
    p.bezierVertex(-20,20, 0,20,20,-20)
    p.endShape()
  }

}
