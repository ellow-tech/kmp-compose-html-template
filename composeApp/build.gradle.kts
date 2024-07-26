plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.compose")
    id("dev.icerock.mobile.multiplatform-resources")
    id("org.jetbrains.kotlin.plugin.serialization")
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation("dev.icerock.moko:resources:0.24.1")
            implementation("io.ktor:ktor-client-core:2.3.12")
            implementation("io.ktor:ktor-client-content-negotiation:2.3.12")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.12")
        }
        jsMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.html.core)
            implementation("io.ktor:ktor-client-js:2.3.12")
            implementation("dev.inmo:tgbotapi.webapps:15.2.0")
        }
    }
}

multiplatformResources {
    resourcesPackage.set("teck.ellow.clicker")
    resourcesClassName.set("Res")
}