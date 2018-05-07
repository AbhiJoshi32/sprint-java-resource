package com.binktec.sprint_resource.web.repository;

import com.binktec.sprint_resource.web.modal.PrintBinding;
import com.binktec.sprint_resource.web.modal.ShopInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Collection;

@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SHOP')")
@RepositoryRestResource(collectionResourceRel = "binding_info", path = "binding_info")
public interface PrintBindingRepository extends PagingAndSortingRepository<PrintBinding, Long> {
    Collection<PrintBinding> findByName(@Param("name") String name);
}
