package com.webtoon.www.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.webtoon.www.util.FileUtils;
import com.webtoon.www.board.model.dto.Board;
import com.webtoon.www.board.model.dto.BoardFile;
import com.webtoon.www.board.model.dto.BoardPageData;
import com.webtoon.www.board.model.service.BoardService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	@Qualifier("fileLocation")
	private String root;
	@Autowired
	private FileUtils fileUtils;

	@GetMapping(value="/boardList")
	public String boardList(int reqPage, Model model) {
		BoardPageData bpd = boardService.getBoardList(reqPage);
		model.addAttribute("list", bpd.getList());
		model.addAttribute("pageNavi", bpd.getPageNavi());
		return "board/boardList";
	}
	
	@GetMapping(value="/writeFrm")
	public String writeFrm() {
		return "board/writeFrm";
	}
	
	@PostMapping(value="/write")
	public String write(Board board, MultipartFile[] upfile) {
		List<BoardFile> fileList = new ArrayList<BoardFile>();
		if(!upfile[0].isEmpty()) {
			String savepath = root + "/board/";
			for(MultipartFile file : upfile) {
				String filename = file.getOriginalFilename();
				String filepath = fileUtils.upload(savepath, file);
				BoardFile boardFile = new BoardFile();
				boardFile.setFilename(filename);
				boardFile.setFilepath(filepath);
				fileList.add(boardFile);
			}
			System.out.println(root);
		}
		
		System.out.println(board);
		System.out.println(fileList);
		board.setFileList(fileList);
		int result = boardService.insertBoard(board);
		if(result == fileList.size() + 1) {
			return "redirect:/board/boardList?reqPage=1";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping(value="/boardView")
	public String boardView(int boardNo, Model model) {
		Board board = boardService.selectOneBoard(boardNo);
		model.addAttribute("board", board);
		return "board/boardView";
	}
	
	@GetMapping(value="/boardView2")
	public String boardView2(int boardNo, Model model) {
		Board board = boardService.getOneBoard(boardNo);
		model.addAttribute("board", board);
		return "board/boardView";
	}
	
	@GetMapping(value="/downloadFile")
	public void downloadFile(String filename, String filepath, HttpServletResponse response) {
		String savepath = root + "/board/";
		fileUtils.downloadFile(savepath, filename, filepath, response);
	}
	
	@GetMapping(value="/updateFrm")
	public String updateFrm(int boardNo, Model model) {
		Board board = boardService.getOneBoard(boardNo);
		model.addAttribute("board", board);
		return "board/updateFrm";
	}
	
	@PostMapping(value="/update")
	public String update(Board board, MultipartFile[] upfile, int[] delFileNo) {
		List<BoardFile> fileList = new ArrayList<BoardFile>();
		if(!upfile[0].isEmpty()) {
			String savepath = root + "/board/";
			for(MultipartFile file : upfile) {
				String filename = file.getOriginalFilename();
				String filepath = fileUtils.upload(savepath, file);
				BoardFile boardFile = new BoardFile();
				boardFile.setFilename(filename);
				boardFile.setFilepath(filepath);
				fileList.add(boardFile);
			}
		}
		board.setFileList(fileList);
		List<BoardFile> delFileList = boardService.updateBoard(board, delFileNo);
		if(delFileList != null) {
			String savepath = root + "/board/";
			for(BoardFile file : delFileList) {
				fileUtils.deleteFile(savepath, file.getFilepath());				
			}
		}
		return "redirect:/board/boardView2?boardNo="+board.getBoardNo();
	}
	
	@GetMapping(value="/delete")
	public String delete(int boardNo) {
		List<BoardFile> fileList = boardService.deleteBoard(boardNo);
		if(fileList != null) {
			String savepath = root + "/board/";
			for(BoardFile file : fileList) {
				fileUtils.deleteFile(savepath, file.getFilepath());				
			}
			return "redirect:/board/boardList?reqPage=1";			
		}else {
			return "redirect:/board/boardView?boardNo="+boardNo;
		}
	}
}






