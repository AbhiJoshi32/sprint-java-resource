package com.binktec.sprint_resource.web.repository;

import com.binktec.sprint_resource.web.modal.Price;
import com.binktec.sprint_resource.web.modal.Service;
import com.binktec.sprint_resource.web.modal.ShopInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Collection;

@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SHOP')")
@RepositoryRestResource(collectionResourceRel = "price", path = "price")
public interface PriceRepository extends PagingAndSortingRepository<Price, Long> {
    Collection<Price> findByShopInfo_Username(@Param("username") String shopInfo_username);
}