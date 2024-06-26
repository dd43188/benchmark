/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.ring

internal fun classValues(size: Int): Iterable<Value> {
    return intValues(size).map { Value(it) }
}

internal fun stringValues(size: Int): Iterable<String> {
    return intValues(size).map { it.toString() }
}

internal fun intValues(size: Int): Iterable<Int> {
    return 1..size
}

internal open class Value(var value: Int) {
    val text = value.toString().reversed()
}

internal fun filterLoad(v: Value): Boolean {
    return v.value.toString() in v.text
}

internal fun mapLoad(v: Value): String = v.text.reversed()

internal fun filterLoad(v: Int): Boolean {
    return v.toString() in "0123456789"
}

internal fun mapLoad(v: Int): String = v.toString()

internal fun filterSome(v: Int): Boolean = v % 7 == 0 || v % 11 == 0

internal fun filterPrime(v: Int): Boolean {
    if (v <= 1)
        return false
    if (v <= 3)
        return true
    if (v % 2 == 0)
        return false
    var i = 3
    while (i*i <= v) {
        if (v % i == 0)
            return false
        i += 2
    }
    return true
}

internal inline fun Array<Value>.cnt(predicate: (Value) -> Boolean): Int {
    var count = 0
    for (element in this) {
        if (predicate(element))
            count++
    }
    return count
}

internal inline fun IntArray.cnt(predicate: (Int) -> Boolean): Int {
    var count = 0
    for (element in this) {
        if (predicate(element))
            count++
    }
    return count
}

internal inline fun Iterable<Int>.cnt(predicate: (Int) -> Boolean): Int {
    var count = 0
    for (element in this) {
        if (predicate(element))
            count++
    }
    return count
}

internal inline fun Sequence<Int>.cnt(predicate: (Int) -> Boolean): Int {
    var count = 0
    for (element in this) {
        if (predicate(element))
            count++
    }
    return count
}

