package com.rian.learnblock.repository;

import com.rian.learnblock.entity.BlockChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BlockChainRepository extends JpaRepository<BlockChain, Object> {

    @Query(value = "SELECT * FROM BlockChain b order by ID desc LIMIT 1", nativeQuery = true)
    BlockChain getLastBlockCode();

}
