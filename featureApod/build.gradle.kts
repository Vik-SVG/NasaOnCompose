plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = ConfigData.nameSpace
    compileSdk = ConfigData.compieSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinComposeCompilerVersion
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":core"))
    implementation(project(":data"))

    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.DaggerHiltLib.Android)
    implementation(Dependencies.ComposeLib.Activity)
    implementation(Dependencies.ComposeLib.ViewModel)
    implementation(Dependencies.ComposeLib.Ui)
    implementation(Dependencies.ComposeLib.Preview)
    implementation(Dependencies.ComposeLib.Material)
    implementation(Dependencies.NavigationLib.Navigation)
    implementation(Dependencies.DaggerHiltLib.Android)
    implementation(Dependencies.DaggerHiltLib.Compose)
    implementation(Dependencies.AccompanistLib.Swiperefresh)
    implementation(Dependencies.ComposeLib.Coil)
    kapt(Dependencies.DaggerHiltLib.Compiler)

}