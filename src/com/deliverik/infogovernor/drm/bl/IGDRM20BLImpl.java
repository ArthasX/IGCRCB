package com.deliverik.infogovernor.drm.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.drm.bl.task.SOC0509BL;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2001Form;
import com.deliverik.infogovernor.drm.form.IGDRM2003Form;
import com.deliverik.infogovernor.drm.form.IGDRM2004Form;
import com.deliverik.infogovernor.drm.form.IGDRM2005Form;
import com.deliverik.infogovernor.drm.model.SOC0509Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0509SearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.SOC0509TB;

/**
 * ����: ��������: ������¼: �޸ļ�¼:
 */
public class IGDRM20BLImpl extends BaseBLImpl implements IGDRM20BL {

	static Log log = LogFactory.getLog(IGDRM20BLImpl.class);

	/** ���̶���BL */
	protected SOC0117BL soc0117BL;

	protected SOC0509BL soc0509BL;

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	public void setSoc0509BL(SOC0509BL soc0509bl) {
		soc0509BL = soc0509bl;
	}

	public IGDRM20DTO insertEntityAction(IGDRM20DTO dto) throws BLException {
		log.debug("========�ʲ���Ϣ�ǼǴ���ʼ========");
		IGDRM2001Form form = (IGDRM2001Form) dto.getForm();
		SOC0117TB soc0117tb = new SOC0117TB();
		this.copyProperties(soc0117tb, form);
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(form.getEparcoding());
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond);
		if (entityList != null && entityList.size() > 0) {
			// �ʲ���Ϣ�ǼǴ���
			SOC0117Info soc0117Info = entityList.get(0);
			SOC0117Info entity = this.soc0117BL.registEntity(soc0117tb,
					soc0117Info.getEid());
			dto.setEntity(entity);
			//Copy�ϼ�Ŀ¼���ԣ��൱�ڼ̳У����ڶ�������
			copyConfig(soc0117Info, entity);
		} else {
			// �ʲ���Ϣ�ǼǴ���
			SOC0117Info entity = this.soc0117BL.registEntity(soc0117tb, "");
			dto.setEntity(entity);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I004", "ģ�������Ϣ"));
		log.debug("========�ʲ���Ϣ�ǼǴ�������========");
		return dto;
	}

	public IGDRM20DTO updateEntityAction(IGDRM20DTO dto) throws BLException {
		log.debug("========�ʲ���Ϣ���´���ʼ========");

		// ��ѯ���µ�����Դ
		IGDRM2001Form form = (IGDRM2001Form) dto.getForm();
		String eid = form.getEid();
		SOC0117TB update = (SOC0117TB) SerializationUtils.clone(soc0117BL.searchEntityByKey(eid));
		
		// ��ֵ
		update.setEname(form.getEname());
		update.setEdesc(form.getEdesc());
		
		// �ʲ���Ϣ���´���
		this.soc0117BL.updateEntity(update);

		dto.addMessage(new ActionMessage("IGCO10000.I005", "ģ�ͻ�����Ϣ"));
		log.debug("========�ʲ���Ϣ���´�������========");
		return dto;
	}

	public IGDRM20DTO getPlanSectionTree(IGDRM20DTO dto) throws BLException {
		// ��ȡ����ʵ��
		SOC0117Info entity = dto.getEntity();

		// ��ѯ�½���Ϣ
		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();
		String esyscoding = entity.getEsyscoding();
		cond.setEsyscoding(esyscoding);
		List<SOC0509Info> searchSOC0509 = soc0509BL.searchSOC0509(cond);

		// �����ڵ�
		if (searchSOC0509 == null || searchSOC0509.isEmpty()) {
			searchSOC0509 = new ArrayList<SOC0509Info>();
		}
		SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
		entityCond.setEsyscoding(esyscoding);
		List<SOC0117Info> searchEntity = soc0117BL.searchEntity(entityCond);

		SOC0509TB root = new SOC0509TB();
		if(null != searchEntity && searchEntity.size() > 0){
			SOC0117Info tbRoot = searchEntity.get(0);
			root.setCid("CI" + tbRoot.getEsyscoding());
			root.setPcid("0");
			root.setCname(tbRoot.getEname());
			root.setEid(tbRoot.getEid());
			root.setEsyscoding(tbRoot.getEsyscoding());
			searchSOC0509.add(root);
		}

		// �����½���
		dto.setPlanSectionTree(searchSOC0509);
		return dto;
	}

