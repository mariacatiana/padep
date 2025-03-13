plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.ksp)
    alias(libs.plugins.detekt)
    alias(libs.plugins.hilt)
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "br.com.jpegsinng.padep"
    compileSdk = 35

    defaultConfig {
        applicationId = "br.com.jpegsinng.padep"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.recyclerview)

    // Coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.testing)
    testImplementation(libs.coroutines.test)

    // Detekt
//    detektPlugins(libs.detekt.formatting)

    //Fragment
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    androidTestImplementation(libs.androidx.navigation.testing)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //Javax
    implementation(libs.javax.inject)

    //  Lifecycle
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)

    // Retrofit
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    //Paging
    implementation(libs.paging.runtime)
    implementation(libs.paging.common)

    //Picasso
    implementation(libs.picasso)
    implementation(libs.circleimageview)

    // Room
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)

    // Shimmer
    implementation(libs.shimmer)

    // Test
    kaptAndroidTest(libs.hilt.compiler)
    kaptTest(libs.hilt.compiler)

    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.mockk.android)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidxTestRunner)
    androidTestImplementation(libs.androidxTestRules)

    //Testes Espresso
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.android.fragment.testing)
    androidTestImplementation(libs.mockwebserver)

    testImplementation(libs.mockwebserver)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.mockk.core)
    testImplementation(libs.mockwebserver)
    testImplementation(libs.junit)
    testImplementation(libs.mockserver.netty)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockito.core)
    testImplementation(libs.core.testing)
    testImplementation(libs.junit)
}