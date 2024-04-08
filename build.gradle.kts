buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
//
//        classpath("androidx.test:runner:1.5.2")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
//plugins {
//    alias(libs.plugins.androidApplication) apply false
//
//}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

//android {
//    testOptions {
//        unitTests.returnDefaultValues = true
//    }