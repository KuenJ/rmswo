package org.zerock.springex.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.service.TodoService;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {


    @Autowired(required = false)
    private TodoMapper todoMapper;
    private TodoService todoService;

    @Test
    public void testGetTime() {
        log.info(todoMapper.getTime());

    }

    @Test
    public void testInsert() {

        TodoVO todoVO = TodoVO.builder()
                .title("스프링테스트")
                .dueDate(LocalDate.of(2022, 10, 10))
                .writer("user00")
                .build();

        todoMapper.insert(todoVO);
    }

    @Test
    public void selectAll() {
        List<TodoVO> voList = todoMapper.selectAll();

        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne() {
        TodoVO todoVO = todoMapper.selectOne(3L);
        log.info((todoVO));
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));
    }

//    @Test
//    public void testPaging(){
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
//        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
//        log.info(responseDTO);
//
//        responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));
//    }
}