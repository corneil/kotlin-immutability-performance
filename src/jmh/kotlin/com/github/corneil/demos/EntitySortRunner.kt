package com.github.corneil.demos

import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder
import org.openjdk.jmh.runner.options.TimeValue
import org.openjdk.jmh.runner.options.VerboseMode

object EntitySortRunner {
	@JvmStatic
	fun main(args: Array<String>) {
		System.setProperty("jmh.ignoreLock", "true")
		val opt = OptionsBuilder()
				// .include(".*EntitySortBenchmark.*")
				.verbosity(VerboseMode.EXTRA)
				.warmupIterations(3)
				.measurementIterations(5)
				.warmupTime(TimeValue.seconds(3))
				.measurementTime(TimeValue.seconds(5))
				.mode(Mode.Throughput)
				.forks(1)
				.threads(1)
				.detectJvmArgs()
				.build()
		Runner(opt).run()
	}

}
