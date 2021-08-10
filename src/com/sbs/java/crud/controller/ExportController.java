package com.sbs.java.crud.controller;

import java.util.List;
import java.util.Scanner;

import com.sbs.java.crud.container.Container;
import com.sbs.java.crud.dto.Article;
import com.sbs.java.crud.dto.Member;
import com.sbs.java.crud.service.ArticleService;
import com.sbs.java.crud.service.ExportService;
import com.sbs.java.crud.util.Util;

public class ExportController extends Controller {
	private Scanner sc;
	private String command;
	private String actionMethodName;
	private ExportService exportService;

	public ExportController(Scanner sc) {
		this.sc = sc;
		exportService = Container.exportService;
	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "html":
			doHtml();
			break;
		default:
			System.out.println("존재하지 않는 명령어입니다.");
			break;
		}
	}

	private void doHtml() {
		System.out.println("html 생성을 시작합니다.");
		exportService.makeHtml();
	}

	@Override
	public void makeTestData() {
		
	}
}
