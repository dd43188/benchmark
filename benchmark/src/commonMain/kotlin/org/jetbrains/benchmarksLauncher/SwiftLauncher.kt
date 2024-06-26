/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

import org.jetbrains.benchmarksLauncher.*

internal class SwiftLauncher: Launcher() {
    override val baseBenchmarksSet: MutableMap<String, AbstractBenchmarkEntry> = mutableMapOf()
    override val extendedBenchmarksSet: MutableMap<String, AbstractBenchmarkEntry> = mutableMapOf()
}