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
// al modificar el valor de "a" los cambios se propagan hacia las demas variables inteligentes
// es decir estan receptan el nuevo valor
a()=5

println(f.now)


//Aplicando Observadores en el codigo

val a= Var(1)
val b =Rx{2*a()}
var count = 0
val o = b.trigger{count =b.now } // al parecer solo sirve agregando el now (investigare a que se debe)
  println(count)
a()=4
//Continuando ampliando conocimientos
println(count)
o.kill()// matamos al Observer por ende ya no se actualizara los datos
a() = 3
println(count)