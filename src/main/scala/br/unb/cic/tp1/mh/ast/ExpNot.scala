package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpNot(rhs:Expressao) extends Expressao{
  override def avaliar(): Valor = {
    val v1 = rhs.avaliar().asInstanceOf[ValorBooleano]

    return ValorBooleano(!v1.valor)
  }

  override def verificaTipo: Tipo = {
    val t1 = rhs.verificaTipo

    if(t1 == TBool()){
      return TBool()
    }
    return TErro()
  }

  override def aceitar(v: Visitor): Unit = {
    v.visitar(this)
  }
}
