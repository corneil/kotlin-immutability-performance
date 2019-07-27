package com.github.corneil.demos

import java.util.Date
import kotlin.random.Random

object EntitySorterSetup {
	private val mlst1 = mutableListOf<Test1Entity>()
	private val mlst2 = mutableListOf<Test2Entity>()
	private val mlst3 = mutableListOf<Test3Entity>()
	private val rand = Random(42)

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

	val lst1 = mlst1.toList()
	val lst2 = mlst2.toList()
	val lst3 = mlst3.toList()

}
