import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PeakViewComponent } from './peak-view.component';

describe('PeakViewComponent', () => {
  let component: PeakViewComponent;
  let fixture: ComponentFixture<PeakViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PeakViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PeakViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
