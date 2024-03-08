module java_scene02 {
	exports login.main;
	exports login.service;
	exports login.controller;
	exports login.dao;
	exports login.dto;
	exports login.url;
	
	exports member.main;
	exports member.service;
	exports member.controller;
	exports member.dao;
	exports member.dto;
	exports common;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;

	requires java.sql;
}