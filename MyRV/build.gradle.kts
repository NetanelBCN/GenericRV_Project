
plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

android {
    namespace = "dev.netanelbcn.myrv"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
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

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {  // Changed from "default" to "release"
            afterEvaluate {
                from(components["release"])    // Changed from "default" to "release"
            }
            groupId = "com.github.NetanelBCN"
            artifactId = "GenericRV_Project"
            version = "1.2.1"
        }
    }
}

dependencies {
    // Removed this line - it shouldn't be in dependencies block:
    // implementation("com.android.tools.build:gradle:8.0.0")

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}