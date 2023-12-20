import rx._

implicit  val ctx: Ctx.Owner = Ctx.Owner.safe()

val a = Var (3)
val b = Var (4)
val c = Var (5)

val d = Rx{ a() +b() / c()}

println(d)
