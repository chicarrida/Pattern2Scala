
import processing.core.{PVector, PApplet}
import scala.beans.BeanProperty


abstract class GeoShape(var position: PVector, val p: PApplet, val a:Int) {

  protected var distanceToParent = new PVector()
  @BeanProperty var child: GeoShape = null
  @BeanProperty var rotationAngle: Float = 0

  def determineDistanceToParent(parent: GeoShape): Unit = {
    distanceToParent.x = Math.abs(parent.position.x - position.x)
    distanceToParent.y = Math.abs(parent.position.y - position.y)
  }

  def draww(parentPos: PVector, drawChild: Boolean = false): Unit = {
      val x = parentPos.x + (if (distanceToParent != null) distanceToParent.x else 0)
      val y = parentPos.y + (if (distanceToParent != null) distanceToParent.x else 0)
      p.stroke(0, 0, 255)
      transformAndDraw(x, y)
      if (drawChild) {
        drawChlid(x toInt, y toInt)
      }
  }

  def transformAndDraw(x: Float, y: Float): Unit = {
    p.pushMatrix()
    p.translate(x, y)
    p.rotate(rotationAngle)
    drawShape()
    p.popMatrix()
  }

  def drawChlid(x: Int, y: Int): Unit = {
    if (child != null) {
      child.draww(new PVector(x, y), true)
    }
  }

  def drawShape()

  def drawAtInitialPos(): Unit = {
    transformAndDraw(position.x toInt, position.y toInt)
  }

  def drawGhost(x: Float, y: Float): Unit ={
    //println("draw ghost at "+x+" ,"+y)
    p.noFill()
    p.stroke(255,0,0)
    transformAndDraw(x,y)
  }
}


  object GeoShape {
    def getShape(s: Int, pos: PVector, p: PApplet, size:Int): GeoShape = {
      s match {
        case 1 => return new Rectangle(pos,p,size)
        case 2 => return new Hexagon(pos,p,size)
        case 3 => return new Triangle(pos,p,size)
        case 4 => return new Ellipse(pos,p,size)
        case 5 => return new Rectangle(pos,p,size/2) // small rectangle
        case _ => return new Rectangle(pos,p,size)
      }
    }
  }

