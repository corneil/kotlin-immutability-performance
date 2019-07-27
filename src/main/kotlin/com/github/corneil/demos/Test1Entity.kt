package com.github.corneil.demos

import java.util.*

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
