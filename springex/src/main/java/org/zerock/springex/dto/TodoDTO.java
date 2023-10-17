package org.zerock.springex.dto;


import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString    //
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {


    private Long tno;
    @NotEmpty
    private String title;
    @Future
    private LocalDate dueDate;

    private  boolean finished;

    @NotEmpty
    private  String  writer; //새로추가됨


/**
 *@ToString: Lombok 어노테이션 중 하나로, 이 어노테이션을 사용하면 클래스의 toString() 메서드를 자동으로 생성해 줍니다
 *  toString() 메서드는 객체를 문자열로 표현할 때 사용되며, 주로 디버깅 목적으로 사용됩니다.
 * @ToString를 사용하면 객체의 필드 값을 쉽게 확인할 수 있습니다.
 * 
 *
 *
 * */
}
