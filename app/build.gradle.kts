plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
	alias(libs.plugins.kotlin.serialization)
	alias(libs.plugins.kotlinAndroidKsp)
	alias(libs.plugins.hiltAndroid)
}

android {
	namespace = "com.example.mechtasmartphones"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.example.mechtasmartphones"
		minSdk = 26
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		debug {
			buildConfigField("String", "BASE_URL", "\"https://www.mechta.kz/api/v2/\"")
		}
		release {
			buildConfigField("String", "BASE_URL", "\"https://www.mechta.kz/api/v2/\"")
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
			signingConfig = signingConfigs.getByName("debug")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		compose = true
		buildConfig = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.14"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)

	// Navigation
	implementation(libs.navigation.compose)
	implementation(libs.kotlinx.serialization.json)

	// Retrofit
	implementation(libs.retrofit)
	implementation(libs.retrofit.converter.moshi)

	// Moshi
	implementation(libs.moshi)
	ksp(libs.moshi.kotlin.codegen)

	// Chucker
	implementation(libs.chucker)

	// Hilt
	implementation(libs.hilt.android)
	implementation(libs.hilt.navigation.compose)
	ksp(libs.hilt.compiler)

	// Coil
	implementation(libs.coil.compose)

	// Room
	implementation(libs.room.runtime)
	implementation(libs.room.ktx)
	annotationProcessor(libs.room.compiler)
	ksp(libs.room.compiler)

	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)
}