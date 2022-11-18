package com.github.corneil.demos

import java.util.*

class Test1Entity(
    var field1: String,
    var field2: Long,
    var field3: Double,
    var date1: Date,
    var date2: Date
) : Comparable<Test1Entity> {

    override fun compareTo(other: Test1Entity): Int {
        var result = this.field1.compareTo(other.field1)
        if (result == 0) {
            result = this.field2.compareTo(other.field2)
        }
        if (result == 0) {
            result = this.field3.compareTo(other.field3)
        }
        if (result == 0) {
            result = this.date1.compareTo(date1)
        }
        if (result == 0) {
            result = this.date2.compareTo(other.date2)
        }
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Test1Entity

        if (field1 != other.field1) return false
        if (field2 != other.field2) return false
        if (field3 != other.field3) return false
        if (date1 != other.date1) return false
        if (date2 != other.date2) return false

        return true
    }

    override fun hashCode(): Int {
        var result = field1.hashCode()
        result = 31 * result + field2.hashCode()
        result = 31 * result + field3.hashCode()
        result = 31 * result + date1.hashCode()
        result = 31 * result + date2.hashCode()
        return result
    }

    override fun toString(): String {
        return "Test1Entity(field1='$field1', field2=$field2, field3=$field3, date1=$date1, date2=$date2)"
    }
}
