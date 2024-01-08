import {Component, OnInit} from '@angular/core';
import {PeakForm} from "../../model/peak-form";
import {PeakService} from "../../service/peak.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";
import {Ranges} from "../../../range/model/ranges";
import {RangeService} from "../../../range/service/range.service";

@Component({
  selector: 'app-peak-edit',
  templateUrl: './peak-edit.component.html',
  styleUrl: './peak-edit.component.css'
})
export class PeakEditComponent implements OnInit{
  /**
   * Peak's id.
   */
  uuid: string | undefined;

  /**
   * Single peak.
   */
  peak: PeakForm | undefined;

  /**
   * Single peak.
   */
  original: PeakForm | undefined;

  ranges: Ranges | undefined;

  /**
   * @param peakService peak service
   * @param rangeService range service
   * @param route activated route
   * @param router router
   * @param location location
   */
  constructor(
    private peakService: PeakService,
    private rangeService: RangeService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location
  ) {
  }

  ngOnInit() {
    this.rangeService.getRanges().subscribe(ranges => this.ranges = ranges);

    this.route.params.subscribe(params => {
      this.peakService.getPeak(params['uuid'])
        .subscribe(peak => {
          this.uuid = peak.id;
          this.peak = {
            name: peak.name,
            height: peak.height,
            range: peak.rangeUUID
          };
          this.original = {...this.peak};
        });
    });
  }

  /**
   * Updates peak.
   */
  onSubmit(): void {
    this.peakService.putPeak(this.uuid!, this.peak!)
      .subscribe(() => this.location.back());
  }

}
