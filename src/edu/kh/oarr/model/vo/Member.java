package edu.kh.oarr.model.vo;

public class Member {
	
	// 필드 ( == 멤버 변수)
 	private String memberId;
 	private String memberPw;
 	private String memberName;
 	private int memberAge;
 	private String region; // 지역
	
	
	// 생성자 :: 기본 , 매개변수
 	// 생성자 만드는 규칙
 	// 1. 생성자 이름은 클래스명과 같다
 	// 2. 반환형이 없는 메서드 
 	// ** 기본 생성자는 컴파일러가 자동으로 생성해주는데, 
 	// 생성자가 하나라도 있으면, 자동생성 안해줌. 
 	// --> 기본생성자 직접 작성해야 함! 
 	
	public Member() { // 기본 생성자
		
		
	}
	
	// 💥 오버로딩
	// 매개변수의 타입, 순서, 갯수가 달라야함
	
	public Member(String memberId, String memberPw, String memberName, int memberAge, String region) {
		// 매개변수 생성자
		
		this.memberId = memberId; // this 참조변수
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;	
	}
	
	// 메서드 
	// getter / setter (필드에 간접 접근 방법) 
	// 다 접근 가능하도록 public / String (반환형 자료형)  / 
	public String getMemberId() { 
		return memberId; // memberId가 String자료형이니까~~~
					     // Q1) this를 안쓰는 이유
						 // A1) 매개변수가 없어서 중복된 이름의mebmerId가 없기 때문에
						 // 	memberId라고만 써도 가능! 
	}

	public void setMemberId(String memberId) {
		// setter : 세팅하는 애, 무엇을 세팅할지 전달받아온 아이가 매개변수다. 
		// setting만 하고 반환하는것이 없으므로 void 사용. ( return은 있지만, 생략 ) 
		this.memberId = memberId;
		
		// 원래 모든 메서드는 종료 시, 호출한 곳으로 돌아가는 
		// return구문이 작성되어야 하지만, 
		// 단, void일 경우 생략가능
		// --> 생략 시, 컴파일러가 자동 추가해준다.
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
	
	
	
	
	
	
	

}
