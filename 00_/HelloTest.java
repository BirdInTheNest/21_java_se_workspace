class HelloTest {
	public static void main(String[] args) {
		System.out.print("안녕하세요\n"); //\n은 다음줄로 내려가라는 뜻 (new line)
		System.out.println("반갑습니다"); //println도 같은 결과를 가짐 (ln)
		System.out.println("사과\t딸기\t수박"); //\t은 탭만큼의 공백을 띄우라는 뜻 (tab)
		System.out.println(); //한줄 띄기
		System.out.println(25+36); //61 (일반적인 숫자 계산)
		System.out.println("25+36"); //25+36 ("문자열")
		System.out.println("25"+"36"); //2536 ("문자열"+"문자열" -> +는 결합을 의미)
		System.out.println("25+36="+25); //25+36=25
		System.out.println("25+36="+25+36); //25+36=2536
											//(연산자 우선순위때문에 "25+36=25"+36 -> "25+36=2536")
		System.out.println("25+36="+(25+36)); //25+36=61
	}
}

//은 주석, 나만 보고 컴퓨터가 컴파일할 수 없도록 명령한 것


/*
[실행결과]
D:\java_se\workspace\0721>javac HelloTest.java

D:\java_se\workspace\0721>java HelloTest
안녕하세요
반갑습니다
사과    딸기    수박

61
25+36
2536
25+36=25
25+36=2536
25+36=61
*/