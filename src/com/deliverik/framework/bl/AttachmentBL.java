/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;

/**
 * <p>
 * 历史记录附件业务逻辑
 * </p>
 */

public interface AttachmentBL extends BaseBL {

	/**
	 * 获取指定历史记录的相关附件信息
	 * 
	 * @param attkey 附件KEY
	 * @return 附件信息
	 */
	
	public List<Attachment> searchAttachmentsByAttkey(String attkey);
	
	/**
	 * 添加多个附件
	 * 
	 * @param list 附件信息
	 * @throws BLException
	 */
	
	public void registAttachments(List<Attachment> list) throws BLException;
	
	/**
	 * 添加一个附件
	 * 
	 * @param attachment 附件信息
	 * @throws BLException
	 */
	
	public void registAttachment(Attachment attachment) throws BLException;	
	
	/**
	 * 获取指定的附件
	 * 
	 * @param attId 附件ID
	 * @return 附件信息
	 * @throws BLException 
	 */
	
	public Attachment searchAttachmentByKey(Integer attId) throws BLException;
	
	/**
	 * 获取附件实例
	 * 
	 * @return 附件信息
	 */
	
	public AttachmentTB getAttachmentTBInstance();
	
	/**
	 * 删除一个附件
	 * 
	 * @param attachment 附件信息
	 * @throws BLException
	 */
	
	public void deleteAttachment(Attachment attachment) throws BLException;
}
