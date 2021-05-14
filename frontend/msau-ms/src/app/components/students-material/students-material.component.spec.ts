import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentsMaterialComponent } from './students-material.component';

describe('StudentsMaterialComponent', () => {
  let component: StudentsMaterialComponent;
  let fixture: ComponentFixture<StudentsMaterialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentsMaterialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentsMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
