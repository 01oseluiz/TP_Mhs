package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteMatOperadores extends FlatSpec with Matchers{

  behavior of "expressions with math operators"

  it should "be evaluated to Value(5) when 3+2" in{
    val soma = new ExpSoma(ValorInteiro(3), ValorInteiro(2))

    soma.verificaTipo should be(TInt())
    soma.avaliar() should be(ValorInteiro(5))
  }

  it should "be evaluated to Value(-1) when 4-5" in{
    val sub = new ExpSub(ValorInteiro(4), ValorInteiro(5))

    sub.verificaTipo should be(TInt())
    sub.avaliar() should be(ValorInteiro(-1))
  }

  it should "be evaluated to Value(30) when 5*6" in{
    val mult = new ExpMult(ValorInteiro(5), ValorInteiro(6))

    mult.verificaTipo should be(TInt())
    mult.avaliar() should be(ValorInteiro(30))
  }

  it should "be evaluated to Value(5) when 25/5" in{
    val div = new ExpDiv(ValorInteiro(25), ValorInteiro(5))

    div.verificaTipo should be(TInt())
    div.avaliar() should be(ValorInteiro(5))
  }

  it should "be evaluated to Value(4) when (2+3)*4/5" in{
    val soma = new ExpSoma(ValorInteiro(2), ValorInteiro(3))
    val mult = new ExpMult(soma, ValorInteiro(4))
    val div = new ExpDiv(mult, ValorInteiro(5))

    div.verificaTipo should be(TInt())
    div.avaliar() should be(ValorInteiro(4))
  }
}
