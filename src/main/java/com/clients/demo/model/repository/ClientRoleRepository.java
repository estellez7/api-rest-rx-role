package com.clients.demo.model.repository;

import com.clients.demo.model.entity.ClientRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// DAO
@Repository
public interface ClientRoleRepository extends JpaRepository<ClientRoleEntity, Integer> {

    ClientRoleEntity findByClientIdAndRoleId(Integer clientId, Integer roleId);

    @Transactional
    void deleteByRoleId(Integer roleId);
}
