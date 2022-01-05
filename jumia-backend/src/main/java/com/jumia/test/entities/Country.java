package com.jumia.test.entities;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author martin
 */
@ToString
@AllArgsConstructor
@Data
public class Country implements Serializable {
    private String country;
    private String country_code;
    private String country_regex;
}
