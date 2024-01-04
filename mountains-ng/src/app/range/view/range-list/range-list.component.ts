import {Component, OnInit} from '@angular/core';
import {Ranges} from "../../model/ranges";
import {Range} from "../../model/range";
import {RangeService} from "../../service/range.service";

/**
 * Navigable view with list of all ranges.
 */
@Component({
  selector: 'app-range-list',
  templateUrl: './range-list.component.html',
  styleUrl: './range-list.component.css'
})
export class RangeListComponent implements OnInit{
  /**
   * @param service ranges service
   */
  constructor(private service: RangeService) {
  }

  /**
   * Available ranges.
   */
  ranges: Ranges | undefined;
  ngOnInit(): void {
    this.service.getRanges().subscribe(ranges => this.ranges = ranges);
  }

  /**
   * Deletes selected range.
   *
   * @param range range to be removed
   */
  onDelete(range: Range): void{
    this.service.deleteRange(range.id).subscribe(() => this.ngOnInit());
  }

}
