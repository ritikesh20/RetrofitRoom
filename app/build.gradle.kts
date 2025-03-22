plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.retrofitroom"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.retrofitroom"
        minSdk = 24
        targetSdk = 34
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

//    // Retrofit (Networking)
//    implementation("com.google.code.gson:gson:2.10.1")
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//
//// Glide (Image Loading)
//    implementation("com.github.bumptech.glide:glide:4.16.0")
//    implementation("com.google.android.material:material:1.11.0")
//
//// Room Database (Local Database)
//    implementation("androidx.room:room-runtime:2.6.1")
//    annotationProcessor("androidx.room:room-compiler:2.6.1")
//
//// Lifecycle Components (MVVM + LiveData)
//    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
//    annotationProcessor("androidx.lifecycle:lifecycle-compiler:2.2.0")
//
//// UI Components (Material Design)
//    implementation("com.google.android.material:material:1.11.0")
//
//// Testing Libraries
//    androidTestImplementation ("androidx.arch.core:core-testing:2.2.0")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.android.volley:volley:1.2.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation ("com.squareup.picasso:picasso:2.8")


}