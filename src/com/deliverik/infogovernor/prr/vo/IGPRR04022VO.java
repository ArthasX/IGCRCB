/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR04022VO extends BaseVO{



	/** ��ʾ���� */
	protected String title;
	
	/** �Ƿ���ʾ����(1����ʾ 0������ʾ) */
	protected String isShowTitle = "1";
	
	/** ��ʾ���� */
	protected List<IGPRR04023VO> content;

	/**
	 * ��ʾ����ȡ��
	 * @return title ��ʾ����
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * ��ʾ�����趨
	 * @param title ��ʾ����
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * �Ƿ���ʾ����ȡ��
	 * @return isShowTitle �Ƿ���ʾ����
	 */
	public String getIsShowTitle() {
		return isShowTitle;
	}

	/**
	 * �Ƿ���ʾ�����趨
	 * @param isShowTitle �Ƿ���ʾ����
	 */
	public void setIsShowTitle(String isShowTitle) {
		this.isShowTitle = isShowTitle;
	}

	/**
	 * ��ʾ����ȡ��
	 * @return content ��ʾ����
	 */
	public List<IGPRR04023VO> getContent() {
		return content;
	}

	/**
	 * ��ʾ�����趨
	 * @param content ��ʾ����
	 */
	public void setContent(List<IGPRR04023VO> content) {
		this.content = content;
	}

}
