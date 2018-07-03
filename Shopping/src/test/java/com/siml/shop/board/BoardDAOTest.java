package com.siml.shop.board;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.siml.shop.board.dao.BoardDAO;
import com.siml.shop.board.dto.QnABoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class BoardDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

    @Inject
    private BoardDAO dao;

    @Test
    public void testInsert() throws Exception {
        QnABoardDTO dto = new QnABoardDTO();
        dto.setTitle("t");
        dto.setContent("c");
        dto.setWriter("w");
        dao.insert(dto);
    }

    @Test
    public void testRead() throws Exception {
        logger.info(dao.read(1).toString());
    }

    @Test
    public void testUpdate() throws Exception {
    	QnABoardDTO dto = new QnABoardDTO();
    	dto.setSeq(1);
    	dto.setTitle("t1");
    	dto.setContent("c1");
        dao.modify(dto);
    }

    @Test
    public void testDelete() throws Exception {
    	dao.delete(1);
    }
}