package com.projectjavasem4.service;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import com.projectjavasem4.entities.ColorEntity;
import com.projectjavasem4.entities.ProductDetailEntity;
import com.projectjavasem4.entities.ProductEntity;
import com.projectjavasem4.entities.SizeEntity;
import com.projectjavasem4.repository.ColorRepository;
import com.projectjavasem4.repository.ProductDetailRepository;
import com.projectjavasem4.repository.ProductRepository;
import com.projectjavasem4.repository.SizeRepository;

@SessionScope  // name= scopedTarget.cartService
@Service
public class CartService2 {

	@Autowired private	ProductDetailRepository proDetailRep;
	@Autowired private  ColorRepository colorRep;
	@Autowired private  SizeRepository sizeRep;
	@Autowired private  ProductRepository proRep;
	
	Map<Long, ProductDetailEntity> map = new HashMap<>();
	DecimalFormat decimalFormat = new DecimalFormat("###.###"); 
	
    public boolean add(int quantity,Long idSize,Long idColor,Long idProduct) {
		ColorEntity findColor = colorRep.findOne(idColor);
		SizeEntity findSize = sizeRep.findOne(idSize);
		ProductEntity findPro=proRep.findOne(idProduct);	
		ProductDetailEntity ProDetailCheck= proDetailRep.findProIdsizeAndIdColor(findSize.getId(), findColor.getId(), findPro.getId());
		Long idProDetailCheck=ProDetailCheck.getId();	
		ProductDetailEntity p = map.get(idProDetailCheck);	
		if (p == null) { //nếu chưa có trong giỏ
			p=proDetailRep.findOne(idProDetailCheck);
			p.setQuantity_order(quantity);
			map.put(p.getId(), p);
			return true;
		} else {  //đã có trong giỏ
			//  nếu k muốn check sp đã tồn tại trong giỏ hàng chưa thì update số lượng
			//p.setQuantity_order(p.getQuantity_order()+quantity);
			return false;
		}
	}
	
	public void updateQuantity(long id, int quantity) {
		ProductDetailEntity p = map.get(id);
		p.setQuantity_order(quantity);
	}
	
	public void updateAttribute(long id,long idSize,long idColor) {
		ProductDetailEntity p = map.get(id);
		p.setSize(sizeRep.findOne(idSize));
		p.setColor(colorRep.findOne(idColor));
	}

	public void remove(long id) {
    	map.remove(id);
	}

	public Collection<ProductDetailEntity> getAll() {
		Collection<ProductDetailEntity> result = new ArrayList<ProductDetailEntity>();
		Collection<ProductDetailEntity> listProDetailMap = map.values();		
		//duyệt tất cả n phần tử trong list proDetail lấy ra n phần tử proEntity và set Group color và size	
		for (ProductDetailEntity detail : listProDetailMap) {		
			ProductEntity p = proRep.findOne(detail.getProduct().getId());		
				List<ProductDetailEntity> colorGroup = proDetailRep.colorGroup(p.getId());
				List<ProductDetailEntity> sizeGroup = proDetailRep.sizeGroup(p.getId());
				p.setProduct_detailGroupByColor(colorGroup);
				p.setProduct_detailGroupBySize(sizeGroup);
				
			detail.setProduct(p);			
			result.add(detail);	
		}	
		return result;
	}

	public int getTotalItems() {
		return map.size();
	}

	public String getTotalPrice() {
		Collection<ProductDetailEntity> l = this.getAll();
		double count = 0;
		for (ProductDetailEntity p : l) {
			count += (p.getProduct().getPrice() * p.getQuantity_order() * ((100 - p.getProduct().getDiscount()))) / 100;
		}	
		return decimalFormat.format(count);
	}

	public void clear() {
		map.clear();
	}

	public String getPriceByCheckboxChecked(long[] ids) {
		double price = 0;
			for (int i = 0; i < ids.length ; i++) {
				ProductDetailEntity p= map.get(ids[i]);
				price += (p.getProduct().getPrice() * p.getQuantity_order() * ((100 - p.getProduct().getDiscount()))) / 100;
			} 	
		return decimalFormat.format(price);
	}
}
