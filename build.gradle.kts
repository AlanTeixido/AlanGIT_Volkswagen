plugins {
    kotlin("jvm") version "1.9.10"
    application
    id("org.jetbrains.dokka") version "1.9.10"
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
tasks.dokkaHtml.configure {
    outputDirectory.set(buildDir.resolve("dokka"))
}

dependencies {
    testImplementation(kotlin("test"))
    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.9.10")
}
