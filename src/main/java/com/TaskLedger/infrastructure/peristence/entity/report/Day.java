package com.TaskLedger.infrastructure.peristence.entity.report;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "UUID")
    private UUID id;

    private String name;
    private Integer number;
    private Integer hours;
    private Integer extraHours;
    private String prefix;

    @ManyToOne
    @JoinColumn(name = "month_id", referencedColumnName = "id")
    private Month month;
}
