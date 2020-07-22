package com.producer.cdm.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.time.LocalDateTime;

/**
 * member 들은 keggle data와 일치하게
 */
@NoArgsConstructor
@Getter
@Entity
public class UberData {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String startLocation;

    @Column(nullable = false)
    private String stopLocation;

    @Column(nullable = false)
    private Double miles;

    private String purpose;


    @Builder
    public UberData(LocalDateTime startDate, LocalDateTime endDate, String category, String startLocation,
                    String stopLocation, Double miles, String purpose){
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        this.miles = miles;
        this.purpose = purpose;

    }


}
