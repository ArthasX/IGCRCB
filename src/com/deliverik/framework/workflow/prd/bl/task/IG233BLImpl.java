/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG233DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG233PK;
import com.deliverik.framework.workflow.prd.model.entity.IG233TB;

/**
  * ����: �Զ������̷��ɶ����ҵ���߼�ʵ��
  * ��������: �Զ������̷��ɶ����ҵ���߼�ʵ��
  * ������¼: 2013/03/12
  * �޸ļ�¼: 
  */
public class IG233BLImpl extends BaseBLImpl implements IG233BL {

	/** �Զ������̷��ɶ����DAO�ӿ� */
	protected IG233DAO ig233DAO;
	
	/**
	 * �Զ������̷��ɶ����DAO�ӿ��趨
	 *
	 * @param iG233DAO �Զ������̷��ɶ����DAO�ӿ�
	 */
	public void setIg233DAO(IG233DAO ig233DAO) {
		this.ig233DAO = ig233DAO;
	}

	/**
	 * �Զ������̷��ɶ����ʵ��ȡ��
	 *
	 * @return �Զ������̷��ɶ����ʵ��
	 */
	public IG233TB getIG233TBInstance() {
		return new IG233TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG233Info> searchIG233() {
		return ig233DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG233Info searchIG233ByPK(IG233PK pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG233SearchCond cond) {
		return ig233DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG233Info> searchIG233(IG233SearchCond cond) {
		return ig233DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG233Info> searchIG233(IG233SearchCond cond, int start,int count) {
		return ig233DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ����״̬id��ѯ
	 * @param psdid
	 * @return
	 */
	public List<IG233Info> searchByPsdid(String psdid){
		if(StringUtils.isEmpty(psdid)){
			return null;
		}
		IG233SearchCondImpl cond = new IG233SearchCondImpl();
		cond.setPsdid(psdid);
		return this.searchIG233(cond);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG233Info registIG233(IG233Info instance) throws BLException {
		return ig233DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG233Info updateIG233(IG233Info instance) throws BLException {
		checkExistInstance(new IG233PK(instance.getPsdid(), instance.getAssignpsdid()));
		return ig233DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG233ByPK(IG233PK pk) throws BLException {
		ig233DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG233(IG233Info instance) throws BLException {
		ig233DAO.delete(instance);
	}
	
	/**
	 * ����ɾ��
	 * @param list
	 */
	public void deleteIG233(List<IG233Info> list){
		ig233DAO.delete(list);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG233Info checkExistInstance(IG233PK pk) throws BLException {
		IG233Info instance = ig233DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG233SearchCondImpl cond = new IG233SearchCondImpl();
		cond.setPdid(pdid);
		List<IG233Info> lst_IG233Info = this.searchIG233(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG233>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG233Info != null) {
			for(IG233Info info : lst_IG233Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("<ASSIGNPSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getAssignpsdid()) ? "" : IGStringUtils.filterXMLStr(info.getAssignpsdid()));
				sbf_xml.append("</ASSIGNPSDID>");
				sbf_xml.append("<ASSIGNPBDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getAssignpbdid()) ? "" : IGStringUtils.filterXMLStr(info.getAssignpbdid()));
				sbf_xml.append("</ASSIGNPBDID>");
				sbf_xml.append("<ASSIGNFLAG>");
				sbf_xml.append(StringUtils.isEmpty(info.getAssignflag()) ? "" : IGStringUtils.filterXMLStr(info.getAssignflag()));
				sbf_xml.append("</ASSIGNFLAG>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG233>");
		return sbf_xml;
	}
	
	/**
	 * XML�ű����봦��
	 *
	 * @param element Element
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public void importXML(Element element) throws BLException {
		Element data = element.getChild("DATALIST");
		List<Element> dataList = data.getChildren();
		List<IG233Info> lst_IG233 = new ArrayList<IG233Info>();
		IG233TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG233TBInstance();
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setAssignpsdid(e.getChildText("ASSIGNPSDID"));
			entity.setAssignpbdid(e.getChildText("ASSIGNPBDID"));
			entity.setAssignflag(e.getChildText("ASSIGNFLAG"));
			lst_IG233.add(entity);
		}
		this.ig233DAO.saveOrUpdateAll(lst_IG233);
	}

}