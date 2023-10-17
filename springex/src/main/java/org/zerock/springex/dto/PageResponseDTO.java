package org.zerock.springex.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;


@Getter
@ToString

public class PageResponseDTO<E> {

    private int page;
    private int size;
    private  int total;

    //시작페이지 번호
    private  int start;

    //끝페이지 번호

    private  int end;


    //이전페이지의 존재여부

    private boolean prev;
    //다음페이지의 존재여부

    private  boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total =total;
        this.dtoList =dtoList;

        //마지막 페이지
        this.end =(int)(Math.ceil(this.page/ 10.0)) * 10;
        //시작페이지 번호 계산
        this.start = this.end -9;


        int last =   (int)(Math.ceil((total/(double)size)));

        this.end =end > last ? last : end;
        //이전
        this.prev = this.start >1;
        //다음 페이지
        this.next = total > this.end * this.size;
    }
}
//  마지막페이지 시작페이지의 번호 계산
/**  마지막 페이지를 구하는 계산을 먼저하는것이  더편하다
 *   end는 현재의 페이지 번호를 기준으로 계산한다 .
 *
 *   마지막 페이지를 먼저 계산하는  이유는 시작페이지의 계산을 쉽게 하기 위함
 *
 *   시작페이지의 경우 계산한 마지막 페이지에서 9를 빼면되기때문이다 .
 *
 *
 *   시작페이지의 구성은 끝났지만 마지막 페이지의 경우 다사 전체개수를 고려해야한다.
 *   만일 10개씩 보여주는 경우 전체개수 가 75 라면 마지막 페이지는 10이 아닌 8이 되어해서이다.
 *
 *   마지막페이지는 앞에서 구한 last 값보다 작은경우에 last값이 end가 되어야한다.
 *   */

//이전 / 다음 계산
//이전 페이지의 존재여부는 시작페이지가 1이 아니라면 무조건 true가 되어야한다 다음은 마지막페이지와 페이지당 개수를 곱한값보다
// 전체개수가 더많은지 보고판단해야함