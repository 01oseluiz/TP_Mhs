package br.unb.cic.tp1.mh.visitors
import br.unb.cic.tp1.mh.ast._

class PPVisitor extends Visitor {

  val sb = new StringBuilder("")

  override def visitar(exp: ValorInteiro): Unit = {
    sb.append(exp.valor.toString)
  }

  override def visitar(exp: ValorBooleano): Unit = {
    sb.append(exp.valor.toString)
  }

  override def visitar(exp: ExpSoma): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb += '+'
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpSub): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb += '-'
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpDiv): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb += '/'
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpMult): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb += '*'
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpOR): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb += '|'
    sb += '|'
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpAND): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb += '&'
    sb += '&'
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpNot): Unit = {
    sb += '!'
    exp.rhs.aceitar(this)
  }

  override def visitar(exp: ExpLet): Unit = { }

  override def visitar(exp: ExpLambda): Unit = { }

  override def visitar(exp: ExpAplicacaoLambda): Unit = { }

  override def visitar(exp: ExpAplicacaoNomeada): Unit = { }

  override def visitar(exp: ExpRef): Unit = { }

  override def visitar(exp: Closure): Unit = { }
}
