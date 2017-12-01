package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente
import org.scalatest._

class TesteValores extends FlatSpec with Matchers {


  "An integer value 5 and a Boolean value true" should "be evaluated to 5 and true" in {
    val val5 = ValorInteiro(5)
    val valTrue = ValorBooleano(true)

    valTrue.avaliar() should be (ValorBooleano(true))
    val5.avaliar() should be (ValorInteiro(5))
  }

}
