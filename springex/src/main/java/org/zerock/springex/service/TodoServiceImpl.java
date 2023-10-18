package org.zerock.springex.service;



import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.mapper.TodoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor

public class TodoServiceImpl implements TodoService {
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);
        log.info(todoVO);

        todoMapper.insert(todoVO);
    }

//    @Override
//    public List<TodoDTO> getAll() {
//       List<TodoDTO> dtoList = todoMapper.selectAll().stream()
//                .map(vo->modelMapper.map(vo,TodoDTO.class))
//                .collect(Collectors.toList());
//
//
//       return dtoList;
//    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        int total = todoMapper.getCount(pageRequestDTO);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }
    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO = todoMapper.selectOne(tno);
        TodoDTO todoDTO =modelMapper.map(todoVO, TodoDTO.class);

        return todoDTO;
    }
    @Override
    public  void remove(Long tno){
        todoMapper.delete(tno);
    }

    @Override

    public  void  modify(TodoDTO todoDTO){
        TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);

        todoMapper.update(todoVO);
    }
}
/**log.info(modelMapper);: 이 부분은 로깅을 통해 modelMapper 객체를 출력합니다.
 *  modelMapper는 org.modelmapper.ModelMapper 클래스의 인스턴스로, 엔티티 클래스와 DTO 클래스 간의 매핑을 담당합니다.
 *  이 로깅은 modelMapper 객체가 현재 메서드에서 사용되고 있음을 확인하는 데 도움이 됩니다.

 TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);: 이 줄은 modelMapper를 사용하여 TodoDTO 객체(todoDTO)를 TodoVO 객체(todoVO)로 매핑합니다.
 일반적으로 엔티티 클래스 (TodoVO)와 데이터 전송 객체(DTO - TodoDTO) 간의 필드를 복사하고 변환하는 역할을 합니다. 이로써 데이터를 엔티티 객체 형식으로 변환하고,
 이 엔티티 객체를 데이터베이스에 저장할 수 있게 됩니다.

 log.info(todoVO);: 이 부분은 todoVO를 로깅하여 TodoVO 객체가 어떻게 변환되었는지 확인합니다.
 로깅을 통해 todoVO 객체의 상태 및 데이터를 확인할 수 있습니다.

 todoMapper.insert(todoVO);: 이 부분은 TodoVO 객체를 데이터베이스에 삽입하는 작업을 수행합니다.
 todoMapper는 데이터베이스와 상호 작용하는 객체로, insert 메서드를 통해 todoVO를 데이터베이스에 추가합니다.
 따라서 todoDTO를 받아서 이를 엔티티 형식인 todoVO로 변환한 후, 데이터베이스에 저장하는 역할을 합니다.

 결론적으로, register 메서드는 입력된 TodoDTO를 엔티티 형식인 TodoVO로 변환하고,
 이를 데이터베이스에 저장하여 새로운 To-Do 항목을 등록하는 역할을 합니다.
 로깅을 사용하여 매핑 및 데이터 상태를 확인하는 것이 유용합니다.*/