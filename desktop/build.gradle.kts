import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

repositories {
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(compose.desktop.currentOs)
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}