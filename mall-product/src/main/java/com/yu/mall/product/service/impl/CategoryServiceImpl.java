package com.yu.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.common.utils.PageUtils;
import com.yu.common.utils.Query;
import com.yu.mall.product.dao.CategoryBrandRelationDao;
import com.yu.mall.product.dao.CategoryDao;
import com.yu.mall.product.entity.CategoryEntity;
import com.yu.mall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
    @Autowired
    private CategoryBrandRelationDao categoryBrandRelationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //2、组装成父子的树形结构：cat_level
        /**
         * stream: list.stream()获取流：(当只有一个参数时，参数括号可以省略，当只有一行代码，return和{}还有后面的;可以省略)
         *      1、过滤操作(filter)： 2、遍历操作(map) 3、排序操作(sorted)
         */
        List<CategoryEntity> level1Menus = entities.stream()
                .filter(categoryEntity -> categoryEntity.getCatLevel() == 1) //筛选所有的一级分类
                .map(categoryEntity -> {
                    categoryEntity.setChildren(getChildren(categoryEntity, entities));
                    return categoryEntity;
                })
                .sorted((obj1, obj2) -> {
                    return (obj1.getSort() == null ? 0 : obj1.getSort()) - (obj2.getSort() == null ? 0 : obj2.getSort());
                })
                .collect(Collectors.toList());

        return level1Menus;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 1、检查当前删除的菜单，是否被别的地方调用

        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] getCatelogPath(Long attrGroupId) {
        List<Long> path = new ArrayList();

        path = getParentCateId(path, attrGroupId);

        Collections.reverse(path);

        return path.toArray(new Long[path.size()]);
    }

    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        if(!StringUtils.isEmpty(category.getName())){
            //更新关联表的信息
            categoryBrandRelationDao.updateCategory(category.getCatId(), category.getName());
        }
    }

    /**
     * 递归获取当前对象的父分类id
     */
    private List getParentCateId(List<Long> path, Long attrGroupId) {
        //收集当前传入id
        path.add(attrGroupId);
        //根据id查找父id
        CategoryEntity selectById = baseMapper.selectById(attrGroupId);
        if(selectById.getParentCid() != 0){
            getParentCateId(path, selectById.getParentCid());
        }
        return path;
    }


    /**
     * 递归获取当前对象的子菜单
     *
     * @param root
     * @param all
     * @return
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        /*if(root.getCatLevel() == 3){
            return null;
        }*/
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            //判断两个Long类型是否相等不能用==(如果Long的值在[-127,128]之间可以)，不在范围之间可以用A.equals(B)或A.longValue()==B.longValue()
            return categoryEntity.getParentCid().equals(root.getCatId());   //找出第一层子菜单
        }).map(categoryEntity -> { //如果子菜单下面还存在子菜单，遍历找第二层子菜单
            categoryEntity.setChildren(getChildren(categoryEntity, all));
            return categoryEntity;
        }).sorted((t1, t2) -> Integer.compare((t1.getSort() == null ? 0 : t1.getSort()), (t2.getSort() == null ? 0 : t2.getSort())))
                .collect(Collectors.toList());

        return children;
    }

}