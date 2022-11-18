package com.github.corneil.demos


fun currentTimeMillis(): Long = System.currentTimeMillis()


object EntitySorter {
	@JvmStatic
	fun main(args: Array<String>) {
		val version = System.getProperty("java.version")
		val kotlinVersion = KotlinVersion.CURRENT
		println("Starting...Java:${version}, Kotlin:${kotlinVersion}")
		val executTime = if(args.isNotEmpty()) args[0].toLong() else 10 * 1000
		println("Sort Entity1")
		val ips1 = sortEntity(executTime, EntitySorterSetup.lst1)
		if (ips1 < 1.0) {
			println("${1.0 / ips1} ms/Iteration")
		} else {
			println("$ips1 Iterations/ms")
		}
		println("Sort Entity2")
		val ips2 = sortEntity(executTime, EntitySorterSetup.lst2)
		if (ips2 < 1.0) {
			println("${1.0 / ips2} ms/Iteration")
		} else {
			println("$ips2 Iterations/ms")
		}
		println("Sort Entity3")
		val ips3 = sortEntity(executTime, EntitySorterSetup.lst3)
		if (ips3 < 1.0) {
			println("${1.0 / ips3} ms/Iteration")
		} else {
			println("$ips3 Iterations/ms")
		}
	}
}

fun <T : Comparable<T>> sortEntity(milliseconds: Long, lst: List<T>): Double {
	val startTime = System.currentTimeMillis()
	var iterations = 0
	while (currentTimeMillis() - startTime < milliseconds) {
		val testList = lst.toMutableList()
		testList.sort()
		iterations += 1
	}
	val endTime = System.currentTimeMillis()
	val totalTime = endTime - startTime
	println("Iteration=$iterations, TotalTime=$totalTime")
	return iterations.toDouble() / totalTime.toDouble()
}
