package me.erikthered.day01

import me.erikthered.getInput
import kotlin.math.absoluteValue

object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Part 1 Solution: ${part1()}")
        println("Part 2 Solution: ${part2()}")
    }

    fun part1(): Int {
        val lines = getInput("01").lines()
        val a = mutableListOf<Int>()
        val b = mutableListOf<Int>()
        lines.filter { it.isNotBlank() }
            .map { it.split(delimiters = arrayOf("   "), true, 2) }
            .forEach { (l, r) ->
                a += l.toInt()
                b += r.toInt()
            }

        a.sort()
        b.sort()

        return a.zip(b).fold(0) { acc, p ->
            acc + (p.first - p.second).absoluteValue
        }
    }

    fun part2(): Int {
        val lines = getInput("01").lines()
        val a = mutableListOf<Int>()
        val b = mutableListOf<Int>()
        lines.filter { it.isNotBlank() }
            .map { it.split(delimiters = arrayOf("   "), true, 2) }
            .forEach { (l, r) ->
                a += l.toInt()
                b += r.toInt()
            }

        var sum = 0

        a.forEach { v ->
            sum += v * b.count { it == v }
        }

        return sum
    }
}