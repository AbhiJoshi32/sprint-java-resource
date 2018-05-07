package com.binktec.sprint_resource.web.repository;

import com.binktec.sprint_resource.web.modal.ShopInfo;
import com.binktec.sprint_resource.web.modal.ShopTransaction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ShopTransactionRepository extends PagingAndSortingRepository<ShopTransaction, Long> {
    public List<ShopTransaction> findByShopInfo_Username(String username);
    public List<ShopTransaction> findByShopInfo_UsernameAndStatus(@Param("username")String username,@Param("status") int Status);
    public List<ShopTransaction> findByClientUsernameAndStatus(@Param("username")String username,@Param("status") int Status);
}