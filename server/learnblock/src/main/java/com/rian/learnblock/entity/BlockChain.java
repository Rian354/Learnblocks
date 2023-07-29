package com.rian.learnblock.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "blockchain")
public class BlockChain {

    @Id
    private int id;
    private int code;
    private int lastcode;

    private String comments;
}
