/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.2.1/userguide/building_java_projects.html in the Gradle documentation.
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    `maven-publish`
    id("io.freefair.lombok") version "8.1.0"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()

    maven {
        isAllowInsecureProtocol = true
        url = uri("http://makechtec.online:8080/yolotli/package")
        credentials {
            username = System.getenv("MAKECH_USERNAME")
            password = System.getenv("MAKECH_PASSWORD")
        }
        authentication {
            create<BasicAuthentication>("basic")
        }
    }
}

dependencies {
    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.apache.commons:commons-math3:3.6.1")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:31.1-jre")
    implementation("org.makechtec.software:path_generator:2.0.3")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.9.2")
        }
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.makechtec.software"
            artifactId = "cli_arguments_reader"
            version = "2.0.0"

            from(components["java"])
        }
    }

    repositories{
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://makechtec.online:8080/yolotli/package")
            credentials {
                username = System.getenv("MAKECH_USERNAME")
                password = System.getenv("MAKECH_PASSWORD")
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
}