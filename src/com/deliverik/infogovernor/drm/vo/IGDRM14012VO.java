/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;

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
 * @author tangxiaona@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM14012VO extends BaseVO implements Serializable {

	/**
	 * ֪ͨ����List
	 */
	
	protected Notice notice;

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}


}
