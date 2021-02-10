pluginManagement {
    plugins {
        kotlin("multiplatform") version "1.4.20"
        kotlin("js") version "1.4.20"
        kotlin("jvm") version "1.4.20"
        id("org.jetbrains.compose") version "0.2.0-build132"
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }
}

rootProject.name = "color-sheet-multiplatform"

include(":desktop")
include(":common")
include(":browser")