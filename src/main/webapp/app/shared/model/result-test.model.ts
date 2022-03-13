import { Moment } from 'moment';

export interface IResultTest {
  id?: number;
  finishedAt?: string;
  extraversionType?: number;
  spontaneityType?: number;
  aggressivenessType?: number;
  rigidityType?: number;
  introversionType?: number;
  sensitivityType?: number;
  anxietyType?: number;
  labilityType?: number;
  lieType?: number;
  aggravationType?: number;
  userId?: number;
}

export const defaultValue: Readonly<IResultTest> = {};
