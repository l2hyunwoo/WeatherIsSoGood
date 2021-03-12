plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = Apps.pacakageName
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode(Apps.versionCode)
        versionName(Apps.versionName)
        buildConfigField("String", "WEATHER_API_KEY", properties["WEATHER_API_KEY"].toString())
        buildConfigField("String", "WEATHER_BASE_URL", properties["WEATHER_BASE_URL"].toString())

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.java_version
        targetCompatibility = Versions.java_version
    }
    kotlinOptions {
        jvmTarget = Versions.jvm_version
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(KotlinDependencies.kotlin)
    implementation(AndroidXDependencies.appCompat)
    implementation(AndroidXDependencies.coreKtx)
    implementation(MaterialDesignDependencies.materialDesign)
    implementation(AndroidXDependencies.constraintLayout)

    // Dagger-Hilt
    implementation(AndroidXDependencies.hilt)
    kapt(KaptDependencies.hiltCompiler)

    // Gson
    implementation(ThirdPartyDependencies.gson)

    // KTX
    implementation(AndroidXDependencies.viewModelKtx)
    implementation(AndroidXDependencies.activityKtx)
    implementation(AndroidXDependencies.fragmentKtx)

    // Retrofit & OkHttp
    implementation(ThirdPartyDependencies.okHttp)
    implementation(ThirdPartyDependencies.okHttpInterceptor)
    implementation(ThirdPartyDependencies.retrofit)
    implementation(ThirdPartyDependencies.retrofitGsonConverter)

    testImplementation(TestDependencies.jUnit)
    androidTestImplementation(TestDependencies.androidTest)
    androidTestImplementation(TestDependencies.espresso)
}