package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.exceptions.ExpressaoInvalida
import br.unb.cic.tp1.mh.memoria.Ambiente
import br.unb.cic.tp1.mh.visitors.Visitor

class ExpAplicacaoNomeada(val nome: String, val argumentoAtual : Array[Expressao]) extends Expressao {

  override def avaliar(): Valor = {
    val decFuncao = Ambiente.recuperarFuncao(nome)
    var count = 0

    Ambiente.novoAmbiente()
    try {
      decFuncao.argFormal.foreach { arg =>
        Ambiente.atualiza(arg, argumentoAtual(count).avaliar())
        count += 1
      }
    }catch{
      case ex:NullPointerException => throw ExpressaoInvalida()
      case ex:ArrayIndexOutOfBoundsException => throw  ExpressaoInvalida()
    }

    val res = decFuncao.corpo.avaliar()

    Ambiente.removeAmbiente()

    return res
  }

  override def verificaTipo: Tipo = TErro()

  override def aceitar(v: Visitor): Unit = {
    v.visitar(this)
  }
}
