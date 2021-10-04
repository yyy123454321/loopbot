package com.github.yyy123454321.loopbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.ServerTextChannelBuilder;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.webhook.IncomingWebhook;
import org.javacord.api.entity.webhook.Webhook;
import org.javacord.api.entity.webhook.WebhookBuilder;

import java.awt.*;
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class main {
    public static String message = "<@!514021652657602583>";
    public static long terror = 877416494596759562L;
    public static void main(String[] args) {
        String token;
        Scanner sc = new Scanner(System.in);

        // Send Embed
        long channelid;
        token = sc.nextLine().trim();
        channelid = sc.nextLong();
        new sendEmbed(token, channelid);

        // Terror with Webhook
        /*
        while(true) {
            token = sc.nextLine().trim();
            new loopWebhook(token).start();
        }
        */

        // Terror with Bot
        /*
        while(true) {
            token = sc.nextLine().trim();
            new loopBot(token).start();
        }
        */
    }
}

class sendEmbed {
    DiscordApi api;
    sendEmbed(String token, long channelid) {
        api = new DiscordApiBuilder().setToken(token).login().join();
        //new MessageBuilder().setEmbed(
                //new EmbedBuilder().setTitle("신고 양식")
                //        .setColor(new Color(255, 85, 85))
                //        .addField("==============================\n세부 신고 양식 (* 필수항목)", "** **\n**신고인 닉네임**:\n\n\\***피신고인 닉네임**:\n\n\\***위반한 규정**:\n\n**복구 희망 여부**(예/아니오):\n\n\\***설명**(증거 자료 첨부 권장):\n\n** **")
                //        .addField("==============================\n간편 신고 양식", "** **\n**피신고인 닉네임**:\n\n**위반한 규정**:\n\n**설명**(증거 자료 첨부 권장):\n\n** **")
                //        .setFooter("양식을 따르지 않은 신고는 **처리 불가**가 될 수 있습니다.\n간편 신고 양식을 사용하시면 신고인은 디스코드 별명, 복구 희망 여부는 아니오로 간주됩니다.")
        //).send(api.getTextChannelById(channelid).get());
    }
}

class loopWebhook extends Thread{
    DiscordApi api;
    Server terrorServer;
    loopWebhook(String token) {
        api = new DiscordApiBuilder().setToken(token).login().join();
        terrorServer = api.getServerById(main.terror).get();
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            //new ServerTextChannelBuilder(event.getServer().get()).setName("terror").create();
        }
        int j = 0; int k = 0;
        for (ServerTextChannel i : terrorServer.getTextChannels()) {
            //if(i.getTopic().equalsIgnoreCase("noBot")) continue;
           // if (j++ > 40) break;
           // new WebhookBuilder(i).setName("KillRyan" + k++).create();
        }
        try {
            for (IncomingWebhook i : terrorServer.getIncomingWebhooks().get()) {
                new loopWebhookMessage(i).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class loopWebhookMessage extends Thread{
    IncomingWebhook webhook;
    public loopWebhookMessage(IncomingWebhook webhook) {
        this.webhook = webhook;
    }
    public void run() {
        while(true) {
            webhook.sendMessage(main.message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class loopBot extends Thread{
    DiscordApi api;
    Server terrorServer;
    loopBot(String token) {
        api = new DiscordApiBuilder().setToken(token).login().join();
        terrorServer = api.getServerById(main.terror).get();
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            //new ServerTextChannelBuilder(event.getServer().get()).setName("terror").create();
        }
        int j = 0;
        for (ServerTextChannel i : terrorServer.getTextChannels()) {
            if (j++ > 40) break;
            new loop(i).start();
        }
    }
}

class loop extends Thread {
    ServerTextChannel channel;
    public loop(ServerTextChannel channel) {
        this.channel = channel;
    }
    public void run() {
        while(true) {
            channel.sendMessage(main.message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}