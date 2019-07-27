package com.github.corneil.demos

import java.util.*

object EntitySorterSetup {
	private val mlst1 = mutableListOf<Test1Entity>()
	private val mlst2 = mutableListOf<Test2Entity>()
	private val mlst3 = mutableListOf<Test3Entity>()
	private val rand = Random(42)

	private fun list1(): List<Test1Entity> = mlst1.toList()
	private fun list2(): List<Test2Entity> = mlst2.toList()
	private fun list3(): List<Test3Entity> = mlst3.toList()

	fun randString(len: Int): String {
		val builder = StringBuilder(len)
		for (i in 1..len) {
			builder.append((rand.nextInt(26) + 32).toChar())
		}
		return builder.toString()
	}

	init {

		val f1 = randString(32)
		val f2 = rand.nextLong()
		val f3 = rand.nextDouble()
		val d1 = Date(rand.nextLong())
		val t1 = Test1Entity(f1, f2, f3, d1, Date())
		val t2 = Test2Entity(f1, f2, f3, d1, Date())
		val t3 = Test3Entity(f1, f2, f3, d1, Date())
		for (i in 0..999) {
			val d2 = Date(rand.nextLong())
			mlst1.add(t1.copy(date2 = d2))
			mlst2.add(t2.copy(date2 = d2))
			mlst3.add(t3.copy(date2 = d2))
		}
	}

	val lst1 = list1()
	val lst2 = list2()
	val lst3 = list3()


}
