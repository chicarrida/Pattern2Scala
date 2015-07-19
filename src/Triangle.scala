import processing.core.{PApplet, PVector}


class Triangle ( pos: PVector,  _p: PApplet, a: Int) extends GeoShape(pos, _p, a){

  def drawShape(): Unit ={

    p.triangle(-a/2,-a/2,0,a/2,a/2,-a/2)
  }
}
