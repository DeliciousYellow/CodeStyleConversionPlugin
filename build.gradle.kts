import org.jetbrains.intellij.tasks.PatchPluginXmlTask

plugins {
    id("org.jetbrains.intellij") version "1.13.3"
    kotlin("jvm") version "1.9.0"  // 加上版本号
}

intellij {
    version.set("2023.1")
    plugins.set(listOf("java"))
}

tasks.withType<PatchPluginXmlTask> {
    version.set("1.0.0")
    // 表示支持所有未来版本
    untilBuild.set("999.*")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains:annotations:24.0.1")
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}