package br.unb.cic.tp1.mh.ast
import br.unb.cic.tp1.mh.visitors.Visitor

class ExpIfThenElse(val If: Expressao, val Then: Expressao, val Else: Expressao) extends Expressao {
  override def avaliar(): Valor = {
    if (If.avaliar().asInstanceOf[ValorBooleano].valor) {
      Then.avaliar()
    }
    else{
      Else.avaliar()
    }
  }

  override def verificaTipo: Tipo = {
    val t1 = If.verificaTipo
    val t2 = Then.verificaTipo
    val t3 = Else.verificaTipo

    if (t1 == TBool() && t2 == t3) {
      return t2
    }
    TErro()
  }

  override def aceitar(v: Visitor): Unit = {
    v.visitar(this)
  }
}
