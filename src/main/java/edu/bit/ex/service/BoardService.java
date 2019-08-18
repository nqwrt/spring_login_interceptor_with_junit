package edu.bit.ex.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.bit.ex.vo.BoardVO;
import edu.bit.mapper.BoardMapper;

@Service
public class BoardService {

	@Inject
	BoardMapper boardMapper;
	
    public List<BoardVO> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
    }
    
	//boardService.insertBoard(boardVO);
    public void insertBoard(BoardVO boardVO) throws Exception {
    	boardMapper.insertBoard(boardVO);
    }

    public BoardVO selectBoardOne(String bId) throws Exception {
		return boardMapper.selectBoardOne(bId);
    }
    
    /*
    public List<BoardVO> selectBoardListPage(Criteria criteria)  {
		return sqlSession.selectList("selectBoardListPage",criteria);
    }
    
    public int selectTotal() throws Exception {
		return sqlSession.selectOne("selectTotal");
    }
    
    public void updateShape(BoardVO param) throws Exception {
		sqlSession.insert("updateShape", param);
    }
    
    public void insertReply(BoardVO param) throws Exception {
		sqlSession.insert("insertReply", param);
    }
    
    public void updateBoard(BoardVO param) throws Exception {
		sqlSession.insert("updateBoard1", param);
    }
     
    public BoardVO selectBoardOne(String bId) throws Exception {
		return sqlSession.selectOne("selectBoardOne", bId);
    }

    public void deleteBoardOne(String bId) throws Exception {
		sqlSession.delete("deleteBoardOne", bId);
    }
    */


    
}
