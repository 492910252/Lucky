package com.games.lucky;

import java.util.Scanner;

public class LuckyDemo {
	public static void main(String[] args) {
		LuckyDemo common = new LuckyDemo();
		int code = 0;
		String choice = null;
		while (true) {
			System.out.println("*****欢迎进入幸运大抽奖系统*****");
			System.out.println(" 1.注册");
			System.out.println(" 2.登陆");
			System.out.println(" 3.抽奖");
			System.out.println("*******************************");
			System.out.print(" 请选择菜单: ");
			Scanner input = new Scanner(System.in);
			code = input.nextInt();
			switch (code) {
			case 1:
				System.out.println("幸运大抽奖系统>> 注册");
				common.regDemo();
				break;
			case 2:
				System.out.println("幸运大抽奖系统>> 登陆");
				common.loginDemo();
				break;
			case 3:
				System.out.println("幸运大抽奖系统>> 抽奖");
				common.luckyDemo();
				break;
			default:
				System.out.println("您的输入有误！");
				break;
			}
			System.out.println("继续吗？(y/n): ");
			choice = input.next();

			if ("n".equals(choice)) {
				System.out.println("系统退出，谢谢使用");
				break;
			}
		}
	}

	int[] vipNum = new int[3];
	int index = 0;
	String[] name = new String[3];
	String[] passWord = new String[3];
	// 注册

	public void regDemo() {
		for (int i = 0; i < vipNum.length; i++) {
			if (name[i] == null) {
				index = i;
			}
		}
		System.out.println("请填写个人注册信息: ");
		Scanner input = new Scanner(System.in);
		System.out.println("用户名： ");
		name[index] = input.next();
		System.out.println("密码： ");
		passWord[index] = input.next();
		vipNum[index] = (int) (Math.random() * 10);
		System.out.println("注册成功，请记好您的会员卡号");
		System.out.println("\r用户名：" + name[index] + "\t密码：" + passWord[index] + "" + "会员卡号：" + vipNum[index]);
	}

	String nameLog = null;
	String passWordLog = null;

	// 登陆
	public void loginDemo() {
		Scanner input = new Scanner(System.in);
		System.out.println("用户名： ");
		nameLog = input.next();
		System.out.println("密码： ");
		passWordLog = input.next();
		if (name[index].equals(nameLog) && passWord[index].equals(passWordLog)) {
			System.out.println("登陆成功！");
		} else {
			System.out.println("登陆失败！");
		}

	}

	// 抽奖
	int[] vipNums = new int[5];

	public void luckyDemo() {
		// 生成随机数组
		for (int i = 0; i < vipNums.length; i++) {
			vipNums[i] = (int) (Math.random() * 10);
			for (int j = 0; j < i; j++) {
				if (vipNums[i] == vipNums[j]) {
					vipNums[i] = (int) (Math.random() * 10);
					j = -1;
				}
			}
		}
		System.out.println("您的卡号为：" + vipNum[index]);
		// 打印数组
		System.out.println("幸运卡号为：");
		for (int k = 0; k < vipNums.length; k++) {
			System.out.print(vipNums[k] + " ");
		}
		// 判断是否中奖
		boolean flag = false;
		for (int k = 0; k < vipNums.length; k++) {
			if (vipNums[k] == vipNum[index]) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("恭喜！");
		} else {
			System.out.println("抱歉！");
		}
	}
}