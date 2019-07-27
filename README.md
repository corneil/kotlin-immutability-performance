# Comparing Performance of lambdas

Consider the following tradition code when implementing a comparator for an entity.

```kotlin
data class Test1Entity(
		val field1: String,
		val field2: Long,
		val field3: Double,
		val date1: Date,
		val date2: Date
) : Comparable<Test1Entity> {

	override fun compareTo(other: Test1Entity): Int {
		var result = this.field1.compareTo(other.field1)
		if (result == 0) {
			result = this.field2.compareTo(other.field2)
			if (result == 0) {
				result = this.field3.compareTo(other.field3)
				if (result == 0) {
					result = this.date1.compareTo(date1)
					if (result == 0) {
						return this.date2.compareTo(other.date2)
					}
				}
			}
		}
		return result
	}
}
```
Or when trying to avoid immutable.
```kotlin
data class Test1Entity(
		val field1: String,
		val field2: Long,
		val field3: Double,
		val date1: Date,
		val date2: Date
) : Comparable<Test1Entity> {

	override fun compareTo(other: Test1Entity): Int {
		val result = this.field1.compareTo(other.field1)
		if (result == 0) {
			val result2 = this.field2.compareTo(other.field2)
			if (result2 == 0) {
				val result3 = this.field3.compareTo(other.field3)
				if (result3 == 0) {
					val result4 = this.date1.compareTo(date1)
					if (result4 == 0) {
						return this.date2.compareTo(other.date2)
					} else {
						return result4
					}
				} else {
					return result3
				}
			} else {
				return result2
			}
		}
		return result
	}
}
```

When using a construct like this it reads easier and shouldn't provide a runtime penalty.

```kotlin
inline fun <T> T.ifZero(exp: Int, block: () -> Int): Int = if (exp == 0) block() else exp

data class Test2Entity(
		val field1: String,
		val field2: Long,
		val field3: Double,
		val date1: Date,
		val date2: Date
) : Comparable<Test2Entity> {

	override fun compareTo(other: Test2Entity): Int =
			ifZero(field1.compareTo(other.field1)) {
				ifZero(field2.compareTo(other.field2)) {
					ifZero(field3.compareTo(other.field3)) {
						ifZero(date1.compareTo(other.date1)) {
							date2.compareTo(other.date2)
						}
					}
				}
			}


}
```

```
Benchmark                                  Mode  Cnt          Score         Error  Units
EntitySortBenchmark.testCompareTo1        thrpt    5  153702052.915 ± 1894629.525  ops/s
EntitySortBenchmark.testCompareTo2        thrpt    5  130079997.037 ± 1632301.585  ops/s
EntitySortBenchmark.testCompareTo3        thrpt    5   39224254.427 ± 1146574.992  ops/s
EntitySortBenchmark.testEntity1Benchmark  thrpt    5       6760.718 ±     349.851  ops/s
EntitySortBenchmark.testEntity2Benchmark  thrpt    5       6310.201 ±      90.302  ops/s
EntitySortBenchmark.testEntity3Benchmark  thrpt    5       2957.105 ±     133.031  ops/s
```
