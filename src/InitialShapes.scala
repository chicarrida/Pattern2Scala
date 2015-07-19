import processing.core.PVector

import scala.collection.mutable.ArrayBuffer

class InitialShapes {
  var shapes = ArrayBuffer[GeoShape]()
  var maxDistances = new PVector(-1, -1)

  def addToList(shape: GeoShape): Unit = {
    shapes += shape
    sortShapes
    calculateParentDistances
    calculateMaxDistances
  }

  def sortShapes: Unit = {
    shapes.sortWith { (a, b) =>
      if (a.position.x < b.position.x && a.position.y <= b.position.y) {
        false
      } else {
        true
      }
    }
  }

  def calculateParentDistances: Unit = {

    for (i <- 0 until shapes.length) {
      if (i > 0)
        shapes(i).determineDistanceToParent(shapes(i - 1))
      if (i != shapes.length - 1) {
        shapes(i).setChild(shapes(i + 1))
      }
    }
  }

  def calculateMaxDistances: Unit = {

    var tmpShapes = new ArrayBuffer[GeoShape]
    var xSorted = new ArrayBuffer[GeoShape]
    var ySorted = new ArrayBuffer[GeoShape]
    tmpShapes ++= shapes

    xSorted = tmpShapes.sortWith(_.position.x < _.position.x)
    maxDistances.x = Math.abs(xSorted(xSorted.length - 1).position.x - xSorted(0).position.x)

    ySorted = tmpShapes.sortWith(_.position.y < _.position.y)
    maxDistances.y = Math.abs(ySorted(ySorted.length - 1).position.y - ySorted(0).position.y)

  }
}
