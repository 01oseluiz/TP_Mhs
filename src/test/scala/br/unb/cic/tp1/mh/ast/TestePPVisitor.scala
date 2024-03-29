package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.visitors.PPVisitor

import org.scalatest._


class TestePPVisitor extends  FlatSpec with Matchers{

  behavior of "an application of our visitor"

  it should "be evaluated to (3 + 4) + 5) when (3+4)+5" in {
    val soma = ExpSoma(ExpSoma(ValorInteiro(3), ValorInteiro(4)),
                                ValorInteiro(5))

    val c = new PPVisitor()

    soma.aceitar(c)
    
    c.sb.toString should be ("((3+4)+5)")
  }

}
