/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sym.model.Notice;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_֪ͨ����_��ѯVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM05011VO extends BaseVO implements Serializable {

	/**
	 * ֪ͨ����List
	 */
	
	protected List<Notice> noticecondList;

	/**
	 * ���췽��
	 * @param noticecondList List<Notice>
	 */
	
	public IGSYM05011VO(List<Notice> noticecondList) {
		this.noticecondList = noticecondList;
	}
	
	/**
	 * ��ȡ֪ͨ����List
	 * @return List<Notice>
	 */
	
	public List<Notice> getNoticecondList() {
		return noticecondList;
	}
}
