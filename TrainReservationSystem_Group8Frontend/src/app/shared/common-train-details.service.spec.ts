import { TestBed } from '@angular/core/testing';

import { CommonTrainDetailsService } from './common-train-details.service';

describe('CommonTrainDetailsService', () => {
  let service: CommonTrainDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommonTrainDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
