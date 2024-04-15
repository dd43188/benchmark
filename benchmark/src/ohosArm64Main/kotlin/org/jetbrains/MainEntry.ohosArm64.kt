package org.jetbrains

import kotlinx.cinterop.ExperimentalForeignApi
import platform.myohos.skikobridge_compose_logI

@OptIn(ExperimentalForeignApi::class)
actual fun kLog(log: String) {
    skikobridge_compose_logI(log)
}