/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
 * ��ʷ��¼����ҵ���߼�ʵ��
 * </p>
 */

public class AttachmentBLImpl extends BaseBLImpl implements AttachmentBL {

	/**��������*/
	protected AttachmentTBDAO attachmentTBDAO;

	/**
	 * ���ø�������
	 * @param attachmentTBDAO AttachmentTBDAO
	 */
	public void setAttachmentTBDAO(AttachmentTBDAO attachmentTBDAO) {
		this.attachmentTBDAO = attachmentTBDAO;
	}

	/**
	 * ��ȡָ����ʷ��¼����ظ�����Ϣ
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
	 * ��Ӷ������
	 * 
	 * @param list ������Ϣ
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
	 * ���һ������
	 * 
	 * @param attachment ������Ϣ
	 * @throws BLException
	 */
	
	public void registAttachment(Attachment attachment) throws BLException {
		attachmentTBDAO.save(attachment);
	}

	/**
	 * ��ȡָ���ĸ���
	 * 
	 * @param attId ����ID
	 * @return ������Ϣ
	 * @throws BLException 
	 */
	
	public Attachment searchAttachmentByKey(Integer attId) throws BLException{
		return checkExistAttachment(attId);
	}

	/**
	 * ��ȡ����ʵ��
	 * 
	 * @return ������Ϣ
	 */
	
	public AttachmentTB getAttachmentTBInstance(){
		return new AttachmentTB();
	}
	
	/**
	 * ������Ϣ���ڼ��
	 * 
	 * @param attId ����ID
	 * @return ������Ϣ
	 * @throws BLException 
	 */
	private Attachment checkExistAttachment(Integer attId) throws BLException{
		Attachment info = attachmentTBDAO.findByPK(attId);
		if( info == null) {
			throw new BLException(BLErrorType.COMMON_ERROR_TYPE,
					"IGCO10000.E004","��������");
		}
		
		return info;
	}
	
	/**
	 * ɾ��һ������
	 * 
	 * @param attachment ������Ϣ
	 * @throws BLException
	 */
	
	public void deleteAttachment(Attachment attachment) throws BLException {
		attachmentTBDAO.delete(attachment);
	}
}
