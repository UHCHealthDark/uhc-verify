plugins {
    id("xyz.jpenilla.run-paper") version "2.0.0"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.3"
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
    implementation("redis.clients:jedis:4.4.3")
    implementation("org.mongodb:mongodb-driver-sync:4.10.2")
    implementation("team.unnamed:inject:2.0.0")
    implementation("net.kyori:adventure-text-minimessage:4.13.1")

    implementation(project(":api"))
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()

        options.release.set(17)
    }
    runServer {
        minecraftVersion("1.18.2")

    }
    shadowJar {
        val packageName = "io.github.wickeddroid.libs"

        archiveBaseName.set("uhc-verify")
        archiveVersion.set("1.0-SNAPSHOT")

        relocate("team.unnamed", "$packageName.command-flow")
        relocate("org.mongodb", "$packageName.mongo")
        relocate("redis.clients", "$packageName.jedis")
    }
}

bukkit {
    main = "io.github.wickeddroid.plugin.UhcVerifyPlugin"
    name = "uhc-verify"
    version = "1.0-SNAPSHOT"
    apiVersion = "1.17"
    author = "Wicked"
}