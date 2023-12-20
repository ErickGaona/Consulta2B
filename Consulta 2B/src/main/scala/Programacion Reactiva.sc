// Consulta
// Datos de ventas
val ventas = List(
  ("Zapatos", 10, 50),
  ("Camisas", 20, 30),
  ("Pantalones", 15, 40),
  ("Gorras", 18, 15),
  ("Calcetines", 50, 5))

// Filtrar Productos Caros
val productosCaros = ventas.filter(tupla => tupla._3 > 35.0)
println("Productos Caros: " + productosCaros)

// Calcular Ventas Totales
val ingresosPorProducto = ventas.map(tupla => tupla._2 * tupla._3)
println("Ingresos por Producto: " + ingresosPorProducto)

// Lista Detallada de Precios
val listaDetalladaPrecios = ventas.flatMap(tupla => List.fill(tupla._2)(tupla._3))
println("Lista Detallada de Precios: " + listaDetalladaPrecios)

// Ingresos Totales
val ingresoTotal = ingresosPorProducto.foldLeft(0)((acumulado, actual) => acumulado + actual)
println("Ingreso Total: " + ingresoTotal)

// Precio Promedio
val precioPromedio = ingresosPorProducto.reduce((total, actual) => total + actual) / ventas.map(tupla => tupla._2).sum.toDouble
println("Precio Promedio: " + precioPromedio)