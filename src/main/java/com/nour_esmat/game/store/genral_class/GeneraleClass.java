package com.nour_esmat.game.store.genral_class;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class GeneraleClass {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    // audting fields
    // private String createdBy;
    // private String updatedBy;
    // private String createdAt;
    // private String updatedAt;
}
