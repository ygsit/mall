package com.yu.mall.product;

import com.yu.mall.product.entity.BrandEntity;
import com.yu.mall.product.service.BrandService;
import com.yu.mall.product.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class MallProductApplicationTests {

	@Autowired
	private BrandService brandService;

	@Autowired
	private CategoryService categoryService;

	@Test
	public void  getCatelogPath(){
		Long[] catelogPath = categoryService.getCatelogPath(225L);
		System.out.println(Arrays.asList(catelogPath));
	}

	@Test
	void contextLoads() {
		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setName("华为");
//		brandService.save(brandEntity);
//		System.out.println("添加成功");

		brandEntity.setBrandId(1L);
		brandEntity.setDescript("华为");
		brandService.updateById(brandEntity);
		System.out.println("修改成功");
	}

}
