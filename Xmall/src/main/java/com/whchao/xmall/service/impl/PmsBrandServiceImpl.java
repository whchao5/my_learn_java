package com.whchao.xmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.whchao.xmall.mbg.mapper.PmsBrandMapper;
import com.whchao.xmall.mbg.model.PmsBrand;
import com.whchao.xmall.mbg.model.PmsBrandExample;
import com.whchao.xmall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Resource
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {

        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    @Transactional
    public int createBrand(PmsBrand pmsBrand) {

        return pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {

        brand.setId(id);
        return pmsBrandMapper.updateByPrimaryKeySelective(brand);
    }
    @Override
    public int deleteBrand(Long id) {

        return pmsBrandMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());

    }
    @Override
    public PmsBrand getBrand(Long id) {

        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
