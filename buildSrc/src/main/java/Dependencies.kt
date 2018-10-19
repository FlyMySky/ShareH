

object Androids {
    const val compileSdkVersion = 28
    const val applicationId = "com.skwen.foru"
    const val recommendApplicationId = "com.skwen.foru.recommendmodule"
    const val connotationApplicationId = "com.skwen.foru.connotationmodule"
    const val minSdkVersion = 14
    const val targetSdkVersion = 28
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
}


object Versions {

    const val junitVersion = "4.12"
    const val runnerVersion = "1.0.2"
    const val espressoVersion = "3.0.2"

    const val kotlinVersion = "1.2.71"
    const val buildGradleVersion = "3.2.0-rc03"

    const val appcompatVersion = "28.0.0"
    const val constraintLayoutVersion = "1.1.3"

    const val retrofitVersion = "2.4.0"
    const val converterGsonVersion = "2.2.0"
    const val adapterRxJava2Version = "2.4.0"

    const val okhttpVersion = "3.11.0"
    const val okhttpInterceptorVersion = "3.11.0"
    const val rxJavaVersion = "2.2.2"
    const val rxAndroidVersion = "2.1.0"
    const val glideVersion = "4.8.0"
}

object Deps {

    //test
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val runner = "com.android.support.test:runner:${Versions.runnerVersion}"
    const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espressoVersion}"

    //plugin
    const val buildGradle = "com.android.tools.build:gradle:${Versions.buildGradleVersion}"
    const val kotlinStdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

    //support
    const val appcompatV7 = "com.android.support:appcompat-v7:${Versions.appcompatVersion}"
    const val supportAnnotations = "com.android.support:support-annotations:${Versions.appcompatVersion}"
    const val design = "com.android.support:design:${Versions.appcompatVersion}"
    const val recyclerview = "com.android.support:recyclerview-v7:${Versions.appcompatVersion}"
    const val cardview = "com.android.support:cardview-v7:${Versions.appcompatVersion}"
    const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayoutVersion}"

    //retrofit2
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGsonVersion}"
    const val adapterRxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.adapterRxJava2Version}"

    //okhttp3
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val okhttpinterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpInterceptorVersion}"

    //rxjava2
    const val rxjava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"

    //glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glidecompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

}