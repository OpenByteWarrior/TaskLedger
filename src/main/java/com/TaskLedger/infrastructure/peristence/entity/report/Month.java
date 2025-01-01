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
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "UUID")
    private UUID id;

    private String name;
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private Report report;

    @OneToMany(mappedBy = "month", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Day> days;
}
