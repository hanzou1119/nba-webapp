package com.example.nba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;           //名前
    private Integer jerseyNumber;  //背番号
    private String team;           //チーム
    private String position;      //ポジション
    private Integer heightCm;     //身長cm
    private Integer weightKg;     //体重kg
    private String country;       //出身国
    private String imageUrl;      //写真URL
}