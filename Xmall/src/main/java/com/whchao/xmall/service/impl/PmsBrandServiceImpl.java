package com.whchao.xmall.service.impl;

import com.whchao.xmall.mbg.mapper.PmsBrandMapper;
import com.whchao.xmall.mbg.model.PmsBrand;
import com.whchao.xmall.mbg.model.PmsBrandExample;
import com.whchao.xmall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Resource
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {

//        return null;
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    public int createBrand(PmsBrand pmsBrand) {

        return pmsBrandMapper.insertSelective(pmsBrand);
    }
}
