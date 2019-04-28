plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AppConfigurations.ofNumberSdk.compile)
    defaultConfig {
        applicationId = AppConfigurations.applicationId
        minSdkVersion(AppConfigurations.ofNumberSdk.minimum)
        targetSdkVersion(AppConfigurations.ofNumberSdk.maximum)
        versi onCode = AppConfigurations.applicationBuild
        versionName = AppConfigurations.applicationName

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // Google support
    implementation(GoogleLibraries.appCompatv7)
    implementation(GoogleLibraries.appSupportv4)
    implementation(GoogleLibraries.supportDesign)
    implementation(GoogleLibraries.recyclerView)
    implementation(GoogleLibraries.cardView)
    implementation(GoogleLibraries.kotlinStdLib7)

    // Google AAC
    implementation(GoogleLibraries.aacRoomRuntime)

    implementation(GoogleLibraries.aacLcExtensions)
    kapt(GoogleLibraries.aacLcCompiler)

    // Network n' debugging
    implementation(GeneralLibraries.Debugging.stetho)
    implementation(GeneralLibraries.Network.retrofit)
    implementation(GeneralLibraries.Network.retrofitAdapterRx2)
    implementation(GeneralLibraries.Network.retrofitGsonConverter)
    implementation(GeneralLibraries.Network.okhttp)
    implementation(GeneralLibraries.Network.okhttpLogging)

    // Async
    implementation(GeneralLibraries.Async.rxAndroid)
    implementation(GeneralLibraries.Async.rxJava)

    // Utils
    implementation(GeneralLibraries.Image.glide)
    kapt(GeneralLibraries.Image.glideCompiler)

    implementation(GeneralLibraries.Utils.timber)

    // Dependency Injection
    implementation(GeneralLibraries.DependenciesInjection.dagger)
    implementation(GeneralLibraries.DependenciesInjection.daggerAndroid)
    implementation(GeneralLibraries.DependenciesInjection.daggerSupport)

    kapt(GeneralLibraries.DependenciesInjection.daggerCompiler)
    kapt(GeneralLibraries.DependenciesInjection.daggerProcessor)
}
