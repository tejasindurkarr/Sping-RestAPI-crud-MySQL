package com.tejas.excpetion;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Response {

	private String msg;
	private String expCode;
	private LocalDate date;
}
