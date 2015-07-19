import processing.core.{PApplet, PVector}

class  Ellipse ( pos: PVector,  _p: PApplet, a:Int) extends GeoShape(pos, _p, a ){
  override def drawShape(): Unit ={
    p.beginShape()

    p.vertex(a/2,-a/2)
    p.bezierVertex(0,a/2, -a/2,0,-a/2,a/2)
    p.bezierVertex(-a/2,a/2, 0,a/2,a/2,-a/2)
    p.endShape()
  }

}
