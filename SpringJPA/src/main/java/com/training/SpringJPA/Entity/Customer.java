package com.training.SpringJPA.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private int id;
    private String firstName;
    private int age;
    private String gender;

}
        //CascadeType.PERSIST: When persisting an entity, also persist the entities held in its fields.
        //We suggest a liberal application of this cascade rule, because if the EntityManager finds a field that references a new entity during the flush,
        // and the field does not use CascadeType.PERSIST, it is an error.
        //CascadeType.REMOVE: When deleting an entity, it also deletes the entities held in this field.
        //CascadeType.REFRESH: When refreshing an entity, also refresh the entities held in this field.
        //CascadeType.MERGE: When merging entity state, also merge the entities held in this field.
