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

package org.jetbrains.ring

const val BENCHMARK_SIZE = 10000

internal interface AtomicRef<T> {
    /**
     * Reading/writing this property maps to read/write of volatile variable.
     */
    public var value: T

    /**
     * Maps to [AtomicReferenceFieldUpdater.lazySet].
     */
    public fun lazySet(value: T)

    /**
     * Maps to [AtomicReferenceFieldUpdater.compareAndSet].
     */
    public fun compareAndSet(expect: T, update: T): Boolean

    /**
     * Maps to [AtomicReferenceFieldUpdater.getAndSet].
     */
    public fun getAndSet(value: T): T
}

internal fun <T> atomic(initial: T): AtomicRef<T> {
    return object : AtomicRef<T> {

        private val origin = kotlinx.atomicfu.atomic(initial)

        override var value: T
            get() = origin.value
            set(value) {
                origin.value = value
            }

        override fun getAndSet(value: T): T {
            return origin.getAndSet(value)
        }

        override fun compareAndSet(expect: T, update: T): Boolean {
            return origin.compareAndSet(expect, update)
        }

        override fun lazySet(value: T) {
            return origin.lazySet(value)
        }

    }
}
