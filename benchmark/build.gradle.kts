plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    androidNativeArm64() {
        binaries.sharedLib()
    }

    iosArm64() {
        binaries.sharedLib()
    }
    ohosArm64 {
        binaries.sharedLib()
        compilations.all {
            val ohos by cinterops.creating {
                defFile = file("src/ohosInterop/cinterop/ohos.def")
                includeDirs(file("src/ohosInterop/include"))
            }
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "11.0"
        framework {
            baseName = "benchmark"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation("org.jetbrains.kotlinx:atomicfu:0.23.3-kno")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.kn_benchmark"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}