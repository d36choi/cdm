package com.producer.cdm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * member 들은 keggle data와 일치하게
 */
@NoArgsConstructor
@Getter
@Entity
public class UberData {

    @Id
    public long id;


}
