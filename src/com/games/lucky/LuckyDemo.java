package com.games.lucky;

import java.util.Scanner;

public class LuckyDemo {
	public static void main(String[] args) {
		LuckyDemo common = new LuckyDemo();
		int code = 0;
		String choice = null;
		while (true) {
			System.out.println("*****��ӭ�������˴�齱ϵͳ*****");
			System.out.println(" 1.ע��");
			System.out.println(" 2.��½");
			System.out.println(" 3.�齱");
			System.out.println("*******************************");
			System.out.print(" ��ѡ��˵�: ");
			Scanner input = new Scanner(System.in);
			code = input.nextInt();
			switch (code) {
			case 1:
				System.out.println("���˴�齱ϵͳ>> ע��");
				common.regDemo();
				break;
			case 2:
				System.out.println("���˴�齱ϵͳ>> ��½");
				common.loginDemo();
				break;
			case 3:
				System.out.println("���˴�齱ϵͳ>> �齱");
				common.luckyDemo();
				break;
			default:
				System.out.println("������������");
				break;
			}
			System.out.println("������(y/n): ");
			choice = input.next();

			if ("n".equals(choice)) {
				System.out.println("ϵͳ�˳���ллʹ��");
				break;
			}
		}
	}

	int[] vipNum = new int[3];
	int index = 0;
	String[] name = new String[3];
	String[] passWord = new String[3];
	// ע��

	public void regDemo() {
		for (int i = 0; i < vipNum.length; i++) {
			if (name[i] == null) {
				index = i;
			}
		}
		System.out.println("����д����ע����Ϣ: ");
		Scanner input = new Scanner(System.in);
		System.out.println("�û����� ");
		name[index] = input.next();
		System.out.println("���룺 ");
		passWord[index] = input.next();
		vipNum[index] = (int) (Math.random() * 10);
		System.out.println("ע��ɹ�����Ǻ����Ļ�Ա����");
		System.out.println("\r�û�����" + name[index] + "\t���룺" + passWord[index] + "" + "��Ա���ţ�" + vipNum[index]);
	}

	String nameLog = null;
	String passWordLog = null;

	// ��½
	public void loginDemo() {
		Scanner input = new Scanner(System.in);
		System.out.println("�û����� ");
		nameLog = input.next();
		System.out.println("���룺 ");
		passWordLog = input.next();
		if (name[index].equals(nameLog) && passWord[index].equals(passWordLog)) {
			System.out.println("��½�ɹ���");
		} else {
			System.out.println("��½ʧ�ܣ�");
		}

	}

	// �齱
	int[] vipNums = new int[5];

	public void luckyDemo() {
		// �����������
		for (int i = 0; i < vipNums.length; i++) {
			vipNums[i] = (int) (Math.random() * 10);
			for (int j = 0; j < i; j++) {
				if (vipNums[i] == vipNums[j]) {
					vipNums[i] = (int) (Math.random() * 10);
					j = -1;
				}
			}
		}
		System.out.println("���Ŀ���Ϊ��" + vipNum[index]);
		// ��ӡ����
		System.out.println("���˿���Ϊ��");
		for (int k = 0; k < vipNums.length; k++) {
			System.out.print(vipNums[k] + " ");
		}
		// �ж��Ƿ��н�
		boolean flag = false;
		for (int k = 0; k < vipNums.length; k++) {
			if (vipNums[k] == vipNum[index]) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("��ϲ��");
		} else {
			System.out.println("��Ǹ��");
		}
	}
}