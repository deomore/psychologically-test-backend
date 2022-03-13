import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './result-test.reducer';
import { IResultTest } from 'app/shared/model/result-test.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';
import { overridePaginationStateWithQueryParams } from 'app/shared/util/entity-utils';

export interface IResultTestProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const ResultTest = (props: IResultTestProps) => {
  const [paginationState, setPaginationState] = useState(
    overridePaginationStateWithQueryParams(getSortState(props.location, ITEMS_PER_PAGE), props.location.search)
  );

  const getAllEntities = () => {
    props.getEntities(paginationState.activePage - 1, paginationState.itemsPerPage, `${paginationState.sort},${paginationState.order}`);
  };

  const sortEntities = () => {
    getAllEntities();
    const endURL = `?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`;
    if (props.location.search !== endURL) {
      props.history.push(`${props.location.pathname}${endURL}`);
    }
  };

  useEffect(() => {
    sortEntities();
  }, [paginationState.activePage, paginationState.order, paginationState.sort]);

  useEffect(() => {
    const params = new URLSearchParams(props.location.search);
    const page = params.get('page');
    const sort = params.get('sort');
    if (page && sort) {
      const sortSplit = sort.split(',');
      setPaginationState({
        ...paginationState,
        activePage: +page,
        sort: sortSplit[0],
        order: sortSplit[1],
      });
    }
  }, [props.location.search]);

  const sort = p => () => {
    setPaginationState({
      ...paginationState,
      order: paginationState.order === 'asc' ? 'desc' : 'asc',
      sort: p,
    });
  };

  const handlePagination = currentPage =>
    setPaginationState({
      ...paginationState,
      activePage: currentPage,
    });

  const { resultTestList, match, loading, totalItems } = props;
  return (
    <div>
      <h2 id="result-test-heading">
        <Translate contentKey="psychologicallyTestBackendApp.resultTest.home.title">Result Tests</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="psychologicallyTestBackendApp.resultTest.home.createLabel">Create new Result Test</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {resultTestList && resultTestList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  <Translate contentKey="global.field.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('finishedAt')}>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.finishedAt">Finished At</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('extraversionType')}>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.extraversionType">Extraversion Type</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('spontaneityType')}>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.spontaneityType">Spontaneity Type</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('aggressivenessType')}>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.aggressivenessType">Aggressiveness Type</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('rigidityType')}>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.rigidityType">Rigidity Type</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('introversionType')}>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.introversionType">Introversion Type</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('sensitivityType')}>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.sensitivityType">Sensitivity Type</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('anxietyType')}>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.anxietyType">Anxiety Type</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('labilityType')}>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.labilityType">
                    Lability Type
                  </Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('lieType')}>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.lieType">Lie Type</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('aggravationType')}>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.aggravationType">Aggravation Type</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th>
                  <Translate contentKey="psychologicallyTestBackendApp.resultTest.user">User</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {resultTestList.map((resultTest, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${resultTest.id}`} color="link" size="sm">
                      {resultTest.id}
                    </Button>
                  </td>
                  <td>
                    {resultTest.finishedAt ? <TextFormat type="date" value={resultTest.finishedAt} format={APP_DATE_FORMAT} /> : null}
                  </td>
                  <td>{resultTest.extraversionType}</td>
                  <td>{resultTest.spontaneityType}</td>
                  <td>{resultTest.aggressivenessType}</td>
                  <td>{resultTest.rigidityType}</td>
                  <td>{resultTest.introversionType}</td>
                  <td>{resultTest.sensitivityType}</td>
                  <td>{resultTest.anxietyType}</td>
                  <td>{resultTest.labilityType}</td>
                  <td>{resultTest.lieType}</td>
                  <td>{resultTest.aggravationType}</td>
                  <td>{resultTest.userId ? resultTest.userId : ''}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${resultTest.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`${match.url}/${resultTest.id}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="primary"
                        size="sm"
                      >
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`${match.url}/${resultTest.id}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="danger"
                        size="sm"
                      >
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="psychologicallyTestBackendApp.resultTest.home.notFound">No Result Tests found</Translate>
            </div>
          )
        )}
      </div>
      {props.totalItems ? (
        <div className={resultTestList && resultTestList.length > 0 ? '' : 'd-none'}>
          <Row className="justify-content-center">
            <JhiItemCount page={paginationState.activePage} total={totalItems} itemsPerPage={paginationState.itemsPerPage} i18nEnabled />
          </Row>
          <Row className="justify-content-center">
            <JhiPagination
              activePage={paginationState.activePage}
              onSelect={handlePagination}
              maxButtons={5}
              itemsPerPage={paginationState.itemsPerPage}
              totalItems={props.totalItems}
            />
          </Row>
        </div>
      ) : (
        ''
      )}
    </div>
  );
};

const mapStateToProps = ({ resultTest }: IRootState) => ({
  resultTestList: resultTest.entities,
  loading: resultTest.loading,
  totalItems: resultTest.totalItems,
});

const mapDispatchToProps = {
  getEntities,
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(ResultTest);
