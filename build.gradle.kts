plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.1.1").apply(false)
    id("com.android.library").version("8.1.1").apply(false)
    id("io.gitlab.arturbosch.detekt").version("1.23.1").apply(true)
    id("com.github.ben-manes.versions").version("0.47.0").apply(false)
    kotlin("android").version("1.8.21").apply(false)
    kotlin("multiplatform").version("1.8.21").apply(false)
}

allprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    dependencies {
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.1")
    }
}

subprojects {
    detekt {
        autoCorrect = true
        buildUponDefaultConfig = true
        config.setFrom(rootProject.files("config/quality/detekt/detekt.yml"))
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
