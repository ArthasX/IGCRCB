/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.condition.IG110SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG110SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG110DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG110TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѯ��ʾ�ж���ʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IG110BLImpl extends BaseBLImpl implements IG110BL{

	/** ��ѯ��ʾ��DAO */
	protected IG110DAO ig110DAO;

	/**
	 * ��ѯ��ʾ��DAO�趨
	 * @param ig110DAO ��ѯ��ʾ��DAO
	 */
	public void setIg110DAO(IG110DAO ig110dao) {
		ig110DAO = ig110dao;
	}
	
	/**
	 * ��������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG110Info> searchIG110(IG110SearchCond cond) throws BLException {
		return ig110DAO.findByCond(cond,0,0);
	}
	
	/**
	 * ɾ������
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG110(IG110Info instance) throws BLException {
		ig110DAO.delete(instance);
	}
	
	/**
	 * ��������
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG110Info registIG110(IG110Info instance) throws BLException {
		return ig110DAO.save(instance);
	}
	
	/**
	 * �޸Ĵ���
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG110Info updateIG110(IG110Info instance) throws BLException {
		checkExistInstance(instance.getSid());
		return ig110DAO.save(instance);
	}
	
	/**
	 * ȡ����һ��ID
	 * @param pdid ���̶���ID
	 * @return ʵ��ID
	 * @throws BLException
	 */
	public String getNextId(String pdid) throws BLException{
		return ig110DAO.getNextId(pdid);
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG110Info checkExistInstance(String pk) throws BLException {
		IG110Info instance = ig110DAO.findByPK(pk);
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
		IG110SearchCondImpl cond = new IG110SearchCondImpl();
		cond.setPdid(pdid);
		List<IG110Info> list = this.searchIG110(cond);
		StringBuffer sbf_xml = new StringBuffer();
		sbf_xml.append("<IG110>");
		sbf_xml.append("<DATALIST>");
		for(IG110Info info:list){
			sbf_xml.append("<DATA>");
			sbf_xml.append("<SID>");
			sbf_xml.append(info.getSid());
			sbf_xml.append("</SID>");
			sbf_xml.append("<PDID>");
			sbf_xml.append(info.getPdid());
			sbf_xml.append("</PDID>");
			sbf_xml.append("<STYPE>");
			sbf_xml.append(info.getStype());
			sbf_xml.append("</STYPE>");
			sbf_xml.append("<SFLAG>");
			sbf_xml.append(info.getSflag());
			sbf_xml.append("</SFLAG>");
			sbf_xml.append("<SNAME>");
			sbf_xml.append(info.getSname());
			sbf_xml.append("</SNAME>");
			sbf_xml.append("<WIDTH>");
			sbf_xml.append(info.getWidth());
			sbf_xml.append("</WIDTH>");
			sbf_xml.append("<FINGERPRINT>");
			sbf_xml.append(info.getFingerPrint());
			sbf_xml.append("</FINGERPRINT>");
			sbf_xml.append("</DATA>");
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG110>");
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
		IG110TB entity = null;
		for(Element e : dataList) {
			entity = new IG110TB();
			entity.setSid(e.getChildText("SID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setStype(e.getChildText("STYPE"));
			entity.setSflag(e.getChildText("SFLAG"));
			entity.setSname(e.getChildText("SNAME"));
			String width = e.getChildText("WIDTH");
			if(StringUtils.isEmpty(width)){
				width = "0";
			}
			entity.setWidth(Integer.valueOf(width));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			this.registIG110(entity);
		}
	}

	/**
	 * �������̶���idɾ����ʾ��
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid) throws BLException {
		ig110DAO.deleteByPdid(pdid);
	}
}