	public IGDRM20DTO insertSoc0509Info(IGDRM20DTO dto) throws BLException {
		IGDRM2003Form form = (IGDRM2003Form) dto.getForm();
		String eid = form.getEid();
		String esyscoding = form.getEsyscoding();
		String[] pcids = form.getParent_cids();
		String[] names = form.getNode_names();
		String[] attaches = form.getNode_attaches();
		String[] node_cseq = form.getNode_cseq();
		int corder = getNextCorder();
		for(int i=0;i<pcids.length;i++){
			SOC0509TB tb = soc0509BL.getSOC0509TBInstance();
			tb.setCstatus("1");
			tb.setEid(eid);
			tb.setCid(getNextCid(tb.getEid()));
			tb.setEsyscoding(esyscoding);
			tb.setCname(names[i]);
			tb.setPcid(pcids[i]);
			tb.setCattach(attaches[i]);
			tb.setCorder(corder++ + "");
			tb.setCseq(Integer.valueOf(node_cseq[i]));
			soc0509BL.registSOC0509(tb);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I004", "�½���Ϣ"));
		return dto;
	}

	/**
	 * ��ȡģ����������
	 * 
	 * @param eid
	 * @return
	 */
	private String getNextCid(String eid) {

		// ƴдģ������ID
		String cidhead = "CI" + eid.substring(2) + "1";
		// ģ������id
		String cidstr = "";

		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();
		cond.setEid(eid);
		List<SOC0509Info> clist = soc0509BL.searchSOC0509(cond);

		// �����ڣ���ȡ���ֵ+1
		if (clist != null && clist.size() > 0) {
			String lastCid = clist.get(0).getCid();
			String serinum = lastCid.substring(10);
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
	 * ��ȡ������һ��CORDER��ֵ
	 */
	private Integer getNextCorder(){
		return soc0509BL.getNextCorder();
	}
	
	/**
	 * ��������ѯ
	 */
	public IGDRM20DTO searchPlanAction(IGDRM20DTO dto) throws BLException {
		IGDRM2004Form form = (IGDRM2004Form) dto.getForm();
		
		SOC0117SearchCond cond = new SOC0117SearchCondImpl();
		this.copyProperties(cond, form);
		
		int totalCount = soc0117BL.getEntitySearchCount(cond);
		PagingDTO pDto = dto.getPagingDTO();

		dto.setSoc0117List(soc0117BL.searchEntity(cond,
				pDto.getFromCount(), pDto.getPageDispCount()));
		pDto.setTotalCount(totalCount);
		return dto;
	}

	/**
	 * ����ģ��
	 */
	public IGDRM20DTO startAction(IGDRM20DTO dto) throws BLException {
		return changeStatus(dto, "1");
	}

	/**
	 * ����ģ��
	 */
	public IGDRM20DTO stopAction(IGDRM20DTO dto) throws BLException {
		return changeStatus(dto, "2");
	}

	/**
	 * ����ģ��״̬�����û�ͣ�ã�
	 * 
	 * @param dto
	 * @param status
	 * @return
	 * @throws BLException
	 */
	private IGDRM20DTO changeStatus(IGDRM20DTO dto, String status)
			throws BLException {
		IGDRM2004Form form = (IGDRM2004Form) dto.getForm();
		SOC0117TB info = (SOC0117TB) SerializationUtils.clone(soc0117BL
				.searchEntityByKey(form.getEid()));
		info.setEstatus(status);
		soc0117BL.updateEntity(info);
		return dto;
	}

	/**
	 * ��ʼ��Entity
	 */
	public IGDRM20DTO initEntityAction(IGDRM20DTO dto) throws BLException {
		IGDRM2005Form form = (IGDRM2005Form) dto.getForm();
		String eid = form.getEid();
		SOC0117Info info = soc0117BL.searchEntityByKey(eid);
		dto.setEntity(info);
		return dto;
	}

	/**
	 * ɾ��ĳ��Entity�µ�SOC0509
	 */
	public IGDRM20DTO deletePlanOfEntity(IGDRM20DTO dto) throws BLException {
		IGDRM2005Form form = (IGDRM2005Form) dto.getForm();
		String cid = form.getCid();
		soc0509BL.deleteSOC0509ByPK(cid);
		
		// �ݹ�ɾ�������Ӵ��ڵ�
		deletePlanChild(cid);
		return dto;
	}
	
	/**
	 * �ݹ�ɾ���Ӵ��ڵ�
	 * @param pcid
	 */
	private void deletePlanChild(String pcid) throws BLException {
		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();
		cond.setPcid(pcid);
		List<SOC0509Info> children = soc0509BL.searchSOC0509(cond);
		for(int i=0;i<children.size();i++){
			SOC0509Info child = children.get(i);
			soc0509BL.deleteSOC0509(child);
			deletePlanChild(child.getCid());
		}
	}

	/**
	 * ������ĳ��Entity�µ�SOC0509
	 */
	public IGDRM20DTO renamePlanOfEntity(IGDRM20DTO dto) throws BLException {
		IGDRM2005Form form = (IGDRM2005Form) dto.getForm();
		String cid = form.getCid();
		String cname = form.getCname();
		SOC0509TB info;
		info = (SOC0509TB) SerializationUtils.clone(soc0509BL
				.searchSOC0509ByPK(cid));
		info.setCname(cname);
		soc0509BL.updateSOC0509(info);
		return dto;
	}

	/**
	 * ��ʾ�ƶ�eid��Esntity�µ���ϸ�½���Ϣ
	 */
	public IGDRM20DTO getPlanTreeDetail(IGDRM20DTO dto) throws BLException {
		IGDRM2005Form form = (IGDRM2005Form) dto.getForm();
		String eid = form.getEid();
		SOC0117Info info = soc0117BL.searchEntityByKey(eid);
		dto.setEntity(info);
		dto = getPlanSectionTree(dto);
		return dto;
	}

	public IGDRM20DTO initModelAction(IGDRM20DTO dto) throws BLException {
		IGDRM2003Form form = (IGDRM2003Form) dto.getForm();
		String pcid = form.getPcid();
		String eid = form.getEid();

		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();
		
		if(null == eid){// δ������ڵ�
			dto.setModelInfo(soc0509BL.searchSOC0509ByPK(pcid));
		}
		else{// ����˸��ڵ�
			dto.setEntity(soc0117BL.searchEntityByKey(eid));
		}
		
		cond.setPcid(pcid);
		dto.setModelChildrenInfo(soc0509BL.searchSOC0509(cond));
		return dto;
	}

	public IGDRM20DTO initS0C0117EditInfo(IGDRM20DTO dto) throws BLException {
		// Form�Ļ�ȡ
		IGDRM2001Form form = (IGDRM2001Form) dto.getForm();
		
		// ����Ϊ����ģʽ
		form.setMode("1");
		
		// ��ȡ����
		String eid = form.getEid();
		
		// ������Ϣ
		SOC0117Info editInfo = soc0117BL.searchEntityByKey(eid);
		this.copyProperties(form, editInfo);
		
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(editInfo.getEparcoding());
		List<SOC0117Info> parInfo = soc0117BL.searchEntity(cond);
		if(null != parInfo && parInfo.size()>0){
			form.setEparname(parInfo.get(0).getEname());
		} else {
			form.setEparname("<δ֪>");
			log.debug("==============δ�ҵ�esyscodingΪ" + editInfo.getEparcoding() + "��Ԥ����Ϣ==============");
		}
		
		return dto;
	}

	public IGDRM20DTO copyAction(IGDRM20DTO dto) throws BLException {
		IGDRM2004Form form = (IGDRM2004Form)dto.getForm();
		String eid = form.getEid();
		//---ģ��copy
		//��ѯҪ������Entity��Ϣ
		SOC0117Info soc0117Info = soc0117BL.searchEntityByKey(eid);
		SOC0117TB newSOC0117tb = (SOC0117TB) SerializationUtils.clone(soc0117Info);
		newSOC0117tb.setEname(soc0117Info.getEname()+"_New");
		//��ѯ�ϼ��ʲ�������Ϣ
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(soc0117Info.getEparcoding());
		List<SOC0117Info> searchParEntity = soc0117BL.searchEntity(cond);
		//���������ʲ���Ϣ
		SOC0117Info registEntity = soc0117BL.registEntity(newSOC0117tb, searchParEntity.get(0).getEid());
		dto.setEntity(registEntity);
		
		//---������copy
		copyConfig(soc0117Info, registEntity);
		dto.addMessage(new ActionMessage("IGCO10000.I003","���Ƴɹ�"));
		return dto;
	}

	private void copyConfig(SOC0117Info soc0117Info, SOC0117Info registEntity) throws BLException {
		SOC0509SearchCondImpl soc0509Cond = new SOC0509SearchCondImpl();
		soc0509Cond.setEsyscoding(soc0117Info.getEsyscoding());
		List<SOC0509Info> searchSOC0509List = soc0509BL.searchSOC0509(soc0509Cond);
		if(searchSOC0509List != null && !searchSOC0509List.isEmpty()){
			//��ԭ�е����Է�װΪMap<PCID,List<����>>
			Map<String, List<SOC0509Info>> pcidKeySoc0509Map = new HashMap<String, List<SOC0509Info>>();
			for (SOC0509Info soc0509Info : searchSOC0509List) {
				List<SOC0509Info> soc0509List = new ArrayList<SOC0509Info>();
				if(pcidKeySoc0509Map.containsKey(soc0509Info.getPcid())){
					soc0509List = pcidKeySoc0509Map.get(soc0509Info.getPcid());
				}
				soc0509List.add(soc0509Info);
				pcidKeySoc0509Map.put(soc0509Info.getPcid(), soc0509List);
			}
			Set<String> pcidSet = pcidKeySoc0509Map.keySet();
			for (String pcid : pcidSet) {
				//����������½�
				if(pcid.indexOf(soc0117Info.getEsyscoding()) != -1){
					List<SOC0509Info> list = pcidKeySoc0509Map.get(pcid);
					for (SOC0509Info soc0509Info : list) {
						SOC0509TB newSOC0509tb = (SOC0509TB) SerializationUtils.clone(soc0509Info);
						newSOC0509tb.setCid(getNextCid(registEntity.getEid()));
						newSOC0509tb.setEid(registEntity.getEid());
						newSOC0509tb.setEsyscoding(registEntity.getEsyscoding());
						newSOC0509tb.setPcid(pcid.replace(soc0117Info.getEsyscoding(), registEntity.getEsyscoding()));
						SOC0509Info newSOC0509Info = soc0509BL.registSOC0509(newSOC0509tb);
						//�����¼� �ݹ�
						updateSoc0509InfoByRecursion(pcidKeySoc0509Map,soc0509Info, newSOC0509Info);
					}
				}
			}
		}
	}
	
	//�ݹ�����½���Ϣ
	private void updateSoc0509InfoByRecursion(Map<String, List<SOC0509Info>> soc0509Map,SOC0509Info oldSoc0509Info,SOC0509Info parSoc0509Info) throws BLException{
		if(soc0509Map.containsKey(oldSoc0509Info.getCid())){
			List<SOC0509Info> nextSoc0509List = soc0509Map.get(oldSoc0509Info.getCid());
			for (SOC0509Info soc0509Info : nextSoc0509List) {
				SOC0509TB newSOC0509tb = (SOC0509TB) SerializationUtils.clone(soc0509Info);
				newSOC0509tb.setCid(getNextCid(parSoc0509Info.getEid()));
				newSOC0509tb.setPcid(parSoc0509Info.getCid());
				newSOC0509tb.setEid(parSoc0509Info.getEid());
				newSOC0509tb.setEsyscoding(parSoc0509Info.getEsyscoding());
				SOC0509Info registSOC0509 = soc0509BL.registSOC0509(newSOC0509tb);
				//�ݹ� ����
				updateSoc0509InfoByRecursion(soc0509Map,soc0509Info, registSOC0509);
			}
		}
	}

	public IGDRM20DTO sortSoc0509Action(IGDRM20DTO dto) throws BLException {
		IGDRM2003Form form = (IGDRM2003Form) dto.getForm();
		String pcid = form.getPcid();
		String[] cids = form.getSort_cids();
		
		// ��ѯǰ̨˳�����Ϣ
		List<SOC0509TB> infos = new ArrayList<SOC0509TB>();
		for(String cid : cids){
			infos.add(getSOC0509ByPK(cid));
		}
		
		// ��ѯ���ݿ���Ϣ
		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();
		cond.setPcid(pcid);
		List<SOC0509Info> oldInfos = soc0509BL.searchSOC0509(cond);
		
		// corderֵ���滻
		for(int i=0;i<infos.size();i++){
			SOC0509TB tb = infos.get(i);
			tb.setCorder(oldInfos.get(i).getCorder());
		}
		
		// �Ȼ�ֵ����£� ����corderֵ�򸲸Ƕ���ʧ
		for(SOC0509TB tb : infos){
			soc0509BL.updateSOC0509(tb);
		}
		return dto;
	}
	
	private SOC0509TB getSOC0509ByPK(String pk) throws BLException{
		return (SOC0509TB) SerializationUtils.clone(soc0509BL.searchSOC0509ByPK(pk));
	}
}
