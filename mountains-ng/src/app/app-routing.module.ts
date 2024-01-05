import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RangeListComponent} from "./range/view/range-list/range-list.component";
import {PeakListComponent} from "./peak/view/peak-list/peak-list.component";
import {PeakViewComponent} from "./peak/view/peak-view/peak-view.component";

const routes: Routes = [
  {
    component: RangeListComponent,
    path: "ranges"
  },
  {
    component: PeakListComponent,
    path: "peaks"
  },
  {
    component: PeakViewComponent,
    path: "peaks/:uuid"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
