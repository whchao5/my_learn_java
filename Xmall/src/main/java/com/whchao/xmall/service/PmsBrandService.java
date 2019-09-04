package com.whchao.xmall.service;

import com.whchao.xmall.mbg.model.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand pmsBrand);
}
