plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "org.demre.ei8razasperros"
    compileSdk = 34

    defaultConfig {
        applicationId = "org.demre.ei8razasperros"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures{
        viewBinding = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    //Retrofit
    val retroVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retroVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retroVersion")
    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    //Navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.0")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.0")
    //Coil
    implementation ("io.coil-kt:coil:2.4.0")

    // ROOM
    val roomVersion = "2.5.2"
    implementation ("androidx.room:room-runtime:$roomVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")
    annotationProcessor ("androidx.room:room-compiler:$roomVersion")
    ksp ("androidx.room:room-compiler:$roomVersion")

    //Testear
    //val mockitoCoreVersion = "3.3.3"
    //testImplementation ("org.mockito:mockito-core:$mockitoCoreVersion")
    //val archCoreTest = "2.2.0"
    //testImplementation ("androidx.arch.core:core-testing:$archCoreTest")
    //val coroutinesTest = "1.7.1"
    //testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTest")
    //val mockWebserverVersion = "4.7.2"
    //testImplementation ("com.squareup.okhttp3:mockwebserver:$mockWebserverVersion")
    androidTestImplementation ("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation ("androidx.room:room-testing:$roomVersion")
    androidTestImplementation ("androidx.test.ext:truth:1.5.0")
    testImplementation ("androidx.test.ext:truth:1.5.0")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}