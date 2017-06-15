/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.framework.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;

/**
 * <p>
 * ��ʷ��¼����ҵ���߼�
 * </p>
 */

public interface AttachmentBL extends BaseBL {

	/**
	 * ��ȡָ����ʷ��¼����ظ�����Ϣ
	 * 
	 * @param attkey ����KEY
	 * @return ������Ϣ
	 */
	
	public List<Attachment> searchAttachmentsByAttkey(String attkey);
	
	/**
	 * ��Ӷ������
	 * 
	 * @param list ������Ϣ
	 * @throws BLException
	 */
	
	public void registAttachments(List<Attachment> list) throws BLException;
	
	/**
	 * ���һ������
	 * 
	 * @param attachment ������Ϣ
	 * @throws BLException
	 */
	
	public void registAttachment(Attachment attachment) throws BLException;	
	
	/**
	 * ��ȡָ���ĸ���
	 * 
	 * @param attId ����ID
	 * @return ������Ϣ
	 * @throws BLException 
	 */
	
	public Attachment searchAttachmentByKey(Integer attId) throws BLException;
	
	/**
	 * ��ȡ����ʵ��
	 * 
	 * @return ������Ϣ
	 */
	
	public AttachmentTB getAttachmentTBInstance();
	
	/**
	 * ɾ��һ������
	 * 
	 * @param attachment ������Ϣ
	 * @throws BLException
	 */
	
	public void deleteAttachment(Attachment attachment) throws BLException;
}
