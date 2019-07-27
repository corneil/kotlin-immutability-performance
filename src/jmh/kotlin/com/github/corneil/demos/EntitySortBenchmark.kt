package com.github.corneil.demos

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State


@State(value = Scope.Thread)
open class EntitySortBenchmark {

	@Setup
	fun setup() {

	}

	@Benchmark
	fun testCompareTo1() {
		val c1 = EntitySorterSetup.lst1[0]
		val c2 = EntitySorterSetup.lst1[1]
		c1.compareTo(c2).toLong()
	}

	@Benchmark
	fun testCompareTo2() {
		val c1 = EntitySorterSetup.lst2[0]
		val c2 = EntitySorterSetup.lst2[1]
		c1.compareTo(c2).toLong()
	}

	@Benchmark
	fun testCompareTo3() {
		val c1 = EntitySorterSetup.lst3[0]
		val c2 = EntitySorterSetup.lst3[1]
		c1.compareTo(c2).toLong()
	}

	@Benchmark
	fun testEntity1Benchmark() {
		val testList = EntitySorterSetup.lst1.toMutableList()
		testList.sort()
	}

	@Benchmark
	fun testEntity2Benchmark() {
		val testList = EntitySorterSetup.lst2.toMutableList()
		testList.sort()
	}

	@Benchmark
	fun testEntity3Benchmark() {
		val testList = EntitySorterSetup.lst3.toMutableList()
		testList.sort()
	}
}
