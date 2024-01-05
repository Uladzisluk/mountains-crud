import { Component } from '@angular/core';

@Component({
  selector: 'app-peak-list',
  templateUrl: './peak-list.component.html',
  styleUrl: './peak-list.component.css'
})
export class PeakListComponent {
  /**
   * @param service peaks service
   */
  constructor(private service: PeakService) {
  }

  /**
   * Available peaks.
   */
  peaks: Peaks | undefined;

  ngOnInit(): void {
    this.service.getPeaks().subscribe(peaks => this.peaks = peaks);
  }

  /**
   * Deletes selected peak.
   *
   * @param range peak to be removed
   */
  onDelete(peak: Peak): void {
    this.service.deletePeak(peak.id).subscribe(() => this.ngOnInit());
  }
}
