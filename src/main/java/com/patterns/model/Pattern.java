package com.patterns.model;

import com.patterns.usage.AbstractPatternUsage;
import com.patterns.usage.creational.singleton.SingletonUsage;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="pattern")
public class Pattern {

    private static final Integer MAX_NAME_LENGTH = 50;
    private static final Integer MAX_DESCRIPTION_LENGTH = 500;
    private static final Double IS_MAIN_FALSE_CF = 0.5d;
    private static final Double IS_MAIN_TRUE_CF = 1d;
    private static final Boolean DEFAULT_IS_MAIN = true;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="typ")
    private PatternType patternType;

    private Boolean isMain;

    private Double rating;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public PatternType getPatternType() {
        return patternType;
    }

    public Boolean getMain() {
        return isMain;
    }

    public Double getRating() {
        return rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPatternType(PatternType patternType) {
        this.patternType = patternType;
    }

    public void setMain(Boolean main){ isMain = main; }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void calculate()
    {
        calculateIsMain();
        calculateRating();
    }

    private void calculateIsMain()
    {
        if(isMain == null)
            isMain = DEFAULT_IS_MAIN;
    }

    private void calculateRating()
    {
        Double cf = isMain ? IS_MAIN_TRUE_CF : IS_MAIN_FALSE_CF;
        Double rating = cf;
        this.rating = roundDouble(rating);
    }

    public boolean isValid()
    {
        if(name == null || description == null || patternType == null)
            return false;
        if(name.length() > MAX_NAME_LENGTH || description.length() > MAX_DESCRIPTION_LENGTH)
            return false;
        if(name.equals("") || description.equals(""))
            return false;
        return true;
    }

    public static Double roundDouble(Double input)
    {
        return Math.round(input * 100.0) / 100.0;
    }

    public String use()
    {
        AbstractPatternUsage pattern = new SingletonUsage();
        return pattern.use();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pattern pattern = (Pattern) o;
        return id.equals(pattern.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "id=" + id +
                '}';
    }
}