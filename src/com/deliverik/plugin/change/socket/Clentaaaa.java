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
		//实例化客户端对象
		Socket socket = new Socket();
		//连接server
		socket.connect(new InetSocketAddress("192.168.0.52",8976));
		//实例化输出流
		BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
		
		
//		File file = new File("d:\\加班费申请单_张强_20150718-20150724.xls");
		
		
		StringBuffer bf = new StringBuffer();
		
		bf.append("施悦(#)");              //pruserId    发起人ID-
		bf.append("(#)");                //prroleid    发起人角色id-
		bf.append("吕新test5(#)");       //changeName  变更名称
		bf.append("描述(#)");                  //changeDescription 变更描述
		bf.append("2017/10/29(#)");           //beginTime   开始时间-
		bf.append("2017/10/29(#)");           //endtime     结束时间-
		bf.append("110002001002001000_tree_应用程序类-核心系统类-国结系统-国际结算业务-国际结算业务(#)");  //changeType   变更类型 
		bf.append("紧急变更(#)");                 //changeCategory 变更类别
		bf.append("新增需求(#)");               //changeClassify 变更分类
		bf.append("核心账务系统(#)");                 //updatePlatform  更新平台
		bf.append("程序不完善(#)");            //changeReasonClassify  变更原因分类
		bf.append("(#)");              //changeReason 变更原因
		bf.append("(#)");              //changeContent 变更内容
		bf.append("(#)");              //prjid         相关项目编号-
		bf.append("(#)");           //prjtitle      相关项目名称-
		bf.append("否(#)");             //isBusiness     影响业务
		bf.append("无(#)");          //businessScope  业务影响范围      
		bf.append("0(#)");         //businessTime  计划影响业务时长(分钟) 
		bf.append("(#)");             //deliveryProgram 执行计划
		bf.append("(#)");             //rollbackProgram 回退计划
		bf.append("(#)");             //verificationProgram 验证计划
		bf.append("f08e79f8-ca01-431a-b24f-76302c5aac16(#)");     			//tick
		bf.append("(#)");             //relatedPrid 相关程序开发流程
		bf.append("核心账务系统(#)");
		bf.append("SSH:cyccall/watch;(#)");
		bf.append("7772&12901|12903;(#)");
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
		 * 在D盘中创建一个文件夹名称为socket,将要上传的文件放在文件夹中，该文件夹中的文件即可全部上传
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
