package com.otonashi.command

import com.otonashi.TwitterCommandArgumentContext
import com.otonashi.TwitterHelper
import com.otonashi.TwitterHelper.logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.utils.io.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import net.mamoe.mirai.console.command.*
import net.mamoe.mirai.console.permission.*
import net.mamoe.mirai.contact.*
import java.io.File
import java.net.URI
import kotlin.io.path.toPath

val client = HttpClient(CIO){
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
}
@Serializable
data class SoftResponseAssets(val browser_download_url: String)
@Serializable
data class SoftResponse(val assets: Array<SoftResponseAssets>)

object DownloadSoftCommand:SimpleCommand(owner = TwitterHelper,
    "download-douden",
    "下载同传软件",
    description = "下载同传软件指令",
    overrideContext = TwitterCommandArgumentContext
) {
    @Handler
    suspend fun handle(context: CommandContext, platform: String = "all", version: String = "latest") {
        val url = "https://api.github.com/repos/OToNaShiAKi/material-douden-tool/releases/latest";
        val response:SoftResponse = client.get(url).body();
        for(item in response.assets) {
            val uri = URI(item.browser_download_url)
            println("${uri.fragment} ${uri.scheme} ${uri.toPath().fileName} ${uri.toURL().file}")

        }
    }
}