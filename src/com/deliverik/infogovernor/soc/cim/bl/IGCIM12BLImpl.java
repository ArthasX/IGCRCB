package com.deliverik.infogovernor.soc.cim.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.asset.EiRelationKeyWords;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM12DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1202Form;


public class IGCIM12BLImpl extends BaseBLImpl implements IGCIM12BL {

	static Log log = LogFactory.getLog(IGCIM12BLImpl.class);

	/** �ʲ���ϢBL */
	protected SOC0117BL soc0117BL;
	
	protected SOC0118BL soc0118BL;
	
	protected SOC0107BL soc0107BL;
	
	protected SOC0119BL soc0119BL;
	
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}
	

	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}


	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}


	
	public void setSoc0119BL(SOC0119BL soc0119BL) {
		this.soc0119BL = soc0119BL;
	}


	/**
	 * <p>
	 * ��ѯEntitiy��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGCIM12DTO searchEntityTreeAction(IGCIM12DTO dto) throws BLException{
		log.debug("========��ѯEntitiy_TREE��ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGCIM1202Form form = dto.getIgcim1202form();

		//String esys = form.getEsyscoding();
		//String eparsys = form.getEparcoding();

		//form.setEparcoding("999");//��1�����(4λ)
		String estatus = form.getEstatus();
		//�����������CI���Ϸ���ʱ����Ҫ�ܹ���ѯ����ͣ�õ�ģ�ͣ�
		if(estatus==null){
			form.setEstatus("1");
		}else{
			form.setEstatus(null);
		}
		String emodeltype_eq = form.getEmodeltype_eq();
		
		if(StringUtils.isNotEmpty(emodeltype_eq)) {
			form.setEmodeltype_eq(null);//�����豣���豸�ʲ�ģ��
			form.setEcategory("001");
		}

		dto.setEntitySearchCond(form);
		
		List<SOC0117Info> entitylist = soc0117BL.searchEntity(dto.getEntitySearchCond(), 0, 0);//��1�����

		for(SOC0117Info entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());

			
			//���õ�ǰ����������(�Ӹü��������)
			form = new IGCIM1202Form();
			form.setSyscoding_q(syscoding);//sql : like 
			//�����������CI���Ϸ���ʱ����Ҫ�ܹ���ѯ����ͣ�õ�ģ�ͣ�
			if(estatus==null){
				form.setEstatus("1");
			}else{
				form.setEstatus(null);
			}
			form.setEkey1(EntityItemKeyWords.ENTITY_EKEY1_0);//�Ѳ���Ҫ��ʾ�Ĺ��˵�
			dto.setEntitySearchCond(form);
			
			//��ѯ���ýڵ㼰�ýڵ��������е�����ڵ�
			List<SOC0117Info> elist = soc0117BL.searchEntity(dto.getEntitySearchCond(), 0, 0);
			//��Ӻ��ӽ��
			int nowlen = elist.get(0).getEsyscoding().length();
			if(StringUtils.isNotEmpty(emodeltype_eq)) {
				getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), true);
			} else {
				getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), false);
			}
			treeNodeMap.put(ptNode.getId(),ptNode);
		}

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��ѯEntitiy_TREE����========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ�ӽ��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param �ü������ϼ����
	 * @param �ü������ϼ�����syscoding�ĳ���
	 * @author duchong@deliverik.com
	 */
	private void getEntityChildTreeNodeMap(List<SOC0117Info> code,TreeNode ptNode,int ptlen,String syscoding, boolean emodeltype){

		List<SOC0117Info> nextcode = getEntityNextLevelNodes(code,ptlen,syscoding, emodeltype);//ȡ�øü�����LIST

		for(int i=0,j=nextcode.size();i<j;i++){
			String syscode = nextcode.get(i).getEsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextcode.get(i).getEid()+"_"+nextcode.get(i).getEsyscoding()+"_"+nextcode.get(i).getEcategory());
			pdNode.setName(nextcode.get(i).getEname());
				
			getEntityChildTreeNodeMap(code,pdNode,syscode.length(),syscode, emodeltype);
			
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}

	}
	
	/**
	 * <p>
	 * ȡ��һlevel�Ľ�㼯��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param ��ǰ����len
	 * @param ��ǰ����syscode
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private List<SOC0117Info> getEntityNextLevelNodes(List<SOC0117Info> code,int levellen,String syscode, boolean emodeltype) {
		
		List<SOC0117Info> detail = new ArrayList<SOC0117Info>();
		for(int i=0,j=code.size();i<j;i++){
			String syscoding = code.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH)
					&& (syscoding.substring(0,syscoding.length()-CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH)).equals(syscode)){
				//domain�����е�CI��ѯֻ��ʾ���ģ��
				if(emodeltype && !"999001".equals(syscoding) && !EiRelationKeyWords.NETDEVICE.equals(syscoding)) {
					if("1".equals(code.get(i).getEmodeltype())) {
						detail.add(code.get(i));
					}
				} else {
					detail.add(code.get(i));
				}
			}
			
		}
		
		return detail;
	}

	public IGCIM12DTO initIGCIM1203Action(IGCIM12DTO dto) throws BLException {

		log.debug("========������Ϣ��ʷ��¼������ڻ�����ʼ========");

		// ��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(Integer.parseInt(dto.getIgcim1203form().getEiid()));

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "");
		}

		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}

		if (StringUtils.isEmpty(dto.getIgcim1203form().getCiversion()+""))
		{
			dto.getIgcim1203form().setCiversion(String.valueOf(
					entityItemVWInfo.getEiversion()));
		}
		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(),entityItemVWInfo);

		if (!flag)
		{
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}
		else
		{
			dto.setFlag(flag);
		}

		// ������Ϣ��ѯ����ȡ��
		//int totalCount = this.soc0107BL.getSOC0107SearchCount(dto.getIgcim1203form());

		dto.getIgcim1203form().setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		//�豸������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(dto.getIgcim1203form());
		
		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
			return dto;
		}

		// ������Ϣȫ������

//		List<SOC0107Info> configItemList = this.soc0107BL.searchSOC0107(dto.getIgcim1203form(), 0, 0);
//		Map<String, List<SOC0107Info>> map = new LinkedHashMap<String, List<SOC0107Info>>();
//		
//		Map<String, String> cldVersionMap=new HashMap<String, String>();//���ʲ��汾����
//		boolean bool=false;
//		for (SOC0107Info e : configItemList)
//		{
//			if("4".equals(e.getConfiguration().getCattach())){
//				String civalue = e.getCivalue();
//				if(StringUtils.isNotEmpty(civalue)){
//					int cldeiid = Integer.parseInt(civalue.substring(civalue.lastIndexOf("(")+1, civalue.length()-1));//���ʲ�eiid
//					
//					SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
//					cond.setPareiid(Integer.parseInt(dto.getIgcim1203form().getEiid()));
//					cond.setCldeiid(cldeiid);
//					if(StringUtils.isNotEmpty(dto.getIgcim1203form().getCiversion())){
//						cond.setParversion(Integer.parseInt(dto.getIgcim1203form().getCiversion()));
//					}
//					cond.setEirinfo("_"+e.getCiid()+"_");
//					cond.setDeleteflag("0");
//					List<SOC0119Info> soc0119Info = soc0119BL.searchEntityItemRelation(cond);
//					String cldversion="";
//					if(soc0119Info!=null&&soc0119Info.size()>0){
//						cldversion = String.valueOf(soc0119Info.get(0).getCldversion());//���ʲ��汾
//					}
//					cldVersionMap.put(String.valueOf(cldeiid), cldversion);
//				}
//			}
//			if (!map.containsKey(e.getConfiguration().getCcategory()))
//			{
//				map.put(e.getConfiguration().getCcategory(),
//						new ArrayList<SOC0107Info>());
//			}
//			//��ͬ�ʲ�ֻ��ʾӦ���Ϊ�յı���
//			if(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT_SYSCODING.equals(entityItemVWInfo.getEsyscoding())){
//				String clabel = e.getConfiguration().getClabel();
//				//��2��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY2.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��3��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY3.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��4��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY4.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��5��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY5.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��6��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY6.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��7��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY7.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��8��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY8.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��9��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY9.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��10��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY10.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��11��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY11.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��12��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY12.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��13��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY13.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��14��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY14.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//��15��
//				if(CommonDefineUtils.ENTIY_COMPACT_ACTUALMONEY15.equals(clabel)&&StringUtils.isEmpty(e.getCivalue())){
//					bool=true;
//				}
//				//�Ѹ���
//				if(CommonDefineUtils.ENTIY_COMPACT_ACCOUNTMONEY.equals(clabel)){
//					bool=false;
//				}
//			}
//			if(bool){
//				continue;
//			}
//			map.get(e.getConfiguration().getCcategory()).add(e);
//		}
//		dto.getIgcim1203form().setCldVersionMap(cldVersionMap);
//		map = new MapKeySort<List<SOC0107Info>>().sort(map, false);
//		dto.setConfigItemMap(map);
		
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(dto.getIgcim1203form());
		Map<String, List<SOC0129Info>> map = new LinkedHashMap<String, List<SOC0129Info>>();
		for (SOC0129Info e : configItemVWInfoList)
		{
			if (!map.containsKey(e.getCcategory()))
			{
				map.put(e.getCcategory(),
						new ArrayList<SOC0129Info>());
			}
			map.get(e.getCcategory()).add(e);
		}
		dto.setSoc0129InfoVWMap(map);
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		log.debug("========������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	
	}


	public IGCIM12DTO initIGCIM1204Action(IGCIM12DTO dto) throws BLException {
		
		log.debug("========�ʲ���������Ϣ�汾�Ƚϻ�����ڻ�����ʼ========");

		// �豸��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(Integer.parseInt(dto.getIgcim1204form().getEiid()));

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "�豸");
		}

		if (entityItemVWInfo.getEiversion() == 0)
		{
			dto.addMessage(new ActionMessage("IGCOM0205.W001"));
		}

		dto.setEntityItemVWInfo(entityItemVWInfo);

		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(),entityItemVWInfo);

		if (!flag)
		{
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}
		else
		{
			dto.setFlag(flag);
		}

		// �豸������Ϣ��ѯ����ȡ��
		int totalCount = this.soc0107BL.getSOC0107SearchCount(dto.getIgcim1204form());

		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
			return dto;
		}

		// �豸������Ϣȫ������

		List<SOC0107Info> configItemList = this.soc0107BL.searchSOC0107(dto.getIgcim1204form(),0,0);
		Map<String, String> cldVersionMap=new HashMap<String, String>();//���ʲ��汾����
		for (SOC0107Info info : configItemList) {
			String cattach = info.getConfiguration().getCattach();
			if("4".equals(cattach)){
				String value = info.getCivalue();
				if(StringUtils.isNotEmpty(value)){
					Integer cldeiid =Integer.parseInt(( value.substring(value.lastIndexOf("(")+1, value.length()-1)));//���ʲ�eiid
					
					SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
					cond.setPareiid(entityItemVWInfo.getEiid());
					cond.setCldeiid(cldeiid);
					cond.setParversion(info.getCiversion());
					cond.setEirinfo("_"+info.getCiid()+"_");
					cond.setDeleteflag("0");
					List<SOC0119Info> soc0119Info = soc0119BL.searchEntityItemRelation(cond);
					String cldversion="";
					if(soc0119Info!=null&&soc0119Info.size()>0){
						cldversion = String.valueOf(soc0119Info.get(0).getCldversion());//���ʲ��汾
					}
					cldVersionMap.put(value+info.getCiversion(), cldversion);
				}
			}
		}
		dto.getIgcim1204form().setCldVersionMap(cldVersionMap);
		dto.setConfigItemList(configItemList);

		dto.setFlag(flag);

		log.debug("========�ʲ���������Ϣ�汾�Ƚϻ�����ڻ���������========");
		return dto;
	
	}
}
