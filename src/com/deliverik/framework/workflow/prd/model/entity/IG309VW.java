/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prd.model.IG309Info;

/**
  * ����: �����߿��Ӱ�ťʵ��
  * ��������: �����߿��Ӱ�ťʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
public class IG309VW implements Serializable,
		Cloneable, IG309Info {

	/** ��ť����ID */
	@Id
	protected String  vbid;

	/** ��ť��ʾ���� */
	protected String vbname;

	/** ��ť��ʾ��Ϣ */
	protected String vbdesc;

	/** �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0 */
	protected String vbauth;
	
	/** ͼƬ�� */
	protected String vbimage;
	
	/** У����Ƿ���� */
	protected String vbrequired;
	
	/** У���¼�Ƿ���� */
	protected String vbrecord;
	
	/** ����ҳjs���� */
	protected String vbacturl;
	
	/**
	 * ��ť����IDȡ��
	 *
	 * @return ��ť����ID
	 */
	public String getVbid() {
		return vbid;
	}

	/**
	 * ��ť����ID�趨
	 *
	 * @param vbid ��ť����ID
	 */
	public void setVbid(String vbid) {
		this.vbid = vbid;
	}

	/**
	 * ��ť��ʾ����ȡ��
	 *
	 * @return ��ť��ʾ����
	 */
	public String getVbname() {
		return vbname;
	}

	/**
	 * ��ť��ʾ�����趨
	 *
	 * @param vbname ��ť��ʾ����
	 */
	public void setVbname(String vbname) {
		this.vbname = vbname;
	}

	/**
	 * ��ť��ʾ��Ϣȡ��
	 *
	 * @return ��ť��ʾ��Ϣ
	 */
	public String getVbdesc() {
		return vbdesc;
	}

	/**
	 * ��ť��ʾ��Ϣ�趨
	 *
	 * @param vbdesc ��ť��ʾ��Ϣ
	 */
	public void setVbdesc(String vbdesc) {
		this.vbdesc = vbdesc;
	}

	/**
	 * �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0ȡ��
	 *
	 * @return �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0
	 */
	public String getVbauth() {
		return vbauth;
	}

	/**
	 * �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0�趨
	 *
	 * @param vbauth �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0
	 */
	public void setVbauth(String vbauth) {
		this.vbauth = vbauth;
	}

	/**
	 * ͼƬ��ȡ��
	 * 
	 * @return ͼƬ��
	 */
	public String getVbimage() {
		return vbimage;
	}

	/**
	 * ͼƬ���趨
	 * 
	 * @param pbdimage ͼƬ��
	 */
	public void setVbimage(String vbimage) {
		this.vbimage = vbimage;
	}

	/**
	 *У����Ƿ����ȡ��
	 */
	public String getVbrequired() {
		return vbrequired;
	}

	/**
	 *У����Ƿ�����趨
	 */
	public void setVbrequired(String vbrequired) {
		this.vbrequired = vbrequired;
	}

	/**
	 *У���¼�Ƿ����ȡ��
	 */
	public String getVbrecord() {
		return vbrecord;
	}

	/**
	 *У���¼�Ƿ�����趨
	 */
	public void setVbrecord(String vbrecord) {
		this.vbrecord = vbrecord;
	}

	/**
	 *����ҳjs����ȡ��
	 */
	public String getVbacturl() {
		return vbacturl;
	}

	/**
	 *����ҳjs�����趨
	 */
	public void setVbacturl(String vbacturl) {
		this.vbacturl = vbacturl;
	}
	
	
	
}