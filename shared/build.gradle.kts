plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("kotlin-parcelize")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val androidMain by getting {
            dependencies {
                api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
                api("io.insert-koin:koin-android:3.4.0")
                api("org.orbit-mvi:orbit-viewmodel:6.0.0")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
            }
        }
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
                implementation("io.insert-koin:koin-core:3.4.0")
                implementation("org.orbit-mvi:orbit-core:6.0.0")
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "de.smartwireless.smartaccess"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}