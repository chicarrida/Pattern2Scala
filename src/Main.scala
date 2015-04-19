

import processing.core.{PVector, PApplet}


class Main extends PApplet {

  val GRID_SIZE: Int = 40;
  val FIELDS: Int = 16
  val shapes = new InitialShapes
  var shapeType: Int = 1
  var rotationAngle = 0
  var showInitial: Boolean = true

  override def setup() = {
    size(GRID_SIZE * FIELDS, GRID_SIZE * FIELDS)
    noLoop()
  }

  override def draw() = {
    background(125)
    noFill()
    drawPattern()
    drawInitialShapes()
    noLoop()
  }

  def drawPattern() = {
    if(shapes.shapes.length > 0){
      fill(17,130,67)
      val yDist = if(shapes.maxDistances.y == 0) 1 else (shapes.maxDistances.y/GRID_SIZE)+1
      val xDist = if(shapes.maxDistances.x == 0) 1 else (shapes.maxDistances.x/GRID_SIZE)+1
      for(y <- 0 to (FIELDS, yDist.asInstanceOf[Int]))
        for(x <- 0 to (FIELDS, xDist.asInstanceOf[Int])) {
          shapes.shapes(0).draww(new PVector(x * GRID_SIZE, y * GRID_SIZE), true)
          //println("x: " + x+" y: "+y)
        }
    }
  }

  def drawInitialShapes() = {
    if (showInitial) {
      noFill();
      stroke(240, 0, 230);
      for ( s <- shapes.shapes) s.drawAtInitialPos
    }
  }

  override def mouseReleased(): Unit = {
    val pos = getCurrentPosition
    val shape = setUpShape(pos)
    shapes.addToList(shape)
    redraw()
  }


  def getCurrentPosition: PVector = {
    val x = ((mouseX + GRID_SIZE / 2) / GRID_SIZE) * GRID_SIZE
    val y = ((mouseY + GRID_SIZE / 2) / GRID_SIZE) * GRID_SIZE
    new PVector(x, y);
  }

  def setUpShape(pos: PVector): GeoShape = {
    val shape = GeoShape.getShape(shapeType, pos, this)
    shape.setRotationAngle(rotationAngle)
    shape
  }

  override def keyPressed(): Unit ={
    if (key == 'r' || key == 'R') {
      shapes.shapes.clear
    } else if (key == 'i' || key == 'I') {
      showInitial = !showInitial;
    }else if (key >= 48 && key <= 57){
      shapeType = key -'0'
      println("shapeType" + shapeType)
    }
    redraw()
  }
}