package org.zerock.springex.domain;


import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder


/**
 * @Getter  필드에대한 getter 메서드를 자동으로 생성
 * @ToString 이메서드는 객체의 문자열 표현을 반환하며 주로 디버깅 및 로깅목적으로 사용된다.
 * @AllargsConstructor 모든필드를 매개변수로 받는 생성자를 자동으로 생성 이를통해 객체를 초기화하는데 편하게 사용가능
 * @NoArgsConstructor 매개변수를 받지 않는 기본생성자를 자동으로 생성한다. 주로 프레임워크 및 라이브러리 통합을위해 사용
 * @Builder  빌더패션을 구현하는 메서드를 자동생성  빌더패턴을 사용하면 객체 생성시 다용한 옵션을 지정하기 용이하면 가독성 높아짐.
 * */
public class TodoVO {
    private  Long tno;
    private  String title;
    private LocalDate dueDate;
    private  String writer;
    private  boolean finished;

}
