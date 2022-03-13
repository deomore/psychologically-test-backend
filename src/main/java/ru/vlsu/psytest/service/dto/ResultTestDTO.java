package ru.vlsu.psytest.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link ru.vlsu.psytest.domain.ResultTest} entity.
 */
public class ResultTestDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant finishedAt;

    @NotNull
    private Integer extraversionType;

    @NotNull
    private Integer spontaneityType;

    @NotNull
    private Integer aggressivenessType;

    @NotNull
    private Integer rigidityType;

    @NotNull
    private Integer introversionType;

    @NotNull
    private Integer sensitivityType;

    @NotNull
    private Integer anxietyType;

    @NotNull
    private Integer labilityType;

    @NotNull
    private Integer lieType;

    private Integer aggravationType;


    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Instant finishedAt) {
        this.finishedAt = finishedAt;
    }

    public Integer getExtraversionType() {
        return extraversionType;
    }

    public void setExtraversionType(Integer extraversionType) {
        this.extraversionType = extraversionType;
    }

    public Integer getSpontaneityType() {
        return spontaneityType;
    }

    public void setSpontaneityType(Integer spontaneityType) {
        this.spontaneityType = spontaneityType;
    }

    public Integer getAggressivenessType() {
        return aggressivenessType;
    }

    public void setAggressivenessType(Integer aggressivenessType) {
        this.aggressivenessType = aggressivenessType;
    }

    public Integer getRigidityType() {
        return rigidityType;
    }

    public void setRigidityType(Integer rigidityType) {
        this.rigidityType = rigidityType;
    }

    public Integer getIntroversionType() {
        return introversionType;
    }

    public void setIntroversionType(Integer introversionType) {
        this.introversionType = introversionType;
    }

    public Integer getSensitivityType() {
        return sensitivityType;
    }

    public void setSensitivityType(Integer sensitivityType) {
        this.sensitivityType = sensitivityType;
    }

    public Integer getAnxietyType() {
        return anxietyType;
    }

    public void setAnxietyType(Integer anxietyType) {
        this.anxietyType = anxietyType;
    }

    public Integer getLabilityType() {
        return labilityType;
    }

    public void setLabilityType(Integer labilityType) {
        this.labilityType = labilityType;
    }

    public Integer getLieType() {
        return lieType;
    }

    public void setLieType(Integer lieType) {
        this.lieType = lieType;
    }

    public Integer getAggravationType() {
        return aggravationType;
    }

    public void setAggravationType(Integer aggravationType) {
        this.aggravationType = aggravationType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ResultTestDTO() {
    }

    public ResultTestDTO(
        @NotNull Integer extraversionType,
        @NotNull Integer spontaneityType,
        @NotNull Integer aggressivenessType,
        @NotNull Integer rigidityType,
        @NotNull Integer introversionType,
        @NotNull Integer sensitivityType,
        @NotNull Integer anxietyType,
        @NotNull Integer labilityType,
        @NotNull Integer lieType,
        @NotNull Integer aggravationType,
        Long userId) {
        this.extraversionType = extraversionType;
        this.spontaneityType = spontaneityType;
        this.aggressivenessType = aggressivenessType;
        this.rigidityType = rigidityType;
        this.introversionType = introversionType;
        this.sensitivityType = sensitivityType;
        this.anxietyType = anxietyType;
        this.labilityType = labilityType;
        this.lieType = lieType;
        this.aggravationType = aggravationType;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResultTestDTO)) {
            return false;
        }

        return id != null && id.equals(((ResultTestDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ResultTestDTO{" +
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
            ", userId=" + getUserId() +
            "}";
    }
}
