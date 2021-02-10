plugins {
    kotlin("js")
}

repositories {
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
}

kotlin {
    js(IR) {
        browser {
            binaries.executable()
            webpackTask {
                cssSupport.enabled = true
            }
            runTask {
                cssSupport.enabled = true
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
    }

    sourceSets {
        val main by getting {
            dependencies {
                implementation(project(":common"))
                implementation("org.jetbrains.kotlinx:kotlinx-html:0.7.2")
            }
        }

        val test by getting
    }
}
