package com.run.boot.demo.telegrambots;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

/**
 * @Auther: Administrator
 * @Date: 2019/9/13 01:32
 * @Description:
 */
public class TestRobot {
    // Example taken from https://github.com/rubenlagus/TelegramBotsExamplepublicclassMain {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//        try {
//            telegramBotsApi.registerBot(new ChannelHandlers());
//            telegramBotsApi.registerBot(new DirectionsHandlers());
//            telegramBotsApi.registerBot(new RaeHandlers());
//            telegramBotsApi.registerBot(new WeatherHandlers());
//            telegramBotsApi.registerBot(new TransifexHandlers());
//            telegramBotsApi.registerBot(new FilesHandlers());
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
    }
}
