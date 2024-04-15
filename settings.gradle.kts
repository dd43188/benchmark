enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        mavenLocal()
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://mirrors.tencent.com/repository/maven/tmm-snapshot")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven("https://mirrors.tencent.com/repository/maven/tmm-snapshot")
    }
}

rootProject.name = "KN-Benchmark"
include(":androidApp")
include(":benchmark")