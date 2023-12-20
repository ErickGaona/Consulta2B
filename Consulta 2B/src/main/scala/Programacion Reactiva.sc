import rx._

implicit  val ctx: Ctx.Owner = Ctx.Owner.safe()

val a = Var[Int]  (1)
val b = Var[Int] (2)

// Segunda instancia (cambia de valor)
val c = Rx{ a() +b()} // 5 + 2 = 7
val d = Rx{ c() *5}   //7 * 5 = 35
val e = Rx{ c() +4}   //7 + 4 = 11
val f = Rx{ d() +e()+4}  //35 + 11 +4 = 50

println(f.now)

a()=5

println(f.now)