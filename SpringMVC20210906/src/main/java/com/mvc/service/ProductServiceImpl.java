package com.mvc.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.mvc.entity.product.Group;
import com.mvc.entity.product.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	//�غc�l�@�ι�@
	{
		if( groups.size() == 0 ) {
			groups.put(1, new Group(11, "A"));
			groups.put(2, new Group(21, "B"));
			groups.put(3, new Group(31, "C"));
		}
	}
	
	
	@Override
	public List<Product> query() {
		return products;
	}

	@Override
	public Product get(String name) {
		Optional<Product> opt = products.stream()
										.filter(p -> p.getName().equals(name))
										.findAny();
		
		return opt.isPresent()? opt.get() : null ;
	}

	@Override
	public boolean save(Product product) {
		//�ھ�group.gid ��� group����
		//�N�ק粒��group �b��i�h products
		String name = groups.entrySet().stream()
							.filter(g -> g.getValue().getGid() == product.getGroup().getGid() )
							.findAny().get().getValue().getGname();
		product.getGroup().setGname(name);  
		products.add(product);
		return false;
	}

	@Override
	public boolean update(Product product) {
		//	�O�_�������
		Product oldProduct = get(product.getName());
		if(oldProduct == null) {
			return false;
		}
		//�i���s
		oldProduct = product;
		return true;
	}

	@Override
	public boolean delete(String name) {
		return products.removeIf(p -> p.getName().equals(name));
	}

}
