package com.hw3.run;

import com.hw3.controller.ProductController;

//제품 관리 프로그램으로 제품들을 추가하고 조회하는 프로그램이다. 해당 구현 클래스 다이어그램과 클래스
//구조를 참고하여 프로젝트를 완성하시오. (완성 후 본인들이 원하는 메소드들을 추가적으로 구현해보시오)


public class Run {

	public static void main(String[] args) {
		
		ProductController pc = new ProductController();
		
		pc.mainMenu();
		
		
	}
	

}
