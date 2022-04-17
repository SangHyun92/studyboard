package com.study.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.board.entity.Board;
import com.study.board.entity.BoardRepository;

@SpringBootTest
public class BoardTests {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Test
	void save() {
		// 1. create board post param
		Board params = Board.builder()
				.title("1st post title")
				.content("1st post content")
				.writer("A")
				.hits(0)
				.deleteYn('N')
				.build();
		

        // 2. save board post
        boardRepository.save(params);
        
        // 3. select saved data
        Board entity = boardRepository.findById((long) 1).get();
        assertThat(entity.getTitle()).isEqualTo("1st post title");
        assertThat(entity.getContent()).isEqualTo("1st post content");
        assertThat(entity.getWriter()).isEqualTo("A");
	}
	
	@Test
    void findAll() {
        // 1. counting all board posts
        long boardsCount = boardRepository.count();

        // 2. search all board posts
        List<Board> boards = boardRepository.findAll();
    }

    @Test
    void delete() {
        // 1. search 1st board posts
        Board entity = boardRepository.findById((long) 1).get();

        // 2. delete founded data
        if (entity != null) {
            boardRepository.delete(entity);
        } else {
        	System.out.println("no entity");
        }
    }
}
