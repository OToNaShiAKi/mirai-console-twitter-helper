package com.otonashi

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info
import com.otonashi.command.*

object TwitterHelper : KotlinPlugin(
        JvmPluginDescription(
                id = "com.otonashi.twitter-helper",
                name = "twitter-helper",
                version = "0.1.0",
        ) {
            author("OToNaShiAKi")
        }
) {
    override fun onEnable() {
        logger.info { "Twitter-Help Plugin loaded" }
    }
}