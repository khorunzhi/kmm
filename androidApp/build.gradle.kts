plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "de.smartwireless.smartaccess.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "de.smartwireless.smartaccess.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("io.insert-koin:koin-compose:1.1.0")
    implementation("io.insert-koin:koin-androidx-compose:3.5.0")
    implementation("org.orbit-mvi:orbit-compose:6.0.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.0-beta01")
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.activity:activity-compose:1.7.1")
}