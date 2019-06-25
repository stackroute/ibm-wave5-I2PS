import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SericeProviderComponent } from './serice-provider.component';

describe('SericeProviderComponent', () => {
  let component: SericeProviderComponent;
  let fixture: ComponentFixture<SericeProviderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SericeProviderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SericeProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
