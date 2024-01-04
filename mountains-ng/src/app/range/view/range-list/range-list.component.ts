import {Component, OnInit} from '@angular/core';
import {Ranges} from "../../model/ranges";
import {Range} from "../../model/range";

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
   * Available ranges.
   */

  ranges: Ranges | undefined;
  ngOnInit(): void {
    this.ranges = {
      ranges :[
        {
          name: 'Everest',
          id: crypto.randomUUID()
        },
        {
          name: 'K2',
          id: crypto.randomUUID()
        }
      ]
    }
  }

  /**
   * Deletes selected range.
   *
   * @param range range to be removed
   */
  onDelete(range: Range): void{
    this.ranges?.ranges.splice(this.ranges?.ranges.indexOf(range), 1);
  }

}
