package ADT

//sealed class Expr {
//    abstract fun isZero(v: Visitor): Boolean
//    abstract fun isAddZero(v: Visitor): Boolean
//    abstract fun simplifyExpr(v: Visitor): Expr
//
//    class Num(val value: Int) : Expr() {
//        override fun isZero(v: Visitor): Boolean = v.matchZero(this)
//        override fun isAddZero(v: Visitor): Boolean = v.matchAddZero(this)
//        override fun simplifyExpr(v: Visitor): Expr = v.doSimplifyExpr(this)
//    }
//}
//
//class Operate(val opName: String, val left: Expr, val right: Expr) : Expr() {
//    override fun isZero(v: Visitor): Boolean = v.matchZero(this)
//    override fun isAddZero(v: Visitor): Boolean = v.matchAddZero(this)
//    override fun simplifyExpr(v: Visitor): Expr = this
//
//}
//
//class Visitor {
//    fun matchAddZero(expr: Expr.Num): Boolean = false
//    fun matchAddZero(expr: Expr.Operate): Boolean = when (expr) {
//        Expr.Operate("+", Expr.Num(0), expr.right) -> true
//        Expr.Operate("+", expr.left, Expr.Num(0)) -> true
//        else -> false
//    }
//
//    fun matchZero(expr: Expr.Num): Boolean = expr.value == 0
//    fun matchZero(expr: Expr.Operate): Boolean = false
//    fun doSimplifyExpr(expr: Expr.Num): Expr = expr
//    fun doSimplifyExpr(expr: Expr.Operate, v: Visitor): Expr = when {
//        (expr.right is Expr.Num && v.matchAddZero(expr) && v.matchAddZero(expr.right))
//                && (expr.right is Expr.Operate && expr.left is Expr.Num) &&
//                v.matchZero(expr.right.left) -> expr.right.left
//        else -> expr
//    }
//
//
//}