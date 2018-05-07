package com.binktec.sprint_resource.web.repository;

import com.binktec.sprint_resource.web.modal.ShopInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RepositoryRestResource(collectionResourceRel = "shop_info", path = "shop_info")
public interface ShopInfoRepository extends JpaRepository<ShopInfo, Long> {
    Optional<ShopInfo> findByUsername(@Param("username") String username);
}