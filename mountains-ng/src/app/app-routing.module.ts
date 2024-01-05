import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RangeListComponent} from "./range/view/range-list/range-list.component";
import {PeakListComponent} from "./peak/view/peak-list/peak-list.component";

const routes: Routes = [
  {
    component: RangeListComponent,
    path: "ranges"
  },
  {
    component: PeakListComponent,
    path: "peaks"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
