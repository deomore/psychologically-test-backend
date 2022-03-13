import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './result-test.reducer';
import { IResultTest } from 'app/shared/model/result-test.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IResultTestDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const ResultTestDetail = (props: IResultTestDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { resultTestEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="psychologicallyTestBackendApp.resultTest.detail.title">ResultTest</Translate> [<b>{resultTestEntity.id}</b>
          ]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="finishedAt">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.finishedAt">Finished At</Translate>
            </span>
          </dt>
          <dd>
            {resultTestEntity.finishedAt ? <TextFormat value={resultTestEntity.finishedAt} type="date" format={APP_DATE_FORMAT} /> : null}
          </dd>
          <dt>
            <span id="extraversionType">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.extraversionType">Extraversion Type </Translate>
            </span>
          </dt>
          <dd>{resultTestEntity.extraversionType}</dd>
          <dt>
            <span id="spontaneityType">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.spontaneityType">Spontaneity Type</Translate>
            </span>
          </dt>
          <dd>{resultTestEntity.spontaneityType}</dd>
          <dt>
            <span id="aggressivenessType">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.aggressivenessType">Aggressiveness Type</Translate>
            </span>
          </dt>
          <dd>{resultTestEntity.aggressivenessType}</dd>
          <dt>
            <span id="rigidityType">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.rigidityType">Rigidity Type</Translate>
            </span>
          </dt>
          <dd>{resultTestEntity.rigidityType}</dd>
          <dt>
            <span id="introversionType">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.introversionType">IntroversionT Type</Translate>
            </span>
          </dt>
          <dd>{resultTestEntity.introversionType}</dd>
          <dt>
            <span id="sensitivityType">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.sensitivityType">Sensitivity Type</Translate>
            </span>
          </dt>
          <dd>{resultTestEntity.sensitivityType}</dd>
          <dt>
            <span id="anxietyType">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.anxietyType">Anxiety Type</Translate>
            </span>
          </dt>
          <dd>{resultTestEntity.anxietyType}</dd>
          <dt>
            <span id="labilityType">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.labilityType">Lability Type</Translate>
            </span>
          </dt>
          <dd>{resultTestEntity.labilityType}</dd>
          <dt>
            <span id="lieType">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.emotiveType">Lie  Type</Translate>
            </span>
          </dt>
          <dd>{resultTestEntity.lieType}</dd>
          <dt>
            <span id="aggravationType">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.aggravationType">Aggravation Type</Translate>
            </span>
          </dt>
          <dd>{resultTestEntity.aggravationType}</dd>
          <dt>
            <Translate contentKey="psychologicallyTestBackendApp.resultTest.user">User</Translate>
          </dt>
          <dd>{resultTestEntity.userId ? resultTestEntity.userId : ''}</dd>
        </dl>
        <Button tag={Link} to="/result-test" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/result-test/${resultTestEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ resultTest }: IRootState) => ({
  resultTestEntity: resultTest.entity,
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(ResultTestDetail);
