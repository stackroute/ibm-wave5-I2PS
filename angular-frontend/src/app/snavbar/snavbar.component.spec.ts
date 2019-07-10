import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SnavbarComponent } from './snavbar.component';

describe('SnavbarComponent', () => {
  let component: SnavbarComponent;
  let fixture: ComponentFixture<SnavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SnavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SnavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
