package com.api.dummy.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.dummy.model.Model;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/api")
public class DummyAPIController {
		
	@RequestMapping(value = "/API-dummy", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String postApiDummy(@RequestBody LinkedHashMap<?, ?> model) {
		
		String texto = (String) model.get("texto");
		
		if (texto.contentEquals("hola")) {
			return "hola-nuevo-docker";
		} else {
			return "chau";
		}
	}
	
	@RequestMapping(value = "/API-dummy", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getApiDummy() {
			return "Proceso Ejecutado, se recibio el get";		
	}
	
	//Funcion para dar formato a los Date
		public static String formatDateToString(Date date, String format,
				String timeZone) {
			// null check
			if (date == null) return null;
			// create SimpleDateFormat object with input format
			// settings locale to spanish
			Locale l = new Locale ( "es" , "ES" );

			SimpleDateFormat sdf = new SimpleDateFormat(format, l);
			// default system timezone if passed null or empty
			if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
				timeZone = Calendar.getInstance().getTimeZone().getID();
			}
			// set timezone to SimpleDateFormat
			sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
			// return Date in required format with timezone as String
			return sdf.format(date);
		}
}
