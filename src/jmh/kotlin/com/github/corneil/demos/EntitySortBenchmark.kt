package com.github.corneil.demos

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole


@State(value = Scope.Thread)
open class EntitySortBenchmark {

	@Setup
	fun setup() {

	}

	@Benchmark
	fun testCompareTo1(blackHole: Blackhole) {
		val c1 = EntitySorterSetup.lst1[0]
		val c2 = EntitySorterSetup.lst1[1]
		blackHole.consume(c1.compareTo(c2))
	}

	@Benchmark
	fun testCompareTo2(blackHole: Blackhole) {
		val c1 = EntitySorterSetup.lst2[0]
		val c2 = EntitySorterSetup.lst2[1]
		blackHole.consume(c1.compareTo(c2))
	}

	@Benchmark
	fun testCompareTo3(blackHole: Blackhole) {
		val c1 = EntitySorterSetup.lst3[0]
		val c2 = EntitySorterSetup.lst3[1]
		blackHole.consume(c1.compareTo(c2))
	}

	@Benchmark
	fun testEntity1Benchmark(blackHole: Blackhole) {
		val testList = EntitySorterSetup.lst1.toMutableList()
		testList.sort()
		blackHole.consume(testList)

	}

	@Benchmark
	fun testEntity2Benchmark(blackHole: Blackhole) {
		val testList = EntitySorterSetup.lst2.toMutableList()
		testList.sort()
		blackHole.consume(testList)
	}

	@Benchmark
	fun testEntity3Benchmark(blackHole: Blackhole) {
		val testList = EntitySorterSetup.lst3.toMutableList()
		testList.sort()
		blackHole.consume(testList)
	}
}
