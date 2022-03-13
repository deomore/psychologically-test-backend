package ru.vlsu.psytest.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.InstantFilter;

/**
 * Criteria class for the {@link ru.vlsu.psytest.domain.ResultTest} entity. This class is used
 * in {@link ru.vlsu.psytest.web.rest.ResultTestResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /result-tests?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ResultTestCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private InstantFilter finishedAt;

    private IntegerFilter extraversionType;

    private IntegerFilter spontaneityType;

    private IntegerFilter aggressivenessType;

    private IntegerFilter rigidityType;

    private IntegerFilter introversionType;

    private IntegerFilter sensitivityType;

    private IntegerFilter anxietyType;

    private IntegerFilter labilityType;

    private IntegerFilter lieType;

    private IntegerFilter aggravationType;

    private LongFilter userId;

    public ResultTestCriteria() {
    }

    public ResultTestCriteria(ResultTestCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.finishedAt = other.finishedAt == null ? null : other.finishedAt.copy();
        this.extraversionType = other.extraversionType == null ? null : other.extraversionType.copy();
        this.spontaneityType = other.spontaneityType == null ? null : other.spontaneityType.copy();
        this.aggressivenessType = other.aggressivenessType == null ? null : other.aggressivenessType.copy();
        this.rigidityType = other.rigidityType == null ? null : other.rigidityType.copy();
        this.introversionType = other.introversionType == null ? null : other.introversionType.copy();
        this.sensitivityType = other.sensitivityType == null ? null : other.sensitivityType.copy();
        this.anxietyType = other.anxietyType == null ? null : other.anxietyType.copy();
        this.labilityType = other.labilityType == null ? null : other.labilityType.copy();
        this.lieType = other.lieType == null ? null : other.lieType.copy();
        this.aggravationType = other.aggravationType == null ? null : other.aggravationType.copy();
        this.userId = other.userId == null ? null : other.userId.copy();
    }

    @Override
    public ResultTestCriteria copy() {
        return new ResultTestCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public InstantFilter getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(InstantFilter finishedAt) {
        this.finishedAt = finishedAt;
    }

    public IntegerFilter getExtraversionType() {
        return extraversionType;
    }

    public void setExtraversionType(IntegerFilter extraversionType) {
        this.extraversionType = extraversionType;
    }

    public IntegerFilter getSpontaneityType() {
        return spontaneityType;
    }

    public void setSpontaneityType(IntegerFilter spontaneityType) {
        this.spontaneityType = spontaneityType;
    }

    public IntegerFilter getAggressivenessType() {
        return aggressivenessType;
    }

    public void setAggressivenessType(IntegerFilter aggressivenessType) {
        this.aggressivenessType = aggressivenessType;
    }

    public IntegerFilter getRigidityType() {
        return rigidityType;
    }

    public void setRigidityType(IntegerFilter rigidityType) {
        this.rigidityType = rigidityType;
    }

    public IntegerFilter getIntroversionType() {
        return introversionType;
    }

    public void setIntroversionType(IntegerFilter introversionType) {
        this.introversionType = introversionType;
    }

    public IntegerFilter getSensitivityType() {
        return sensitivityType;
    }

    public void setSensitivityType(IntegerFilter sensitivityType) {
        this.sensitivityType = sensitivityType;
    }

    public IntegerFilter getAnxietyType() {
        return anxietyType;
    }

    public void setAnxietyType(IntegerFilter anxietyType) {
        this.anxietyType = anxietyType;
    }

    public IntegerFilter getLabilityType() {
        return labilityType;
    }

    public void setLabilityType(IntegerFilter labilityType) {
        this.labilityType = labilityType;
    }

    public IntegerFilter getLieType() {
        return lieType;
    }

    public void setLieType(IntegerFilter lieType) {
        this.lieType = lieType;
    }

    public IntegerFilter getAggravationType() {
        return aggravationType;
    }

    public void setAggravationType(IntegerFilter aggravationType) {
        this.aggravationType = aggravationType;
    }

    public LongFilter getUserId() {
        return userId;
    }

    public void setUserId(LongFilter userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ResultTestCriteria that = (ResultTestCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(finishedAt, that.finishedAt) &&
            Objects.equals(extraversionType, that.extraversionType) &&
            Objects.equals(spontaneityType, that.spontaneityType) &&
            Objects.equals(aggressivenessType, that.aggressivenessType) &&
            Objects.equals(rigidityType, that.rigidityType) &&
            Objects.equals(introversionType, that.introversionType) &&
            Objects.equals(sensitivityType, that.sensitivityType) &&
            Objects.equals(anxietyType, that.anxietyType) &&
            Objects.equals(labilityType, that.labilityType) &&
            Objects.equals(lieType, that.lieType) &&
            Objects.equals(aggravationType, that.aggravationType) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        finishedAt,
        extraversionType,
        spontaneityType,
        aggressivenessType,
        rigidityType,
        introversionType,
        sensitivityType,
        anxietyType,
        labilityType,
        lieType,
        aggravationType,
        userId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ResultTestCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (finishedAt != null ? "finishedAt=" + finishedAt + ", " : "") +
                (extraversionType != null ? "extraversionType=" + extraversionType + ", " : "") +
                (spontaneityType != null ? "spontaneityType=" + spontaneityType + ", " : "") +
                (aggressivenessType != null ? "aggressivenessType=" + aggressivenessType + ", " : "") +
                (rigidityType != null ? "rigidityType=" + rigidityType + ", " : "") +
                (introversionType != null ? "introversionType=" + introversionType + ", " : "") +
                (sensitivityType != null ? "sensitivityType=" + sensitivityType + ", " : "") +
                (anxietyType != null ? "anxietyType=" + anxietyType + ", " : "") +
                (labilityType != null ? "labilityType=" + labilityType + ", " : "") +
                (lieType != null ? "lieType=" + lieType + ", " : "") +
                (aggravationType != null ? "aggravationType=" + aggravationType + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
