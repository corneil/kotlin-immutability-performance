package com.github.corneil.demos

import java.util.*

fun Test3Entity.ifZero(exp: Int, block: () -> Int): Int = if (exp == 0) block() else exp

data class Test3Entity(
		val field1: String,
		val field2: Long,
		val field3: Double,
		val date1: Date,
		val date2: Date
) : Comparable<Test3Entity> {

	override fun compareTo(other: Test3Entity): Int =
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
