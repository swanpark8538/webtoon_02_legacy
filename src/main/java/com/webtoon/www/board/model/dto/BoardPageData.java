package com.webtoon.www.board.model.dto;

import lombok.Data;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardPageData {
	private List list;
	private String pageNavi;
}
