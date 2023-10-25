plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

android {
    namespace = ConfigData.nameSpace
    compileSdk = ConfigData.compieSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdk
        targetSdk = ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "BASE_URL", "\"https://api.nasa.gov\"")
        buildConfigField("String", "API_KEY", "\"API_KEY\"")         //TODO add api key here
    }

    buildTypes {
        release {
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
        jvmTarget = ConfigData.jvmTarget
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinComposeCompilerVersion
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.DaggerHiltLib.Android)
    implementation(Dependencies.ComposeLib.Activity)
    implementation(Dependencies.ComposeLib.ViewModel)
    implementation(Dependencies.ComposeLib.Ui)
    implementation(Dependencies.ComposeLib.Preview)
    implementation(Dependencies.ComposeLib.Material)
    implementation(Dependencies.NavigationLib.Navigation)

    implementation(Dependencies.NetworkLib.Retrofit)
    implementation(Dependencies.NetworkLib.RetrofitGson)
    implementation(Dependencies.NetworkLib.RetrofitMoshi)
    implementation(Dependencies.NetworkLib.Okhttp)
    implementation(Dependencies.NetworkLib.LoggingInterceptor)

    kapt(Dependencies.StorageLib.RoomCompiler)
    implementation(Dependencies.StorageLib.RoomRuntime)
    implementation(Dependencies.StorageLib.RoomKtx)

    kapt(Dependencies.DaggerHiltLib.Compiler)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitTest)
    androidTestImplementation(Dependencies.Test.espresso)
}