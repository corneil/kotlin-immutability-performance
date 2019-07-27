package com.github.corneil.demos

import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.results.format.ResultFormatType
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder
import org.openjdk.jmh.runner.options.TimeValue
import org.openjdk.jmh.runner.options.VerboseMode

object EntitySortRunner {
	@JvmStatic
	fun main(args: Array<String>) {
		System.setProperty("jmh.ignoreLock", "true")
		Runner(
			OptionsBuilder()
					.verbosity(VerboseMode.EXTRA)
					.resultFormat(ResultFormatType.CSV)
					.warmupIterations(10)
					.measurementIterations(5)
					.warmupTime(TimeValue.seconds(5))
					.measurementTime(TimeValue.seconds(5))
					.mode(Mode.Throughput)
					.forks(1)
					.threads(1)
					.detectJvmArgs()
					.build()
		).run()
	}

}
