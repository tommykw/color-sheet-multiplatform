pluginManagement {
    plugins {
        kotlin("multiplatform") version "1.4.21-2 "
        kotlin("js") version "1.4.21-2 "
        kotlin("jvm") version "1.4.21-2 "
        id("org.jetbrains.compose") version "0.3.0-build146"
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