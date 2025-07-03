import org.jetbrains.intellij.tasks.PatchPluginXmlTask

plugins {
    id("org.jetbrains.intellij") version "1.13.3"
}

intellij {
    version.set("2023.1")
    plugins.set(listOf("java"))
}

tasks.withType<PatchPluginXmlTask> {
    version.set("1.0.0")
    sinceBuild.set("231")
    untilBuild.set("232.*")
}
