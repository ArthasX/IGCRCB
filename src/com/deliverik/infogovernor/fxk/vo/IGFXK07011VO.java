/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:  ҳ����ʾ
 * </p>
 * 2014-6-19
 * @author zhangq@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK07011VO extends BaseVO implements Serializable{
	
	/** ������ʾ�����Ϣ���� */
    protected List<IGFXK07012VO> voList;
    
    /**������ʾ���������Ϣ����*/
    protected IGFXK07012VO igfxk07012vo;

	/**
	 * ������ʾ���������Ϣ����ȡ��
	 * @return igfxk07012vo ������ʾ���������Ϣ����
	 */
	public IGFXK07012VO getIgfxk07012vo() {
		return igfxk07012vo;
	}

	/**
	 * ������ʾ���������Ϣ�����趨
	 * @param igfxk07012vo ������ʾ���������Ϣ����
	 */
	public void setIgfxk07012vo(IGFXK07012VO igfxk07012vo) {
		this.igfxk07012vo = igfxk07012vo;
	}

	/**
	 * ������ʾ�����Ϣ����ȡ��
	 * @return voList ������ʾ�����Ϣ����
	 */
	public List<IGFXK07012VO> getVoList() {
		return voList;
	}

	/**
	 * ������ʾ�����Ϣ�����趨
	 * @param voList ������ʾ�����Ϣ����
	 */
	public void setVoList(List<IGFXK07012VO> voList) {
		this.voList = voList;
	}
}
