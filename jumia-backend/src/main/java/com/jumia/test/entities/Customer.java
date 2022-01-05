package com.jumia.test.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
/**
 *
 * @author martin
 */
@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "sample.customer")
public class Customer implements Serializable {
    
    @Id
    @Column(value = "id")
    private Integer id;
    
    @Column(value = "name")
    private String name;
 
    @Column(value = "phone")
    private String phone;
    
    @Transient
    private String country;
    
    @Transient
    private boolean isValid;
    
    @Transient
    private String country_code;
}
