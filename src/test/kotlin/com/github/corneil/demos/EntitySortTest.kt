package com.github.corneil.demos

import java.text.SimpleDateFormat
import java.util.*
import kotlin.test.assertEquals

fun date(input: String): Date {
	val df = SimpleDateFormat("yyyy-MM-dd")
	return df.parse(input)
}

class EntitySortTest {
	fun `test compareTo1`() {
		// given
		val f1 = EntitySorterSetup.randString(32)
		val t1 = Test1Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-8"))
		val t2 = Test1Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-2"))
		val t3 = Test1Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-15"))
		val t4 = Test1Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-1"))
		val lst = arrayListOf(t1, t2, t3, t4)
		// when
		lst.sort()
		// then
		assertEquals(lst, arrayListOf(t4, t2, t1, t3))
	}

	fun `test compareTo2`() {
		// given
		val f1 = EntitySorterSetup.randString(32)
		val t1 = Test2Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-8"))
		val t2 = Test2Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-2"))
		val t3 = Test2Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-15"))
		val t4 = Test2Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-1"))
		val lst = arrayListOf(t1, t2, t3, t4)
		// when
		lst.sort()
		// then
		assertEquals(lst, arrayListOf(t4, t2, t1, t3))
	}

	fun `test compareTo3`() {
		// given
		val f1 = EntitySorterSetup.randString(32)
		val t1 = Test3Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-8"))
		val t2 = Test3Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-2"))
		val t3 = Test3Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-15"))
		val t4 = Test3Entity(f1, 2, 3.0, date("2019-4-6"), date("2019-4-1"))
		val lst = arrayListOf(t1, t2, t3, t4)
		// when
		lst.sort()
		// then
		assertEquals(lst, arrayListOf(t4, t2, t1, t3))
	}
}
