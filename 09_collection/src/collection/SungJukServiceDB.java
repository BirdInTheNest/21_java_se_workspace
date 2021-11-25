package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SungJukServiceDB {
	Scanner scan = new Scanner(System.in);
	private List<SungJukDTO> list;
	
	public SungJukServiceDB() { //������
		list = new ArrayList<SungJukDTO>(); //�θ� = �ڽ�
	}
	
	public void menu() {
	      int num;
	      while(true) {
	         System.out.println();
	         System.out.println("****************");
	         System.out.println("   1. �Է�");
	         System.out.println("   2. ���");
	         System.out.println("   3. �˻�");
	         System.out.println("   4. ����");
	         System.out.println("   5. ����");
	         System.out.println("   6. ��");
	         System.out.println("****************");
	         System.out.print(" ��ȣ : ");
	         num = scan.nextInt();
	           
	         if(num==6) break;
	         if(num==1) insertArticle();
	         else if(num==2) printArticle();
	         else if(num==3) searchArticle(); //��ȣ �˻�
	         else if(num==4) deleteArticle(); //��ȣ �˻� �� sql - delete
	         else if(num==5) sortArticle(); //sql
	         else System.out.println("1~6�߿� �����ϼ���");
	      }//while
	   }//menu()
	
	private void insertArticle() { //�Է�
		//������
		System.out.println();
		System.out.print("��ȣ �Է� :");
		int no = scan.nextInt();
		System.out.print("�̸� �Է� :");
		String name = scan.next();
		System.out.print("���� �Է� :");
		int kor = scan.nextInt();
		System.out.print("���� �Է� :");
		int eng = scan.nextInt();
		System.out.print("���� �Է� :");
		int math = scan.nextInt();
		
		//�����Ͱ��� �������ϱ� dto�� �����ϸ鼭 �����͸� dto�� ������ �Ǵ� setter�� ��������
		SungJukDTO dto = new SungJukDTO();
		dto.setNo(no);
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMath(math);
		
		dto.calc(); //����, ��� ���
		
		//DB
		SungJukDAO dao = new SungJukDAO();
		dao.insertArticle(dto); //dto�� DB�� insertArticle()�� ����
		
		System.out.println("��� �Ϸ�");
		
	}//insertArticle()
	
	private void printArticle() { //���
		//DB���� select���� rs�� ����, rs�� �ִ� ���� ������ dto�� ����, dto�� ������ Ÿ������ �ϴ� list�� ����
		SungJukDAO dao = new SungJukDAO();
		List<SungJukDTO> list = dao.printArticle(); 
		
		System.out.println();
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(SungJukDTO dto : list) {
			System.out.println(dto);
		}
	}//printArticle()
	
	private void searchArticle() { //�˻�
		System.out.println();
		System.out.print("�˻� �� ��ȣ �Է� : ");
		int no = scan.nextInt(); //�˻��� ��ȣ�� �Է¹޾Ƽ�
		
		//DB
		SungJukDAO dao = new SungJukDAO();
		SungJukDTO dto = dao.searchArticle(no); //�� ���� DB�� searchArticle�� �����ϰ� ���ϰ� dto�� ����
		
		//printArticle�� rs�� ���� select ������� �������̱� ������ 1�κо� dto�� ��� list�� �־ ����������
		//searchArticle�� select ������� �� ���̱� ������ 1�κ��� dto�� ��Ƽ� �������� �ȴ�
			
		if(dto==null) { 
			System.out.println("ã���� �ϴ� ��ȣ�� �����ϴ�.");
		}else {
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
			System.out.println(dto);			
		}
		
	}//searchArticle()
	
	private void deleteArticle() { //����
		System.out.println();
		System.out.print("���� �� ��ȣ �Է� : ");
		int no = scan.nextInt(); //������ ��ȣ�� �Է¹޾Ƽ�
		
		//DB
		SungJukDAO dao = new SungJukDAO();
		int su = dao.deleteArticle(no); //�� ���� DB�� deleteArticle�� �����ϰ� ���ϰ� su�� ����
		
		if(su==0)
			System.out.println("ã���� �ϴ� ��ȣ�� �����ϴ�.");
		else
			System.out.println("���� �Ϸ�");
		
	}//deleteArticle()

	private void sortArticle() { //����
		System.out.println();
		int num;
		
		//DB
		SungJukDAO dao = new SungJukDAO();
		
		while(true) {
			System.out.println();
			System.out.println("*****************");
			System.out.println("	1. �̸����� ��������");
			System.out.println("	2. �������� ��������");
			System.out.println("	3. �����޴�");
			System.out.println("*****************");
			System.out.print("��ȣ");
			num = scan.nextInt(); //��ȣ�� �Է��ϰ� 
			if(num==3) break;

			List<SungJukDTO> list = dao.sortArticle(num); //�� ���� DB�� sortArticle�� ����
			//sort�ϸ� rs�� ���� select ������� �������̱� ������, 1�κо� dto�� ��� list�� �־ �����´�.

			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
			for(SungJukDTO dto : list) {
				System.out.println(dto);
			}
		}//while	
	}//sortArticle()
}