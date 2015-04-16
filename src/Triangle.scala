import processing.core.{PApplet, PVector}


class Triangle ( pos: PVector,  _p: PApplet = new PApplet) extends GeoShape(pos, _p){

  def drawShape(): Unit ={
    p.triangle(-20,0,0,40,20,0)
  }
}
