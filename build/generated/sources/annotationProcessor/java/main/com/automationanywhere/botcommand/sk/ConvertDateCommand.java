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
import java.util.Map;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ConvertDateCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(ConvertDateCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    ConvertDate command = new ConvertDate();
    if(parameters.get("datestring") == null || parameters.get("datestring").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","datestring"));
    }

    if(parameters.get("sourceformat") == null || parameters.get("sourceformat").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","sourceformat"));
    }

    if(parameters.get("sourcelocale") == null || parameters.get("sourcelocale").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","sourcelocale"));
    }

    if(parameters.get("targetformat") == null || parameters.get("targetformat").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","targetformat"));
    }

    if(parameters.get("targetlocale") == null || parameters.get("targetlocale").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","targetlocale"));
    }

    if(parameters.get("datestring") != null && parameters.get("datestring").get() != null && !(parameters.get("datestring").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","datestring", "String", parameters.get("datestring").get().getClass().getSimpleName()));
    }
    if(parameters.get("sourceformat") != null && parameters.get("sourceformat").get() != null && !(parameters.get("sourceformat").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","sourceformat", "String", parameters.get("sourceformat").get().getClass().getSimpleName()));
    }
    if(parameters.get("sourcelocale") != null && parameters.get("sourcelocale").get() != null && !(parameters.get("sourcelocale").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","sourcelocale", "String", parameters.get("sourcelocale").get().getClass().getSimpleName()));
    }
    if(parameters.get("targetformat") != null && parameters.get("targetformat").get() != null && !(parameters.get("targetformat").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","targetformat", "String", parameters.get("targetformat").get().getClass().getSimpleName()));
    }
    if(parameters.get("targetlocale") != null && parameters.get("targetlocale").get() != null && !(parameters.get("targetlocale").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","targetlocale", "String", parameters.get("targetlocale").get().getClass().getSimpleName()));
    }
    try {
      Optional<Value> result =  Optional.ofNullable(command.action(parameters.get("datestring") != null ? (String)parameters.get("datestring").get() : (String)null ,parameters.get("sourceformat") != null ? (String)parameters.get("sourceformat").get() : (String)null ,parameters.get("sourcelocale") != null ? (String)parameters.get("sourcelocale").get() : (String)null ,parameters.get("targetformat") != null ? (String)parameters.get("targetformat").get() : (String)null ,parameters.get("targetlocale") != null ? (String)parameters.get("targetlocale").get() : (String)null ));
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
