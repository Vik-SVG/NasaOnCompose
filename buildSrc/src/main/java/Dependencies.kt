object Dependencies {

    object AndroidX {

        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val appCompat = "androidx.core:core-ktx:${Versions.appCompatVersion}"

    }

    object SupportLib {
        const val Material = "com.google.android.material:material:1.5.0"
        const val CoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1"
        const val CoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1"
        const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"

        const val Splashscreen = "androidx.core:core-splashscreen:1.0.0-beta02"
        const val Timber = "com.jakewharton.timber:timber:5.0.1"
        const val Paging = "androidx.paging:paging-runtime-ktx:3.1.1"
    }

    object ComposeLib {
        const val Ui = "androidx.compose.ui:ui:${Versions.composeUiVersion}"
        const val Tooling = "androidx.compose.ui:ui-tooling:${Versions.composeUiVersion}"
        const val Preview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeUiVersion}"
        const val Material = "androidx.compose.material:material:${Versions.composeUiVersion}"
        const val Runtime = "androidx.compose.runtime:runtime:1.1.1"
        const val Foundation = "androidx.compose.foundation:foundation:1.1.1"
        const val MaterialIconCore = "androidx.compose.material:material-icons-core:1.1.1"
        const val MaterialIconExtended = "androidx.compose.material:material-icons-extended:1.1.1"
        const val Manifest = "androidx.compose.ui:ui-test-manifest:1.1.1"

        const val Activity = "androidx.activity:activity-compose:1.8.0"
        const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
        const val ConstraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0"
        const val Lottie = "com.airbnb.android:lottie-compose:5.0.3"
        const val Paging = "androidx.paging:paging-compose:1.0.0-alpha14"
        const val Coil = "io.coil-kt:coil-compose:2.2.2"
    }

    object NavigationLib {
        const val Navigation = "androidx.navigation:navigation-compose:2.7.4"
        const val DestinationCore = "io.github.raamcosta.compose-destinations:core:1.4.4-beta"
        const val DestinationKsp = "io.github.raamcosta.compose-destinations:ksp:1.4.4-beta"
        const val DestinationAnimation =
            "io.github.raamcosta.compose-destinations:animations-core:1.4.4-beta"
    }

    object AccompanistLib {
        const val Swiperefresh = "com.google.accompanist:accompanist-swiperefresh:0.23.1"
        const val Systemuicontroller =
            "com.google.accompanist:accompanist-systemuicontroller:0.23.1"
        const val Insets = "com.google.accompanist:accompanist-insets:0.23.1"
        const val PlaceholderMaterial =
            "com.google.accompanist:accompanist-placeholder-material:0.23.1"
        const val NavigationMaterial =
            "com.google.accompanist:accompanist-navigation-material:0.23.1"
        const val Permissions = "com.google.accompanist:accompanist-permissions:0.23.1"
        const val Pager = "com.google.accompanist:accompanist-pager:0.23.1"
        const val Indicators = "com.google.accompanist:accompanist-pager-indicators:0.23.1"
        const val Webview = "com.google.accompanist:accompanist-webview:0.24.6-alpha"
    }

    object NetworkLib {
        const val Moshi = "com.squareup.moshi:moshi-kotlin:1.13.0"
        const val MoshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:1.13.0"
        const val MoshiLazyAdapter = "com.serjltt.moshi:moshi-lazy-adapters:2.2"
        const val Retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val RetrofitMoshi = "com.squareup.retrofit2:converter-moshi:2.9.0"
        const val RetrofitGson = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val Okhttp = "com.squareup.okhttp3:okhttp:4.11.0"
        const val LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.11.0"
        const val KotlinXSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"
        const val KotlinXSerializationRetrofit =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    }

    object StorageLib {
        const val RoomKtx = "androidx.room:room-ktx:2.6.0"
        const val RoomRuntime = "androidx.room:room-runtime:2.6.0"
        const val RoomCompiler = "androidx.room:room-compiler:2.6.0"
        const val DatastorePref = "androidx.datastore:datastore-preferences:1.0.0"
        const val Datastore = "androidx.datastore:datastore:1.0.0"
        const val SecurityPref = "androidx.security:security-crypto-ktx:1.1.0-alpha03"
    }

    object DaggerHiltLib {
        const val Android = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val Compiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
        const val Compose = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val Coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1"
    }

    object Test {
        const val Truth = "com.google.truth:truth:1.1.3"
        const val Robolectric = "org.robolectric:robolectric:4.7.3"
        const val Turbine = "app.cash.turbine:turbine:0.7.0"
        const val Mockk = "io.mockk:mockk:1.12.3"
        const val Okhttp = "com.squareup.okhttp3:mockwebserver:5.0.0-alpha.6"
        const val jUnit = "junit:junit:${Versions.jUnitVersion}"
        const val jUnitTest = "androidx.test.ext:junit:${Versions.jUnitTestExtVersion}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    }
}