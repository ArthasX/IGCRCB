package com.deliverik.plugin.change.socket;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Clent {

	public static void main(String[] args) throws Exception{
		//ʵ�����ͻ��˶���
		Socket socket = new Socket();
		//����server
		socket.connect(new InetSocketAddress("192.168.1.42",8976));
		//ʵ���������
		BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
		
		
		File file = new File("d:\\�Ӱ�����뵥_��ǿ_20150718-20150724.xls");
		
		
		StringBuffer bf = new StringBuffer();
		
		bf.append("���¹�(#)");              //pruserId    ������ID-
		bf.append("���й����(#)");                //prroleid    �����˽�ɫid-
		bf.append("��˧������2(#)");       //changeName  �������
		bf.append("����(#)");                  //changeDescription �������
		bf.append("2015/07/02(#)");           //beginTime   ��ʼʱ��-
		bf.append("2015/07/10(#)");           //endtime     ����ʱ��-
		bf.append("110001001_tree_ϵͳ������-������/С�ͻ�(#)");  //changeType   ������� 
		bf.append("������(#)");                 //changeCategory ������
		bf.append("�������(#)");               //changeClassify �������
		bf.append("abs#����afe#����afe(#)");                 //updatePlatform  ����ƽ̨
		bf.append("���ԭ�����(#)");            //changeReasonClassify  ���ԭ�����
		bf.append("���ԭ��(#)");              //changeReason ���ԭ��
		bf.append("�������(#)");              //changeContent �������
		bf.append("01830(#)");              //prjid         �����Ŀ���-
		bf.append("�����Ŀ����(#)");           //prjtitle      �����Ŀ����-
		bf.append("Ӱ��ҵ��(#)");             //isBusiness     Ӱ��ҵ��
		bf.append("ҵ��Ӱ�췶Χ(#)");          //businessScope  ҵ��Ӱ�췶Χ      
		bf.append("2015/06/06(#)");         //businessTime  �ƻ�Ӱ��ҵ��ʱ��(����) 
		bf.append("ִ�мƻ�(#)");             //deliveryProgram ִ�мƻ�
		bf.append("���˼ƻ�(#)");             //rollbackProgram ���˼ƻ�
		bf.append("��֤�ƻ�(#)");             //verificationProgram ��֤�ƻ�
		bf.append("1001(#)");    
		bf.append("sdff(#)");             //relatedPrid ��س��򿪷�����
		bf.append(file.getName()+"(#)");
		String context = bf.toString();
		
		int iaaa = context.getBytes().length;
			
		out.write((iaaa+"").getBytes().length);
		out.write((iaaa+"").getBytes());
		out.write(context.getBytes("GBK"));
		FileInputStream fis = new FileInputStream(file);
		int actual = 0;
		byte[] b = new byte[1024];
		
		while ((actual = fis.read(b)) > 0) {
			out.write(b,0,actual);
			
		}
		out.flush();			
		
		out.close();
		socket.close();
	}
}
