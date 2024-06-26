/*
 * Copyright 2010-2018 JetBrains s.r.o.
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

package org.jetbrains.benchmarksLauncher

import kotlin.native.runtime.GC
import kotlin.native.runtime.NativeRuntimeApi

internal fun writeToFile(fileName: String, text: String) {

}

internal fun assert(value: Boolean) {

}

//inline fun measureNanoTime(block: () -> Unit): Long {
//    measureNanoTime {  }
//}

@OptIn(NativeRuntimeApi::class)
internal fun cleanup() {
    GC.collect()
}

internal fun printStderr(message: String) {

}

internal fun currentTime(): String {
    TODO()
}

internal fun nanoTime(): Long {
    TODO()
}

internal class Blackhole {
    companion object {
        var consumer = 0
        fun consume(value: Any) {
            consumer += value.hashCode()
        }
    }
}

internal class Random  {
    companion object {
        var seedInt = 0
        fun nextInt(boundary: Int = 119): Int {
            seedInt = (3 * seedInt + 11) % boundary
            return seedInt
        }

        var seedDouble: Double = 0.1
        fun nextDouble(boundary: Double = 119.0): Double {
            seedDouble = (7.0 * seedDouble + 7.0) % boundary
            return seedDouble
        }
    }
}