package com.deliverik.plugin.change.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.lang.StringUtils;




public class ServerTest {
	
	/** server�����˿� */
	private static int PORT = 8974;
	public static void main(String[] args) throws Exception {
		
		//ʵ����server����
		ServerSocket server = new ServerSocket(PORT);
		while (true) {
			//�ȴ��ͻ�������
			Socket accept = server.accept();
			
			
			BufferedInputStream in = new BufferedInputStream( accept.getInputStream());
			
			
			/** �ϴ��ļ����� */
			int contents = 0;
			
			
			byte[] newSize = new byte[1];
			 in.read(newSize);
			 int aaqw = newSize[0];
			 			 
			System.out.println(aaqw);
			
			byte[] isize = new byte[aaqw];
			in.read(isize);
			String assString = new String(isize,0,aaqw);
			if(StringUtils.isEmpty(assString.trim())){
				System.out.println("���ĳ���Ϊ��");
				break;
			}
			System.out.println(assString);
			
			byte[] info = new byte[Integer.parseInt(assString.trim())];
			in.read(info);
			String file_name = new String(info).trim();
			
			String[] acceptMsg = file_name.split("\\(\\#\\)");
			
			for(int y=0;y<acceptMsg.length;y++){
				System.out.println(acceptMsg[y]);
			}
			
			System.out.println(file_name);
			
			if(acceptMsg.length>23 ){
			
			
			/** �ϴ��ļ�������ȡ�� */
			FileOutputStream out = new FileOutputStream("e:\\"+acceptMsg[23]);
			
			/** �ϴ��ļ�����������ȡ�� */
			BufferedOutputStream outBuffer = new BufferedOutputStream(out);
			
		
			
			byte[] b = new byte[8096];
			
			while ((contents = in.read(b)) !=- 1) {
				outBuffer.write(b,0,contents);
				
			}
			out.flush();
			outBuffer.flush();
			
			//�ļ����ر�
			outBuffer.close();
			out.close();
			}else {
				System.out.println("û�и���");
			}
			in.close();

		}
	}
}

