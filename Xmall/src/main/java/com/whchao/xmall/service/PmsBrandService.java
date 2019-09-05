package com.whchao.xmall.service;

import com.whchao.xmall.mbg.model.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand pmsBrand);


    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int PageNum, int PageSize);

    PmsBrand getBrand(Long id);
}
