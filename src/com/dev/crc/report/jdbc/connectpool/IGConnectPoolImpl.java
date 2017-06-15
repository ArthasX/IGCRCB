/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.report.jdbc.connectpool;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.crc.report.jdbc.connection.IGConnection;
import com.dev.crc.report.jdbc.connection.IGConnectionImpl;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ӳض���ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGConnectPoolImpl implements IGConnectPool{

	/** ���Ӵ��λ�� */
	protected List<IGConnection> conList = new ArrayList<IGConnection>();
	
	/** driver��·�� */
	protected String driver;
	
	/** ����URL */
	protected String url;
	
	/** �û��� */
	protected String username;
	
	/** ���� */
	protected String password;
	
	/** ��С���Ӹ��� */
	protected int minNum;
	
	/** ������Ӹ��� */
	protected int maxNum;
	
	/**
	 * ���췽��
	 * @param driver driver��·��
	 * @param url ����URL
	 * @param username �û���
	 * @param password ����
	 * @param minNum ��С������
	 * @param maxNum ���������
	 */
	public IGConnectPoolImpl(String driver,String url,String username,
			String password,int minNum,int maxNum) throws ClassNotFoundException ,
			SQLException{
		init(driver, url, username, password, minNum, maxNum);
	}
	
	/**
	 * ��ʼ��
	 * @param driver driver��·��
	 * @param url ����URL
	 * @param username �û���
	 * @param password ����
	 * @param minNum ��С������
	 * @param maxNum ���������
	 */
	private void init(String driver,String url,String username,
			String password,int minNum,int maxNum) throws ClassNotFoundException ,
			SQLException{
		//----------------��ʼ��������Ϣ----------------
		//��ʼ��driver��·��
		this.driver = driver;
		//��ʼ������url
		this.url = url;
		//��ʼ���û���
		this.username = username;
		//��ʼ������
		this.password = password;
		//��ʼ����С������
		this.minNum = minNum;
		//��ʼ�����������
		this.maxNum = maxNum;
		
		//------------------��ʼ������------------------
		//������С������ʼ�����ݿ�����
		for(int i=0;i<minNum;i++){
			IGConnection con = new IGConnectionImpl(driver, url, username, password);
			this.conList.add(con);
		}
	}
	
	/**
	 * ��ȡ���Ӷ���
	 * @return ���Ӷ���
	 * @throws ClassNotFoundException driver����ʧ��
	 * @throws SQLException ���������쳣
	 * @throws InterruptedException �߳��쳣
	 */
	public IGConnection getCon() throws ClassNotFoundException,SQLException,InterruptedException{
		//�������Ӵ洢����ȡ�õ�ǰδʹ������
		for(IGConnection con:conList){
			//�жϵ�ǰ�����Ƿ����
			if(con.isLeisure()){
				//������У����ص�ǰ����
				return con.getCon();
			}
		}
		//������Ӵ洢�����е��������Ӿ���ʹ�ã��ж����������Ƿ��Ѿ��ﵽ���������
		//���δ�ﵽ�������������������
		//�����߳���ͣ1�룬�ȴ�ʹ���е������ͷţ����»��
		if(conList.size() < maxNum){
			//�������Ӷ���
			IGConnection con = new IGConnectionImpl(driver, url, username, password);
			//�����Ӷ�����ӵ����Ӵ洢����
			this.conList.add(con);
			//���ص�ǰ����
			return con.getCon();
		}else{
			//��ͣ1�룬�ȴ������ͷ�
			Thread.sleep(1000);
			//���»�ȡ����
			return getCon();
		}
	}
	
	/**
	 * �ͷŶ�������
	 * ����ʹ�ô��ڿ���״̬����Ҫ�ͷŵ����������
	 * ����Ϊ��������С���������������������ȫ���ر�
	 */
	public void release() throws SQLException{
		//�������Ӵ洢���󣬹رմ�����С����������������
		for(int i=minNum;i<conList.size();i++){
			//�ر�����
			conList.get(i).close();
		}
		//�������Ӵ洢����
		List<IGConnection> list = new ArrayList<IGConnection>();
		//������С���ӣ������¶���
		for(int i=0;i<conList.size() && i<minNum;i++){
			list.add(conList.get(i));
		}
		//�ͷ�ԭ���Ӵ洢����
		this.conList = null;
		//�������Ӵ洢����
		this.conList = list;
	}
	
	/**
	 * �ر����ӳ�
	 * ���򣺲������κ����ӣ�ȫ���ر�
	 */
	public void close() throws SQLException{
		//�������Ӵ洢���󣬹ر���������
		for(int i=0;i<conList.size();i++){
			//�ر�����
			conList.get(i).close();
		}
	}
}
