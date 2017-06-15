/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.condition.AttachmentSearchCondImpl;
import com.deliverik.framework.model.dao.AttachmentTBDAO;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.utility.BLErrorType;

/**
 * <p>
 * 历史记录附件业务逻辑实现
 * </p>
 */

public class AttachmentBLImpl extends BaseBLImpl implements AttachmentBL {

	/**附件操作*/
	protected AttachmentTBDAO attachmentTBDAO;

	/**
	 * 设置附件操作
	 * @param attachmentTBDAO AttachmentTBDAO
	 */
	public void setAttachmentTBDAO(AttachmentTBDAO attachmentTBDAO) {
		this.attachmentTBDAO = attachmentTBDAO;
	}

	/**
	 * 获取指定历史记录的相关附件信息
	 * 
	 * @param attkey getAttachments
	 * @return List<Attachment>
	 */

	public List<Attachment> searchAttachmentsByAttkey(String attkey){
		if(StringUtils.isNotEmpty(attkey)){
			AttachmentSearchCondImpl cond = new AttachmentSearchCondImpl();
			cond.setAttkey(attkey);
			return attachmentTBDAO.findByCond(cond, 0, 0);
		}else{
			return new ArrayList<Attachment>();
		}
	}
	
	/**
	 * 添加多个附件
	 * 
	 * @param list 附件信息
	 * @throws BLException
	 */
	
	public void registAttachments(List<Attachment> list) throws BLException{
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				attachmentTBDAO.save(list.get(i));
			}
		}
	}
	
	/**
	 * 添加一个附件
	 * 
	 * @param attachment 附件信息
	 * @throws BLException
	 */
	
	public void registAttachment(Attachment attachment) throws BLException {
		attachmentTBDAO.save(attachment);
	}

	/**
	 * 获取指定的附件
	 * 
	 * @param attId 附件ID
	 * @return 附件信息
	 * @throws BLException 
	 */
	
	public Attachment searchAttachmentByKey(Integer attId) throws BLException{
		return checkExistAttachment(attId);
	}

	/**
	 * 获取附件实例
	 * 
	 * @return 附件信息
	 */
	
	public AttachmentTB getAttachmentTBInstance(){
		return new AttachmentTB();
	}
	
	/**
	 * 附件信息存在检查
	 * 
	 * @param attId 附件ID
	 * @return 附件信息
	 * @throws BLException 
	 */
	private Attachment checkExistAttachment(Integer attId) throws BLException{
		Attachment info = attachmentTBDAO.findByPK(attId);
		if( info == null) {
			throw new BLException(BLErrorType.COMMON_ERROR_TYPE,
					"IGCO10000.E004","附件基本");
		}
		
		return info;
	}
	
	/**
	 * 删除一个附件
	 * 
	 * @param attachment 附件信息
	 * @throws BLException
	 */
	
	public void deleteAttachment(Attachment attachment) throws BLException {
		attachmentTBDAO.delete(attachment);
	}
}
