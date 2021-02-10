buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.20")
    }
}

group = "color.sheet"
version = "1.0"

allprojects {
    repositories {
        jcenter()
        mavenCentral()
    }
}