class HelloTest {
	public static void main(String[] args) {
		System.out.print("�ȳ��ϼ���\n"); //\n�� �����ٷ� ��������� �� (new line)
		System.out.println("�ݰ����ϴ�"); //println�� ���� ����� ���� (ln)
		System.out.println("���\t����\t����"); //\t�� �Ǹ�ŭ�� ������ ����� �� (tab)
		System.out.println(); //���� ���
		System.out.println(25+36); //61 (�Ϲ����� ���� ���)
		System.out.println("25+36"); //25+36 ("���ڿ�")
		System.out.println("25"+"36"); //2536 ("���ڿ�"+"���ڿ�" -> +�� ������ �ǹ�)
		System.out.println("25+36="+25); //25+36=25
		System.out.println("25+36="+25+36); //25+36=2536
											//(������ �켱���������� "25+36=25"+36 -> "25+36=2536")
		System.out.println("25+36="+(25+36)); //25+36=61
	}
}

//�� �ּ�, ���� ���� ��ǻ�Ͱ� �������� �� ������ ������ ��


/*
[������]
D:\java_se\workspace\0721>javac HelloTest.java

D:\java_se\workspace\0721>java HelloTest
�ȳ��ϼ���
�ݰ����ϴ�
���    ����    ����

61
25+36
2536
25+36=25
25+36=2536
25+36=61
*/