package com.springbook.biz.board;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//데이터를 묶음 단위로 처리하기위한 빈 클래스
@Getter
@Setter
@ToString
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String searchKeyword;
	private String searchCondition;
	
}
