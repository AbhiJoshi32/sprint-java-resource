package com.binktec.sprint_resource.web.controller;

import com.binktec.sprint_resource.web.modal.ShopInfo;
import com.binktec.sprint_resource.web.repository.ShopInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@RestController
@RequestMapping("api/info")
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
public class InfoRest {
    @Autowired
    ShopInfoRepository shopInfoRepository;
    @PreAuthorize("hasRole('ROLE_SHOP')")
    @RequestMapping("/shop")
    public ShopInfo getShopInfo(Principal principal) {
        return shopInfoRepository.findByUsername(principal.getName()).orElse(null);
    }
}