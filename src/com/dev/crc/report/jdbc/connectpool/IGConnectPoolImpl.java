/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.report.jdbc.connectpool;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.crc.report.jdbc.connection.IGConnection;
import com.dev.crc.report.jdbc.connection.IGConnectionImpl;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 连接池对象实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGConnectPoolImpl implements IGConnectPool{

	/** 连接存放位置 */
	protected List<IGConnection> conList = new ArrayList<IGConnection>();
	
	/** driver类路径 */
	protected String driver;
	
	/** 连接URL */
	protected String url;
	
	/** 用户名 */
	protected String username;
	
	/** 密码 */
	protected String password;
	
	/** 最小连接个数 */
	protected int minNum;
	
	/** 最大连接个数 */
	protected int maxNum;
	
	/**
	 * 构造方法
	 * @param driver driver类路径
	 * @param url 连接URL
	 * @param username 用户名
	 * @param password 密码
	 * @param minNum 最小连接数
	 * @param maxNum 最大连接数
	 */
	public IGConnectPoolImpl(String driver,String url,String username,
			String password,int minNum,int maxNum) throws ClassNotFoundException ,
			SQLException{
		init(driver, url, username, password, minNum, maxNum);
	}
	
	/**
	 * 初始化
	 * @param driver driver类路径
	 * @param url 连接URL
	 * @param username 用户名
	 * @param password 密码
	 * @param minNum 最小连接数
	 * @param maxNum 最大连接数
	 */
	private void init(String driver,String url,String username,
			String password,int minNum,int maxNum) throws ClassNotFoundException ,
			SQLException{
		//----------------初始化参数信息----------------
		//初始化driver类路径
		this.driver = driver;
		//初始化连接url
		this.url = url;
		//初始化用户名
		this.username = username;
		//初始化密码
		this.password = password;
		//初始化最小连接数
		this.minNum = minNum;
		//初始化最大连接数
		this.maxNum = maxNum;
		
		//------------------初始化连接------------------
		//按照最小数量初始化数据库连接
		for(int i=0;i<minNum;i++){
			IGConnection con = new IGConnectionImpl(driver, url, username, password);
			this.conList.add(con);
		}
	}
	
	/**
	 * 获取连接对象
	 * @return 连接对象
	 * @throws ClassNotFoundException driver加载失败
	 * @throws SQLException 创建连接异常
	 * @throws InterruptedException 线程异常
	 */
	public IGConnection getCon() throws ClassNotFoundException,SQLException,InterruptedException{
		//遍历连接存储对象，取得当前未使用连接
		for(IGConnection con:conList){
			//判断当前连接是否空闲
			if(con.isLeisure()){
				//如果空闲，返回当前连接
				return con.getCon();
			}
		}
		//如果连接存储对象中的所有连接均被使用，判断连接数量是否已经达到最大连接数
		//如果未达到最大连接数，创建连接
		//否则，线程暂停1秒，等待使用中的连接释放，重新获得
		if(conList.size() < maxNum){
			//创建连接对象
			IGConnection con = new IGConnectionImpl(driver, url, username, password);
			//将连接对象添加到连接存储对象
			this.conList.add(con);
			//返回当前连接
			return con.getCon();
		}else{
			//暂停1秒，等待连接释放
			Thread.sleep(1000);
			//重新获取连接
			return getCon();
		}
	}
	
	/**
	 * 释放多余连接
	 * 连接使用处于空闲状态，需要释放掉多余的连接
	 * 规则为：保留最小连接数量，将其与的连接全部关闭
	 */
	public void release() throws SQLException{
		//遍历连接存储对象，关闭大于最小连接数的所有连接
		for(int i=minNum;i<conList.size();i++){
			//关闭连接
			conList.get(i).close();
		}
		//重组连接存储对象
		List<IGConnection> list = new ArrayList<IGConnection>();
		//保留最小连接，加入新对象
		for(int i=0;i<conList.size() && i<minNum;i++){
			list.add(conList.get(i));
		}
		//释放原连接存储对象
		this.conList = null;
		//更新连接存储对象
		this.conList = list;
	}
	
	/**
	 * 关闭连接池
	 * 规则：不保留任何连接，全部关闭
	 */
	public void close() throws SQLException{
		//遍历连接存储对象，关闭所有连接
		for(int i=0;i<conList.size();i++){
			//关闭连接
			conList.get(i).close();
		}
	}
}
