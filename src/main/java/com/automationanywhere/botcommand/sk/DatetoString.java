/*
 * Copyright (c) 2019 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */
/**
 * 
 */
package com.automationanywhere.botcommand.sk;



import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.AttributeType.VARIABLE;
import static com.automationanywhere.commandsdk.model.AttributeType.CHECKBOX;

import static com.automationanywhere.commandsdk.model.DataType.RECORD;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.automationanywhere.commandsdk.model.DataType.BOOLEAN;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.DateTimeValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.data.model.Schema;
import com.automationanywhere.botcommand.data.model.record.Record;

import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;

import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import com.automationanywhere.commandsdk.annotations.ConditionTest;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.BotCommand.CommandType;

/**
 * @author Stefan Karsten
 *
 */

@BotCommand
@CommandPkg(label = "Converts Date to String ", name = "datetostring",
        description = "Converts a Date to a String",
        node_label = "Converts Date to String", icon = "pgk.svg", comment = true  , background_color =  "#86c2ff" ,
        return_type=DataType.STRING, return_label="Date String", return_required=true)
public class DatetoString {
	   
	@Execute
    public StringValue  action(@Idx(index = "1", type = AttributeType.DATETIME)  @Pkg(label = "Date " , default_value_type = DataType.DATETIME) @NotEmpty ZonedDateTime  datevalue,
                               @Idx(index = "2", type = TEXT) @Pkg(label = "Target Format"  , default_value_type = STRING ) @NotEmpty String format,
                               @Idx(index = "3", type = TEXT) @Pkg(label = "Locale"  , default_value_type = STRING , default_value = "en") @NotEmpty String formatlocale) throws Exception
     {

		Locale locale = new Locale(formatlocale);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format,locale);
		String formattedString = datevalue.format(formatter);
		return new StringValue(formattedString);
     
     }
		
	
}