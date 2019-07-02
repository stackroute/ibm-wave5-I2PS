import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceProviderProfileDashbaordComponent } from './service-provider-profile-dashbaord.component';

describe('ServiceProviderProfileDashbaordComponent', () => {
  let component: ServiceProviderProfileDashbaordComponent;
  let fixture: ComponentFixture<ServiceProviderProfileDashbaordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceProviderProfileDashbaordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceProviderProfileDashbaordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
