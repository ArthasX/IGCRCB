package com.csebank.items.bl.task;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.ItemsCategory;
import com.csebank.items.model.condition.ItemsCategorySearchCond;
import com.csebank.items.model.condition.ItemsCategorySearchCondImpl;
import com.csebank.items.model.dao.ItemsCategoryTBDAO;
import com.deliverik.framework.base.BaseBLImpl;

public class ItemsCategoryBLImpl extends BaseBLImpl implements ItemsCategoryBL{
	
	private ItemsCategoryTBDAO itemsCategoryTBDAO;

	public void setItemsCategoryTBDAO(ItemsCategoryTBDAO itemsCategoryTBDAO) {
		this.itemsCategoryTBDAO = itemsCategoryTBDAO;
	}

	public List<ItemsCategory> searchItemsCategory(ItemsCategorySearchCond cond, int start, int count) {
		List<ItemsCategory> itemsCategoryList = itemsCategoryTBDAO.findByCond(cond, 0, 0);
		return itemsCategoryList;
	}

	public ItemsCategory insertItemsCategory(ItemsCategory itemsCategory) {
		if(isExistItemsCategory(itemsCategory)){
			return null;
		}
		return itemsCategoryTBDAO.save(itemsCategory);
	}

	public ItemsCategory findItemsCategoryByPk(Serializable icid) {
		return itemsCategoryTBDAO.findByPK(icid);
	}

	private boolean isExistItemsCategory(ItemsCategory itemsCategory) {
		if(itemsCategory.getIcid() == null || itemsCategory.getIcid() == 0){ //ÐÂÔö
			ItemsCategorySearchCondImpl cond = new ItemsCategorySearchCondImpl();
			cond.setCategory(itemsCategory.getCategory());
			cond.setSeqcode(itemsCategory.getSeqcode());
			List<ItemsCategory> itemsCategoryList = itemsCategoryTBDAO.findByCond(cond, 0, 0);
			if(itemsCategoryList == null || itemsCategoryList.size() == 0){
				return false;
			}
		} else { //ÐÞ¸Ä
			String oldseq = itemsCategoryTBDAO.findByPK(itemsCategory.getIcid()).getSeqcode();
			String newseq = itemsCategory.getSeqcode();
			if(oldseq.equals(newseq)){
				return false;
			} else {
				ItemsCategorySearchCondImpl cond = new ItemsCategorySearchCondImpl();
				cond.setCategory(itemsCategory.getCategory());
				cond.setSeqcode(itemsCategory.getSeqcode());
				List<ItemsCategory> itemsCategoryList = itemsCategoryTBDAO.findByCond(cond, 0, 0);
				if(itemsCategoryList == null || itemsCategoryList.size() == 0){
					return false;
				}
			}
		}
		return true;
	}

}
