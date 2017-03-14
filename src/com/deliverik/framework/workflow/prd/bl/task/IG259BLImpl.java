/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG259DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG259TB;

/**
 * <p>
 * ����ģ����Ϣ����ҵ���߼�ʵ�� 
 * </p>
 */

public class IG259BLImpl extends BaseBLImpl implements IG259BL{
	
	/**����ģ�����*/
	protected IG259DAO ig259DAO;
	
	/**
	 * ��������ģ�����
	 * @param ig259DAO
	 */
	public void setIg259DAO(IG259DAO ig259DAO) {
		this.ig259DAO = ig259DAO;
	}
	
	/**
	 * ������ģ��ʵ��
	 * 
	 * @return ProcessTemplateTB
	 * @throws BLException
	 */
	
	public IG259TB getIG259TBInstance(){
		return new IG259TB();
	}
	
	
	/**
	 * ��ȡʹ���е�����ģ����Ϣ
	 * @param processType String
	 * @return ProcessTemplate
	 * @throws BLException
	 */
	
	public IG259Info searchIG259ByPrType(String processType){
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setPttype(processType);
		cond.setPtstatus("a");
		List<IG259Info> list= ig259DAO.findByCond(cond, 0, 0);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}
	/**
	 * ������������ģ����Ϣ
	 * @param cond ����ģ����Ϣ��������
	 * @return ����ģ����Ϣ����б�
	 * @throws BLException
	 */
	public List<IG259Info> searchIG259Info(IG259SearchCond cond) {
		List<IG259Info> processTemplateList = ig259DAO.findByCond(cond, 0, 0);
		return processTemplateList;
	}
	
	/**
	 * ������������ģ����Ϣ
	 * @param cond ����ģ����Ϣ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ����ģ����Ϣ����б�
	 * @throws BLException
	 */
	public List<IG259Info> searchIG259Info(IG259SearchCond cond, int start, int count) {
		List<IG259Info> processTemplateList = ig259DAO.findByCond(cond, start, count);
		return processTemplateList;
	}
	
	/**
	 * ��������ģ��ID��ȡ����ģ��
	 * @param ptid ����ģ��ID
	 * @return ����ģ����Ϣ
	 * @throws BLException
	 */
	public IG259Info searchIG259InfoByKey(Integer ptid) throws BLException {
		return checkExistIG259Info(ptid);
	}
	
	/**
	 * ��������
	 * 
	 * @param Ig273 ��������
	 * @return �ʲ���Ϣ
	 */
	
	public IG259Info registIG259Info(
			IG259Info ig259Info) throws BLException{
		return ig259DAO.save(ig259Info);
	}
	
	/**
	 * ɾ������
	 * 
	 * @param ptid ����ģ��ID
	 * @return
	 */
	
	public void deleteIG259InfoByKey(Integer ptid) throws BLException{
		IG259Info processTemplate = checkExistIG259Info(ptid);
		ig259DAO.delete(processTemplate);
	}
	
	/**
	 * �������
	 * 
	 * @param processTemplate �������
	 * @return ����״̬ԾǨ����
	 */
	
	public IG259Info updateIG259Info(
			IG259Info processTemplate) throws BLException{
		return ig259DAO.save(processTemplate);
	}
	
	/**
	 * ����ģ����ڼ��
	 * 
	 * @param ptid ����ģ��ID
	 * @return ����ģ��
	 * @throws BLException 
	 */
	
	protected IG259Info checkExistIG259Info(Integer ptid) throws BLException{
		IG259Info info = ig259DAO.findByPK(ptid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","����ģ�����");
		}
		return info;
	}
}
