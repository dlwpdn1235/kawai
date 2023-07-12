package com.kawai.dto;

import lombok.Data;

@Data
public class CommDtoPage {
	//1. 전체글
	private int listtotal;
	//2. 한페이지에 보여줄 게시물의 수 10
	private int onepagelist;
	//3. 총페이지 계산 *** / 10 => 소수점올리기
	private int pagetotal;
	//4. 하단에 페이지 나누기 수 = > 10개씩
	private int bottomlist;
	//5. 페이지에 스타트 번호
	private int pstartno;
	//6. 하단 현재번호
	private int current;
	//7. 하단 시작
	private int start;
	//8. 하단 끝
	private int end;
	public CommDtoPage(int pstartno, int listtotal) {
		super();
		this.listtotal = listtotal;
		this.onepagelist = 10;
		this.pagetotal = (int)Math.ceil((double)listtotal/onepagelist);
		this.bottomlist = 10;
		this.pstartno = pstartno;
		this.current = (int)Math.ceil((pstartno + 1)/(double)onepagelist);
		this.start = ((int)Math.floor((current-1)/bottomlist))*bottomlist+1;
		this.end = start + bottomlist -1;
		if(pagetotal < end) {end=pagetotal;}
	}
}
