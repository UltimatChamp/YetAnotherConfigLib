import dev.kikugie.stonecutter.StonecutterSettings

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://maven.architectury.dev")
        maven("https://maven.neoforged.net/releases/")
        maven("https://maven.minecraftforge.net/")
        maven("https://maven.kikugie.dev/releases")
        maven("https://maven.kikugie.dev/snapshots")
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.4.5"
}

extensions.configure<StonecutterSettings> {
    kotlinController = true
    centralScript = "build.gradle.kts"
    shared {
        fun mc(mcVersion: String, name: String = mcVersion, loaders: Iterable<String>) {
            for (loader in loaders) {
                vers("$name-$loader", mcVersion)
            }
        }

        mc("1.21.2", loaders = listOf("fabric", "neoforge"))
        mc("1.21", loaders = listOf("fabric", "neoforge"))
        mc("1.20.6", loaders = listOf("fabric", "neoforge"))
        mc("1.20.4", loaders = listOf("fabric", "neoforge"))
        mc("1.20.1", loaders = listOf("fabric", "forge"))
    }
    create(rootProject)
}
rootProject.name = "YetAnotherConfigLib"
