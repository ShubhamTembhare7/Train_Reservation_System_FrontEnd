import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RailwaystatusComponent } from './railwaystatus.component';

describe('RailwaystatusComponent', () => {
  let component: RailwaystatusComponent;
  let fixture: ComponentFixture<RailwaystatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RailwaystatusComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RailwaystatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
