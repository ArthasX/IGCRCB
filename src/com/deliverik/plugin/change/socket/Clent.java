package com.deliverik.plugin.change.socket;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Clent {

	public static void main(String[] args) throws Exception{
		//实例化客户端对象
		Socket socket = new Socket();
		//连接server
		socket.connect(new InetSocketAddress("192.168.1.42",8976));
		//实例化输出流
		BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
		
		
		File file = new File("d:\\加班费申请单_张强_20150718-20150724.xls");
		
		
		StringBuffer bf = new StringBuffer();
		
		bf.append("韩月广(#)");              //pruserId    发起人ID-
		bf.append("运行管理岗(#)");                //prroleid    发起人角色id-
		bf.append("陈帅来测试2(#)");       //changeName  变更名称
		bf.append("描述(#)");                  //changeDescription 变更描述
		bf.append("2015/07/02(#)");           //beginTime   开始时间-
		bf.append("2015/07/10(#)");           //endtime     结束时间-
		bf.append("110001001_tree_系统网络类-服务器/小型机(#)");  //changeType   变更类型 
		bf.append("常规变更(#)");                 //changeCategory 变更类别
		bf.append("变更分类(#)");               //changeClassify 变更分类
		bf.append("abs#内联afe#外联afe(#)");                 //updatePlatform  更新平台
		bf.append("变更原因分类(#)");            //changeReasonClassify  变更原因分类
		bf.append("变更原因(#)");              //changeReason 变更原因
		bf.append("变更内容(#)");              //changeContent 变更内容
		bf.append("01830(#)");              //prjid         相关项目编号-
		bf.append("相关项目名称(#)");           //prjtitle      相关项目名称-
		bf.append("影响业务(#)");             //isBusiness     影响业务
		bf.append("业务影响范围(#)");          //businessScope  业务影响范围      
		bf.append("2015/06/06(#)");         //businessTime  计划影响业务时长(分钟) 
		bf.append("执行计划(#)");             //deliveryProgram 执行计划
		bf.append("回退计划(#)");             //rollbackProgram 回退计划
		bf.append("验证计划(#)");             //verificationProgram 验证计划
		bf.append("1001(#)");    
		bf.append("sdff(#)");             //relatedPrid 相关程序开发流程
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
