/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.dto;

import com.steevelinformaticien.core.entity.Match;

import javax.persistence.*;

/**
 *
 * @author PEPECELL
 */
public class ScoreFullDto {
    private Long id;
    private Byte set1;

    private Byte set2;

    private Byte set3;

    private Byte set4;

    private Byte set5;

    private MatchDto matchDto;


    public ScoreFullDto(Long id, Byte set1, Byte set2, Byte set3, Byte set4) {
        this.id = id;
        this.set1 = set1;
        this.set2 = set2;
        this.set3 = set3;
        this.set4 = set4;
    }

    public ScoreFullDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getSet1() {
        return set1;
    }

    public void setSet1(Byte set1) {
        this.set1 = set1;
    }

    public Byte getSet2() {
        return set2;
    }

    public void setSet2(Byte set2) {
        this.set2 = set2;
    }

    public Byte getSet3() {
        return set3;
    }

    public void setSet3(Byte set3) {
        this.set3 = set3;
    }

    public Byte getSet4() {
        return set4;
    }

    public void setSet4(Byte set4) {
        this.set4 = set4;
    }

    public Byte getSet5() {
        return set5;
    }

    public void setSet5(Byte set5) {
        this.set5 = set5;
    }

    public MatchDto getMatchDto() {
        return matchDto;
    }

    public void setMatchDto(MatchDto matchDto) {
        this.matchDto = matchDto;
    }
}
