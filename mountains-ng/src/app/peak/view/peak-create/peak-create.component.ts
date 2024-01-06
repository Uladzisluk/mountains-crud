import {Component, OnInit} from '@angular/core';
import {PeakForm} from "../../model/peak-form";
import {PeakService} from "../../service/peak.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-peak-create',
  templateUrl: './peak-create.component.html',
  styleUrl: './peak-create.component.css'
})
export class PeakCreateComponent implements OnInit{
  /**
   * UUID of the peak.
   */
  uuid: string = "";

  /**
   * Name of the peak.
   */
  name: string | undefined;

  /**
   * Height of the peak.
   */
  height: number | undefined;

  /**
   * Single peak.
   */
  peak: PeakForm = new class implements PeakForm {
    height: number = 0;
    name: string = '';
    range: string = '';
  }

  /**
   * @param peakService peak service
   * @param route activated route
   * @param router router
   * @param location location
   */
  constructor(
    private peakService: PeakService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location
  ) {
  }

  onSubmit(): void{
    this.peakService.putPeak(this.uuid!, this.peak!)
      .subscribe(() => this.location.back());
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => this.peak.range = params['uuid']);
  }
}
