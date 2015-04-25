

import processing.core.{PVector, PApplet}


class Main extends PApplet {

  val GRID_SIZE: Int = 40;
  val FIELDS: Int = 16
  val shapes = new InitialShapes
  var shapeType: Int = 1
  var rotationAngle: Float = 0
  var showInitial: Boolean = true

  override def setup() = {
    size(GRID_SIZE * FIELDS, GRID_SIZE * FIELDS)
    noLoop()
  }

  override def draw() = {
    background(125)
   // testSortingOfShapes()
    noFill()
    drawPattern()
    drawInitialShapes()
    noLoop()
  }

  def drawPattern() = {
    if (shapes.shapes.length > 0) {
      fill(17, 130, 67)
      val yDist = if (shapes.maxDistances.y == 0) 1 else (shapes.maxDistances.y / GRID_SIZE) + 1
      val xDist = if (shapes.maxDistances.x == 0) 1 else (shapes.maxDistances.x / GRID_SIZE) + 1
      for (y <- 0 to(FIELDS, yDist.asInstanceOf[Int]))
        for (x <- 0 to(FIELDS, xDist.asInstanceOf[Int])) {
          shapes.shapes(0).draww(new PVector(x * GRID_SIZE, y * GRID_SIZE), true)
          ellipse(x * GRID_SIZE, y * GRID_SIZE, 5, 5)
        }
    }
  }

  def drawInitialShapes() = {
    if (showInitial) {
      noFill();
      stroke(240, 0, 230);
      for (s <- shapes.shapes) s.drawAtInitialPos
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
    println("pos @ " + x + " ," + y)
    new PVector(x, y);
  }

  def setUpShape(pos: PVector): GeoShape = {
    val shape = GeoShape.getShape(shapeType, pos, this, GRID_SIZE)
    shape.setRotationAngle(rotationAngle)
    println("Rotation Angle "+rotationAngle)
    shape
  }

  override def keyPressed(): Unit = {
    if (key == 'c' || key == 'C') {
      shapes.shapes.clear
    } else if (key == 'i' || key == 'I') {
      showInitial = !showInitial;
    } else if (key >= 48 && key <= 57) {
      shapeType = key - '0'
      println("shapeType" + shapeType)
    } else if (key == 'D' || key == 'd') {
      shapes.shapes.remove(shapes.shapes.size - 1)
    }
    else if (key == 'r' || key == 'R') {
      rotationAngle += (Math.PI/2).toFloat
    }
    redraw()
  }


  def testSortingOfShapes(): Unit = {
    val t = new Triangle(new PVector(2* GRID_SIZE, 4*GRID_SIZE), this, GRID_SIZE)
    val r = new Rectangle(new PVector(4* GRID_SIZE, 3* GRID_SIZE), this, GRID_SIZE)
    val h = new Hexagon(new PVector(4*GRID_SIZE, 5*GRID_SIZE) ,this, GRID_SIZE)

    shapes.addToList(h)
    shapes.addToList(t)
    shapes.addToList(r)
    for(s <- shapes.shapes)println(s)
    println("max Distances" +shapes.maxDistances.x+", "+ shapes.maxDistances.y)

  }

}
