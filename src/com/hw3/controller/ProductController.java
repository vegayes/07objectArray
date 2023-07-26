package com.hw3.controller;

import java.util.Scanner;

import com.hw3.model.vo.Product;

public class ProductController {
	
	private Product[] pro = null;
	
	public int count ; // 객체수의 카운트 
	
	Scanner sc = new Scanner(System.in);
	
		// 1) 초기화 블럭을 이용하여 10개의 Product 배열의 크기  ?????????????
	public ProductController() {
		pro = new Product[10];
	}
	
	
	
	public void mainMenu() {
		
		//do~while 문을 이용하여 반복적으로 메뉴화면 출력
		// 각 버튼 선택 시 각각의 메소드 호출
		
		int menu = 0;
		
		do {
			System.out.println("====제품 관리 메뉴 ====");
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴를 선택해 주세요! >> ");
			menu = sc.nextInt();
			
			switch(menu) {
			
			case 1:
				if( count > 9) {
					System.out.println("새로 추가할 제품의 공간이 없습니다.");
				}else {
					System.out.println(count);
					productInput();
				}
				break;
			case 2:
				productPrint();
				break;
			case 0:
				System.out.println("프로그램 종료");
				break;
			default :
				System.out.println("다른값을 넣어주세요!");
				break;
			}
		
			
			
		}while(menu != 0);
		
		
		
		
	}
	
	
	public void productInput() {
		
		//새로운 제품 정보 기록을 위해 키보드로 정보들을 입력 받아 객체를 생성하고 
		//현재 카운트 인덱스에 주소 저장
		
		System.out.print("새로 추가 할 제품의 ID :  ");
		int inputpId = sc.nextInt();
		
		System.out.print("새로 추가 할 제품의 이름 :  ");
		String inputpName = sc.next();
		
		System.out.print("새로 추가 할 제품의 가격 :  ");
		int inputPrice = sc.nextInt();
		
		System.out.print("새로 추가 할 제품의 세금 :  ");
		double inputTax = sc.nextDouble();
		
		/*for(int i = 0; i < pro.length; i++) {
			if(pro[i] == null) {
				
				pro[i] = new Product(inputpId, inputpName,inputPrice, inputTax);
				
				System.out.println(pro[i].getpId()+ pro[i].getpName()+pro[i].getPrice()+pro[i].getTax());
				
				count ++;
			}
		}*/
		
		if(pro[count] == null) {
			pro[count] = new Product(inputpId, inputpName,inputPrice, inputTax);
//			System.out.println(pro[count].getpId()+ pro[count].getpName()+pro[count].getPrice()+pro[count].getTax());
			count ++;
		}
		
		
		
	}
	
	
	public void productPrint() {
		
		
		//현재까지 기록된 도서 정보 모두 출력
		for(int i = 0; i < pro.length; i++) {
			
//			String str = "제품의 아이디 : " + String.valueOf(pro[i].getpId());
			if(pro[i] ==  null) {
			
				continue;
			}else {
			String str = "\n제품의 정보";
			str +=  (String.valueOf(pro[i].getpId())+" "+pro[i].getpName()+" "+String.valueOf(pro[i].getPrice())+" "+String.valueOf(pro[i].getTax())+" \n");
			
			System.out.println(str);
			}
			
		}
		
		
	}
	
	
	
	

}
