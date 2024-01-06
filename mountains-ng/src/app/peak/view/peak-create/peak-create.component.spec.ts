import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PeakCreateComponent } from './peak-create.component';

describe('PeakCreateComponent', () => {
  let component: PeakCreateComponent;
  let fixture: ComponentFixture<PeakCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PeakCreateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PeakCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
