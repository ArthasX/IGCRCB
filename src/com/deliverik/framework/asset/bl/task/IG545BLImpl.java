package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.asset.model.IG545Bean;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.asset.model.condition.IG545SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG545DAO;
import com.deliverik.framework.asset.model.entity.IG545TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;

/**
 * �ʲ�����ȡֵ��Χ����ҵ���߼�ʵ��
 * 
 */
public class IG545BLImpl extends BaseBLImpl implements IG545BL {

	/** ig545 DAO */
	protected IG545DAO ig545DAO;

	public void setIg545DAO(IG545DAO ig545DAO) {
		this.ig545DAO = ig545DAO;
	}
	
	/**
	 * <p>
	 * �µ��ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 */

	public IG545TB getIG545TBInstance() {
		return new IG545TB();
	}

	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ��������б�
	 */
	public List<IG545Info> searchIG545Info(IG545SearchCond cond, int start, int count){
		List<IG545Info> ret = ig545DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��ʶ�����б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��ʶ���Ƽ�������б�
	 */
	public List<IG545Bean> searchIG545Bean(IG545SearchCond cond){
		List<IG545Bean> ret = ig545DAO.findIG545Bean(cond);
		return ret;
	}
	
	/**
	 * �������ݱ�ʶȡ���ʲ�����ȡֵ��Χ��ǩ����
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��ǩ�����������б�
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory){
		IG545SearchCondImpl cond = new IG545SearchCondImpl();
		cond.setCcdcategory(ccdcategory);
		cond.setCcdstatus("1");
		List<IG545Info> ret = this.searchIG545Info(cond, 0, 0);
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		for(IG545Info ccd : ret){
			list.add(new LabelValueBean(ccd.getCcdvalue(), ccd.getCcdvalue()));
		}
		return list;
	}
	
	/**
	 * �����ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param configurationCodeDetail ������ʲ�����ȡֵ��Χ������Ϣ����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 */
	public IG545Info registIG545Info(IG545Info configurationCodeDetail) throws BLException{
		IG545Info ret = ig545DAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * ɾ���ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param ig545Info ɾ�����ʲ�����ȡֵ��Χ������Ϣ����
	 * @return
	 */
	public void deleteIG545Info(IG545Info ig545Info) throws BLException {
		checkExistConfigurationCodeDetail(ig545Info.getCcdid());
		ig545DAO.delete(ig545Info);
	}

	/**
	 * �����ʲ�����ȡֵ��Χ������Ϣ����ɾ���ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param ccdid ɾ���ʲ�����ȡֵ��Χ������Ϣ������
	 * @return
	 */
	public void deleteIG545InfoByKey(Integer ccdid) throws BLException {
		IG545Info configurationCodeDetail = checkExistConfigurationCodeDetail(ccdid);
		ig545DAO.delete(configurationCodeDetail);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�������
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ������Ϣ�������
	 */
	public int getIG545InfoSearchCount(IG545SearchCond cond) {
		return ig545DAO.getSearchCount(cond);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ������Ϣ��������б�
	 */
	public List<IG545Info> searchIG545Info(IG545SearchCond cond) {
		List<IG545Info> ret = ig545DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * �����ʲ�����ȡֵ��Χ������Ϣ����ȡ���ʲ�����ȡֵ��Χ������Ϣ
	 * 
	 * @param ccdid �ʲ�����ȡֵ��Χ������Ϣ����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 * @throws BLException 
	 */
	public IG545Info searchIG545InfoByKey(Integer ccdid) throws BLException {
		return checkExistConfigurationCodeDetail(ccdid);
	}

	/**
	 * ����ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param ig545Info ������ʲ�����ȡֵ��Χ������Ϣ����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 */
	public IG545Info updateIG545Info(IG545Info ig545Info) throws BLException {
		checkExistConfigurationCodeDetail(ig545Info.getCcdid());
		IG545Info ret = ig545DAO.save(ig545Info);
		return ret;
	}

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ���ݱ�ʶȡ���ʲ�����ȡֵ��Χ��Ϣ
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 */
	public IG545Info searchIG545InfoByKey(String ccdcategory) {
		IG545Info ret = ig545DAO.findByPK(ccdcategory);
		return ret;
	}
	
	/**
	 * �ʲ�����ȡֵ��Χ������Ϣ���ڼ��
	 * 
	 * @param ccdid �ʲ�ID
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 * @throws BLException 
	 */
	protected IG545Info checkExistConfigurationCodeDetail(Integer ccdid) throws BLException{
		IG545Info info = ig545DAO.findByPK(ccdid);
		if(info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ�����ȡֵ��Χ���ݻ���");
		}
		return info;
	}
}
