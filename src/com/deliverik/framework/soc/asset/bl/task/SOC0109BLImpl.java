package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0109DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;
import com.deliverik.framework.utility.BLErrorType;


/**
 * <p>
 * �ʲ�ģ������ҵ���߼�ʵ��
 * </p>
 */
public class SOC0109BLImpl extends BaseBLImpl implements SOC0109BL {

	/** Configuration DAO */
	protected SOC0109DAO soc0109DAO;
	
	/** �ʲ�ģ��BL */
	protected SOC0117BL soc0117BL;


	/**
	 * �ʲ�ģ��BL�趨
	 *
	 * @param soc0117BL �ʲ�ģ��BL
	 */
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}

	/**
	 * ConfigurationDAO�趨
	 *
	 * @param soc0109DAO ConfigurationDAO
	 */
	public void setSoc0109DAO(SOC0109DAO soc0109DAO) {
		this.soc0109DAO = soc0109DAO;
	}

	/**
	 * <p>
	 * �µ��ʲ�ģ��������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�ģ��������Ϣ����ʵ��ȡ��
	 */

	public SOC0109TB getConfigurationTBInstance() {
		return new SOC0109TB();
	}

	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @return �ʲ�ģ��������Ϣ����
	 */
	public int getConfigurationSearchCount(SOC0109SearchCond cond){

		return soc0109DAO.getSearchCount(cond);
	}

	/**
	 * �����ʲ�ģ����������ȡ���ʲ�ģ��������Ϣ
	 * 
	 * @param cid �ʲ�ģ����������
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException 
	 */
	public SOC0109Info searchConfigurationByKey(String cid) throws BLException{

		return checkExistConfiguration(cid);
	}

	/**
	 * ȡ�ø��ʲ�ģ�͵�ģ��������Ϣ
	 * 
	 * @param list �ʲ�ģ�ͼ���
	 * @param cseq �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ���ԣ�0����ʾ��null����ȫ�����ԣ�
	 * @return ���ʲ�ģ�͵�ģ��������Ϣ
	 */
	public Map<String,List<SOC0109Info>> searchConfiguration(List<SOC0117Info> list,Integer cseq){
		Map<String,List<SOC0109Info>> map = new LinkedHashMap<String,List<SOC0109Info>>();
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		if(cseq!=null){
			cond.setCseq(cseq);//�����Ƿ���ʾ��1������ʾ���ԣ�0������ʾ
		}
		//�ʲ�������Ϣ�ֲ�β�ѯ
		for(SOC0117Info e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109Info> configurationList = soc0109DAO.findByCond(cond, 0, 0);
			map.put(e.getEname(), configurationList);
		}

		return map;
	}
	
	/**
	 * �����ʲ�ģ��IDȡ�������м̳�������Ϣ�б�
	 * 
	 * @param eid ģ������ID
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<SOC0109Info> searchConfigurationByEid(String eid) throws BLException{
		List<SOC0117Info> list = soc0117BL.getParentNodes(eid);
		List<SOC0109Info> configlist = new ArrayList<SOC0109Info>();
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		cond.setCstatus("1");//1����
		//�ʲ�������Ϣ�ֲ�β�ѯ
		for(SOC0117Info e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109Info> configurationList = soc0109DAO.findByCond(cond, 0, 0);
			configlist.addAll(configurationList);
		}

		return configlist;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<SOC0109Info> searchConfiguration(SOC0109SearchCond cond, int start, int count){

		List<SOC0109Info> ret = soc0109DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * �����ʲ�ģ��������Ϣ����
	 * 
	 * @param configuration �ʲ�ģ��������Ϣ
	 * @return �������ʲ�ģ��������Ϣ
	 * @throws BLException
	 */
	public SOC0109Info registConfiguration(SOC0109Info configuration) throws BLException{
		if(null!=configuration.getClabel()&&!configuration.getClabel().equals("")){
			checkNotExistConfiguration(configuration.getClabel());
		}
		
		SOC0109TB ctb = getConfigurationTBInstance();
		this.copyProperties(ctb, configuration);

		if (StringUtils.isEmpty(configuration.getCid())) {

			// ��ȡģ��ID
			String eid = configuration.getEid();
			
			// ��ȡģ������ID
			String cid = getNextCid(eid);
			
			if (cid == null) {
				throw new BLException("IGASM0101.E008","ģ�����Ի�����Ϣ");
			} else {
				ctb.setCid(cid);
			}
		}
		
		SOC0109Info ret = soc0109DAO.save(ctb);
		return ret;
	}

	/**
	 * ��ȡģ����������
	 * @param eid
	 * @return
	 */
	private String getNextCid(String eid) {
		
		// ƴдģ������ID
		String cidhead = "CM" + eid.substring(2) + "1";
		// ģ������id
		String cidstr = "";
		
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		cond.setCid_like(cidhead);
		List<SOC0109Info> clist = soc0109DAO.findMaxCidByCond(cond);
		
		// �����ڣ���ȡ���ֵ+1
		if (clist != null && clist.size() > 0) {
			String lastCid = clist.get(0).getCid();
			String serinum = lastCid.substring(11);
			if (serinum.equals("999")) {
				return null;
			}
			String nextnum = String.valueOf(Integer.parseInt(serinum) + 1);
			cidstr = cidhead + StringUtils.leftPad(nextnum, 3, "0");
		} 
		// ���������к���Ϊ001
		else {
			cidstr = cidhead + "001";
		}
		
		return cidstr;
	}

	/**
	 * ɾ���ʲ�ģ��������Ϣ����
	 * 
	 * @param configuration ɾ�����ʲ�ģ��������Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteConfiguration(SOC0109Info configuration) throws BLException{
		checkExistConfiguration(configuration.getCid());
		soc0109DAO.delete(configuration);
	}

	/**
	 * �����ʲ�ģ����������ɾ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cid ɾ���ʲ�ģ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteConfiguration(String cid) throws BLException{
		SOC0109Info ret = checkExistConfiguration(cid);
		soc0109DAO.delete(ret);
	}

	/**
	 * ����ʲ�ģ��������Ϣ����
	 * 
	 * @param configuration ���ǰ���ʲ�ģ��������Ϣ
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException
	 */
	public SOC0109Info updateConfiguration(SOC0109Info configuration) throws BLException{
		checkExistConfiguration(configuration.getCid());
		SOC0109Info ret = soc0109DAO.save(configuration);
		return ret;
	}

	/**
	 * �ʲ�ģ��������Ϣ�����ڼ��
	 * 
	 * @param clabel ���ñ�� 
	 * @return
	 * @throws BLException 
	 */
	protected void checkNotExistConfiguration(String clabel) throws BLException{
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		cond.setClabel(clabel);
		
		List<SOC0109Info> infoList = soc0109DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size() >0 ) {
			throw new BLException(BLErrorType.CONFIGURATION_ALREADY_EXISTS,
					"IGCO10000.E003","�ʲ�ģ������");
		}
	}
	
	/**
	 * �ʲ�ģ��������Ϣ���ڼ��
	 * 
	 * @param cid ����ID
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException 
	 */
	protected SOC0109Info checkExistConfiguration(String cid) throws BLException{
		SOC0109Info info = soc0109DAO.findByPK(cid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�ʲ�ģ������");
		}
		
		return info;
	}

	/**
	 * �����ʲ�ģ����������ɾ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cid ɾ���ʲ�ģ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteConfigurationByKey(String cid) throws BLException {
		SOC0109Info Configuration = checkExistConfiguration(cid);
		soc0109DAO.delete(Configuration);
		
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<SOC0109Info> searchConfiguration(SOC0109SearchCond cond) {
		List<SOC0109Info> ret = soc0109DAO.findByCond(cond,0,0);
		return ret;
	}
}
