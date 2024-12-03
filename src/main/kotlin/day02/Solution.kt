package me.erikthered.day02

import me.erikthered.getInput


object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Part 1 Solution: ${part1()}")
        println("Part 2 Solution: ${part2()}")
    }

    fun part1(): Int {
        val lines = getInput("02").lines()

        var safeReports = 0

        lines.filter { it.isNotBlank() }.forEach { r ->
            val levels = r.split(" ").map { it.toInt() }

            if(isSafe(levels)) safeReports++
        }

        return safeReports
    }

    fun part2(): Int {
        val lines = getInput("02").lines()

        var safeReports = 0

        lines.filter { it.isNotBlank() }.forEach { r ->
            val levels = r.split(" ").map { it.toInt() }

            var safe = isSafe(levels)

            if(!safe) {
                safe = (0..levels.lastIndex).any { idx ->
                    isSafe(levels.take(idx) + levels.drop(idx + 1))
                }
            }

            if(safe) safeReports++
        }

        return safeReports
    }

    fun isSafe(levels: List<Int>): Boolean {
        if(levels.sorted() != levels && levels.sortedDescending() != levels) return false

        return levels.sorted().windowed(2).none { (a, b) ->
            (b - a) > 3 || (b - a) < 1
        }
    }
}