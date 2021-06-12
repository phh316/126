package com.agree.selenium.domain.utils;

import org.apache.log4j.Logger;

/**
 * Created by 86183 on 2021/5/29.
 */
public class Log {

    private static final Logger LOGGER = Logger.getLogger(Log.class.getName());

    public static void startCase(String message){
        LOGGER.info("*******************            "+message+"            *******************");
    }
    public static void endtCase(String message){
        LOGGER.info("*******************            "+message+"       *******************");
    }
    public static void endtCasec(String message){
        LOGGER.info("*******************            "+"\033[32;4m"+message+"\033[0m"+"       *******************");
    }
    public static void info(String message){
        LOGGER.info("*******************            "+message+"            *******************");
    }
    public static void infoc(String message){
        LOGGER.error("*******************            "+"\033[32;4m"+message+"\033[0m"+"     *******************");
    }
    public static void warn(String message){
        LOGGER.warn(message);
    }
    public static void error(String message){
        LOGGER.error("*******************            "+"\033[31;4m"+message+"\033[0m"+"     *******************");
    }
    public static void fatal(String message){
        LOGGER.fatal("*******************            "+"\033[31;4m"+message+"\033[0m"+"     *******************");
    }
    public static void debug(String message){
        LOGGER.debug(message);
    }
}
