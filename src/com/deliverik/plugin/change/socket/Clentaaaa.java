package com.deliverik.plugin.change.socket;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Clentaaaa {

	public static void main(String[] args) throws Exception{
		//ʵ�����ͻ��˶���
		Socket socket = new Socket();
		//����server
		socket.connect(new InetSocketAddress("192.168.1.42",8976));
		//ʵ���������
		BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
		
		
//		File file = new File("d:\\�Ӱ�����뵥_��ǿ_20150718-20150724.xls");
		
		
		StringBuffer bf = new StringBuffer();
		
		bf.append("ʩ��(#)");              //pruserId    ������ID-
		bf.append("(#)");                //prroleid    �����˽�ɫid-
		bf.append("11111R00088�����Ż�(#)");       //changeName  �������
		bf.append("����(#)");                  //changeDescription �������
		bf.append("2015/10/29(#)");           //beginTime   ��ʼʱ��-
		bf.append("2015/10/29(#)");           //endtime     ����ʱ��-
		bf.append("110002001002001000_tree_Ӧ�ó�����-����ϵͳ��-����ϵͳ-���ʽ���ҵ��-���ʽ���ҵ��(#)");  //changeType   ������� 
		bf.append("������(#)");                 //changeCategory ������
		bf.append("��������(#)");               //changeClassify �������
		bf.append("����ϵͳ(#)");                 //updatePlatform  ����ƽ̨
		bf.append("��������(#)");            //changeReasonClassify  ���ԭ�����
		bf.append("(#)");              //changeReason ���ԭ��
		bf.append("(#)");              //changeContent �������
		bf.append("(#)");              //prjid         �����Ŀ���-
		bf.append("(#)");           //prjtitle      �����Ŀ����-
		bf.append("��(#)");             //isBusiness     Ӱ��ҵ��
		bf.append("��(#)");          //businessScope  ҵ��Ӱ�췶Χ      
		bf.append("0(#)");         //businessTime  �ƻ�Ӱ��ҵ��ʱ��(����) 
		bf.append("(#)");             //deliveryProgram ִ�мƻ�
		bf.append("(#)");             //rollbackProgram ���˼ƻ�
		bf.append("(#)");             //verificationProgram ��֤�ƻ�
		bf.append("f08e79f8-ca01-431a-b24f-76302c5aac16(#)");     			//tick
		bf.append("(#)");             //relatedPrid ��س��򿪷�����
		String context = bf.toString();
		byte[] bytes = context.getBytes();
		
		for(int i=0;i<bytes.length;i++){
			System.out.println(bytes[i]);
		}
		System.out.println(new String(bytes));
		System.out.println(context.getBytes());
		int iaaa = context.getBytes().length;
			
		System.out.println((iaaa+"").getBytes());
		out.write((iaaa+"").getBytes().length);
		out.write((iaaa+"").getBytes());
		out.write(context.getBytes());
		/**
		 * ��D���д���һ���ļ�������Ϊsocket,��Ҫ�ϴ����ļ������ļ����У����ļ����е��ļ�����ȫ���ϴ�
		 */
//		
//		FileInputStream fis = new FileInputStream(file);
//		int actual = 0;
//		byte[] b = new byte[1024];
//		
//		while ((actual = fis.read(b)) > 0) {
//			out.write(b,0,actual);
//			
//		}
		out.flush();			
		
		out.close();
		socket.close();
	}
}
