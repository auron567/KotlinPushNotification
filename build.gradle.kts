plugins {
    id(BuildPlugins.androidApplication) version BuildVersions.agp apply false
    id(BuildPlugins.kotlinAndroid) version BuildVersions.kotlin apply false
    id(BuildPlugins.googleServices) version BuildVersions.googleServices apply false
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
