package com.TaskLedger.infrastructure.peristence.entity.employee;

import com.TaskLedger.infrastructure.peristence.entity.report.Report;
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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "UUID")
    private UUID id;
    private String name;
    private String identifier;

    @ManyToOne
    @JoinColumn(name = "title_id",referencedColumnName = "id")
    private Title title;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Report> reports;
}
