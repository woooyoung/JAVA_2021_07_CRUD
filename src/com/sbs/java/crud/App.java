package com.sbs.java.crud;

import java.util.Scanner;

import com.sbs.java.crud.controller.ArticleController;
import com.sbs.java.crud.controller.Controller;
import com.sbs.java.crud.controller.ExportController;
import com.sbs.java.crud.controller.MemberController;

public class App {

	public App() {
	}

	public void start() {
		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
		ExportController exportController = new ExportController(sc);

		articleController.makeTestData();
		memberController.makeTestData();
		exportController.makeTestData();

		while (true) {
			System.out.printf("명령어) ");
			String command = sc.nextLine();

			command = command.trim();

			if (command.length() == 0) {
				continue;
			}

			if (command.equals("system exit")) {
				break;
			}

			String[] commandBits = command.split(" "); // article detail

			if (commandBits.length == 1) {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}

			String controllerName = commandBits[0]; // article
			String actionMethodName = commandBits[1]; // detail

			Controller controller = null;

			if (controllerName.equals("article")) {
				controller = articleController;
			} else if (controllerName.equals("member")) {
				controller = memberController;
			} else if (controllerName.equals("export")) {
				controller = exportController;
			}

			else {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}

			String actionName = controllerName + "/" + actionMethodName;

			switch (actionName) {
			case "article/write":
			case "article/delete":
			case "article/modify":
			case "member/logout":
				if (Controller.isLogined() == false) {
					System.out.println("로그인 후 이용해주세요.");
					continue;
				}
				break;
			}
			switch (actionName) {
			case "member/login":
			case "member/join":
				if (Controller.isLogined()) {
					System.out.println("로그아웃 후 이용해주세요.");
					continue;
				}
				break;
			}

			controller.doAction(command, actionMethodName);

		}

		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}

}
