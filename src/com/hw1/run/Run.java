package com.hw1.run;

import com.hw1.model.vo.Employee;

public class Run {
	
	public static void main(String[] args) {
//		Employee emp = new Employee();
		
		// 객체 배열을 크기 3으로 할당한 뒤 3개의 생성자를 각각 이용하여 객체 생성 후 출력
		
		int total = 0;
		
		Employee[] arr =  {new Employee(), 
				new Employee(1, "홍길동",19,'M',"01022223333","서울 잠실"), 
				new Employee(2,"강말순","교육부","강사",20,'F',1000000,0.01,"01011112222","서울 마곡")};
	
		
		for ( int i = 0; i< arr.length; i++) {
			
			System.out.printf("emp[%d] : %d, %s, %s, %s, %d, %s, %d, %.2f, %s, %s\n",i, arr[i].getEmpNo(), arr[i].getEmpName(),
					arr[i].getDept(),arr[i].getJob(),arr[i].getAge(),arr[i].getGender(),
					arr[i].getSalary(),arr[i].getBonusPoint(),arr[i].getPhone(),arr[i].getAddress());
		}
		
		System.out.println("=".repeat(80));
		
		// 3개의 객체 중 값이 없는 필드에 각각 값을 넣은 뒤 출력
		arr[0].setEmpName("김말똥");
		arr[0].setDept("영업부");
		arr[0].setJob("팀장");
		arr[0].setAge(30);
		arr[0].setGender('M');
		arr[0].setSalary(3000000);
		arr[0].setBonusPoint(0.2);
		arr[0].setPhone("01055559999");
		arr[0].setAddress("전라도 광주");

		arr[1].setDept("기획부");
		arr[1].setJob("부장");
		arr[1].setSalary(4000000);
		arr[1].setBonusPoint(0.3);

		for ( int i = 0; i< arr.length-1; i++) {
			
			System.out.printf("emp[%d] : %d, %s, %s, %s, %d, %s, %d, %.1f, %s, %s\n",i, arr[i].getEmpNo(), arr[i].getEmpName(),
					arr[i].getDept(),arr[i].getJob(),arr[i].getAge(),arr[i].getGender(),
					arr[i].getSalary(),arr[i].getBonusPoint(),arr[i].getPhone(),arr[i].getAddress());
		}
		
		System.out.println("=".repeat(80));
		
		for( int a = 0; a < arr.length; a++) {
			
			int year = (int) (arr[a].getSalary() + (arr[a].getSalary() * arr[a].getBonusPoint()))*12;
			
			System.out.printf("%s의 연봉 : %d원\n",arr[a].getEmpName(),year);
			
			total += year;
		}
		
		System.out.println("=".repeat(80));
		System.out.printf("직원들의 연봉의 평균 : %d원\n", total/3);
		
	}
	
	

	

}
