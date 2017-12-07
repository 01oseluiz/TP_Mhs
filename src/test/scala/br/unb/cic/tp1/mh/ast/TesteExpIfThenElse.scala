package br.unb.cic.tp1.mh.ast

import org.scalatest.{FlatSpec, Matchers}

class TesteExpIfThenElse extends FlatSpec with Matchers{
  behavior of "conditional expressions"

  it should "return expression return type when implications are of same type" in {
    val Imply = new ExpIfThenElse(ValorBooleano(true), ValorInteiro(10), ValorInteiro(5))
    Imply.verificaTipo should be(TInt())
  }

  it should "return TErro when implication types are different" in{
    val Imply = new ExpIfThenElse(ValorBooleano(true), ValorBooleano(false), ValorInteiro(5))
    Imply.verificaTipo should be(TErro())
  }

  it should "return TErro when condition is not Boolean type" in {
    val Imply = new ExpIfThenElse(ValorInteiro(0), ValorBooleano(true), ValorBooleano(false))
    Imply.verificaTipo should be(TErro())
  }

  it should "be evaluated to Valor(10) when If true Then 10 Else 5" in {
    val Imply = new ExpIfThenElse(ValorBooleano(true), ValorInteiro(10), ValorInteiro(5))
    Imply.avaliar() should be(ValorInteiro(10))
  }

  it should "be evaluated to Valor(true) when If true Then false Else true" in {
    val Imply = new ExpIfThenElse(ValorBooleano(false), ValorBooleano(false), ValorBooleano(true))
    Imply.avaliar() should be(ValorBooleano(true))
  }
}
