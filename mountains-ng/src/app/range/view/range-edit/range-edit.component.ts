import {Component, OnInit} from '@angular/core';
import {RangeForm} from "../../model/range-form";
import {RangeService} from "../../service/range.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-range-edit',
  templateUrl: './range-edit.component.html',
  styleUrl: './range-edit.component.css'
})
export class RangeEditComponent implements OnInit{
  /**
   * Range's id.
   */
  uuid: string | undefined;

  /**
   * Singe range.
   */
  range: RangeForm | undefined;

  /**
   * Single range.
   */
  original: RangeForm | undefined;

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

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.rangeService.getRange(params['uuid'])
        .subscribe(range => {
          this.uuid = range.id;
          this.range = {
            name: range.name,
            length: range.length,
          };
          this.original = {...this.range};
        });
    });
  }

  /**
   * Updates range.
   */
  onSubmit(): void {
    this.rangeService.putRange(this.uuid!, this.range!)
      .subscribe(() => this.router.navigate(['/ranges']));
  }

}
