package com.binktec.sprint_resource.web.controller;


import com.binktec.sprint_resource.web.modal.ShopTransaction;
import com.binktec.sprint_resource.web.repository.ShopTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("api/user/shop_trans")
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
public class UserTransactionRest {
    @Autowired
    ShopTransactionRepository shopTransactionRepository;

    @RequestMapping(method = RequestMethod.POST,value = "/")
    public void newTrans(@RequestBody ShopTransaction shopTransaction) {
        shopTransaction.setIssueTime(Calendar.getInstance());
        shopTransaction.setStatus(0);
        shopTransaction.setPrintedTime(null);
        shopTransactionRepository.save(shopTransaction);
    }

    @RequestMapping(value = "/ongoing")
    public List<ShopTransaction> getOngoing(Principal principal) {
        String username = principal.getName();
        return shopTransactionRepository.findByClientUsernameAndStatus(username,0);
    }

    @RequestMapping(value = "/printed")
    public List<ShopTransaction> getPrinted(Principal principal) {
        String username = principal.getName();
        return shopTransactionRepository.findByClientUsernameAndStatus(username,1);
    }



//    @RequestMapping(method = RequestMethod.POST,value = "/printed")

}
