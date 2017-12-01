package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente
import org.scalatest._

class TesteAplicacaoNomeada  extends FlatSpec with Matchers {

  behavior of "a named function def"

  it should "be evaluated to 16 when inc 1 in def inc (x) = x+1 " in {
    Ambiente.iniciar()

    val inc = new DecFuncao("inc", Array("x"), ExpSoma(ExpRef("x"), ValorInteiro(1)))

    Ambiente.declararFuncao(inc)

    val app = new ExpAplicacaoNomeada("inc", Array(ExpSoma(ValorInteiro(5), ValorInteiro(10))))

    app.avaliar() should be (ValorInteiro(16))

  }

  it should "be evaluated to 16 when inc2 (5,10,1) in def inc2 (x,y) = x+y+1" in{
    Ambiente.iniciar()

    val inc2 = new DecFuncao("inc2", Array("x","y","z"),
      ExpSoma(ExpSoma(ExpRef("x"),ExpRef("y")),ExpRef("z")))

    Ambiente.declararFuncao(inc2)

    val app = new ExpAplicacaoNomeada("inc2", Array(ValorInteiro(5),ValorInteiro(10),ValorInteiro(1)))

    app.avaliar() should be(ValorInteiro(16))
  }

  it should "be evaluated to false when xor (true,true) in def xor(x,y)=(!x&&Y) ||(x&&!Y)" in{
    val xor = new DecFuncao("xor", Array("x","y"),
      ExpOR(ExpAND(ExpNot(ExpRef("x")),ExpRef("y")),ExpAND(ExpRef("x"),ExpNot(ExpRef("y")))))

    Ambiente.declararFuncao(xor)

    val app = new ExpAplicacaoNomeada("xor",Array(ValorBooleano(true),ValorBooleano(true)))

    app.avaliar() should be(ValorBooleano(false))
  }
}
