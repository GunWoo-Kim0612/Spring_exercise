package com.springbook.biz.board;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String searchKeyword;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String searchCondition;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private MultipartFile uploadFile;
	
}
