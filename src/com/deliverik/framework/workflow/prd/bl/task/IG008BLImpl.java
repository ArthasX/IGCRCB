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
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.condition.IG008SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG008SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG008DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG008PK;
import com.deliverik.framework.workflow.prd.model.entity.IG008TB;

/**
  * ����: ��Ա����ɫ�޶�ҵ���߼�ʵ��
  * ��������: ��Ա����ɫ�޶�ҵ���߼�ʵ��
  * ������¼: 2013/11/27
  * �޸ļ�¼: 
  */
public class IG008BLImpl extends BaseBLImpl implements IG008BL {

	/** ��Ա����ɫ�޶�DAO�ӿ� */
	protected IG008DAO ig008DAO;
	
	/**
	 * ��Ա����ɫ�޶�DAO�ӿ��趨
	 *
	 * @param iG008DAO ��Ա����ɫ�޶�DAO�ӿ�
	 */
	public void setIg008DAO(IG008DAO ig008DAO) {
		this.ig008DAO = ig008DAO;
	}

	/**
	 * ��Ա����ɫ�޶�ʵ��ȡ��
	 *
	 * @return ��Ա����ɫ�޶�ʵ��
	 */
	public IG008TB getIG008TBInstance() {
		return new IG008TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG008Info> searchIG008() {
		return ig008DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG008Info searchIG008ByPK(IG008PK pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG008SearchCond cond) {
		return ig008DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG008Info> searchIG008(IG008SearchCond cond) {
		return ig008DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG008Info> searchIG008(IG008SearchCond cond, int start,int count) {
		return ig008DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG008Info registIG008(IG008Info instance) throws BLException {
		return ig008DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG008Info updateIG008(IG008Info instance)throws BLException {
		checkExistInstance(new IG008PK(instance.getPidid(), instance.getRoleid()));
		return ig008DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG008ByPK(IG008PK pk) throws BLException {
		ig008DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG008(IG008Info instance) throws BLException {
		ig008DAO.delete(instance);
	}
	
	/**
	 * ɾ������
	 *
	 * @param entitys ɾ��ʵ������
	 */
	public void deleteIG008(List<IG008Info> entitys) throws BLException{
		ig008DAO.delete(entitys);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG008Info checkExistInstance(IG008PK pk) throws BLException {
		IG008Info instance = ig008DAO.findByPK(pk);
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
		IG008SearchCondImpl cond = new IG008SearchCondImpl();
		cond.setPdid(pdid);
		List<IG008Info> lst_IG008Info = searchIG008(cond);
		StringBuffer sbf_xml = new StringBuffer();
		sbf_xml.append("<IG008>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG008Info != null){
			for(IG008Info info : lst_IG008Info){
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<ROLEID>");
				sbf_xml.append(info.getRoleid() == null ? "" : "&roleid_" + info.getRoleid() + ";");
				sbf_xml.append("</ROLEID>");
				sbf_xml.append("<ROLENAME>");
				sbf_xml.append(StringUtils.isNotEmpty(info.getRolename()) ? "" : IGStringUtils.filterXMLStr(info.getRolename()));
				sbf_xml.append("</ROLENAME>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG008>");
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
		List<IG008Info> lst_IG008 = new ArrayList<IG008Info>(dataList.size());
		IG008TB entity = null;
		for(Element e : dataList){
			entity = this.getIG008TBInstance();
			entity.setPidid(e.getChildText("PIDID"));
			entity.setRoleid(StringUtils.isNotEmpty(e.getChildText("ROLEID")) ? Integer.valueOf(e.getChildText("ROLEID")) : null);
			entity.setRolename(e.getChildText("ROLENAME"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG008.add(entity);
		}
		if(lst_IG008.size() > 0){
			this.ig008DAO.saveOrUpdateAll(lst_IG008);
		}
	}
}