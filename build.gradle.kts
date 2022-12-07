import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0-Beta"
    application
}



group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

val kotestVesion = "5.5.4"

dependencies {
    implementation("com.github.quickbirdstudios.NonEmptyCollections:NonEmptyCollections:1.1.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test:1.7.22")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVesion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVesion")
    testImplementation("io.kotest:kotest-property:$kotestVesion")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }
}

application {
    mainClass.set("MainKt")
}
