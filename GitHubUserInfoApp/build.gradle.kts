plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "com.example.githubuserinfo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
}

application {
    mainClass.set("com.example.githubuserinfo.MainKt")
}
