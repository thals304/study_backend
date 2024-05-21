package com.application.trainingVer1.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.application.trainingVer1.board.service.BoardService;
/*
 * 24.05.20 time 13:43-13:58
 * sql logging까지 포함해 MVC spring boot 게시판 만들기 시작
 * 5/20 - 설정, db 생성/연결 및 Controller , Service , DAO 의 injection까지 
 * 
 * */
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
}
