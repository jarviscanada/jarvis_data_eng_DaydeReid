import scala.io.Source

/**
 * Count number of elements
 * Get the first element
 * Get the last element
 * Get the first 5 elements
 * Get the last 5 elements
 *
 * hint: use the following methods
 * head
 * last
 * size
 * take
 * tails
 */
val ls = List.range(0,10)
//write you solution here
val count = ls.size
val first = ls.head
val last = ls.last
val firstFive = ls.take(5)
val lastFive = ls.tails.toArray.apply(5)


/**
 * Double each number from the numList and return a flatten list
 * e.g.res4: List[Int] = List(2, 3, 4)
 *
 * Compare flatMap VS ls.map().flatten
 */
val numList = List(List(1,2), List(3));
//write you solution here
val flatMapped = numList.flatMap(i => i.map(_ * 2))
val mapThenFlattened = numList.map(i => i.map(_ * 2)).flatten


/**
 * Sum List.range(1,11) in three ways
 * hint: sum, reduce, foldLeft
 *
 * Compare reduce and foldLeft
 * https://stackoverflow.com/questions/7764197/difference-between-foldleft-and-reduceleft-in-scala
 */
//write you solution here
val list = List.range(1,11)

val sumWithSum = list.sum
val sumWithReduce = list.reduce((sum, i) => sum + i)
val sumWithFold = list.foldLeft(0)((sum, i) => sum + i)


/**
 * Practice Map and Optional
 *
 * Map question1:
 *
 * Compare get vs getOrElse (Scala Optional)
 * countryMap.get("Amy");
 * countryMap.getOrElse("Frank", "n/a");
 */
val countryMap = Map("Amy" -> "Canada", "Sam" -> "US", "Bob" -> "Canada")
countryMap.get("Amy")
countryMap.get("edward")
countryMap.getOrElse("edward", "n/a")


/**
 * Map question2:
 *
 * create a list of (name, country) tuples using `countryMap` and `names`
 * e.g. res2: List[(String, String)] = List((Amy,Canada), (Sam,US), (Eric,n/a), (Amy,Canada))
 */
val names = List("Amy", "Sam", "Eric", "Amy")
//write you solution here
val countryNames = names.map(name => (name, countryMap.getOrElse(name, "N/A")))

/**
 * Map question3:
 *
 * count number of people by country. Use `n/a` if the name is not in the countryMap  using `countryMap` and `names`
 * e.g. res0: scala.collection.immutable.Map[String,Int] = Map(Canada -> 2, n/a -> 1, US -> 1)
 * hint: map(get_value_from_map) ; groupBy country; map to (country,count)
 */
//write you solution here
val countryCount = names.map(name => countryMap.getOrElse(name, "N/A")).groupBy(country => country).map{case (country, list) => (country, list.size)}

/**
 * number each name in the list from 1 to n
 * e.g. res3: List[(Int, String)] = List((1,Amy), (2,Bob), (3,Chris))
 */
val names2 = List("Amy", "Bob", "Chris", "Dann")
//write you solution here
val numberedNames = names2.map(name => (name, names2.indexOf(name) + 1))


/**
 * SQL questions1:
 *
 * read file lines into a list
 * lines: List[String] = List(id,name,city, 1,amy,toronto, 2,bob,calgary, 3,chris,toronto, 4,dann,montreal)
 */
//write you solution here
val fileLines = Source.fromFile("/home/centos/dev/jarvis_data_eng_dayde/spark/src/main/resources/employees.csv").getLines.toList

/**
 * SQL questions2:
 *
 * Convert lines to a list of employees
 * e.g. employees: List[Employee] = List(Employee(1,amy,toronto), Employee(2,bob,calgary), Employee(3,chris,toronto), Employee(4,dann,montreal))
 */
//write you solution here
class Employee(var id: Int, var name: String, var city: String, var age: Int) {
  override def toString: String = s"Employee($id,$name,$city,$age)"
}
val employeeList = fileLines.drop(1).map(line => {
  val split = line.split(",")
  new Employee(split(0).toInt, split(1), split(2), split(3).toInt)
})

/**
 * SQL questions3:
 *
 * Implement the following SQL logic using functional programming
 * SELECT uppercase(city)
 * FROM employees
 *
 * result:
 * upperCity: List[Employee] = List(Employee(1,amy,TORONTO,20), Employee(2,bob,CALGARY,19), Employee(3,chris,TORONTO,20), Employee(4,dann,MONTREAL,21), Employee(5,eric,TORONTO,22))
 */
//write you solution here
val upperCity  = fileLines.drop(1).map(line => {
  val split = line.split(",")
  new Employee(split(0).toInt, split(1), split(2).toUpperCase, split(3).toInt)
})


/**
 * SQL questions4:
 *
 * Implement the following SQL logic using functional programming
 * SELECT uppercase(city)
 * FROM employees
 * WHERE city = 'toronto'
 *
 * result:
 * res5: List[Employee] = List(Employee(1,amy,TORONTO,20), Employee(3,chris,TORONTO,20), Employee(5,eric,TORONTO,22))
 */
//write you solution here
val upperToronto  = fileLines.drop(1).map(line => {
  val split = line.split(",")
  new Employee(split(0).toInt, split(1), split(2).toUpperCase, split(3).toInt)
}).filter(employee => employee.city == "TORONTO")

/**
 * SQL questions5:
 *
 * Implement the following SQL logic using functional programming
 *
 * SELECT uppercase(city), count(*)
 * FROM employees
 * GROUP BY city
 *
 * result:
 * cityNum: scala.collection.immutable.Map[String,Int] = Map(CALGARY -> 1, TORONTO -> 3, MONTREAL -> 1)
 */
//write you solution here
val cityCount  = fileLines.drop(1).map(line => {
  val split = line.split(",")
  new Employee(split(0).toInt, split(1), split(2).toUpperCase, split(3).toInt)
}).groupBy(employee => employee.city).map{case (city, list) => (city, list.size)}

/**
 * SQL questions6:
 *
 * Implement the following SQL logic using functional programming
 *
 * SELECT uppercase(city), count(*)
 * FROM employees
 * GROUP BY city,age
 *
 * result:
 * res6: scala.collection.immutable.Map[(String, Int),Int] = Map((MONTREAL,21) -> 1, (CALGARY,19) -> 1, (TORONTO,20) -> 2, (TORONTO,22) -> 1)
 */
//write you solution here
val cityCount  = fileLines.drop(1).map(line => {
  val split = line.split(",")
  new Employee(split(0).toInt, split(1), split(2).toUpperCase, split(3).toInt)
}).groupBy(employee => (employee.city, employee.age)).map{case (city, list) => (city, list.size)}