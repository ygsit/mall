package com.yu.mall.product;

import com.yu.mall.product.entity.BrandEntity;
import com.yu.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallProductApplicationTests {

	@Autowired
	private BrandService brandService;

	@Test
	void contextLoads() {
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setBrandId(1L);
		brandEntity.setDescript("华为");

//		brandEntity.setName("华为");
//		brandService.save(brandEntity);
//		System.out.println("添加成功");

		brandService.updateById(brandEntity);
		System.out.println("修改成功");
	}

}
