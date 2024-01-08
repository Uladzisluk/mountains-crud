import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RangeListComponent} from "./range/view/range-list/range-list.component";
import {PeakListComponent} from "./peak/view/peak-list/peak-list.component";
import {PeakViewComponent} from "./peak/view/peak-view/peak-view.component";
import {PeakEditComponent} from "./peak/view/peak-edit/peak-edit.component";
import {RangeCreateComponent} from "./range/view/range-create/range-create.component";
import {RangeEditComponent} from "./range/view/range-edit/range-edit.component";
import {RangeViewComponent} from "./range/view/range-view/range-view.component";
import {PeakCreateComponent} from "./peak/view/peak-create/peak-create.component";

const routes: Routes = [
  {
    component: RangeListComponent,
    path: "ranges"
  },
  {
    component: RangeCreateComponent,
    path: "ranges/create"
  },
  {
    component: RangeViewComponent,
    path: "ranges/:uuid"
  },
  {
    component: RangeEditComponent,
    path: "ranges/:uuid/edit"
  },
  {
    component: PeakCreateComponent,
    path: "ranges/:uuid/create"
  },
  {
    component: PeakListComponent,
    path: "peaks"
  },
  {
    component: PeakViewComponent,
    path: "ranges/:rangeUuid/peaks/:uuid"
  },
  {
    component: PeakViewComponent,
    path: "peaks/:uuid"
  },
  {
    component: PeakEditComponent,
    path: "ranges/:rangeUuid/peaks/:uuid/edit"
  },
  {
    component: PeakEditComponent,
    path: "peaks/:uuid/edit"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
