plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.coroutinewithmvvm"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.coroutinewithmvvm"
        minSdk = 19
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    //data binding
    buildFeatures {
        viewBinding=true
        dataBinding=true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // Networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.7.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.7.2")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //Coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation ("com.google.code.gson:gson:2.8.6")

    //viewModel
    implementation ("android.arch.lifecycle:extensions:1.1.1")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.13.0")
    //   kapt ("com.github.bumptech.glide:compiler:4.12.0")

    //piccaso
    implementation ("com.squareup.picasso:picasso:2.8")
}