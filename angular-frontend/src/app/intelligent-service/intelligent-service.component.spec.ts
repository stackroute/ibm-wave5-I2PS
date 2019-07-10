import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IntelligentServiceComponent } from './intelligent-service.component';

describe('IntelligentServiceComponent', () => {
  let component: IntelligentServiceComponent;
  let fixture: ComponentFixture<IntelligentServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IntelligentServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IntelligentServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
