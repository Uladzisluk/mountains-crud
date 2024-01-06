import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RangeCreateComponent } from './range-create.component';

describe('RangeCreateComponent', () => {
  let component: RangeCreateComponent;
  let fixture: ComponentFixture<RangeCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RangeCreateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RangeCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
