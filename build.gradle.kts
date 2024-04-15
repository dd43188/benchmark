plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
//    alias(libs.plugins.kotlinAndroid).apply(false)
//    alias(libs.plugins.kotlinMultiplatform).apply(false)
    kotlin("android").version("1.9.23-dev-202").apply(false)
    kotlin("multiplatform").version("1.9.23-dev-202").apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)
}
