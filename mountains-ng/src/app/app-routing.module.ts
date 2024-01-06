import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RangeListComponent} from "./range/view/range-list/range-list.component";
import {PeakListComponent} from "./peak/view/peak-list/peak-list.component";
import {PeakViewComponent} from "./peak/view/peak-view/peak-view.component";
import {PeakEditComponent} from "./peak/view/peak-edit/peak-edit.component";
import {RangeCreateComponent} from "./range/view/range-create/range-create.component";

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
    component: PeakListComponent,
    path: "peaks"
  },
  {
    component: PeakViewComponent,
    path: "peaks/:uuid"
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
