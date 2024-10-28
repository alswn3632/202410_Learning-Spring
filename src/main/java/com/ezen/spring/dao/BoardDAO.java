package com.ezen.spring.dao;

import java.util.List;

import com.ezen.spring.domain.BoardVO;

public interface BoardDAO {

	int register(BoardVO bvo);

	List<BoardVO> getList();

	BoardVO getDetail(int bno);

	int delete(int bno);

	int update(BoardVO bvo);

}
