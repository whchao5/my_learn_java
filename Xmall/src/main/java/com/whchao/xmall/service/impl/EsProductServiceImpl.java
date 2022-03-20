package com.whchao.xmall.service.impl;

import com.whchao.xmall.dao.EsProductDao;
import com.whchao.xmall.nosql.elasticsearch.document.EsProduct;
import com.whchao.xmall.nosql.elasticsearch.repository.EsProductRepository;
import com.whchao.xmall.service.EsProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EsProductServiceImpl implements EsProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsProductServiceImpl.class);
    @Resource
    private EsProductDao esProductDao;
    @Autowired
    private EsProductRepository esProductRepository;


    /**
     * 从数据库中导入所有商品到ES
     */
    @Override
    public int importAll() {
        List<EsProduct> esProductList = esProductDao.getAllEsProductList(null);

        System.out.println(esProductList);

        Iterable<EsProduct> esProductIterable = esProductRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }

//        Iterable<EsProduct> esProducts = esProductList.iterator();
//        Iterator<EsProduct> iterator1 = esProducts.iterator();

        return result;
    }

    /**
     * 根据id删除商品
     */
    @Override
    public void delete(Long id) {
        esProductRepository.deleteById(id);
    }

    /**
     * 根据id创建商品
     */
    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> esProductList = esProductDao.getAllEsProductList(id);
        if (esProductList.size() > 0) {
            EsProduct esProduct = esProductList.get(0);
            result = esProductRepository.save(esProduct);
        }

        return  result;
    }

    /**
     * 批量删除商品
     */
    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsProduct> esProductList = new ArrayList<>();
            for (Long id : ids) {
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            }
            esProductRepository.deleteAll(esProductList);
        }
    }

    /**
     * 根据关键字搜索名称或者副标题
     */
    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return esProductRepository.findByNameOrSubTitleOrKeywords(keyword,keyword,keyword,pageable);
    }
}
