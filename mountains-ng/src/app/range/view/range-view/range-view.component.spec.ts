import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RangeViewComponent } from './range-view.component';

describe('RangeViewComponent', () => {
  let component: RangeViewComponent;
  let fixture: ComponentFixture<RangeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RangeViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RangeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
