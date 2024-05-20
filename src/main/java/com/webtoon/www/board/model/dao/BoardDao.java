package com.webtoon.www.board.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webtoon.www.board.model.dto.Board;
import com.webtoon.www.board.model.dto.BoardFile;

@Repository
public class BoardDao{
	@Autowired
	private SqlSessionTemplate session;
	
	public List getBoardList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectList("board.getBoardList",map);
	}
	public int totalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("board.totalCount");
	}
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		return session.insert("board.insertBoard",board);
	}
	public int insertBoardFile(BoardFile file) {
		// TODO Auto-generated method stub
		return session.insert("board.insertBoardFile",file);
	}
	public int updateReadCount(int boardNo) {
		return session.update("board.updateReadCount",boardNo);
	}
	public Board selectOneBoard(int boardNo) {
		// TODO Auto-generated method stub
		return session.selectOne("board.selectOneBoard",boardNo);
	}
	public int updateBoard(Board board) {
		return session.update("board.updateBoard",board);
	}
	public List<BoardFile> selectDelFileList(int[] delFileNo) {
		// TODO Auto-generated method stub
		return session.selectList("board.selectDelFileList",delFileNo);
	}
	public int deleteBoardFile(int[] delFileNo) {
		// TODO Auto-generated method stub
		return session.delete("board.deleteBoardFile",delFileNo);
	}
	public List<BoardFile> selectOneBoardFiles(int boardNo) {
		// TODO Auto-generated method stub
		return session.selectList("board.selectOneBoardFiles",boardNo);
	}
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return session.delete("board.deleteBoard",boardNo);
	}
}
