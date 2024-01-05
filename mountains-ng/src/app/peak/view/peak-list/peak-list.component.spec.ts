import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PeakListComponent } from './peak-list.component';

describe('PeakListComponent', () => {
  let component: PeakListComponent;
  let fixture: ComponentFixture<PeakListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PeakListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PeakListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
