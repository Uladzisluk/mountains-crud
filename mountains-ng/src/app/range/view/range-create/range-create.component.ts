import {Component, OnInit} from '@angular/core';
import {RangeService} from "../../service/range.service";
import {ActivatedRoute, Router} from "@angular/router";
import {RangeForm} from "../../model/range-form";

@Component({
  selector: 'app-range-create',
  templateUrl: './range-create.component.html',
  styleUrl: './range-create.component.css'
})
export class RangeCreateComponent{
  /**
   * UUID of the range.
   */
  uuid: string = "";

  /**
   * Name of the range.
   */
  name: string | undefined;

  /**
   * Length of the range.
   */
  length: number | undefined;

  /**
   * Single range.
   */
  range: RangeForm = new class implements RangeForm {
    length: number = 0;
    name: string = "";
  };

  /**
   * @param rangeService range service
   * @param route activated route
   * @param router router
   */
  constructor(
    private rangeService: RangeService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  onSubmit(): void{
    this.rangeService.putRange(this.uuid!, this.range!)
      .subscribe(() => this.router.navigate(['/ranges']))
  }

}
