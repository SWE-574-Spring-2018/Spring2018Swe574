/*
 * © 2016 Copyright Amadeus Unauthorised use and disclosure strictly forbidden.
 */
package com.linkyway.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author huseyin.kilic
 */
@Entity
@Table(name = "users  ")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "user_s")
    @SequenceGenerator(name = "user_s", sequenceName = "user_s", allocationSize = 25)
    private Long id;

    private long twitterId;

    private String name;
}