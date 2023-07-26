package edu.kh.oarr.model.service;

import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;
import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {

	Scanner sc = new Scanner(System.in);

	// Member 5칸짜리 객체 배열 선언 및 할당
	private Member[] memberArr = new Member[5];

	public MemberService() { // 기본 생성자

		// memberArr 배열 0,1,2 인덱스 초기화 ( 미리 3명의 객체 만들어놓음 )
		memberArr[0] = new Member("user01", "pass01", "홍길동", 30, "서울");
		memberArr[1] = new Member("user02", "pass02", "자두", 40, "서울");
		memberArr[2] = new Member("user03", "pass03", "마이콜", 50, "경기");

	}

	private Member loginMember = null;

	public void displayMenu() {
		// 반환형 :: void는 반환할 값이 없을 때 사용!
		// 여기서는 출력만 할 것이므로 반환할 값 없음.

		int menuNum = 0; // 메뉴 선택용 변수

		// 무조건 한번은 출력
		do {

			System.out.println("===== 회원 정보 관리 프로그램 v2 =====");
			System.out.println("1. 회원가입 ");
			System.out.println("2. 로그인 ");
			System.out.println("3. 회원 정보 조회 ");
			System.out.println("4. 회원 정보 수정 ");
			System.out.println("5. 회원 검색 (지역) ");
			System.out.println("0. 프로그램 종료 ");

			System.out.print("메뉴 입력 :");
			menuNum = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남은 개행문자 제거용!!!!!!!!

			switch (menuNum) {

			case 1:
				System.out.println(signUp()); // print 구문안에 넣어야 문자열을 콘솔에 출력할 수 있음.
//				signUp();
				break;
			case 2:
				System.out.println(login());
				break;
			case 3:
				System.out.println(selectMember());
				break;
			case 4:

				int result = updateMember();

				if (result == -1) {
					System.out.println("로그인 후 이용해주세요!");
				} else if (result == 0) {

					System.out.println("회원 정보 수정 실패 ( 비밀번호 불일치 )");
				} else { // result == 1

					System.out.println("회원 정보가 수정되었습니다.");
				}
				break;
			case 5:
				System.out.println(search());
			case 0:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요\n");
				break;
			}

		} while (menuNum != 0); // menuNum 0이면 반복 종료

	}

	// memberArr의 비어있는 인덱스 번호 반환하는 메서드
	// 단, 비어있는 인덱스가 없다면 -1 반환
	public int emptyIndex() { // 회원가입을 만들 수 있는지 유무를 판단하는 메서드

		for (int i = 0; i < memberArr.length; i++) {

			if (memberArr[i] == null) {
				return i;// 현재 메서드를 종료하고 호출한곳으로
							// 해당되는 인덱스 번호(i) 가져가기
			}
		}

		// for문을 수행했지만, return이 되지 않은 경우
		// 해당 위치 코드 수행된다!
		// -> for문에서 return되지 않음 == 배열에 빈칸이 없다.
		return -1;
	}

	// 1) 회원가입 메서드
	public String signUp() {


		System.out.println("\n=======회원가입=======");

		// 객체배열 memberArr에 가입한 회원정보를 저장할 예정
		// -> 새로운 회원 정보를 저장할 공간이 있는지 확인
		// 빈 공간의 인덱스 번호를 얻어오기 --> 새로운 메서드 작성

		int index = emptyIndex(); // memberArr배열에서 비어있는 인덱스 번호를 반환 받음. (index 변수에 저장)

		if (index == -1) {

			return "회원가입이 불가능합니다.(인원 수 초과)";
		}

		System.out.print("아이디 : ");
		String memberId = sc.next();

		System.out.print("비밀번호 :");
		String memberPw = sc.next();

		System.out.print("비밀번호 확인 : ");
		String memberPwCheck = sc.next();

		System.out.print("이름 : ");
		String memberName = sc.next();

		System.out.print("나이 :");
		int memberAge = sc.nextInt();

		System.out.print("지역 : ");
		String region = sc.next();

		if (memberPw.equals(memberPwCheck)) { // 일치하는 경우

			// Member객체 생성해서 할당된 주소를 memberArr의 비어있는 인덱스에 대입
			memberArr[index] = new Member(memberId, memberPw, memberName, memberAge, region);
			
			return "회원가입 성공!!\n";

		} else {

			return "회원 가입 실패!! (비밀번호 불일치)\n";
		}
	}

	/*
		memberArr[0] = new Member("user01", "pass01", "홍길동", 30, "서울");
		memberArr[1] = new Member("user02", "pass02", "자두", 40, "서울");
		memberArr[2] = new Member("user03", "pass03", "마이콜", 50, "경기");

	 */
	

	// 2) 로그인 메서드
	public String login() {
		
		// 객체 배열 5명 내가 가져온 값이랑 로그인 한 값이랑 일치하는 지 확인,
		
		System.out.println("\n********* 로그인 *********");
		
		if (memberArr[0] == null) {

			return " 회원 가입부터 진행 해주세요!\n";
		} else {
			
			System.out.print("아이디 입력 :");
			String memberId = sc.next();

			System.out.print("비밀번호 입력 :");
			String memberPw = sc.next();
			
			for(int i = 0; i < memberArr.length; i++){
				
				/*if (memberArr[i].getMemberId().equals(memberId) && memberArr[i].getMemberPw().equals(memberPw) ) {
					
					loginMember = memberArr[i]; 
					
					return loginMember.getMemberName() + "님, 환영합니다!\n";
				} */
				
				if(memberArr[i] == null) {
					continue;
				}else if (memberArr[i].getMemberId().equals(memberId) && memberArr[i].getMemberPw().equals(memberPw) ) {
					
					loginMember = memberArr[i]; 
					
					return loginMember.getMemberName() + "님, 환영합니다!\n";
				}
			}
			return "로그인 실패!\n아이디와 비밀번호 다시 확인해주세요.\n";
		}
			
	}

	// 3) 정보 조회 메서드
	public String selectMember() {
	
		System.out.println("\n***** 회원 정보 조회 ***** ");
		
		if(loginMember == null) {
			return "로그인 후 이용해주세요!";
		} 
		
		String str = "이름 : " + loginMember.getMemberName();
		str += "\n아이디 : " + loginMember.getMemberId();
		str += "\n나이 : " + loginMember.getMemberAge() +"세";

		return str;
	}

	// 4) 회원 정보 수정
	public int updateMember() {
		System.out.println("\n***** 회원 정보 수정 ***** ");
		
		
		// 1) 로그인 여부 판별
		// 로그인이 되어있지 않으면 -1 반환
		if(loginMember == null) {
		
			return -1;
		}
		
		System.out.print("수정할 이름 입력 : ");
		String inputName = sc.next();
		
		System.out.print("수정할 나이 입력 : ");
		int inputAge = sc.nextInt();

		
		// 2-2) 비밀번호를 입력받아서 로그인한 회원의 비밀번호와 일치하는지 확인
		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next();
		
		if(inputPw.equals(loginMember.getMemberPw())) {
			
			// -> 비밀번호가 같은 경우
			//      로그인한 회원의 이름, 나이 정보를 입력받은 값으로 변경 후 
			//     1반환 			
			
			loginMember.setMemberName(inputName);
			loginMember.setMemberAge(inputAge);
			
			return 1;
		}else { // 비밀번호가 다른 경우 0 반환
			return 0;
		}		
	}

	
	// 5) 회원 검색 ( 지역 ) 
	
	public String search() {
		
		System.out.print("찾을 지역 : ");
		String inputRegion = sc.next();
		
		
		String saveMember="";
		
		for( int i = 0; i< memberArr.length; i++) {
			
			if(memberArr[i] == null) {
			
				continue;
			
			}else if( memberArr[i].getRegion().equals(inputRegion)) {
				
				saveMember += ("'"+ memberArr[i].getMemberName()+"' ");

			}
		}
		
		if( saveMember.equals("")) {
			return "\n해당 지역과 관련된 회원은 없습니다.\n";
		}
		
		return "\n" + inputRegion + " 지역과 관련된 회원은 "+ saveMember + "입니다.\n";
	}
	
	
	
	
	
	
	
	
	
	
	
}
