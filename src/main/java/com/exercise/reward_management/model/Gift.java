package com.exercise.reward_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "GIFT")
public class Gift {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GiftSequence")
    @SequenceGenerator(name = "GiftSequence", sequenceName = "GIFT_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "CARD_CODE")
    private String cardCode;
    @Column(name = "USER_RECEIVES")
    private String userReceives;
    @Column(name = "STATUS")
    private int status;
    @Column(name = "CREATE_TIME")
    private Date createTime;
    @Column(name = "USER_TIME")
    private Date userTime;
}
