package ell.unionfind

import org.scalatest._

class UnionFindSpec extends FlatSpec with Matchers {

  "The unionFind 7,2" should "be true" in {
    val unionFind = UnionFind(10)
    unionFind.union(2, 3)
    unionFind.union(5, 6)
    unionFind.union(7, 6)
    unionFind.union(5, 3)
    unionFind.union(8, 9)
    unionFind.union(8, 6)
    unionFind.union(3, 4)
    unionFind.connected(7, 2) shouldEqual true
  }

  "The unionFind 2,2" should "be true" in {
    val unionFind = UnionFind(10)
    unionFind.union(2, 3)
    unionFind.union(5, 3)
    unionFind.union(5, 6)
    unionFind.connected(2, 2) shouldEqual true
  }

  "The unionFind " should "be false" in {
    val unionFind = UnionFind(10)
    unionFind.union(2, 3)
    unionFind.union(5, 3)
    unionFind.union(5, 6)
    unionFind.connected(7, 5) shouldEqual false
  }

}