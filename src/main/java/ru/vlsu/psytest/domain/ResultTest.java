package ru.vlsu.psytest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A ResultTest.
 */
@Entity
@Table(name = "result_test")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ResultTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "finished_at", nullable = false)
    private Instant finishedAt;

    @NotNull
    @Column(name = "extraversion_type", nullable = false)
    private Integer extraversionType;

    @NotNull
    @Column(name = "spontaneity_type", nullable = false)
    private Integer spontaneityType;

    @NotNull
    @Column(name = "aggressiveness_type", nullable = false)
    private Integer aggressivenessType;

    @NotNull
    @Column(name = "rigidity_type", nullable = false)
    private Integer rigidityType;

    @NotNull
    @Column(name = "introversion_type", nullable = false)
    private Integer introversionType;

    @NotNull
    @Column(name = "sensitivity_type", nullable = false)
    private Integer sensitivityType;

    @NotNull
    @Column(name = "anxiety_type", nullable = false)
    private Integer anxietyType;

    @NotNull
    @Column(name = "lability_type", nullable = false)
    private Integer labilityType;

    @NotNull
    @Column(name = "lie_type", nullable = false)
    private Integer lieType;

    @Column(name = "aggravation_type")
    private Integer aggravationType;

    @ManyToOne
    @JsonIgnoreProperties(value = "resultTests", allowSetters = true)
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getFinishedAt() {
        return finishedAt;
    }

    public ResultTest finishedAt(Instant finishedAt) {
        this.finishedAt = finishedAt;
        return this;
    }

    public void setFinishedAt(Instant finishedAt) {
        this.finishedAt = finishedAt;
    }

    public Integer getExtraversionType() {
        return extraversionType;
    }

    public ResultTest extraversionType(Integer extraversionType) {
        this.extraversionType = extraversionType;
        return this;
    }

    public void setExtraversionType(Integer extraversionType) {
        this.extraversionType = extraversionType;
    }

    public Integer getSpontaneityType() {
        return spontaneityType;
    }

    public ResultTest spontaneityType(Integer spontaneityType) {
        this.spontaneityType = spontaneityType;
        return this;
    }

    public void setSpontaneityType(Integer spontaneityType) {
        this.spontaneityType = spontaneityType;
    }

    public Integer getAggressivenessType() {
        return aggressivenessType;
    }

    public ResultTest aggressivenessType(Integer aggressivenessType) {
        this.aggressivenessType = aggressivenessType;
        return this;
    }

    public void setAggressivenessType(Integer aggressivenessType) {
        this.aggressivenessType = aggressivenessType;
    }

    public Integer getRigidityType() {
        return rigidityType;
    }

    public ResultTest rigidityType(Integer rigidityType) {
        this.rigidityType = rigidityType;
        return this;
    }

    public void setRigidityType(Integer rigidityType) {
        this.rigidityType = rigidityType;
    }

    public Integer getIntroversionType() {
        return introversionType;
    }

    public ResultTest introversionType(Integer introversionType) {
        this.introversionType = introversionType;
        return this;
    }

    public void setIntroversionType(Integer introversionType) {
        this.introversionType = introversionType;
    }

    public Integer getSensitivityType() {
        return sensitivityType;
    }

    public ResultTest sensitivityType(Integer sensitivityType) {
        this.sensitivityType = sensitivityType;
        return this;
    }

    public void setSensitivityType(Integer sensitivityType) {
        this.sensitivityType = sensitivityType;
    }

    public Integer getAnxietyType() {
        return anxietyType;
    }

    public ResultTest anxietyType(Integer anxietyType) {
        this.anxietyType = anxietyType;
        return this;
    }

    public void setAnxietyType(Integer anxietyType) {
        this.anxietyType = anxietyType;
    }

    public Integer getLabilityType() {
        return labilityType;
    }

    public ResultTest emotionallyExaltedType(Integer labilityType) {
        this.labilityType = labilityType;
        return this;
    }

    public void setLabilityType(Integer labilityType) {
        this.labilityType = labilityType;
    }

    public Integer getLieType() {
        return lieType;
    }

    public ResultTest lieType(Integer lieType) {
        this.lieType = lieType;
        return this;
    }

    public void setLieType(Integer lieType) {
        this.lieType = lieType;
    }

    public Integer getAggravationType() {
        return aggravationType;
    }

    public ResultTest aggravationType(Integer aggravationType) {
        this.aggravationType = aggravationType;
        return this;
    }

    public void setAggravationType(Integer aggravationType) {
        this.aggravationType = aggravationType;
    }

    public User getUser() {
        return user;
    }

    public ResultTest user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResultTest)) {
            return false;
        }
        return id != null && id.equals(((ResultTest) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ResultTest{" +
            "id=" + getId() +
            ", finishedAt='" + getFinishedAt() + "'" +
            ", extraversionType=" + getExtraversionType() +
            ", spontaneityType=" + getSpontaneityType() +
            ", aggressivenessType=" + getAggressivenessType() +
            ", rigidityType=" + getRigidityType() +
            ", introversionType=" + getIntroversionType() +
            ", sensitivityType=" + getSensitivityType() +
            ", anxietyType=" + getAnxietyType() +
            ", labilityType=" + getLabilityType() +
            ", lieType=" + getLieType() +
            ", aggravationType=" + getAggravationType() +
            "}";
    }
}
