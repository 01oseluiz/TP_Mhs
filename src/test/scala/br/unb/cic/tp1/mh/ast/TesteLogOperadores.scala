package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteLogOperadores extends FlatSpec with Matchers{

  behavior of "Expressions with Logic Operators "

  it should "be evaluated to Value(true) when true And true" in{
    val and = new ExpAND(ValorBooleano(true),ValorBooleano(true))

    and.verificaTipo should be(TBool())
    and.avaliar() should be(ValorBooleano(true))
  }

  it should "be evaluated to Value(false) when false And false" in{
    val or = new ExpOR(ValorBooleano(false),ValorBooleano(false))

    or.verificaTipo should be(TBool())
    or.avaliar() should be(ValorBooleano(false))
  }

  it should "be evaluated to Value(false) when !true" in{
    val not = new ExpNot(ValorBooleano(true))

    not.verificaTipo should be(TBool())
    not.avaliar() should be(ValorBooleano(false))
  }


}
