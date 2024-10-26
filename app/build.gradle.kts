plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id ("androidx.navigation.safeargs.kotlin")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.projectx.CurAndHomWorMon6"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.projectx.CurAndHomWorMon6"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            "String",
            "BASE_URL",
            "\"https://rickandmortyapi.com/api/\""
        )
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
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    dependencies {
        // Core Android libraries
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)

        // Google Material Components
        implementation ("com.google.android.material:material:1.9.0")

        // Kotlin libraries
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
        implementation("org.jetbrains.kotlin:kotlin-parcelize-runtime:1.6.0")

        // Navigation
        val navVersion = "2.7.7"
        implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
        implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

        // Retrofit and OkHttp
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation(libs.okhttp)
        implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")

        // Dagger Hilt
        implementation("com.google.dagger:hilt-android:2.51.1")
        kapt("com.google.dagger:hilt-android-compiler:2.51.1")

        // Glide
        implementation("com.github.bumptech.glide:glide:4.16.0")
        kapt("com.github.bumptech.glide:compiler:4.12.0")

        // Testing libraries
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
    }
    // Корутинная библиотека
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    // Для работы с ViewModel и корутинами
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")

    implementation ("io.insert-koin:koin-core:3.5.6")
    implementation ("io.insert-koin:koin-android:3.5.6")

}