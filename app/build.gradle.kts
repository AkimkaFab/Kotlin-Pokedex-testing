import org.jetbrains.kotlin.daemon.common.ensureServerHostnameIsSetUp
import java.util.regex.Pattern.compile

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("io.gitlab.arturbosch.detekt") version "1.23.3"
}
apply(from = "../ktlint.gradle.kts")

//Allure
//val allureVersion = "2.24.0"
//val aspectJVersion = "1.9.21"
//
//val agent: Configuration by configurations.creating {
//    isCanBeConsumed = true
//    isCanBeResolved = true
//}

android {
    compileSdk = 33
    buildToolsVersion = "33.0.0"
    defaultConfig {
        applicationId = "dev.marcosfarias.pokedex"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        viewBinding = true
    }


    //For mockk tests
    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    namespace = "dev.marcosfarias.pokedex"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Architecture
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")

    // Material
    implementation("com.google.android.material:material:1.8.0")

    // Third Party
    implementation("com.leinardi.android:speed-dial:3.3.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Persistence
    implementation("androidx.room:room-runtime:2.5.0")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    implementation("com.google.firebase:firebase-firestore-ktx:24.11.0")
    implementation("androidx.annotation:annotation:1.7.1")
    implementation("com.android.support:support-v4:28.0.0")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    kapt("androidx.room:room-compiler:2.5.0")

    // Glide
    kapt("com.github.bumptech.glide:compiler:4.13.2")
    implementation("com.github.bumptech.glide:glide:4.13.2")

    // Koin
    implementation("io.insert-koin:koin-android:3.2.0")
    implementation("io.insert-koin:koin-core:3.2.0")

    // Test
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("com.android.support.test.espresso:espresso-contrib:3.0.2")
    androidTestImplementation("androidx.navigation:navigation-testing:2.5.3")
    debugImplementation("androidx.fragment:fragment-testing:1.5.5")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("io.mockk:mockk-android:1.12.4")

    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

    testImplementation("com.android.support:support-annotations:27.1.1")
    testImplementation("com.android.support.test:runner:1.4.2")
    androidTestImplementation("com.android.support.test:rules:1.0.2")
    testImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test:runner:1.4.0")

    //Add android
    androidTestImplementation("androidx.tracing:tracing:1.0.0")


    //Roboletric
    testImplementation("org.robolectric:robolectric:4.1")
    testImplementation("org.robolectric:shadows-httpclient:4.1")
    testImplementation("org.robolectric:shadows-multidex:4.1")


    //Androidx
    androidTestImplementation("androidx.test:core:1.5.0")
    androidTestImplementation("androidx.test:core-ktx:1.5.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")
    androidTestImplementation("androidx.test.ext:truth:1.5.0")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestUtil("androidx.test:orchestrator:1.4.2")

    //Allure
//    testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
//    testImplementation("io.qameta.allure:allure-junit4")
//
//    agent("org.aspectj:aspectjweaver:${aspectJVersion}")


    //Allure Kotlin
//    testImplementation("io.qameta.allure:allure-kotlin-model:2.4.0")
//    testImplementation("io.qameta.allure:allure-kotlin-commons:2.4.0")
//    testImplementation("io.qameta.allure:allure-kotlin-junit4:2.4.0")


}

detekt {
    ignoreFailures = true
    debug = true
    baseline = file("src/test/resources/detektReport.xml")
}

//tasks.test {
//    useJUnit()
//    jvmArgs = listOf(
//        "-javaagent:${agent.singleFile}"
//    )
//}

//allure.results.directory=build/allure-results
//
//tasks.test {
//    useJUnit()
//    jvmArgs = listOf(
//        "-javaagent:${agent.singleFile}"
//    )
//}


//
//allure {
//    version.set("2.19.0")
//    ensureServerHostnameIsSetUp()
//}