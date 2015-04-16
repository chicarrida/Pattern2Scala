

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

    }
  }

    /**
     * * void drawPattern() {
  if (initialShapes.getShapes().size()==0) {
    return;
  }
  //  boolean drawChild = initialShapes.getShapes().size() > 2 ? true : false;
  fill(17, 130, 67);
  int yDist = (int)initialShapes.getMaxDistances().y/GRID_SIZE;
  int xDist = (int)initialShapes.getMaxDistances().x/GRID_SIZE;
  yDist += 1;
  xDist += 1;
  //if (yDist != 0 && xDist != 0) {
  if (yDist == 0) yDist = 1;
  if (xDist == 0) xDist = 1;

  for (int y = 0; y < FIELDS; ) {
    for (int x = 0; x < FIELDS; ) {
      println("drawing @ "+(x*GRID_SIZE)+", "+(y*GRID_SIZE));
      initialShapes.getShapes().get(0).draww(new PVector(x*GRID_SIZE, y*GRID_SIZE), true);
      x += xDist;
    }
    y+= yDist;
  }
}

     */cd Br  
  /

  def drawInitialShapes() = {}

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
    val shape = GeoShape.getShape(shapeType, pos)
    shape.setRotationAngle(rotationAngle)
    shape
  }

  override def keyPressed(): Unit ={
    if (key == 'r' || key == 'R') {
      shapes.shapes.clear
    } else if (key == 'i' || key == 'I') {
      showInitial = !showInitial;
    }else if (key >= 48 && key <= 57){
      shapeType = key
    }
    redraw();
  }
}



/*
*
* void drawPattern() {
  if (initialShapes.getShapes().size()==0) {
    return;
  }
  //  boolean drawChild = initialShapes.getShapes().size() > 2 ? true : false;
  fill(17, 130, 67);
  int yDist = (int)initialShapes.getMaxDistances().y/GRID_SIZE;
  int xDist = (int)initialShapes.getMaxDistances().x/GRID_SIZE;
  yDist += 1;
  xDist += 1;
  //if (yDist != 0 && xDist != 0) {
  if (yDist == 0) yDist = 1;
  if (xDist == 0) xDist = 1;

  for (int y = 0; y < FIELDS; ) {
    for (int x = 0; x < FIELDS; ) {
      println("drawing @ "+(x*GRID_SIZE)+", "+(y*GRID_SIZE));
      initialShapes.getShapes().get(0).draww(new PVector(x*GRID_SIZE, y*GRID_SIZE), true);
      x += xDist;
    }
    y+= yDist;
  }
}

void drawInitialShapes() {
  if (showInitial) {
    noFill();
    stroke(240, 0, 230);
    for (GeoShape s : initialShapes.getShapes ()) {
      s.drawAtInitialPos();
    }
  }
}

* */