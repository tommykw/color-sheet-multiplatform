pluginManagement {
    plugins {
        kotlin("multiplatform") version "1.4.31"
        kotlin("js") version "1.4.31"
        kotlin("jvm") version "1.4.31"
        id("org.jetbrains.compose") version "0.4.0-build177"
    }

    repositories {
        mavenCentral()
        google()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }
}

rootProject.name = "color-sheet-multiplatform"

include(":desktop")
include(":common")
include(":browser")