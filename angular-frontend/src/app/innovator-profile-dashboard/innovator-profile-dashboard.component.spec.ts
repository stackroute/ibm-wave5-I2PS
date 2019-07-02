import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InnovatorProfileDashboardComponent } from './innovator-profile-dashboard.component';

describe('InnovatorProfileDashboardComponent', () => {
  let component: InnovatorProfileDashboardComponent;
  let fixture: ComponentFixture<InnovatorProfileDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InnovatorProfileDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InnovatorProfileDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
