package view;

import java.util.List;
import java.util.Scanner;

import controller.ZhangWuController;
import domain.ZhangWu;

public class MainView {

	private ZhangWuController controller = new ZhangWuController();

	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------�ܼ��ż�ͥ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				addZhangWu();
				break;
			case 2:
				editZhangWu();
				break;
			case 3:
				deleteZhangWu();
				break;
			case 4:
				selectZhangWu();
				break;
			case 5:
				System.exit(0);
				break;
			}

		}
			
	}
	
	
	public void deleteZhangWu(){
		selectAll();
		System.out.println("ѡ�����ɾ�����ܣ�������ID��");
		int zwid= new Scanner(System.in).nextInt();
		controller.deleteZhangWu(zwid);
		System.out.println("��ϲ�� ɾ���˻��ɹ�");
	}
	
	
	public void editZhangWu(){
		selectAll();
		System.out.println("ѡ����Ǳ༭���ܣ�����������");
		Scanner sc= new Scanner(System.in);
		System.out.println("����ID:");
		int zwid= sc.nextInt();
		System.out .println("�����������:");
		String flname=sc.next();
		System.out.println("������:");
		double money =sc.nextDouble();
		System.out.println("�����˻�");
		String zhanghu =sc.next();
		System.out.println("�������ڣ���ʽXXXX-XX-XX");
		String createtime =sc.next();
		System.out.println("�����������");
		String description =sc.next();
		ZhangWu zw = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		controller.editZhangWu(zw);
		System.out.println("��ϲ�� ��ӱ༭�ɹ�");
	}
	
	public void addZhangWu(){
		System.out.println("ѡ������˻����ܣ���������������");
		Scanner sc= new Scanner(System.in);
		System.out .println("�����������");
		String flname=sc.next();
		System.out.println("������");
		double money =sc.nextDouble();
		System.out.println("�����˻�");
		String zhanghu =sc.next();
		System.out.println("�������ڣ���ʽXXXX-XX-XX");
		String createtime =sc.next();
		System.out.println("�����������");
		String description =sc.next();
		//�����ID�������װ����
		ZhangWu zw = new ZhangWu(0, flname, money, zhanghu, createtime, description);
		controller.addZhangWu(zw);
		System.out.println("��ϲ�� ����˻��ɹ�");
		
		
	}
	
	public void selectZhangWu(){
		System.out.println("1.��ѯ���� 2.������ѯ");
		Scanner sc= new Scanner(System.in);
		int selectChooser = sc.nextInt();
		
		switch(selectChooser){
		case 1:
			selectAll();
			break;
			
		case 2:
			select();
			break;
		}
	}
		
	public void selectAll(){
		List<ZhangWu> list = controller.selectAll();
		if(list.size()!=0)
		print(list);
		else
		System.out.println("û�в�ѯ������");
	}


	
	public void select(){
		System.out.println("ѡ��������ѯ���������ڸ�ʽXXXX-XX-XX");
		Scanner sc= new Scanner (System.in);
		System.out.println("�����뿪ʼ���ڣ�");
		String startDate = sc.nextLine();
		System.out.println("�����������ڣ�");
		String endDate = sc.nextLine();
		List<ZhangWu> list = controller.select(startDate, endDate);
		if(list.size()!=0)
		print(list);
		else
		System.out.println("û�в�ѯ������");
		
	}
	
	
	private void print(List<ZhangWu> list) {
		System.out.println("ID\t���\t�˻�\t���\tʱ��\t\t˵��");		
		for(ZhangWu zw:list){
			System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getZhanghu()+"\t"+zw.getMoney()+"\t"
					+zw.getCreatetime()+"\t"+zw.getDescription());
		}
	}
}
