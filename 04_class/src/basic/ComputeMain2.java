package basic;

public class ComputeMain2 {

	public static void main(String[] args) {
		Compute[] ar = new Compute[3]; //��ü �迭 ����
		for(int i=0; i<ar.length; i++) {
			ar[i] = new Compute(); //Ŭ���� ����
		}//for
					
		ar[0].setX(320);
		ar[0].setY(258);
		
		ar[1].setX(236);
		ar[1].setY(125);
		
		ar[2].setX(539);
		ar[2].setY(327);
		
		System.out.println("X\tY\tSum\tSub\tMul\tDiv");
		for(int i=0; i<ar.length; i++) {
			ar[i].calc();
		      
		    System.out.println(ar[i].getX() + "\t"
		                   + ar[i].getY() + "\t"
		                   + ar[i].getSum() + "\t"
		                   + ar[i].getSub() + "\t"
		                   + ar[i].getMul() + "\t"
		                   + String.format("%.2f", ar[i].getDiv()));
		}//for
	}
}

//Ŭ������ ���� ������ �׻� 1�� �������� ��ƾ� �Ѵ� (1�κ�)

/*
[������]
X	Y	Sum	Sub	Mul	Div
320	258	578	62	82560	1.24
236	125	361	111	29500	1.89
539	327	866	212	176253	1.65
*/