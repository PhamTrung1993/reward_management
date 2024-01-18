package com.exercise.reward_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "PRIZE_MANAGEMENT")
public class PrizeManagement {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PrizeManagementSequence")
    @SequenceGenerator(name = "PrizeManagementSequence", sequenceName = "PRIZE_MANAGEMENT_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "PHONE_NUMBER", length = 9)
    private String phoneNumber;
    @Column(name = "EVENT_COUNT")
    private int count;
}
