package ell.unionfind

/**
 * Union Find Algorithms I
 * 	QuickUnion - weight - with path compression
 */
case class UnionFind(numberID: Int) {
  val ids = (0 until numberID).toArray
  val rootLevel = Array.fill[Int](10)(1)

  /**
   * Using a recursion to find the root.
   *
   * @return the root of the element
   */
  private def root(i: Int): Int = {
    //@TODO  path compression*/
    
    val idx = ids(i)

    if (idx == i)
      idx
    else
      root(idx)
  }

  /**
   * Union
   *
   */
  def union(a: Int, b: Int): Unit = {
    val roota = root(a)
    val rootb = root(b)

    if (roota != rootb) {
      if (rootLevel(roota) < rootLevel(rootb)) {
        ids(roota) = rootb
        rootLevel(rootb) += rootLevel(roota)
      } else {
        ids(rootb) = roota
        rootLevel(roota) += rootLevel(rootb)
      }
    }
  }

  /**
   * Compare if the a and b has the same root
   */
  def connected(a: Int, b: Int): Boolean = {
    root(a) == root(b)
  }

}

object UnionFind extends App {
  val unionFind = UnionFind(10)
  unionFind.union(2, 3)
  unionFind.union(5, 6)
  unionFind.union(7, 6)
  unionFind.union(5, 3)
  unionFind.union(8, 9)
  unionFind.union(8, 6)
  unionFind.union(3, 4)
  
  println(unionFind.connected(9, 4))
  unionFind.ids.foreach { x => println(x) }
  unionFind.rootLevel.foreach(print(_))

}

