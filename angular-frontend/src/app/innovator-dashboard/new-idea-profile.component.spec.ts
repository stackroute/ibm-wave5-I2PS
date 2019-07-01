import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewIdeaProfileComponent } from './new-idea-profile.component';

describe('NewIdeaProfileComponent', () => {
  let component: NewIdeaProfileComponent;
  let fixture: ComponentFixture<NewIdeaProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewIdeaProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewIdeaProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
