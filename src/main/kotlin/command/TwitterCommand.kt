package com.otonashi.command

import com.otonashi.TwitterCommandArgumentContext
import com.otonashi.TwitterHelper
import net.mamoe.mirai.console.command.*
import net.mamoe.mirai.console.permission.*
import net.mamoe.mirai.contact.*


object TwitterDynamicCommand:CompositeCommand(owner = TwitterHelper,
    "twitter-dynamic",
    "推特动态",
    description = "Twitter动态指令",
    overrideContext = TwitterCommandArgumentContext
) {
    @SubCommand("add", "添加")
    suspend fun CommandSender.add(uid: Long, contact: Contact) {

    }
}