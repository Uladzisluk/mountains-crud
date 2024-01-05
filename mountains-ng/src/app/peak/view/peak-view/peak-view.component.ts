import {Component, OnInit} from '@angular/core';
import {PeakDetails} from "../../model/peak-details";
import {PeakService} from "../../service/peak.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-peak-view',
  templateUrl: './peak-view.component.html',
  styleUrl: './peak-view.component.css'
})
export class PeakViewComponent implements OnInit{
  /**
   * Single peak.
   */
  peak: PeakDetails | undefined;

  /**
   *
   * @param service peak service
   * @param route activated route
   * @param router router
   */
  constructor(private service: PeakService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getPeak(params['uuid'])
        .subscribe(peak => this.peak = peak)
    });
  }
}
