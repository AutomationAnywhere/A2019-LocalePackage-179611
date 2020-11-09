package com.automationanywhere.botcommand.sk;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DatetoStringCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(DatetoStringCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    DatetoString command = new DatetoString();
    if(parameters.get("datevalue") == null || parameters.get("datevalue").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","datevalue"));
    }

    if(parameters.get("format") == null || parameters.get("format").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","format"));
    }

    if(parameters.get("formatlocale") == null || parameters.get("formatlocale").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","formatlocale"));
    }

    if(parameters.get("datevalue") != null && parameters.get("datevalue").get() != null && !(parameters.get("datevalue").get() instanceof ZonedDateTime)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","datevalue", "ZonedDateTime", parameters.get("datevalue").get().getClass().getSimpleName()));
    }
    if(parameters.get("format") != null && parameters.get("format").get() != null && !(parameters.get("format").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","format", "String", parameters.get("format").get().getClass().getSimpleName()));
    }
    if(parameters.get("formatlocale") != null && parameters.get("formatlocale").get() != null && !(parameters.get("formatlocale").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","formatlocale", "String", parameters.get("formatlocale").get().getClass().getSimpleName()));
    }
    try {
      Optional<Value> result =  Optional.ofNullable(command.action(parameters.get("datevalue") != null ? (ZonedDateTime)parameters.get("datevalue").get() : (ZonedDateTime)null ,parameters.get("format") != null ? (String)parameters.get("format").get() : (String)null ,parameters.get("formatlocale") != null ? (String)parameters.get("formatlocale").get() : (String)null ));
      logger.traceExit(result);
      return result;
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","action"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
