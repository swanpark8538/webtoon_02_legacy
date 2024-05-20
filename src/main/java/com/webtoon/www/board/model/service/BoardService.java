package com.webtoon.www.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webtoon.www.board.model.dao.BoardDao;
import com.webtoon.www.board.model.dto.Board;
import com.webtoon.www.board.model.dto.BoardFile;
import com.webtoon.www.board.model.dto.BoardPageData;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	public BoardPageData getBoardList(int reqPage) {
		int numPerPage = 10;
		int end = reqPage * numPerPage;
		int start = end - numPerPage + 1;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		List list = boardDao.getBoardList(map);
		
		int totalCount = boardDao.totalCount();
		int totalPage = totalCount%numPerPage == 0 ? totalCount/numPerPage : totalCount/numPerPage + 1;
		
		int pageNaviSize = 10;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		String pageNavi = "";
		if(pageNo != 1) {
			pageNavi = "<a href='/board/boardList?reqPage="+(pageNo-1)+"'>[이전]</a>";
		}
		for(int i=0; i<pageNaviSize; i++) {
			if(reqPage == pageNo) {
				pageNavi += "<span>"+pageNo+"</span>";				
			}else {
				pageNavi += "<a href='/board/boardList?reqPage="+pageNo+"'>"+pageNo+"</a>";				
			}
			pageNo++;
			if(pageNo > totalPage) {
				break;
			}
		}
		if(pageNo <= totalPage) {
			pageNavi += "<a href='/board/boardList?reqPage="+pageNo+"'>[다음]</a>";
		}
		
		BoardPageData bpd = new BoardPageData(list, pageNavi);
		return bpd;
	}

	@Transactional
	public int insertBoard(Board board) {
		int result = boardDao.insertBoard(board);
		if(result > 0) {
			for(BoardFile file : board.getFileList()) {
				file.setBoardNo(board.getBoardNo());
				result += boardDao.insertBoardFile(file);
			}
		}
		return result;
	}

	public Board selectOneBoard(int boardNo) {
		int result = boardDao.updateReadCount(boardNo);
		if(result > 0) {
			Board board = boardDao.selectOneBoard(boardNo);
			return board;
		}else {
			return null;
		}
	}

	public Board getOneBoard(int boardNo) {
		Board board = boardDao.selectOneBoard(boardNo);
		return board;
	}

	@Transactional
	public List<BoardFile> updateBoard(Board board, int[] delFileNo) {
		int result = boardDao.updateBoard(board);
		if(result > 0) {
			List<BoardFile> delFileList = new ArrayList<BoardFile>();
			for(BoardFile file : board.getFileList()) {
				file.setBoardNo(board.getBoardNo());
				result += boardDao.insertBoardFile(file);
			}
			if(delFileNo != null) {
				delFileList = boardDao.selectDelFileList(delFileNo);
				result += boardDao.deleteBoardFile(delFileNo);
			}
			int total = delFileNo != null ? 1 + board.getFileList().size() + delFileList.size() : 1 + board.getFileList().size();
			if(result == total) {
				return delFileList;
			}else {
				return null;
			}
		}else {
			return null;			
		}
	}

	@Transactional
	public List<BoardFile> deleteBoard(int boardNo) {
		List<BoardFile> fileList = boardDao.selectOneBoardFiles(boardNo);
		int result = boardDao.deleteBoard(boardNo);
		if(result > 0) {
			return fileList;			
		}else {
			return null;
		}
	}
}



