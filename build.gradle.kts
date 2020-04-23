buildscript {
    repositories {
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
    application
    idea
}

repositories {
    jcenter()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.http4k:http4k-core:3.244.0")
    implementation("org.http4k:http4k-client-okhttp:3.244.0")
    implementation("org.http4k:http4k-server-jetty:3.244.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.6.2")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.10")
    testImplementation("org.assertj:assertj-core:3.12.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:2.0.10")
}

application {
    mainClassName = "http4k.test.drive.AppKt"
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
            javaParameters = true
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
            javaParameters = true
        }
    }
    test {
        useJUnitPlatform {
            includeEngines("spek2")
        }
    }
}
