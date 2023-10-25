plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = ConfigData.nameSpace
    compileSdk =  ConfigData.compieSdkVersion

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }
}

dependencies {

    implementation(Dependencies.NetworkLib.Retrofit)
    implementation(Dependencies.NetworkLib.RetrofitGson)
    implementation(Dependencies.NetworkLib.Okhttp)

    kapt(Dependencies.StorageLib.RoomCompiler)
    implementation(Dependencies.StorageLib.RoomRuntime)
    implementation(Dependencies.StorageLib.RoomKtx)

    implementation(Dependencies.DaggerHiltLib.Android)
    kapt(Dependencies.DaggerHiltLib.Compiler)

}