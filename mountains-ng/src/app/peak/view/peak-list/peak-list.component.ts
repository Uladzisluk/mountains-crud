import { Component } from '@angular/core';
import {PeakService} from "../../service/peak.service";
import {Peaks} from "../../model/peaks";
import {Peak} from "../../model/peak";

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
