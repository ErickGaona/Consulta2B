import rx._ // importando Libreria Rx.

// defino el contexto implícito para la programación reactiva
implicit val ctx: Ctx.Owner = Ctx.Owner.safe()

// Creo dos variables reactivas -> (Vars) con valores iniciales
val a = Var[Int](1)
val b = Var[Int](2)

// creo otras variables reactivas (Rxs) que dependen de a y b
val c = Rx { a() + b() }       // c = 1 + 2 = 3
val d = Rx { c() * 5 }         // d = 3 * 5 = 15
val e = Rx { c() + 4 }         // e = 3 + 4 = 7
val f = Rx { d() + e() + 4 }   // f = 15 + 7 + 4 = 26

// Se imprime el valor actual de f
println(f.now)  // Salida: 26

// modifico el valor de la variable (a) lo que provoca que las dependencias se actualicen automáticamente
a() = 5                  // 5 + 2 = 7
                         //7 * 5 = 35
                         //7 + 4 = 11
                         //35 + 11 +4 = 50



// imprimo el nuevo valor actualizado de f después de la modificación de a
println(f.now)  // Salida: 50

//-----------------------------------------

// Aplicando Observadores en el código

// Se redefine la variable a (se debe comentar o eliminar la definición anterior de a)
val a = Var(1)

// creo una (variable reactiva)-> Rx , b que depende de a
val b = Rx { 2 * a() }

// creo  un contador y se creo un Observer (o) para la variable b
var count = 0
val o = b.trigger { count = b.now }

// Se imprime el valor actual de count
println(count)  // Salida: 2 (2 * 1)

// Modifico el valor de la variable a, lo que provoca que las dependencias se actualicen automáticamente
a() = 4

// Imprimo el nuevo valor actualizado de count después de la modificación de a
println(count)  // Salida: 8 (2 * 4)

// Se "mata" (kill) el Observer, lo que significa que ya no se actualizará automáticamente
o.kill()

// Aunque modifique el valor de a después de matar el Observer, no se actualizará count
//
//Pruebas
// a() = 3
// println(count)
