package SoftTest07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class COVID_19 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			// ֢״�ɼ�
			System.out.println("�Ƿ��������֢״����ѡ������-1����\n"
					+ "\t1.����\n"
					+ "\t2.�ʺ�ʹ\n"
					+ "\t3.����\n"
					+ "\t4.����\n"
					+ "\t5.������\n"
					+ "\t6.����\n"
					+ "\t7.����\n"
					+ "\t8.��������\n"
					+ "\t9.ȫ����ʹ\n"
					+ "\t10.����\n"
					+ "\t11.��к\n"
					+ "\t12.��û��\n");
			List<Integer> list1 = new ArrayList<Integer>();
			int temp1 = 0;
			while(true) {
				temp1 = scanner.nextInt();
				if(temp1 != -1) {
					list1.add(temp1);
				} else {
					break;
				}
			}
			
			// ֢״����ɼ�
			int arr[][] = new int[10][6];
			for (int i = 0; i < list1.size(); i++) {
				if(list1.get(i) == 1) {
					System.out.println("Ŀǰ�����Ƕ��٣�\n"
							+ "\t1.С��37.3��\n"
							+ "\t2.���ڵ���37.3��\n");
					arr[1][1] = scanner.nextInt();
					System.out.println("��������Ƕ��٣�\n");
					arr[1][2] = scanner.nextInt();
					System.out.println("����ʱ��û�����������\n"
							+ "\t1.�������³�������\n"
							+ "\t2.����һֱ����38��\n"
							+ "\t3.��û��\n");
					arr[1][3] = scanner.nextInt();
					System.out.println("���Ⱥ���û�г�����ҩ��\n"
							+ "\t1.��\n"
							+ "\t2.û��\n");
					arr[1][4] = scanner.nextInt();
					System.out.println("������ҩ�����������ǣ�\n"
							+ "\t1.�����½�������\n"
							+ "\t2.����û���½�\n");
					arr[1][5] = scanner.nextInt();
				} else if (list1.get(i) == 3) {
					System.out.println("��û�п��ԣ�\n"
							+ "\t1.û�п��ԣ��ɿȣ�\n"
							+ "\t2.�п���\n");
					arr[2][1] = scanner.nextInt();
				} else if (list1.get(i) == 6) {
					System.out.println("��û�����Ƽ��أ�\n"
							+ "\t1.��\n"
							+ "\t2.û��\n");
					arr[3][1] = scanner.nextInt();
				} else if (list1.get(i) == 7) {
					System.out.println("��û���������أ�\n"
							+ "\t1.��\n"
							+ "\t2.û��\n");
					arr[4][1] = scanner.nextInt();
				} else if (list1.get(i) == 11) {
					System.out.println("��û�и�к���أ�\n"
							+ "\t1.��\n"
							+ "\t2.û��\n");
					arr[5][1] = scanner.nextInt();
				}
			}

			// ֢״ʱ��
			System.out.println("���β�����ж���ˣ�\n"
					+ "\t1.14������\n"
					+ "\t2.14������\n");
			arr[6][1] = scanner.nextInt();
			
			// �Ӵ�ʷѯ��
			System.out.println("��14����û�������������ѡ������-1����");
			System.out.println("\t1.���人������������������ʷ���סʷ");
			System.out.println("\t2.�нӴ����人������������������Ա");
			System.out.println("\t3.�нӴ������ƻ�ȷ�����͹�״������Ⱦ��");
			System.out.println("\t4.����ж��˳��ַ��ȡ����������ԡ���ʹ�ȣ�");
			System.out.println("\t5.��û��");
			List<Integer> list2 = new ArrayList<Integer>();
			int temp2 = 0;
			while(true) {
				temp2 = scanner.nextInt();
				if(temp2 != -1) {
					list2.add(temp2);
				} else {
					break;
				}
			}
			
			// �ж��߼�
			int result = 0;
			if(list1.get(0)==1 || list1.get(0)==2 || list1.get(0)==3 || list1.get(0)==4 || list1.get(0)==5 || list1.get(0)==6 || list1.get(0)==7 || list1.get(0)==8 || list1.get(0)==9 || list1.get(0)==10 || list1.get(0)==11) {
				if(list2.get(0)==1 || list2.get(0)==2 || list2.get(0)==3 || list2.get(0)==4) {
					result = 1;
				}
				if(list2.get(0)==5) {
					result = 2;
				}
			} else if(list1.get(0)==12) {
				if(list2.get(0)==1 || list2.get(0)==2 || list2.get(0)==3 || list2.get(0)==4) {
					result = 3;
				}
				if(list2.get(0)==5) {
					result = 4;
				}
			}
			
			// �����Ƽ����б�
			switch (result) {
			case 1:
				System.out.println("�������̷���������������ÿ������÷��������ҽ����ƿ��ֻ�N95���֣��������������ͨ���ߡ�");
				break;
			case 2:
				System.out.println("������ṩ�Ĳ���֢״���Ӵ�ʷ�ص㣬��������ڼҼ�����£����ʵ��������Ƹ�ð���г�ҩ��ע��������������ˮ����ϢΪ���������³������˻����´���38�����֢״���أ���ʱ���");
				break;
			case 3:
				System.out.println("��������ȫ�Ҽ����нӴ��߾ӼҸ�������2�ܣ��ڼ��ڼ佨������ֽ�������������ʱ������������ס���ס��ͨ�����õĵ��˷��䡣����Ϣ������ˮ��ע���������ͳ�����Ʒ���������������ַ��ȼ�������֢״��������ǰ��ҽԺ���");
				break;
			case 4:
				System.out.println("�����������֡���ϴ�֣�������Ⱥ�ۼ������ٲ���Ҫ�����");
				break;
			default:
				break;
			}
		}
		
	}
}
