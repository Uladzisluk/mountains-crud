import {Component, OnInit} from '@angular/core';
import {PeakDetails} from "../../../peak/model/peak-details";
import {PeakService} from "../../../peak/service/peak.service";
import {ActivatedRoute, Router} from "@angular/router";
import {RangeDetails} from "../../model/range-details";
import {RangeService} from "../../service/range.service";
import {Peaks} from "../../../peak/model/peaks";
import {Peak} from "../../../peak/model/peak";

@Component({
  selector: 'app-range-view',
  templateUrl: './range-view.component.html',
  styleUrl: './range-view.component.css'
})
export class RangeViewComponent implements OnInit{
  /**
   * Single range.
   */
  range: RangeDetails = new class implements RangeDetails {
    id: string = '';
    length: number = 0;
    name: string = '';
  };

  /**
   * Range's peaks.
   */
  peaks: Peaks | undefined;

  /**
   *
   * @param rangeService range service
   * @param peakService peak service
   * @param route activated route
   * @param router router
   */
  constructor(private rangeService: RangeService,
              private peakService: PeakService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.rangeService.getRange(params['uuid'])
        .subscribe(range => this.range = range);
      this.range.id = params['uuid'];
    });
    this.peakService.getRangePeaks(this.range.id).subscribe(peaks => this.peaks = peaks);
  }

  /**
   * Deletes selected peak.
   *
   * @param peak peak to be removed
   */
  onPeakDelete(peak: Peak): void {
    this.peakService.deletePeak(peak.id).subscribe(() => this.ngOnInit());
  }
}
