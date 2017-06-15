package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0109VWDAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0109VW;
import com.deliverik.framework.utility.BLErrorType;


/**
 * <p>
 * �ʲ�ģ������ҵ���߼�ʵ��
 * </p>
 */
public class SOC0109VWBLImpl extends BaseBLImpl implements SOC0109VWBL {

	/** Configuration DAO */
	protected SOC0109VWDAO soc0109VWDAO;
	
	/** �ʲ�ģ��BL */
	protected SOC0117VWBL soc0117VWBL;

	/**
	 * @param soc0109vwdao the soc0109VWDAO to set
	 */
	public void setSoc0109VWDAO(SOC0109VWDAO soc0109vwdao) {
		soc0109VWDAO = soc0109vwdao;
	}

	/**
	 * @param soc0117vwbl the soc0117VWBL to set
	 */
	public void setSoc0117VWBL(SOC0117VWBL soc0117vwbl) {
		soc0117VWBL = soc0117vwbl;
	}

	/**
	 * <p>
	 * �µ��ʲ�ģ��������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�ģ��������Ϣ����ʵ��ȡ��
	 */

	public SOC0109VW getConfigurationTBInstance() {
		return new SOC0109VW();
	}

	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @return �ʲ�ģ��������Ϣ����
	 */
	public int getConfigurationSearchCount(SOC0109VWSearchCond cond){

		return soc0109VWDAO.getSearchCount(cond);
	}

	/**
	 * �����ʲ�ģ����������ȡ���ʲ�ģ��������Ϣ
	 * 
	 * @param cid �ʲ�ģ����������
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException 
	 */
	public SOC0109VWInfo searchConfigurationByKey(String cid) throws BLException{

		return checkExistConfiguration(cid);
	}

	/**
	 * ȡ�ø��ʲ�ģ�͵�ģ��������Ϣ
	 * 
	 * @param list �ʲ�ģ�ͼ���
	 * @param cseq �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ���ԣ�0����ʾ��null����ȫ�����ԣ�
	 * @return ���ʲ�ģ�͵�ģ��������Ϣ
	 */
	public Map<String,List<SOC0109VWInfo>> searchConfiguration(List<SOC0117VWInfo> list,Integer cseq){
		Map<String,List<SOC0109VWInfo>> map = new LinkedHashMap<String,List<SOC0109VWInfo>>();
		SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
		if(cseq!=null){
			cond.setCseq(cseq);//�����Ƿ���ʾ��1������ʾ���ԣ�0������ʾ
		}
		//�ʲ�������Ϣ�ֲ�β�ѯ
		for(SOC0117VWInfo e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109VWInfo> configurationList = soc0109VWDAO.findByCond(cond, 0, 0);
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
	public List<SOC0109VWInfo> searchConfigurationByEid(String eid) throws BLException{
		List<SOC0117VWInfo> list = soc0117VWBL.getParentNodes(eid);
		List<SOC0109VWInfo> configlist = new ArrayList<SOC0109VWInfo>();
		SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
		cond.setCstatus("1");//1����
		//�ʲ�������Ϣ�ֲ�β�ѯ
		for(SOC0117VWInfo e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109VWInfo> configurationList = soc0109VWDAO.findByCond(cond, 0, 0);
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
	public List<SOC0109VWInfo> searchConfiguration(SOC0109VWSearchCond cond, int start, int count){

		List<SOC0109VWInfo> ret = soc0109VWDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * �����ʲ�ģ��������Ϣ����
	 * 
	 * @param configuration �ʲ�ģ��������Ϣ
	 * @return �������ʲ�ģ��������Ϣ
	 * @throws BLException
	 */
	public SOC0109VWInfo registConfiguration(SOC0109VWInfo configuration) throws BLException{
		if(null!=configuration.getClabel()&&!configuration.getClabel().equals("")){
			checkNotExistConfiguration(configuration.getClabel());
		}
		
		SOC0109VW ctb = getConfigurationTBInstance();
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
		
		SOC0109VWInfo ret = soc0109VWDAO.save(ctb);
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
		
		SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
		cond.setCid_like(cidhead);
		List<SOC0109VWInfo> clist = soc0109VWDAO.findMaxCidByCond(cond);
		
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
	public void deleteConfiguration(SOC0109VWInfo configuration) throws BLException{
		checkExistConfiguration(configuration.getCid());
		soc0109VWDAO.delete(configuration);
	}

	/**
	 * �����ʲ�ģ����������ɾ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cid ɾ���ʲ�ģ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteConfiguration(String cid) throws BLException{
		SOC0109VWInfo ret = checkExistConfiguration(cid);
		soc0109VWDAO.delete(ret);
	}

	/**
	 * ����ʲ�ģ��������Ϣ����
	 * 
	 * @param configuration ���ǰ���ʲ�ģ��������Ϣ
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException
	 */
	public SOC0109VWInfo updateConfiguration(SOC0109VWInfo configuration) throws BLException{
		checkExistConfiguration(configuration.getCid());
		SOC0109VWInfo ret = soc0109VWDAO.save(configuration);
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
		SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
		cond.setClabel(clabel);
		
		List<SOC0109VWInfo> infoList = soc0109VWDAO.findByCond(cond, 0, 0);
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
	protected SOC0109VWInfo checkExistConfiguration(String cid) throws BLException{
		SOC0109VWInfo info = soc0109VWDAO.findByPK(cid);
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
		SOC0109VWInfo Configuration = checkExistConfiguration(cid);
		soc0109VWDAO.delete(Configuration);
		
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<SOC0109VWInfo> searchConfiguration(SOC0109VWSearchCond cond) {
		List<SOC0109VWInfo> ret = soc0109VWDAO.findByCond(cond,0,0);
		return ret;
	}
}
