plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.4.20"
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "com.r4wxii.apitest"
        minSdkVersion(28)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String","feeadlyApiToken", "${project.property("feedlyApi.token")}")
        buildConfigField("String","notionApiToken", "${project.property("notionApi.token")}")
        buildConfigField("String","notionApiBlockId", "${project.property("notionApi.blockId")}")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.20")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.fragment:fragment:1.2.5")
    implementation("androidx.fragment:fragment-ktx:1.2.5")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.2")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("com.google.dagger:dagger:2.30")
    kapt("com.google.dagger:dagger-compiler:2.30")
    implementation("com.google.dagger:hilt-android:2.30-alpha")
    kapt("com.google.dagger:hilt-android-compiler:2.30-alpha")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")
    kapt("androidx.hilt:hilt-compiler:1.0.0-alpha02")
    implementation("io.ktor:ktor-client-core:1.4.2")
    implementation("io.ktor:ktor-client-cio:1.4.2")
    implementation("io.ktor:ktor-client-serialization-jvm:1.4.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
}