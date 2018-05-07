package com.binktec.sprint_resource.web.controller;


import com.binktec.sprint_resource.web.modal.ShopTransaction;
import com.binktec.sprint_resource.web.repository.ShopInfoRepository;
import com.binktec.sprint_resource.web.repository.ShopTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("api/shop/shop_trans")
@PreAuthorize("hasRole('ROLE_SHOP') or hasRole('ROLE_ADMIN')")
public class ShopTransactionRest {
    @Autowired
    ShopTransactionRepository shopTransactionRepository;
    @Autowired
    ShopInfoRepository shopInfoRepository;

    @RequestMapping(method = RequestMethod.POST,value = "/print")
    public void newTrans(@RequestBody ShopTransaction shopTransaction) {
        shopTransaction.setPrintedTime(Calendar.getInstance());
        shopTransaction.setStatus(1);
        shopTransactionRepository.save(shopTransaction);
    }

    @RequestMapping(value = "/ongoing")
    public List<ShopTransaction> getOngoing(Principal principal) {
        String username = principal.getName();
        return shopTransactionRepository.findByShopInfo_UsernameAndStatus(username,0);
    }

    @RequestMapping(value = "/printed")
    public List<ShopTransaction> getPrinted(Principal principal) {
        String username = principal.getName();
        return shopTransactionRepository.findByShopInfo_UsernameAndStatus(username,1);
    }
}